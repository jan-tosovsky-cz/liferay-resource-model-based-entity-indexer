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

package my.memo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Memo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Memo
 * @generated
 */
public class MemoWrapper
	extends BaseModelWrapper<Memo> implements Memo, ModelWrapper<Memo> {

	public MemoWrapper(Memo memo) {
		super(memo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memoId", getMemoId());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("text", getText());
		attributes.put("version", getVersion());
		attributes.put("summary", getSummary());
		attributes.put("latest", isLatest());
		attributes.put("main", isMain());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memoId = (Long)attributes.get("memoId");

		if (memoId != null) {
			setMemoId(memoId);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		Boolean latest = (Boolean)attributes.get("latest");

		if (latest != null) {
			setLatest(latest);
		}

		Boolean main = (Boolean)attributes.get("main");

		if (main != null) {
			setMain(main);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public Memo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this memo.
	 *
	 * @return the company ID of this memo
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the container model ID of this memo.
	 *
	 * @return the container model ID of this memo
	 */
	@Override
	public long getContainerModelId() {
		return model.getContainerModelId();
	}

	/**
	 * Returns the container name of this memo.
	 *
	 * @return the container name of this memo
	 */
	@Override
	public String getContainerModelName() {
		return model.getContainerModelName();
	}

	/**
	 * Returns the create date of this memo.
	 *
	 * @return the create date of this memo
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this memo.
	 *
	 * @return the group ID of this memo
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the latest of this memo.
	 *
	 * @return the latest of this memo
	 */
	@Override
	public boolean getLatest() {
		return model.getLatest();
	}

	/**
	 * Returns the main of this memo.
	 *
	 * @return the main of this memo
	 */
	@Override
	public boolean getMain() {
		return model.getMain();
	}

	/**
	 * Returns the memo ID of this memo.
	 *
	 * @return the memo ID of this memo
	 */
	@Override
	public long getMemoId() {
		return model.getMemoId();
	}

	/**
	 * Returns the modified date of this memo.
	 *
	 * @return the modified date of this memo
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the parent container model ID of this memo.
	 *
	 * @return the parent container model ID of this memo
	 */
	@Override
	public long getParentContainerModelId() {
		return model.getParentContainerModelId();
	}

	/**
	 * Returns the primary key of this memo.
	 *
	 * @return the primary key of this memo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resource prim key of this memo.
	 *
	 * @return the resource prim key of this memo
	 */
	@Override
	public long getResourcePrimKey() {
		return model.getResourcePrimKey();
	}

	/**
	 * Returns the status of this memo.
	 *
	 * @return the status of this memo
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this memo.
	 *
	 * @return the status by user ID of this memo
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this memo.
	 *
	 * @return the status by user name of this memo
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this memo.
	 *
	 * @return the status by user uuid of this memo
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this memo.
	 *
	 * @return the status date of this memo
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the summary of this memo.
	 *
	 * @return the summary of this memo
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the text of this memo.
	 *
	 * @return the text of this memo
	 */
	@Override
	public String getText() {
		return model.getText();
	}

	/**
	 * Returns the user ID of this memo.
	 *
	 * @return the user ID of this memo
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this memo.
	 *
	 * @return the user name of this memo
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this memo.
	 *
	 * @return the user uuid of this memo
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the version of this memo.
	 *
	 * @return the version of this memo
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this memo is approved.
	 *
	 * @return <code>true</code> if this memo is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this memo is denied.
	 *
	 * @return <code>true</code> if this memo is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this memo is a draft.
	 *
	 * @return <code>true</code> if this memo is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this memo is expired.
	 *
	 * @return <code>true</code> if this memo is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this memo is inactive.
	 *
	 * @return <code>true</code> if this memo is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this memo is incomplete.
	 *
	 * @return <code>true</code> if this memo is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this memo is latest.
	 *
	 * @return <code>true</code> if this memo is latest; <code>false</code> otherwise
	 */
	@Override
	public boolean isLatest() {
		return model.isLatest();
	}

	/**
	 * Returns <code>true</code> if this memo is main.
	 *
	 * @return <code>true</code> if this memo is main; <code>false</code> otherwise
	 */
	@Override
	public boolean isMain() {
		return model.isMain();
	}

	/**
	 * Returns <code>true</code> if this memo is pending.
	 *
	 * @return <code>true</code> if this memo is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	@Override
	public boolean isResourceMain() {
		return model.isResourceMain();
	}

	/**
	 * Returns <code>true</code> if this memo is scheduled.
	 *
	 * @return <code>true</code> if this memo is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this memo.
	 *
	 * @param companyId the company ID of this memo
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the container model ID of this memo.
	 *
	 * @param containerModelId the container model ID of this memo
	 */
	@Override
	public void setContainerModelId(long containerModelId) {
		model.setContainerModelId(containerModelId);
	}

	/**
	 * Sets the create date of this memo.
	 *
	 * @param createDate the create date of this memo
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this memo.
	 *
	 * @param groupId the group ID of this memo
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this memo is latest.
	 *
	 * @param latest the latest of this memo
	 */
	@Override
	public void setLatest(boolean latest) {
		model.setLatest(latest);
	}

	/**
	 * Sets whether this memo is main.
	 *
	 * @param main the main of this memo
	 */
	@Override
	public void setMain(boolean main) {
		model.setMain(main);
	}

	/**
	 * Sets the memo ID of this memo.
	 *
	 * @param memoId the memo ID of this memo
	 */
	@Override
	public void setMemoId(long memoId) {
		model.setMemoId(memoId);
	}

	/**
	 * Sets the modified date of this memo.
	 *
	 * @param modifiedDate the modified date of this memo
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the parent container model ID of this memo.
	 *
	 * @param parentContainerModelId the parent container model ID of this memo
	 */
	@Override
	public void setParentContainerModelId(long parentContainerModelId) {
		model.setParentContainerModelId(parentContainerModelId);
	}

	/**
	 * Sets the primary key of this memo.
	 *
	 * @param primaryKey the primary key of this memo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the resource prim key of this memo.
	 *
	 * @param resourcePrimKey the resource prim key of this memo
	 */
	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		model.setResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Sets the status of this memo.
	 *
	 * @param status the status of this memo
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this memo.
	 *
	 * @param statusByUserId the status by user ID of this memo
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this memo.
	 *
	 * @param statusByUserName the status by user name of this memo
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this memo.
	 *
	 * @param statusByUserUuid the status by user uuid of this memo
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this memo.
	 *
	 * @param statusDate the status date of this memo
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the summary of this memo.
	 *
	 * @param summary the summary of this memo
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the text of this memo.
	 *
	 * @param text the text of this memo
	 */
	@Override
	public void setText(String text) {
		model.setText(text);
	}

	/**
	 * Sets the user ID of this memo.
	 *
	 * @param userId the user ID of this memo
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this memo.
	 *
	 * @param userName the user name of this memo
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this memo.
	 *
	 * @param userUuid the user uuid of this memo
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the version of this memo.
	 *
	 * @param version the version of this memo
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected MemoWrapper wrap(Memo memo) {
		return new MemoWrapper(memo);
	}

}