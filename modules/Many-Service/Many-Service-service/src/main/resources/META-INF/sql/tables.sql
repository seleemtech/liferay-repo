create table MTM_Course (
	groupId LONG,
	companyId LONG,
	courseId LONG not null primary key,
	courseName VARCHAR(75) null,
	courseGroup VARCHAR(75) null
);

create table MTM_Student (
	uuid_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	studentId LONG not null primary key,
	studentName VARCHAR(75) null,
	studentPlace VARCHAR(75) null,
	studentCollege VARCHAR(75) null
);

create table MTM_Students_Courses (
	companyId LONG not null,
	courseId LONG not null,
	studentId LONG not null,
	primary key (courseId, studentId)
);