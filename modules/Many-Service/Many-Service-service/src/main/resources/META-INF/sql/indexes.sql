create index IX_6D75619C on MTM_Student (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_58E19F1E on MTM_Student (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5E7F0538 on MTM_Students_Courses (companyId);
create index IX_9213BF6 on MTM_Students_Courses (studentId);