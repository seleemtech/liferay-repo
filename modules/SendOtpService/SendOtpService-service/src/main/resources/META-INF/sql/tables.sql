create table FOO_SendDb (
	uuid_ VARCHAR(75) null,
	sendId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	mobileNumber LONG,
	Name VARCHAR(75) null
);