/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package my.memo.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import my.memo.exception.NoSuchMemoException;
import my.memo.model.Memo;
import my.memo.model.MemoTable;
import my.memo.model.impl.MemoImpl;
import my.memo.model.impl.MemoModelImpl;
import my.memo.service.persistence.MemoPersistence;
import my.memo.service.persistence.MemoUtil;
import my.memo.service.persistence.impl.constants.memoPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the memo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MemoPersistence.class)
public class MemoPersistenceImpl
	extends BasePersistenceImpl<Memo> implements MemoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MemoUtil</code> to access the memo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MemoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByResourcePrimKey;
	private FinderPath _finderPathWithoutPaginationFindByResourcePrimKey;
	private FinderPath _finderPathCountByResourcePrimKey;

	/**
	 * Returns all the memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching memos
	 */
	@Override
	public List<Memo> findByResourcePrimKey(long resourcePrimKey) {
		return findByResourcePrimKey(
			resourcePrimKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the memos where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @return the range of matching memos
	 */
	@Override
	public List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end) {

		return findByResourcePrimKey(resourcePrimKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByResourcePrimKey;
				finderArgs = new Object[] {resourcePrimKey};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResourcePrimKey;
			finderArgs = new Object[] {
				resourcePrimKey, start, end, orderByComparator
			};
		}

		List<Memo> list = null;

		if (useFinderCache) {
			list = (List<Memo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Memo memo : list) {
					if (resourcePrimKey != memo.getResourcePrimKey()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MemoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				list = (List<Memo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByResourcePrimKey_First(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByResourcePrimKey_First(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		List<Memo> list = findByResourcePrimKey(
			resourcePrimKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByResourcePrimKey_Last(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByResourcePrimKey_Last(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		int count = countByResourcePrimKey(resourcePrimKey);

		if (count == 0) {
			return null;
		}

		List<Memo> list = findByResourcePrimKey(
			resourcePrimKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the memos before and after the current memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param memoId the primary key of the current memo
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo[] findByResourcePrimKey_PrevAndNext(
			long memoId, long resourcePrimKey,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = findByPrimaryKey(memoId);

		Session session = null;

		try {
			session = openSession();

			Memo[] array = new MemoImpl[3];

			array[0] = getByResourcePrimKey_PrevAndNext(
				session, memo, resourcePrimKey, orderByComparator, true);

			array[1] = memo;

			array[2] = getByResourcePrimKey_PrevAndNext(
				session, memo, resourcePrimKey, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Memo getByResourcePrimKey_PrevAndNext(
		Session session, Memo memo, long resourcePrimKey,
		OrderByComparator<Memo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MEMO_WHERE);

		sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MemoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourcePrimKey);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(memo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Memo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	@Override
	public void removeByResourcePrimKey(long resourcePrimKey) {
		for (Memo memo :
				findByResourcePrimKey(
					resourcePrimKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(memo);
		}
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching memos
	 */
	@Override
	public int countByResourcePrimKey(long resourcePrimKey) {
		FinderPath finderPath = _finderPathCountByResourcePrimKey;

		Object[] finderArgs = new Object[] {resourcePrimKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2 =
			"memo.resourcePrimKey = ?";

	private FinderPath _finderPathWithPaginationFindByR;
	private FinderPath _finderPathWithoutPaginationFindByR;
	private FinderPath _finderPathCountByR;

	/**
	 * Returns all the memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching memos
	 */
	@Override
	public List<Memo> findByR(long resourcePrimKey) {
		return findByR(
			resourcePrimKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the memos where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @return the range of matching memos
	 */
	@Override
	public List<Memo> findByR(long resourcePrimKey, int start, int end) {
		return findByR(resourcePrimKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return findByR(resourcePrimKey, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR;
				finderArgs = new Object[] {resourcePrimKey};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR;
			finderArgs = new Object[] {
				resourcePrimKey, start, end, orderByComparator
			};
		}

		List<Memo> list = null;

		if (useFinderCache) {
			list = (List<Memo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Memo memo : list) {
					if (resourcePrimKey != memo.getResourcePrimKey()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_RESOURCEPRIMKEY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MemoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				list = (List<Memo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_First(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_First(resourcePrimKey, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_First(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		List<Memo> list = findByR(resourcePrimKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_Last(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_Last(resourcePrimKey, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_Last(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		int count = countByR(resourcePrimKey);

		if (count == 0) {
			return null;
		}

		List<Memo> list = findByR(
			resourcePrimKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the memos before and after the current memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param memoId the primary key of the current memo
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo[] findByR_PrevAndNext(
			long memoId, long resourcePrimKey,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = findByPrimaryKey(memoId);

		Session session = null;

		try {
			session = openSession();

			Memo[] array = new MemoImpl[3];

			array[0] = getByR_PrevAndNext(
				session, memo, resourcePrimKey, orderByComparator, true);

			array[1] = memo;

			array[2] = getByR_PrevAndNext(
				session, memo, resourcePrimKey, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Memo getByR_PrevAndNext(
		Session session, Memo memo, long resourcePrimKey,
		OrderByComparator<Memo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MEMO_WHERE);

		sb.append(_FINDER_COLUMN_R_RESOURCEPRIMKEY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MemoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourcePrimKey);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(memo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Memo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	@Override
	public void removeByR(long resourcePrimKey) {
		for (Memo memo :
				findByR(
					resourcePrimKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(memo);
		}
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching memos
	 */
	@Override
	public int countByR(long resourcePrimKey) {
		FinderPath finderPath = _finderPathCountByR;

		Object[] finderArgs = new Object[] {resourcePrimKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_RESOURCEPRIMKEY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_RESOURCEPRIMKEY_2 =
		"memo.resourcePrimKey = ?";

	private FinderPath _finderPathFetchByR_V;
	private FinderPath _finderPathCountByR_V;

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or throws a <code>NoSuchMemoException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_V(long resourcePrimKey, int version)
		throws NoSuchMemoException {

		Memo memo = fetchByR_V(resourcePrimKey, version);

		if (memo == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("resourcePrimKey=");
			sb.append(resourcePrimKey);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMemoException(sb.toString());
		}

		return memo;
	}

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_V(long resourcePrimKey, int version) {
		return fetchByR_V(resourcePrimKey, version, true);
	}

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_V(
		long resourcePrimKey, int version, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {resourcePrimKey, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByR_V, finderArgs, this);
		}

		if (result instanceof Memo) {
			Memo memo = (Memo)result;

			if ((resourcePrimKey != memo.getResourcePrimKey()) ||
				(version != memo.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_V_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_V_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(version);

				List<Memo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByR_V, finderArgs, list);
					}
				}
				else {
					Memo memo = list.get(0);

					result = memo;

					cacheResult(memo);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Memo)result;
		}
	}

	/**
	 * Removes the memo where resourcePrimKey = &#63; and version = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the memo that was removed
	 */
	@Override
	public Memo removeByR_V(long resourcePrimKey, int version)
		throws NoSuchMemoException {

		Memo memo = findByR_V(resourcePrimKey, version);

		return remove(memo);
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and version = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the number of matching memos
	 */
	@Override
	public int countByR_V(long resourcePrimKey, int version) {
		FinderPath finderPath = _finderPathCountByR_V;

		Object[] finderArgs = new Object[] {resourcePrimKey, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_V_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_V_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(version);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_V_RESOURCEPRIMKEY_2 =
		"memo.resourcePrimKey = ? AND ";

	private static final String _FINDER_COLUMN_R_V_VERSION_2 =
		"memo.version = ?";

	private FinderPath _finderPathWithPaginationFindByR_L;
	private FinderPath _finderPathWithoutPaginationFindByR_L;
	private FinderPath _finderPathCountByR_L;

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @return the matching memos
	 */
	@Override
	public List<Memo> findByR_L(long resourcePrimKey, boolean latest) {
		return findByR_L(
			resourcePrimKey, latest, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @return the range of matching memos
	 */
	@Override
	public List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end) {

		return findByR_L(resourcePrimKey, latest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return findByR_L(
			resourcePrimKey, latest, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_L;
				finderArgs = new Object[] {resourcePrimKey, latest};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_L;
			finderArgs = new Object[] {
				resourcePrimKey, latest, start, end, orderByComparator
			};
		}

		List<Memo> list = null;

		if (useFinderCache) {
			list = (List<Memo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Memo memo : list) {
					if ((resourcePrimKey != memo.getResourcePrimKey()) ||
						(latest != memo.isLatest())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_L_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_L_LATEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MemoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(latest);

				list = (List<Memo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_L_First(
			long resourcePrimKey, boolean latest,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_L_First(
			resourcePrimKey, latest, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append(", latest=");
		sb.append(latest);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_L_First(
		long resourcePrimKey, boolean latest,
		OrderByComparator<Memo> orderByComparator) {

		List<Memo> list = findByR_L(
			resourcePrimKey, latest, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_L_Last(
			long resourcePrimKey, boolean latest,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_L_Last(resourcePrimKey, latest, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append(", latest=");
		sb.append(latest);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_L_Last(
		long resourcePrimKey, boolean latest,
		OrderByComparator<Memo> orderByComparator) {

		int count = countByR_L(resourcePrimKey, latest);

		if (count == 0) {
			return null;
		}

		List<Memo> list = findByR_L(
			resourcePrimKey, latest, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the memos before and after the current memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param memoId the primary key of the current memo
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo[] findByR_L_PrevAndNext(
			long memoId, long resourcePrimKey, boolean latest,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = findByPrimaryKey(memoId);

		Session session = null;

		try {
			session = openSession();

			Memo[] array = new MemoImpl[3];

			array[0] = getByR_L_PrevAndNext(
				session, memo, resourcePrimKey, latest, orderByComparator,
				true);

			array[1] = memo;

			array[2] = getByR_L_PrevAndNext(
				session, memo, resourcePrimKey, latest, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Memo getByR_L_PrevAndNext(
		Session session, Memo memo, long resourcePrimKey, boolean latest,
		OrderByComparator<Memo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MEMO_WHERE);

		sb.append(_FINDER_COLUMN_R_L_RESOURCEPRIMKEY_2);

		sb.append(_FINDER_COLUMN_R_L_LATEST_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MemoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourcePrimKey);

		queryPos.add(latest);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(memo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Memo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and latest = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 */
	@Override
	public void removeByR_L(long resourcePrimKey, boolean latest) {
		for (Memo memo :
				findByR_L(
					resourcePrimKey, latest, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(memo);
		}
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @return the number of matching memos
	 */
	@Override
	public int countByR_L(long resourcePrimKey, boolean latest) {
		FinderPath finderPath = _finderPathCountByR_L;

		Object[] finderArgs = new Object[] {resourcePrimKey, latest};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_L_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_L_LATEST_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(latest);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_L_RESOURCEPRIMKEY_2 =
		"memo.resourcePrimKey = ? AND ";

	private static final String _FINDER_COLUMN_R_L_LATEST_2 = "memo.latest = ?";

	private FinderPath _finderPathWithPaginationFindByR_M;
	private FinderPath _finderPathWithoutPaginationFindByR_M;
	private FinderPath _finderPathCountByR_M;

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @return the matching memos
	 */
	@Override
	public List<Memo> findByR_M(long resourcePrimKey, boolean main) {
		return findByR_M(
			resourcePrimKey, main, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @return the range of matching memos
	 */
	@Override
	public List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end) {

		return findByR_M(resourcePrimKey, main, start, end, null);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return findByR_M(
			resourcePrimKey, main, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_M;
				finderArgs = new Object[] {resourcePrimKey, main};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_M;
			finderArgs = new Object[] {
				resourcePrimKey, main, start, end, orderByComparator
			};
		}

		List<Memo> list = null;

		if (useFinderCache) {
			list = (List<Memo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Memo memo : list) {
					if ((resourcePrimKey != memo.getResourcePrimKey()) ||
						(main != memo.isMain())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_M_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_M_MAIN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MemoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(main);

				list = (List<Memo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_M_First(
			long resourcePrimKey, boolean main,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_M_First(resourcePrimKey, main, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append(", main=");
		sb.append(main);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_M_First(
		long resourcePrimKey, boolean main,
		OrderByComparator<Memo> orderByComparator) {

		List<Memo> list = findByR_M(
			resourcePrimKey, main, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_M_Last(
			long resourcePrimKey, boolean main,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_M_Last(resourcePrimKey, main, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append(", main=");
		sb.append(main);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_M_Last(
		long resourcePrimKey, boolean main,
		OrderByComparator<Memo> orderByComparator) {

		int count = countByR_M(resourcePrimKey, main);

		if (count == 0) {
			return null;
		}

		List<Memo> list = findByR_M(
			resourcePrimKey, main, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the memos before and after the current memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param memoId the primary key of the current memo
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo[] findByR_M_PrevAndNext(
			long memoId, long resourcePrimKey, boolean main,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = findByPrimaryKey(memoId);

		Session session = null;

		try {
			session = openSession();

			Memo[] array = new MemoImpl[3];

			array[0] = getByR_M_PrevAndNext(
				session, memo, resourcePrimKey, main, orderByComparator, true);

			array[1] = memo;

			array[2] = getByR_M_PrevAndNext(
				session, memo, resourcePrimKey, main, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Memo getByR_M_PrevAndNext(
		Session session, Memo memo, long resourcePrimKey, boolean main,
		OrderByComparator<Memo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MEMO_WHERE);

		sb.append(_FINDER_COLUMN_R_M_RESOURCEPRIMKEY_2);

		sb.append(_FINDER_COLUMN_R_M_MAIN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MemoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourcePrimKey);

		queryPos.add(main);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(memo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Memo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and main = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 */
	@Override
	public void removeByR_M(long resourcePrimKey, boolean main) {
		for (Memo memo :
				findByR_M(
					resourcePrimKey, main, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(memo);
		}
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @return the number of matching memos
	 */
	@Override
	public int countByR_M(long resourcePrimKey, boolean main) {
		FinderPath finderPath = _finderPathCountByR_M;

		Object[] finderArgs = new Object[] {resourcePrimKey, main};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_M_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_M_MAIN_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(main);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_M_RESOURCEPRIMKEY_2 =
		"memo.resourcePrimKey = ? AND ";

	private static final String _FINDER_COLUMN_R_M_MAIN_2 = "memo.main = ?";

	private FinderPath _finderPathWithPaginationFindByR_S;
	private FinderPath _finderPathWithoutPaginationFindByR_S;
	private FinderPath _finderPathCountByR_S;

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @return the matching memos
	 */
	@Override
	public List<Memo> findByR_S(long resourcePrimKey, int status) {
		return findByR_S(
			resourcePrimKey, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @return the range of matching memos
	 */
	@Override
	public List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end) {

		return findByR_S(resourcePrimKey, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return findByR_S(
			resourcePrimKey, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memos
	 */
	@Override
	public List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_S;
				finderArgs = new Object[] {resourcePrimKey, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_S;
			finderArgs = new Object[] {
				resourcePrimKey, status, start, end, orderByComparator
			};
		}

		List<Memo> list = null;

		if (useFinderCache) {
			list = (List<Memo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Memo memo : list) {
					if ((resourcePrimKey != memo.getResourcePrimKey()) ||
						(status != memo.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_S_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MemoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(status);

				list = (List<Memo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_S_First(
			long resourcePrimKey, int status,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_S_First(
			resourcePrimKey, status, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_S_First(
		long resourcePrimKey, int status,
		OrderByComparator<Memo> orderByComparator) {

		List<Memo> list = findByR_S(
			resourcePrimKey, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	@Override
	public Memo findByR_S_Last(
			long resourcePrimKey, int status,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = fetchByR_S_Last(resourcePrimKey, status, orderByComparator);

		if (memo != null) {
			return memo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchMemoException(sb.toString());
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	@Override
	public Memo fetchByR_S_Last(
		long resourcePrimKey, int status,
		OrderByComparator<Memo> orderByComparator) {

		int count = countByR_S(resourcePrimKey, status);

		if (count == 0) {
			return null;
		}

		List<Memo> list = findByR_S(
			resourcePrimKey, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the memos before and after the current memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param memoId the primary key of the current memo
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo[] findByR_S_PrevAndNext(
			long memoId, long resourcePrimKey, int status,
			OrderByComparator<Memo> orderByComparator)
		throws NoSuchMemoException {

		Memo memo = findByPrimaryKey(memoId);

		Session session = null;

		try {
			session = openSession();

			Memo[] array = new MemoImpl[3];

			array[0] = getByR_S_PrevAndNext(
				session, memo, resourcePrimKey, status, orderByComparator,
				true);

			array[1] = memo;

			array[2] = getByR_S_PrevAndNext(
				session, memo, resourcePrimKey, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Memo getByR_S_PrevAndNext(
		Session session, Memo memo, long resourcePrimKey, int status,
		OrderByComparator<Memo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MEMO_WHERE);

		sb.append(_FINDER_COLUMN_R_S_RESOURCEPRIMKEY_2);

		sb.append(_FINDER_COLUMN_R_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MemoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourcePrimKey);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(memo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Memo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and status = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 */
	@Override
	public void removeByR_S(long resourcePrimKey, int status) {
		for (Memo memo :
				findByR_S(
					resourcePrimKey, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(memo);
		}
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @return the number of matching memos
	 */
	@Override
	public int countByR_S(long resourcePrimKey, int status) {
		FinderPath finderPath = _finderPathCountByR_S;

		Object[] finderArgs = new Object[] {resourcePrimKey, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MEMO_WHERE);

			sb.append(_FINDER_COLUMN_R_S_RESOURCEPRIMKEY_2);

			sb.append(_FINDER_COLUMN_R_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_S_RESOURCEPRIMKEY_2 =
		"memo.resourcePrimKey = ? AND ";

	private static final String _FINDER_COLUMN_R_S_STATUS_2 = "memo.status = ?";

	public MemoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("text", "text_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Memo.class);

		setModelImplClass(MemoImpl.class);
		setModelPKClass(long.class);

		setTable(MemoTable.INSTANCE);
	}

	/**
	 * Caches the memo in the entity cache if it is enabled.
	 *
	 * @param memo the memo
	 */
	@Override
	public void cacheResult(Memo memo) {
		entityCache.putResult(MemoImpl.class, memo.getPrimaryKey(), memo);

		finderCache.putResult(
			_finderPathFetchByR_V,
			new Object[] {memo.getResourcePrimKey(), memo.getVersion()}, memo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the memos in the entity cache if it is enabled.
	 *
	 * @param memos the memos
	 */
	@Override
	public void cacheResult(List<Memo> memos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (memos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Memo memo : memos) {
			if (entityCache.getResult(MemoImpl.class, memo.getPrimaryKey()) ==
					null) {

				cacheResult(memo);
			}
		}
	}

	/**
	 * Clears the cache for all memos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MemoImpl.class);

		finderCache.clearCache(MemoImpl.class);
	}

	/**
	 * Clears the cache for the memo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Memo memo) {
		entityCache.removeResult(MemoImpl.class, memo);
	}

	@Override
	public void clearCache(List<Memo> memos) {
		for (Memo memo : memos) {
			entityCache.removeResult(MemoImpl.class, memo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MemoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MemoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(MemoModelImpl memoModelImpl) {
		Object[] args = new Object[] {
			memoModelImpl.getResourcePrimKey(), memoModelImpl.getVersion()
		};

		finderCache.putResult(_finderPathCountByR_V, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByR_V, args, memoModelImpl);
	}

	/**
	 * Creates a new memo with the primary key. Does not add the memo to the database.
	 *
	 * @param memoId the primary key for the new memo
	 * @return the new memo
	 */
	@Override
	public Memo create(long memoId) {
		Memo memo = new MemoImpl();

		memo.setNew(true);
		memo.setPrimaryKey(memoId);

		memo.setCompanyId(CompanyThreadLocal.getCompanyId());

		return memo;
	}

	/**
	 * Removes the memo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo that was removed
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo remove(long memoId) throws NoSuchMemoException {
		return remove((Serializable)memoId);
	}

	/**
	 * Removes the memo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the memo
	 * @return the memo that was removed
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo remove(Serializable primaryKey) throws NoSuchMemoException {
		Session session = null;

		try {
			session = openSession();

			Memo memo = (Memo)session.get(MemoImpl.class, primaryKey);

			if (memo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(memo);
		}
		catch (NoSuchMemoException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Memo removeImpl(Memo memo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(memo)) {
				memo = (Memo)session.get(
					MemoImpl.class, memo.getPrimaryKeyObj());
			}

			if (memo != null) {
				session.delete(memo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (memo != null) {
			clearCache(memo);
		}

		return memo;
	}

	@Override
	public Memo updateImpl(Memo memo) {
		boolean isNew = memo.isNew();

		if (!(memo instanceof MemoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(memo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(memo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in memo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Memo implementation " +
					memo.getClass());
		}

		MemoModelImpl memoModelImpl = (MemoModelImpl)memo;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (memo.getCreateDate() == null)) {
			if (serviceContext == null) {
				memo.setCreateDate(date);
			}
			else {
				memo.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!memoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				memo.setModifiedDate(date);
			}
			else {
				memo.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(memo);
			}
			else {
				memo = (Memo)session.merge(memo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MemoImpl.class, memoModelImpl, false, true);

		cacheUniqueFindersCache(memoModelImpl);

		if (isNew) {
			memo.setNew(false);
		}

		memo.resetOriginalValues();

		return memo;
	}

	/**
	 * Returns the memo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the memo
	 * @return the memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMemoException {

		Memo memo = fetchByPrimaryKey(primaryKey);

		if (memo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMemoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return memo;
	}

	/**
	 * Returns the memo with the primary key or throws a <code>NoSuchMemoException</code> if it could not be found.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	@Override
	public Memo findByPrimaryKey(long memoId) throws NoSuchMemoException {
		return findByPrimaryKey((Serializable)memoId);
	}

	/**
	 * Returns the memo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo, or <code>null</code> if a memo with the primary key could not be found
	 */
	@Override
	public Memo fetchByPrimaryKey(long memoId) {
		return fetchByPrimaryKey((Serializable)memoId);
	}

	/**
	 * Returns all the memos.
	 *
	 * @return the memos
	 */
	@Override
	public List<Memo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the memos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @return the range of memos
	 */
	@Override
	public List<Memo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the memos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of memos
	 */
	@Override
	public List<Memo> findAll(
		int start, int end, OrderByComparator<Memo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the memos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of memos
	 */
	@Override
	public List<Memo> findAll(
		int start, int end, OrderByComparator<Memo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Memo> list = null;

		if (useFinderCache) {
			list = (List<Memo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MEMO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MEMO;

				sql = sql.concat(MemoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Memo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the memos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Memo memo : findAll()) {
			remove(memo);
		}
	}

	/**
	 * Returns the number of memos.
	 *
	 * @return the number of memos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MEMO);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "memoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MEMO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MemoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the memo persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByResourcePrimKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResourcePrimKey",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"resourcePrimKey"}, true);

		_finderPathWithoutPaginationFindByResourcePrimKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourcePrimKey",
			new String[] {Long.class.getName()},
			new String[] {"resourcePrimKey"}, true);

		_finderPathCountByResourcePrimKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResourcePrimKey",
			new String[] {Long.class.getName()},
			new String[] {"resourcePrimKey"}, false);

		_finderPathWithPaginationFindByR = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"resourcePrimKey"}, true);

		_finderPathWithoutPaginationFindByR = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR",
			new String[] {Long.class.getName()},
			new String[] {"resourcePrimKey"}, true);

		_finderPathCountByR = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR",
			new String[] {Long.class.getName()},
			new String[] {"resourcePrimKey"}, false);

		_finderPathFetchByR_V = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByR_V",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"resourcePrimKey", "version"}, true);

		_finderPathCountByR_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_V",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"resourcePrimKey", "version"}, false);

		_finderPathWithPaginationFindByR_L = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"resourcePrimKey", "latest"}, true);

		_finderPathWithoutPaginationFindByR_L = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_L",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"resourcePrimKey", "latest"}, true);

		_finderPathCountByR_L = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_L",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"resourcePrimKey", "latest"}, false);

		_finderPathWithPaginationFindByR_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_M",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"resourcePrimKey", "main"}, true);

		_finderPathWithoutPaginationFindByR_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_M",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"resourcePrimKey", "main"}, true);

		_finderPathCountByR_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_M",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"resourcePrimKey", "main"}, false);

		_finderPathWithPaginationFindByR_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"resourcePrimKey", "status"}, true);

		_finderPathWithoutPaginationFindByR_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"resourcePrimKey", "status"}, true);

		_finderPathCountByR_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"resourcePrimKey", "status"}, false);

		MemoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		MemoUtil.setPersistence(null);

		entityCache.removeCache(MemoImpl.class.getName());
	}

	@Override
	@Reference(
		target = memoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = memoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = memoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MEMO = "SELECT memo FROM Memo memo";

	private static final String _SQL_SELECT_MEMO_WHERE =
		"SELECT memo FROM Memo memo WHERE ";

	private static final String _SQL_COUNT_MEMO =
		"SELECT COUNT(memo) FROM Memo memo";

	private static final String _SQL_COUNT_MEMO_WHERE =
		"SELECT COUNT(memo) FROM Memo memo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "memo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Memo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Memo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MemoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"text"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}