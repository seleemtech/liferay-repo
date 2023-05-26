create index IX_67B877E7 on rms_Addressinfo (jobId);
create index IX_B848EF33 on rms_Addressinfo (uuid_[$COLUMN_LENGTH:75$]);

create index IX_F39F228F on rms_Descriptiveinfo (jobId);
create index IX_442F99DB on rms_Descriptiveinfo (uuid_[$COLUMN_LENGTH:75$]);

create index IX_DDC0A05E on rms_Jobinfo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1511A660 on rms_Jobinfo (uuid_[$COLUMN_LENGTH:75$], groupId);