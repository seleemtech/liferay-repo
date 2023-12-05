create index IX_D8A265EA on Esquare_Notes (uuid_[$COLUMN_LENGTH:75$]);

create index IX_25AF579 on Esquare_ProjectManagement (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_62E4863B on Esquare_ProjectManagement (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A6E64151 on Esquare_Projects (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1D00E813 on Esquare_Projects (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_86AF5E4D on Esquare_Tasks (projectId);
create index IX_8E554FBD on Esquare_Tasks (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C92CB6DF on Esquare_TeamMembers (projectId);
create index IX_22EAB3FF on Esquare_TeamMembers (userId);
create index IX_BA69C14F on Esquare_TeamMembers (uuid_[$COLUMN_LENGTH:75$]);