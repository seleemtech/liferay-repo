create table FOO_FirstTable (
	soId LONG not null primary key,
	Name VARCHAR(75) null,
	companyId LONG
);

create table FOO_FirstTables_SecondTables (
	companyId LONG not null,
	soId LONG not null,
	coId LONG not null,
	primary key (soId, coId)
);

create table FOO_SecondTable (
	coId LONG not null primary key,
	coName VARCHAR(75) null,
	companyId LONG
);