create table STD_Course (
	courseId LONG not null primary key,
	courseName VARCHAR(75) null,
	companyId LONG
);

create table STD_Courses_Teachers (
	companyId LONG not null,
	courseId LONG not null,
	teacherId LONG not null,
	primary key (courseId, teacherId)
);

create table STD_Parent (
	parentId LONG not null primary key,
	parentName VARCHAR(75) null,
	parentContact LONG,
	companyId LONG
);

create table STD_Student (
	studentId LONG not null primary key,
	studentName VARCHAR(75) null,
	studentPlace VARCHAR(75) null,
	studentEmail VARCHAR(75) null,
	companyId LONG
);

create table STD_Students_Courses (
	companyId LONG not null,
	courseId LONG not null,
	studentId LONG not null,
	primary key (courseId, studentId)
);

create table STD_Students_Parents (
	companyId LONG not null,
	parentId LONG not null,
	studentId LONG not null,
	primary key (parentId, studentId)
);

create table STD_Students_Teachers (
	companyId LONG not null,
	studentId LONG not null,
	teacherId LONG not null,
	primary key (studentId, teacherId)
);

create table STD_Teacher (
	teacherId LONG not null primary key,
	teacherName VARCHAR(75) null,
	teacherEmail VARCHAR(75) null,
	companyId LONG
);

create table ST_Course (
	courseId LONG not null primary key,
	courseName VARCHAR(75) null,
	subject VARCHAR(75) null,
	companyId LONG
);

create table ST_Courses_Teachers (
	companyId LONG not null,
	courseId LONG not null,
	teacherId LONG not null,
	primary key (courseId, teacherId)
);

create table ST_Parent (
	parentId LONG not null primary key,
	parentName VARCHAR(75) null,
	parentContact LONG,
	companyId LONG
);

create table ST_Student (
	studentId LONG not null primary key,
	studentName VARCHAR(75) null,
	studentPlace VARCHAR(75) null,
	studentEmail VARCHAR(75) null,
	companyId LONG
);

create table ST_Students_Courses (
	companyId LONG not null,
	courseId LONG not null,
	studentId LONG not null,
	primary key (courseId, studentId)
);

create table ST_Students_Parents (
	companyId LONG not null,
	parentId LONG not null,
	studentId LONG not null,
	primary key (parentId, studentId)
);

create table ST_Students_Teachers (
	companyId LONG not null,
	studentId LONG not null,
	teacherId LONG not null,
	primary key (studentId, teacherId)
);

create table ST_Teacher (
	teacherId LONG not null primary key,
	teacherName VARCHAR(75) null,
	teacherEmail VARCHAR(75) null,
	subject VARCHAR(75) null,
	companyId LONG
);