create table PRIME_CandidateStatus (
	uuid_ VARCHAR(75) null,
	candidateStatusId LONG not null primary key,
	candidateStatus VARCHAR(75) null
);

create table PRIME_CurrJobTitle (
	uuid_ VARCHAR(75) null,
	currJobTitleId LONG not null primary key,
	currentJobTitle VARCHAR(75) null
);

create table PRIME_DocumentMapper (
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

create table PRIME_HighQualHeld (
	uuid_ VARCHAR(75) null,
	highQualHeldId LONG not null primary key,
	highQualHeld VARCHAR(75) null
);

create table PRIME_Industry (
	uuid_ VARCHAR(75) null,
	industryId LONG not null primary key,
	industryName VARCHAR(75) null
);

create table PRIME_InterviewName (
	uuid_ VARCHAR(75) null,
	interviewNameId LONG not null primary key,
	interviewName VARCHAR(75) null
);

create table PRIME_JobOpeningStatus (
	uuid_ VARCHAR(75) null,
	jobStatusId LONG not null primary key,
	jobOpeningStatus VARCHAR(75) null
);

create table PRIME_JobType (
	uuid_ VARCHAR(75) null,
	jobTypeId LONG not null primary key,
	jobType VARCHAR(75) null
);

create table PRIME_MainTable (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	category VARCHAR(75) null,
	name VARCHAR(75) null
);

create table PRIME_NamePrefix (
	uuid_ VARCHAR(75) null,
	namePrefixId LONG not null primary key,
	namePrefix VARCHAR(75) null
);

create table PRIME_Priority (
	uuid_ VARCHAR(75) null,
	priorityId LONG not null primary key,
	priorityName VARCHAR(75) null
);

create table PRIME_ProjectStatus (
	uuid_ VARCHAR(75) null,
	projectStatusId LONG not null primary key,
	projectStatus VARCHAR(75) null
);

create table PRIME_SalaryRange (
	uuid_ VARCHAR(75) null,
	salaryRangeId LONG not null primary key,
	salaryRange VARCHAR(75) null
);

create table PRIME_SalesStage (
	uuid_ VARCHAR(75) null,
	salesStageId LONG not null primary key,
	salesStage VARCHAR(75) null
);

create table PRIME_SkillSet (
	uuid_ VARCHAR(75) null,
	skillSetId LONG not null primary key,
	skillCategory VARCHAR(75) null,
	skillCategoryTools VARCHAR(75) null
);

create table PRIME_Source (
	uuid_ VARCHAR(75) null,
	sourceId LONG not null primary key,
	sourceBy VARCHAR(75) null
);

create table PRIME_SourceBy (
	uuid_ VARCHAR(75) null,
	sourceId LONG not null primary key,
	sourceBy VARCHAR(75) null
);

create table PRIME_WorkExperience (
	uuid_ VARCHAR(75) null,
	workExpId LONG not null primary key,
	workExpRange VARCHAR(75) null
);

create table PRIME_WorkType (
	uuid_ VARCHAR(75) null,
	workTypeId LONG not null primary key,
	workTypeName VARCHAR(75) null
);