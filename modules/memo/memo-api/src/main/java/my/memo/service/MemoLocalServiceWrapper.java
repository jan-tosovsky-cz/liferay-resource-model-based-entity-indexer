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

package my.memo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MemoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MemoLocalService
 * @generated
 */
public class MemoLocalServiceWrapper
	implements MemoLocalService, ServiceWrapper<MemoLocalService> {

	public MemoLocalServiceWrapper() {
		this(null);
	}

	public MemoLocalServiceWrapper(MemoLocalService memoLocalService) {
		_memoLocalService = memoLocalService;
	}

	@Override
	public my.memo.model.Memo addMemo(
			long userId, long groupId, String text, String summary)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memoLocalService.addMemo(userId, groupId, text, summary);
	}

	/**
	 * Adds the memo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MemoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param memo the memo
	 * @return the memo that was added
	 */
	@Override
	public my.memo.model.Memo addMemo(my.memo.model.Memo memo) {
		return _memoLocalService.addMemo(memo);
	}

	/**
	 * Creates a new memo with the primary key. Does not add the memo to the database.
	 *
	 * @param memoId the primary key for the new memo
	 * @return the new memo
	 */
	@Override
	public my.memo.model.Memo createMemo(long memoId) {
		return _memoLocalService.createMemo(memoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the memo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MemoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo that was removed
	 * @throws PortalException if a memo with the primary key could not be found
	 */
	@Override
	public my.memo.model.Memo deleteMemo(long memoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memoLocalService.deleteMemo(memoId);
	}

	/**
	 * Deletes the memo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MemoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param memo the memo
	 * @return the memo that was removed
	 */
	@Override
	public my.memo.model.Memo deleteMemo(my.memo.model.Memo memo) {
		return _memoLocalService.deleteMemo(memo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _memoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _memoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _memoLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _memoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>my.memo.model.impl.MemoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _memoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>my.memo.model.impl.MemoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _memoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _memoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _memoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public my.memo.model.Memo fetchLatestMemo(
		long resourcePrimKey, int status) {

		return _memoLocalService.fetchLatestMemo(resourcePrimKey, status);
	}

	@Override
	public my.memo.model.Memo fetchMemo(long memoId) {
		return _memoLocalService.fetchMemo(memoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _memoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _memoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the memo with the primary key.
	 *
	 * @param memoId the primary key of the memo
	 * @return the memo
	 * @throws PortalException if a memo with the primary key could not be found
	 */
	@Override
	public my.memo.model.Memo getMemo(long memoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memoLocalService.getMemo(memoId);
	}

	/**
	 * Returns a range of all the memos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>my.memo.model.impl.MemoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of memos
	 * @param end the upper bound of the range of memos (not inclusive)
	 * @return the range of memos
	 */
	@Override
	public java.util.List<my.memo.model.Memo> getMemos(int start, int end) {
		return _memoLocalService.getMemos(start, end);
	}

	/**
	 * Returns the number of memos.
	 *
	 * @return the number of memos
	 */
	@Override
	public int getMemosCount() {
		return _memoLocalService.getMemosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _memoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<? extends com.liferay.portal.kernel.model.PersistedModel>
				getPersistedModel(long resourcePrimKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _memoLocalService.getPersistedModel(resourcePrimKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public my.memo.model.Memo updateMemo(
			long userId, long resourcePrimKey, String text, String summary)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _memoLocalService.updateMemo(
			userId, resourcePrimKey, text, summary);
	}

	/**
	 * Updates the memo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MemoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param memo the memo
	 * @return the memo that was updated
	 */
	@Override
	public my.memo.model.Memo updateMemo(my.memo.model.Memo memo) {
		return _memoLocalService.updateMemo(memo);
	}

	@Override
	public my.memo.model.Memo updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _memoLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Override
	public MemoLocalService getWrappedService() {
		return _memoLocalService;
	}

	@Override
	public void setWrappedService(MemoLocalService memoLocalService) {
		_memoLocalService = memoLocalService;
	}

	private MemoLocalService _memoLocalService;

}