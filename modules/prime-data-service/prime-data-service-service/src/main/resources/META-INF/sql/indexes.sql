create index IX_F00C9D79 on PRIME_CandidateStatus (uuid_[$COLUMN_LENGTH:75$]);

create index IX_146722E1 on PRIME_CurrJobTitle (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2F7B841 on PRIME_DocumentMapper (classPk);
create index IX_21C9678C on PRIME_DocumentMapper (documentId);
create index IX_740C8D72 on PRIME_DocumentMapper (uuid_[$COLUMN_LENGTH:75$]);

create index IX_1E32A308 on PRIME_HighQualHeld (uuid_[$COLUMN_LENGTH:75$]);

create index IX_505D1D10 on PRIME_Industry (uuid_[$COLUMN_LENGTH:75$]);

create index IX_3EFDB02 on PRIME_InterviewName (uuid_[$COLUMN_LENGTH:75$]);

create index IX_AC755921 on PRIME_JobOpeningStatus (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B14ED277 on PRIME_JobType (uuid_[$COLUMN_LENGTH:75$]);

create index IX_8A8EF8CD on PRIME_MainTable (category[$COLUMN_LENGTH:75$]);
create index IX_9B2C1739 on PRIME_MainTable (uuid_[$COLUMN_LENGTH:75$]);

create index IX_A2EB2CD1 on PRIME_NamePrefix (uuid_[$COLUMN_LENGTH:75$]);

create index IX_6804440A on PRIME_Priority (uuid_[$COLUMN_LENGTH:75$]);

create index IX_6D72C923 on PRIME_ProjectStatus (uuid_[$COLUMN_LENGTH:75$]);

create index IX_86BE18FB on PRIME_SalaryRange (uuid_[$COLUMN_LENGTH:75$]);

create index IX_CDB1B01C on PRIME_SalesStage (uuid_[$COLUMN_LENGTH:75$]);

create index IX_CA3F63FD on PRIME_SkillSet (uuid_[$COLUMN_LENGTH:75$]);

create index IX_8E4E2B73 on PRIME_Source (uuid_[$COLUMN_LENGTH:75$]);

create index IX_640FBB9C on PRIME_SourceBy (uuid_[$COLUMN_LENGTH:75$]);

create index IX_AF772033 on PRIME_WorkExperience (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B7A343A3 on PRIME_WorkType (uuid_[$COLUMN_LENGTH:75$]);