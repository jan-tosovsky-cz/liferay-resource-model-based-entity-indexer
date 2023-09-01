create table memo_Memo (
	memoId LONG not null primary key,
	resourcePrimKey LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	text_ VARCHAR(75) null,
	version INTEGER,
	summary VARCHAR(75) null,
	latest BOOLEAN,
	main BOOLEAN,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);