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

package my.memo.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import my.memo.model.Memo;

/**
 * The persistence utility for the memo service. This utility wraps <code>my.memo.service.persistence.impl.MemoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemoPersistence
 * @generated
 */
public class MemoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Memo memo) {
		getPersistence().clearCache(memo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Memo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Memo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Memo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Memo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Memo update(Memo memo) {
		return getPersistence().update(memo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Memo update(Memo memo, ServiceContext serviceContext) {
		return getPersistence().update(memo, serviceContext);
	}

	/**
	 * Returns all the memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching memos
	 */
	public static List<Memo> findByResourcePrimKey(long resourcePrimKey) {
		return getPersistence().findByResourcePrimKey(resourcePrimKey);
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
	public static List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end);
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
	public static List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator);
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
	public static List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public static Memo findByResourcePrimKey_First(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByResourcePrimKey_First(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public static Memo findByResourcePrimKey_Last(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByResourcePrimKey_Last(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);
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
	public static Memo[] findByResourcePrimKey_PrevAndNext(
			long memoId, long resourcePrimKey,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByResourcePrimKey_PrevAndNext(
			memoId, resourcePrimKey, orderByComparator);
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public static void removeByResourcePrimKey(long resourcePrimKey) {
		getPersistence().removeByResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching memos
	 */
	public static int countByResourcePrimKey(long resourcePrimKey) {
		return getPersistence().countByResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns all the memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching memos
	 */
	public static List<Memo> findByR(long resourcePrimKey) {
		return getPersistence().findByR(resourcePrimKey);
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
	public static List<Memo> findByR(long resourcePrimKey, int start, int end) {
		return getPersistence().findByR(resourcePrimKey, start, end);
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
	public static List<Memo> findByR(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().findByR(
			resourcePrimKey, start, end, orderByComparator);
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
	public static List<Memo> findByR(
		long resourcePrimKey, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByR(
			resourcePrimKey, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public static Memo findByR_First(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_First(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public static Memo findByR_Last(
			long resourcePrimKey, OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_Last(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_Last(
		long resourcePrimKey, OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_Last(
			resourcePrimKey, orderByComparator);
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
	public static Memo[] findByR_PrevAndNext(
			long memoId, long resourcePrimKey,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_PrevAndNext(
			memoId, resourcePrimKey, orderByComparator);
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public static void removeByR(long resourcePrimKey) {
		getPersistence().removeByR(resourcePrimKey);
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching memos
	 */
	public static int countByR(long resourcePrimKey) {
		return getPersistence().countByR(resourcePrimKey);
	}

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or throws a <code>NoSuchMemoException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public static Memo findByR_V(long resourcePrimKey, int version)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_V(resourcePrimKey, version);
	}

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_V(long resourcePrimKey, int version) {
		return getPersistence().fetchByR_V(resourcePrimKey, version);
	}

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_V(
		long resourcePrimKey, int version, boolean useFinderCache) {

		return getPersistence().fetchByR_V(
			resourcePrimKey, version, useFinderCache);
	}

	/**
	 * Removes the memo where resourcePrimKey = &#63; and version = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the memo that was removed
	 */
	public static Memo removeByR_V(long resourcePrimKey, int version)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().removeByR_V(resourcePrimKey, version);
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and version = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the number of matching memos
	 */
	public static int countByR_V(long resourcePrimKey, int version) {
		return getPersistence().countByR_V(resourcePrimKey, version);
	}

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @return the matching memos
	 */
	public static List<Memo> findByR_L(long resourcePrimKey, boolean latest) {
		return getPersistence().findByR_L(resourcePrimKey, latest);
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
	public static List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end) {

		return getPersistence().findByR_L(resourcePrimKey, latest, start, end);
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
	public static List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().findByR_L(
			resourcePrimKey, latest, start, end, orderByComparator);
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
	public static List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByR_L(
			resourcePrimKey, latest, start, end, orderByComparator,
			useFinderCache);
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
	public static Memo findByR_L_First(
			long resourcePrimKey, boolean latest,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_L_First(
			resourcePrimKey, latest, orderByComparator);
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_L_First(
		long resourcePrimKey, boolean latest,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_L_First(
			resourcePrimKey, latest, orderByComparator);
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
	public static Memo findByR_L_Last(
			long resourcePrimKey, boolean latest,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_L_Last(
			resourcePrimKey, latest, orderByComparator);
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_L_Last(
		long resourcePrimKey, boolean latest,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_L_Last(
			resourcePrimKey, latest, orderByComparator);
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
	public static Memo[] findByR_L_PrevAndNext(
			long memoId, long resourcePrimKey, boolean latest,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_L_PrevAndNext(
			memoId, resourcePrimKey, latest, orderByComparator);
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and latest = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 */
	public static void removeByR_L(long resourcePrimKey, boolean latest) {
		getPersistence().removeByR_L(resourcePrimKey, latest);
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @return the number of matching memos
	 */
	public static int countByR_L(long resourcePrimKey, boolean latest) {
		return getPersistence().countByR_L(resourcePrimKey, latest);
	}

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @return the matching memos
	 */
	public static List<Memo> findByR_M(long resourcePrimKey, boolean main) {
		return getPersistence().findByR_M(resourcePrimKey, main);
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
	public static List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end) {

		return getPersistence().findByR_M(resourcePrimKey, main, start, end);
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
	public static List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().findByR_M(
			resourcePrimKey, main, start, end, orderByComparator);
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
	public static List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByR_M(
			resourcePrimKey, main, start, end, orderByComparator,
			useFinderCache);
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
	public static Memo findByR_M_First(
			long resourcePrimKey, boolean main,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_M_First(
			resourcePrimKey, main, orderByComparator);
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_M_First(
		long resourcePrimKey, boolean main,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_M_First(
			resourcePrimKey, main, orderByComparator);
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
	public static Memo findByR_M_Last(
			long resourcePrimKey, boolean main,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_M_Last(
			resourcePrimKey, main, orderByComparator);
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_M_Last(
		long resourcePrimKey, boolean main,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_M_Last(
			resourcePrimKey, main, orderByComparator);
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
	public static Memo[] findByR_M_PrevAndNext(
			long memoId, long resourcePrimKey, boolean main,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_M_PrevAndNext(
			memoId, resourcePrimKey, main, orderByComparator);
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and main = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 */
	public static void removeByR_M(long resourcePrimKey, boolean main) {
		getPersistence().removeByR_M(resourcePrimKey, main);
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @return the number of matching memos
	 */
	public static int countByR_M(long resourcePrimKey, boolean main) {
		return getPersistence().countByR_M(resourcePrimKey, main);
	}

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @return the matching memos
	 */
	public static List<Memo> findByR_S(long resourcePrimKey, int status) {
		return getPersistence().findByR_S(resourcePrimKey, status);
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
	public static List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end) {

		return getPersistence().findByR_S(resourcePrimKey, status, start, end);
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
	public static List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().findByR_S(
			resourcePrimKey, status, start, end, orderByComparator);
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
	public static List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end,
		OrderByComparator<Memo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByR_S(
			resourcePrimKey, status, start, end, orderByComparator,
			useFinderCache);
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
	public static Memo findByR_S_First(
			long resourcePrimKey, int status,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_S_First(
			resourcePrimKey, status, orderByComparator);
	}

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_S_First(
		long resourcePrimKey, int status,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_S_First(
			resourcePrimKey, status, orderByComparator);
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
	public static Memo findByR_S_Last(
			long resourcePrimKey, int status,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_S_Last(
			resourcePrimKey, status, orderByComparator);
	}

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public static Memo fetchByR_S_Last(
		long resourcePrimKey, int status,
		OrderByComparator<Memo> orderByComparator) {

		return getPersistence().fetchByR_S_Last(
			resourcePrimKey, status, orderByComparator);
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
	public static Memo[] findByR_S_PrevAndNext(
			long memoId, long resourcePrimKey, int status,
			OrderByComparator<Memo> orderByComparator)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByR_S_PrevAndNext(
			memoId, resourcePrimKey, status, orderByComparator);
	}

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and status = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 */
	public static void removeByR_S(long resourcePrimKey, int status) {
		getPersistence().removeByR_S(resourcePrimKey, status);
	}

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @return the number of matching memos
	 */
	public static int countByR_S(long resourcePrimKey, int status) {
		return getPersistence().countByR_S(resourcePrimKey, status);
	}

	/**
	 * Caches the memo in the entity cache if it is enabled.
	 *
	 * @param memo the memo
	 */
	public static void cacheResult(Memo memo) {
		getPersistence().cacheResult(memo);
	}

	/**
	 * Caches the memos in the entity cache if it is enabled.
	 *
	 * @param memos the memos
	 */
	public static void cacheResult(List<Memo> memos) {
		getPersistence().cacheResult(memos);
	}

	/**
	 * Creates a new memo with the primary key. Does not add the memo to the database.
	 *
	 * @param memoId the primary key for the new memo
	 * @return the new memo
	 */
	public static Memo create(long memoId) {
		return getPersistence().create(memoId);
	}

	/**
	 * Removes the memo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo that was removed
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	public static Memo remove(long memoId)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().remove(memoId);
	}

	public static Memo updateImpl(Memo memo) {
		return getPersistence().updateImpl(memo);
	}

	/**
	 * Returns the memo with the primary key or throws a <code>NoSuchMemoException</code> if it could not be found.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	public static Memo findByPrimaryKey(long memoId)
		throws my.memo.exception.NoSuchMemoException {

		return getPersistence().findByPrimaryKey(memoId);
	}

	/**
	 * Returns the memo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo, or <code>null</code> if a memo with the primary key could not be found
	 */
	public static Memo fetchByPrimaryKey(long memoId) {
		return getPersistence().fetchByPrimaryKey(memoId);
	}

	/**
	 * Returns all the memos.
	 *
	 * @return the memos
	 */
	public static List<Memo> findAll() {
		return getPersistence().findAll();
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
	public static List<Memo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Memo> findAll(
		int start, int end, OrderByComparator<Memo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Memo> findAll(
		int start, int end, OrderByComparator<Memo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the memos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of memos.
	 *
	 * @return the number of memos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MemoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(MemoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile MemoPersistence _persistence;

}