create table Esquare_Notes (
	uuid_ VARCHAR(75) null,
	noteId LONG not null primary key,
	noteTitle VARCHAR(75) null,
	noteDescription VARCHAR(75) null,
	noteType VARCHAR(75) null,
	noteAuthor VARCHAR(75) null,
	noteDate DATE null,
	projectId LONG
);

create table Esquare_ProjectManagement (
	uuid_ VARCHAR(75) null,
	projectMgmtId LONG not null primary key,
	name VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	contactEmail VARCHAR(75) null,
	projectName VARCHAR(75) null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null
);

create table Esquare_Projects (
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	projectName VARCHAR(75) null,
	description VARCHAR(75) null,
	proposedDate DATE null,
	confirmedDate DATE null,
	developmentStartDate DATE null,
	estimatedDate DATE null,
	durationDate VARCHAR(75) null,
	status INTEGER,
	code_ INTEGER,
	documentId LONG,
	resourceIdSettings VARCHAR(75) null,
	name VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	contactEmail VARCHAR(75) null
);

create table Esquare_Tasks (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	developerTeam VARCHAR(75) null,
	testerTeam VARCHAR(75) null,
	taskStartDate DATE null,
	taskEndDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	projectId LONG
);

create table Esquare_TeamMembers (
	uuid_ VARCHAR(75) null,
	memberId LONG not null primary key,
	name VARCHAR(75) null,
	memberRole VARCHAR(75) null,
	userId LONG,
	projectId LONG
);