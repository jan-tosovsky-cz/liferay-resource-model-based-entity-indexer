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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

import my.memo.model.Memo;
import my.memo.model.MemoModel;

/**
 * The base model implementation for the Memo service. Represents a row in the &quot;memo_Memo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>MemoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MemoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemoImpl
 * @generated
 */
public class MemoModelImpl extends BaseModelImpl<Memo> implements MemoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a memo model instance should use the <code>Memo</code> interface instead.
	 */
	public static final String TABLE_NAME = "memo_Memo";

	public static final Object[][] TABLE_COLUMNS = {
		{"memoId", Types.BIGINT}, {"resourcePrimKey", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"text_", Types.VARCHAR}, {"version", Types.INTEGER},
		{"summary", Types.VARCHAR}, {"latest", Types.BOOLEAN},
		{"main", Types.BOOLEAN}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("memoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("resourcePrimKey", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("text_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("version", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("summary", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("latest", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("main", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table memo_Memo (memoId LONG not null primary key,resourcePrimKey LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,text_ VARCHAR(75) null,version INTEGER,summary VARCHAR(75) null,latest BOOLEAN,main BOOLEAN,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table memo_Memo";

	public static final String ORDER_BY_JPQL = " ORDER BY memo.memoId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY memo_Memo.memoId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LATEST_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long MAIN_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long RESOURCEPRIMKEY_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long VERSION_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long MEMOID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public MemoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _memoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMemoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _memoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Memo.class;
	}

	@Override
	public String getModelClassName() {
		return Memo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Memo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Memo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Memo, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Memo)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Memo, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Memo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Memo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Memo, Object>> getAttributeGetterFunctions() {
		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Memo, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Memo, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Memo, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Memo, Object>>();

			attributeGetterFunctions.put("memoId", Memo::getMemoId);
			attributeGetterFunctions.put(
				"resourcePrimKey", Memo::getResourcePrimKey);
			attributeGetterFunctions.put("groupId", Memo::getGroupId);
			attributeGetterFunctions.put("companyId", Memo::getCompanyId);
			attributeGetterFunctions.put("userId", Memo::getUserId);
			attributeGetterFunctions.put("userName", Memo::getUserName);
			attributeGetterFunctions.put("createDate", Memo::getCreateDate);
			attributeGetterFunctions.put("modifiedDate", Memo::getModifiedDate);
			attributeGetterFunctions.put("text", Memo::getText);
			attributeGetterFunctions.put("version", Memo::getVersion);
			attributeGetterFunctions.put("summary", Memo::getSummary);
			attributeGetterFunctions.put("latest", Memo::getLatest);
			attributeGetterFunctions.put("main", Memo::getMain);
			attributeGetterFunctions.put("status", Memo::getStatus);
			attributeGetterFunctions.put(
				"statusByUserId", Memo::getStatusByUserId);
			attributeGetterFunctions.put(
				"statusByUserName", Memo::getStatusByUserName);
			attributeGetterFunctions.put("statusDate", Memo::getStatusDate);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Memo, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Memo, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Memo, ?>>();

			attributeSetterBiConsumers.put(
				"memoId", (BiConsumer<Memo, Long>)Memo::setMemoId);
			attributeSetterBiConsumers.put(
				"resourcePrimKey",
				(BiConsumer<Memo, Long>)Memo::setResourcePrimKey);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Memo, Long>)Memo::setGroupId);
			attributeSetterBiConsumers.put(
				"companyId", (BiConsumer<Memo, Long>)Memo::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Memo, Long>)Memo::setUserId);
			attributeSetterBiConsumers.put(
				"userName", (BiConsumer<Memo, String>)Memo::setUserName);
			attributeSetterBiConsumers.put(
				"createDate", (BiConsumer<Memo, Date>)Memo::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate", (BiConsumer<Memo, Date>)Memo::setModifiedDate);
			attributeSetterBiConsumers.put(
				"text", (BiConsumer<Memo, String>)Memo::setText);
			attributeSetterBiConsumers.put(
				"version", (BiConsumer<Memo, Integer>)Memo::setVersion);
			attributeSetterBiConsumers.put(
				"summary", (BiConsumer<Memo, String>)Memo::setSummary);
			attributeSetterBiConsumers.put(
				"latest", (BiConsumer<Memo, Boolean>)Memo::setLatest);
			attributeSetterBiConsumers.put(
				"main", (BiConsumer<Memo, Boolean>)Memo::setMain);
			attributeSetterBiConsumers.put(
				"status", (BiConsumer<Memo, Integer>)Memo::setStatus);
			attributeSetterBiConsumers.put(
				"statusByUserId",
				(BiConsumer<Memo, Long>)Memo::setStatusByUserId);
			attributeSetterBiConsumers.put(
				"statusByUserName",
				(BiConsumer<Memo, String>)Memo::setStatusByUserName);
			attributeSetterBiConsumers.put(
				"statusDate", (BiConsumer<Memo, Date>)Memo::setStatusDate);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@Override
	public long getMemoId() {
		return _memoId;
	}

	@Override
	public void setMemoId(long memoId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memoId = memoId;
	}

	@Override
	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_resourcePrimKey = resourcePrimKey;
	}

	@Override
	public boolean isResourceMain() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalResourcePrimKey() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("resourcePrimKey"));
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getText() {
		if (_text == null) {
			return "";
		}
		else {
			return _text;
		}
	}

	@Override
	public void setText(String text) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_text = text;
	}

	@Override
	public int getVersion() {
		return _version;
	}

	@Override
	public void setVersion(int version) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_version = version;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalVersion() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("version"));
	}

	@Override
	public String getSummary() {
		if (_summary == null) {
			return "";
		}
		else {
			return _summary;
		}
	}

	@Override
	public void setSummary(String summary) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_summary = summary;
	}

	@Override
	public boolean getLatest() {
		return _latest;
	}

	@Override
	public boolean isLatest() {
		return _latest;
	}

	@Override
	public void setLatest(boolean latest) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_latest = latest;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalLatest() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("latest"));
	}

	@Override
	public boolean getMain() {
		return _main;
	}

	@Override
	public boolean isMain() {
		return _main;
	}

	@Override
	public void setMain(boolean main) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_main = main;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalMain() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("main"));
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalStatus() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("status"));
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public long getContainerModelId() {
		return getResourcePrimKey();
	}

	@Override
	public void setContainerModelId(long containerModelId) {
		_resourcePrimKey = containerModelId;
	}

	@Override
	public String getContainerModelName() {
		return String.valueOf(getContainerModelId());
	}

	@Override
	public long getParentContainerModelId() {
		return 0;
	}

	@Override
	public void setParentContainerModelId(long parentContainerModelId) {
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Memo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Memo toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Memo>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MemoImpl memoImpl = new MemoImpl();

		memoImpl.setMemoId(getMemoId());
		memoImpl.setResourcePrimKey(getResourcePrimKey());
		memoImpl.setGroupId(getGroupId());
		memoImpl.setCompanyId(getCompanyId());
		memoImpl.setUserId(getUserId());
		memoImpl.setUserName(getUserName());
		memoImpl.setCreateDate(getCreateDate());
		memoImpl.setModifiedDate(getModifiedDate());
		memoImpl.setText(getText());
		memoImpl.setVersion(getVersion());
		memoImpl.setSummary(getSummary());
		memoImpl.setLatest(isLatest());
		memoImpl.setMain(isMain());
		memoImpl.setStatus(getStatus());
		memoImpl.setStatusByUserId(getStatusByUserId());
		memoImpl.setStatusByUserName(getStatusByUserName());
		memoImpl.setStatusDate(getStatusDate());

		memoImpl.resetOriginalValues();

		return memoImpl;
	}

	@Override
	public Memo cloneWithOriginalValues() {
		MemoImpl memoImpl = new MemoImpl();

		memoImpl.setMemoId(this.<Long>getColumnOriginalValue("memoId"));
		memoImpl.setResourcePrimKey(
			this.<Long>getColumnOriginalValue("resourcePrimKey"));
		memoImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		memoImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		memoImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		memoImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		memoImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		memoImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		memoImpl.setText(this.<String>getColumnOriginalValue("text_"));
		memoImpl.setVersion(this.<Integer>getColumnOriginalValue("version"));
		memoImpl.setSummary(this.<String>getColumnOriginalValue("summary"));
		memoImpl.setLatest(this.<Boolean>getColumnOriginalValue("latest"));
		memoImpl.setMain(this.<Boolean>getColumnOriginalValue("main"));
		memoImpl.setStatus(this.<Integer>getColumnOriginalValue("status"));
		memoImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		memoImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		memoImpl.setStatusDate(this.<Date>getColumnOriginalValue("statusDate"));

		return memoImpl;
	}

	@Override
	public int compareTo(Memo memo) {
		long primaryKey = memo.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Memo)) {
			return false;
		}

		Memo memo = (Memo)object;

		long primaryKey = memo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Memo> toCacheModel() {
		MemoCacheModel memoCacheModel = new MemoCacheModel();

		memoCacheModel.memoId = getMemoId();

		memoCacheModel.resourcePrimKey = getResourcePrimKey();

		memoCacheModel.groupId = getGroupId();

		memoCacheModel.companyId = getCompanyId();

		memoCacheModel.userId = getUserId();

		memoCacheModel.userName = getUserName();

		String userName = memoCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			memoCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			memoCacheModel.createDate = createDate.getTime();
		}
		else {
			memoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			memoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			memoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		memoCacheModel.text = getText();

		String text = memoCacheModel.text;

		if ((text != null) && (text.length() == 0)) {
			memoCacheModel.text = null;
		}

		memoCacheModel.version = getVersion();

		memoCacheModel.summary = getSummary();

		String summary = memoCacheModel.summary;

		if ((summary != null) && (summary.length() == 0)) {
			memoCacheModel.summary = null;
		}

		memoCacheModel.latest = isLatest();

		memoCacheModel.main = isMain();

		memoCacheModel.status = getStatus();

		memoCacheModel.statusByUserId = getStatusByUserId();

		memoCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = memoCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			memoCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			memoCacheModel.statusDate = statusDate.getTime();
		}
		else {
			memoCacheModel.statusDate = Long.MIN_VALUE;
		}

		return memoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Memo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Memo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Memo, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Memo)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Memo>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Memo.class, ModelWrapper.class);

	}

	private long _memoId;
	private long _resourcePrimKey;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _text;
	private int _version;
	private String _summary;
	private boolean _latest;
	private boolean _main;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Memo, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Memo)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("memoId", _memoId);
		_columnOriginalValues.put("resourcePrimKey", _resourcePrimKey);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("text_", _text);
		_columnOriginalValues.put("version", _version);
		_columnOriginalValues.put("summary", _summary);
		_columnOriginalValues.put("latest", _latest);
		_columnOriginalValues.put("main", _main);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("text_", "text");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("memoId", 1L);

		columnBitmasks.put("resourcePrimKey", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("text_", 256L);

		columnBitmasks.put("version", 512L);

		columnBitmasks.put("summary", 1024L);

		columnBitmasks.put("latest", 2048L);

		columnBitmasks.put("main", 4096L);

		columnBitmasks.put("status", 8192L);

		columnBitmasks.put("statusByUserId", 16384L);

		columnBitmasks.put("statusByUserName", 32768L);

		columnBitmasks.put("statusDate", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Memo _escapedModel;

}