create table Master_DocumentMapping (
	uuid_ VARCHAR(75) null,
	recordId LONG not null primary key,
	moduleName VARCHAR(75) null,
	classPk LONG,
	documentName VARCHAR(75) null,
	documentId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	userId LONG
);