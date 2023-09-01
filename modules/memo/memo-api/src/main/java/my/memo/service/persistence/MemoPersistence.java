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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import my.memo.exception.NoSuchMemoException;
import my.memo.model.Memo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the memo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemoUtil
 * @generated
 */
@ProviderType
public interface MemoPersistence extends BasePersistence<Memo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemoUtil} to access the memo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching memos
	 */
	public java.util.List<Memo> findByResourcePrimKey(long resourcePrimKey);

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
	public java.util.List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end);

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
	public java.util.List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public java.util.List<Memo> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByResourcePrimKey_First(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByResourcePrimKey_First(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByResourcePrimKey_Last(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByResourcePrimKey_Last(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

	/**
	 * Returns the memos before and after the current memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param memoId the primary key of the current memo
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	public Memo[] findByResourcePrimKey_PrevAndNext(
			long memoId, long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Removes all the memos where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public void removeByResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns the number of memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching memos
	 */
	public int countByResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns all the memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching memos
	 */
	public java.util.List<Memo> findByR(long resourcePrimKey);

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
	public java.util.List<Memo> findByR(
		long resourcePrimKey, int start, int end);

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
	public java.util.List<Memo> findByR(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public java.util.List<Memo> findByR(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_First(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_First(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_Last(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_Last(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

	/**
	 * Returns the memos before and after the current memo in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param memoId the primary key of the current memo
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	public Memo[] findByR_PrevAndNext(
			long memoId, long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Removes all the memos where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public void removeByR(long resourcePrimKey);

	/**
	 * Returns the number of memos where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching memos
	 */
	public int countByR(long resourcePrimKey);

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or throws a <code>NoSuchMemoException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_V(long resourcePrimKey, int version)
		throws NoSuchMemoException;

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_V(long resourcePrimKey, int version);

	/**
	 * Returns the memo where resourcePrimKey = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_V(
		long resourcePrimKey, int version, boolean useFinderCache);

	/**
	 * Removes the memo where resourcePrimKey = &#63; and version = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the memo that was removed
	 */
	public Memo removeByR_V(long resourcePrimKey, int version)
		throws NoSuchMemoException;

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and version = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param version the version
	 * @return the number of matching memos
	 */
	public int countByR_V(long resourcePrimKey, int version);

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @return the matching memos
	 */
	public java.util.List<Memo> findByR_L(long resourcePrimKey, boolean latest);

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
	public java.util.List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end);

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
	public java.util.List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public java.util.List<Memo> findByR_L(
		long resourcePrimKey, boolean latest, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_L_First(
			long resourcePrimKey, boolean latest,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_L_First(
		long resourcePrimKey, boolean latest,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_L_Last(
			long resourcePrimKey, boolean latest,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_L_Last(
		long resourcePrimKey, boolean latest,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public Memo[] findByR_L_PrevAndNext(
			long memoId, long resourcePrimKey, boolean latest,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and latest = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 */
	public void removeByR_L(long resourcePrimKey, boolean latest);

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and latest = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param latest the latest
	 * @return the number of matching memos
	 */
	public int countByR_L(long resourcePrimKey, boolean latest);

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @return the matching memos
	 */
	public java.util.List<Memo> findByR_M(long resourcePrimKey, boolean main);

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
	public java.util.List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end);

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
	public java.util.List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public java.util.List<Memo> findByR_M(
		long resourcePrimKey, boolean main, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_M_First(
			long resourcePrimKey, boolean main,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_M_First(
		long resourcePrimKey, boolean main,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_M_Last(
			long resourcePrimKey, boolean main,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_M_Last(
		long resourcePrimKey, boolean main,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public Memo[] findByR_M_PrevAndNext(
			long memoId, long resourcePrimKey, boolean main,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and main = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 */
	public void removeByR_M(long resourcePrimKey, boolean main);

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and main = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param main the main
	 * @return the number of matching memos
	 */
	public int countByR_M(long resourcePrimKey, boolean main);

	/**
	 * Returns all the memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @return the matching memos
	 */
	public java.util.List<Memo> findByR_S(long resourcePrimKey, int status);

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
	public java.util.List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end);

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
	public java.util.List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public java.util.List<Memo> findByR_S(
		long resourcePrimKey, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_S_First(
			long resourcePrimKey, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the first memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_S_First(
		long resourcePrimKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo
	 * @throws NoSuchMemoException if a matching memo could not be found
	 */
	public Memo findByR_S_Last(
			long resourcePrimKey, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Returns the last memo in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching memo, or <code>null</code> if a matching memo could not be found
	 */
	public Memo fetchByR_S_Last(
		long resourcePrimKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public Memo[] findByR_S_PrevAndNext(
			long memoId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Memo>
				orderByComparator)
		throws NoSuchMemoException;

	/**
	 * Removes all the memos where resourcePrimKey = &#63; and status = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 */
	public void removeByR_S(long resourcePrimKey, int status);

	/**
	 * Returns the number of memos where resourcePrimKey = &#63; and status = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param status the status
	 * @return the number of matching memos
	 */
	public int countByR_S(long resourcePrimKey, int status);

	/**
	 * Caches the memo in the entity cache if it is enabled.
	 *
	 * @param memo the memo
	 */
	public void cacheResult(Memo memo);

	/**
	 * Caches the memos in the entity cache if it is enabled.
	 *
	 * @param memos the memos
	 */
	public void cacheResult(java.util.List<Memo> memos);

	/**
	 * Creates a new memo with the primary key. Does not add the memo to the database.
	 *
	 * @param memoId the primary key for the new memo
	 * @return the new memo
	 */
	public Memo create(long memoId);

	/**
	 * Removes the memo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo that was removed
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	public Memo remove(long memoId) throws NoSuchMemoException;

	public Memo updateImpl(Memo memo);

	/**
	 * Returns the memo with the primary key or throws a <code>NoSuchMemoException</code> if it could not be found.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo
	 * @throws NoSuchMemoException if a memo with the primary key could not be found
	 */
	public Memo findByPrimaryKey(long memoId) throws NoSuchMemoException;

	/**
	 * Returns the memo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo, or <code>null</code> if a memo with the primary key could not be found
	 */
	public Memo fetchByPrimaryKey(long memoId);

	/**
	 * Returns all the memos.
	 *
	 * @return the memos
	 */
	public java.util.List<Memo> findAll();

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
	public java.util.List<Memo> findAll(int start, int end);

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
	public java.util.List<Memo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator);

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
	public java.util.List<Memo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Memo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the memos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of memos.
	 *
	 * @return the number of memos
	 */
	public int countAll();

}