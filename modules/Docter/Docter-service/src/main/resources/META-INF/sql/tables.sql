create table DOC_Docters (
	uuid_ VARCHAR(75) null,
	docterId LONG not null primary key,
	docterName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	STATUS INTEGER,
	STATUS_BY_USER_ID LONG,
	STATUS_BY_USER_NAME VARCHAR(75) null,
	STATUS_DATE DATE null
);