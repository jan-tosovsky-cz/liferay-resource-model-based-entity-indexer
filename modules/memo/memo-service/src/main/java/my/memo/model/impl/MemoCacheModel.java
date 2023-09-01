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

package my.memo.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import my.memo.model.Memo;

/**
 * The cache model class for representing Memo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MemoCacheModel implements CacheModel<Memo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MemoCacheModel)) {
			return false;
		}

		MemoCacheModel memoCacheModel = (MemoCacheModel)object;

		if (memoId == memoCacheModel.memoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{memoId=");
		sb.append(memoId);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", text=");
		sb.append(text);
		sb.append(", version=");
		sb.append(version);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", latest=");
		sb.append(latest);
		sb.append(", main=");
		sb.append(main);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Memo toEntityModel() {
		MemoImpl memoImpl = new MemoImpl();

		memoImpl.setMemoId(memoId);
		memoImpl.setResourcePrimKey(resourcePrimKey);
		memoImpl.setGroupId(groupId);
		memoImpl.setCompanyId(companyId);
		memoImpl.setUserId(userId);

		if (userName == null) {
			memoImpl.setUserName("");
		}
		else {
			memoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			memoImpl.setCreateDate(null);
		}
		else {
			memoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memoImpl.setModifiedDate(null);
		}
		else {
			memoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (text == null) {
			memoImpl.setText("");
		}
		else {
			memoImpl.setText(text);
		}

		memoImpl.setVersion(version);

		if (summary == null) {
			memoImpl.setSummary("");
		}
		else {
			memoImpl.setSummary(summary);
		}

		memoImpl.setLatest(latest);
		memoImpl.setMain(main);
		memoImpl.setStatus(status);
		memoImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			memoImpl.setStatusByUserName("");
		}
		else {
			memoImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			memoImpl.setStatusDate(null);
		}
		else {
			memoImpl.setStatusDate(new Date(statusDate));
		}

		memoImpl.resetOriginalValues();

		return memoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memoId = objectInput.readLong();

		resourcePrimKey = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		text = objectInput.readUTF();

		version = objectInput.readInt();
		summary = objectInput.readUTF();

		latest = objectInput.readBoolean();

		main = objectInput.readBoolean();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(memoId);

		objectOutput.writeLong(resourcePrimKey);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text);
		}

		objectOutput.writeInt(version);

		if (summary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(summary);
		}

		objectOutput.writeBoolean(latest);

		objectOutput.writeBoolean(main);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long memoId;
	public long resourcePrimKey;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String text;
	public int version;
	public String summary;
	public boolean latest;
	public boolean main;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}