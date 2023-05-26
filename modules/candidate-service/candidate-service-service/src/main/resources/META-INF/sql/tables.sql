create table RMS_CandidateInfo (
	uuid_ VARCHAR(75) null,
	candidateId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	secondaryEmail VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	street VARCHAR(75) null,
	country VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	houseNumber VARCHAR(75) null,
	website VARCHAR(75) null,
	companyId LONG,
	userId LONG
);

create table RMS_CandidateOtherInfo (
	uuid_ VARCHAR(75) null,
	candidateOtherInfoId LONG not null primary key,
	candidateId LONG,
	candidateStatus VARCHAR(75) null,
	candidateStage VARCHAR(75) null,
	source VARCHAR(75) null,
	candidateOwner VARCHAR(75) null,
	institute VARCHAR(75) null,
	department VARCHAR(75) null,
	degree VARCHAR(75) null,
	fromDuration VARCHAR(75) null,
	toDuration VARCHAR(75) null,
	occupation VARCHAR(75) null,
	company VARCHAR(75) null,
	summary VARCHAR(75) null,
	fromWorkDuration VARCHAR(75) null,
	toWorkDuration VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	folderId LONG
);

create table RMS_ProfessionalDetails (
	uuid_ VARCHAR(75) null,
	professionalDetailsId LONG not null primary key,
	candidateId LONG,
	expectedSalary DOUBLE,
	currentSalary DOUBLE,
	skillSet VARCHAR(75) null,
	additionalInfo VARCHAR(75) null,
	currentEmployer VARCHAR(75) null,
	workType VARCHAR(75) null,
	experience  VARCHAR(75) null,
	qualification VARCHAR(75) null,
	jobTitle VARCHAR(75) null,
	companyId LONG,
	userId LONG
);