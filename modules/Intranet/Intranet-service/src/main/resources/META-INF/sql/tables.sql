create table INTRANET_Billclaim (
	fooId LONG not null primary key,
	employeeID VARCHAR(75) null,
	userName VARCHAR(75) null,
	claimType VARCHAR(75) null,
	claimDate DATE null,
	claimAmount LONG,
	attachBill LONG,
	status VARCHAR(75) null
);

create table INTRANET_ComplaintBox (
	fooId LONG not null primary key,
	employeeId VARCHAR(75) null,
	userName VARCHAR(75) null,
	posistionType VARCHAR(75) null,
	submittedDate DATE null,
	question1 INTEGER,
	question2 INTEGER,
	question3 INTEGER,
	question4 INTEGER,
	question5 INTEGER,
	question6 INTEGER,
	question7 INTEGER,
	question8 INTEGER,
	question9 INTEGER,
	question10 INTEGER,
	question11 INTEGER,
	question12 INTEGER,
	question13 INTEGER,
	question14 INTEGER,
	question15 INTEGER,
	description1 VARCHAR(75) null,
	description2 VARCHAR(75) null,
	description3 VARCHAR(75) null
);

create table INTRANET_EducationDetails (
	educationId LONG not null primary key,
	employeeID LONG,
	pgGraduation VARCHAR(75) null,
	pgSpecialization VARCHAR(75) null,
	pgUniversity VARCHAR(75) null,
	pgPassout VARCHAR(75) null,
	pgPercentage VARCHAR(75) null,
	graduation VARCHAR(75) null,
	specialization VARCHAR(75) null,
	university VARCHAR(75) null,
	passout VARCHAR(75) null,
	percentage VARCHAR(75) null,
	hscSchool VARCHAR(75) null,
	hscPassout VARCHAR(75) null,
	hscPercentage VARCHAR(75) null,
	sslcSchool VARCHAR(75) null,
	sslcPassout VARCHAR(75) null,
	sslcPercentage VARCHAR(75) null
);

create table INTRANET_EmployeeDetails (
	employeeID LONG not null primary key,
	employeename VARCHAR(75) null,
	gender VARCHAR(75) null,
	domain VARCHAR(75) null,
	contact LONG,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	pannumber VARCHAR(75) null,
	passportNumber VARCHAR(75) null,
	aadhar VARCHAR(75) null,
	joiningDate DATE null,
	dob DATE null,
	maritalstatus BOOLEAN,
	anniversaryDate DATE null,
	fileEntryId LONG
);

create table INTRANET_ExperienceDetails (
	experienceId LONG not null primary key,
	employeeID LONG,
	organization VARCHAR(75) null,
	designation VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null
);

create table INTRANET_Graduation (
	graduationCode VARCHAR(75) not null primary key,
	graduationName VARCHAR(75) null
);

create table INTRANET_Specialization (
	graduationCode VARCHAR(75) null,
	specializationName VARCHAR(75) null,
	spCode LONG not null primary key
);

create table INTRANET_skills (
	skillId LONG not null primary key,
	employeeID LONG,
	skill VARCHAR(75) null,
	version VARCHAR(75) null,
	certification BOOLEAN
);