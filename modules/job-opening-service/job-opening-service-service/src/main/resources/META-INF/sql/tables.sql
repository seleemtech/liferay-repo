create table rms_Addressinfo (
	uuid_ VARCHAR(75) null,
	addressId LONG not null primary key,
	jobId LONG,
	remote BOOLEAN,
	city VARCHAR(75) null,
	country VARCHAR(75) null,
	state_ VARCHAR(75) null,
	postalCode LONG
);

create table rms_Descriptiveinfo (
	uuid_ VARCHAR(75) null,
	descriptiveId LONG not null primary key,
	jobId LONG,
	jobDescription VARCHAR(75) null,
	requirements VARCHAR(75) null,
	benefits VARCHAR(75) null
);

create table rms_Jobinfo (
	uuid_ VARCHAR(75) null,
	jobId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	modifiedDate DATE null,
	postingTitle VARCHAR(75) null,
	title VARCHAR(75) null,
	assignedRecruiter VARCHAR(75) null,
	targetDate DATE null,
	jobopeningStatus VARCHAR(75) null,
	industry VARCHAR(75) null,
	jobResource VARCHAR(75) null,
	hiringManager VARCHAR(75) null,
	clientName VARCHAR(75) null,
	positions VARCHAR(75) null,
	dateOpened DATE null,
	jobType VARCHAR(75) null,
	workExperience VARCHAR(75) null,
	skillSet VARCHAR(75) null,
	projectStatus VARCHAR(75) null,
	summaryId LONG,
	otherId LONG
);