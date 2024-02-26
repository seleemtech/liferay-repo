create table API_ApiMapKey (
	uuid_ VARCHAR(75) null,
	apiMapKeyId LONG not null primary key,
	name VARCHAR(75) null,
	key_ STRING null,
	typeSettings STRING null,
	userId LONG,
	groupId LONG
);

create table API_ConnectedAccounts (
	uuid_ VARCHAR(75) null,
	c_accountId LONG not null primary key,
	emailAddress VARCHAR(75) null,
	appName VARCHAR(75) null,
	refreshToken STRING null,
	userId LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table API_MasterMetaData (
	uuid_ VARCHAR(75) null,
	mmdId LONG not null primary key,
	masterUrlId LONG,
	appSubUrl VARCHAR(75) null,
	httpMethod VARCHAR(75) null,
	httpMethodName VARCHAR(75) null,
	userId LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table API_MasterUrl (
	uuid_ VARCHAR(75) null,
	masterUrlId LONG not null primary key,
	appName VARCHAR(75) null,
	baseUrl VARCHAR(75) null,
	svgIcon VARCHAR(75) null,
	userId LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);