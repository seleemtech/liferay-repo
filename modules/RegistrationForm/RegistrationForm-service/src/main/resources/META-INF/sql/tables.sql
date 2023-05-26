create table RG_Register (
	uuid_ VARCHAR(75) null,
	registerId LONG not null primary key,
	firstName VARCHAR(75) null,
	phone LONG,
	userName VARCHAR(75) null,
	password_ VARCHAR(75) null
);