create index IX_AA7BE964 on RMS_CandidateInfo (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_508A1086 on RMS_CandidateOtherInfo (candidateId);
create index IX_A22F5917 on RMS_CandidateOtherInfo (candidateStage[$COLUMN_LENGTH:75$]);
create index IX_A47B551D on RMS_CandidateOtherInfo (candidateStatus[$COLUMN_LENGTH:75$]);
create index IX_BC351B1C on RMS_CandidateOtherInfo (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_3EE86974 on RMS_ProfessionalDetails (candidateId);
create index IX_D92F26EE on RMS_ProfessionalDetails (uuid_[$COLUMN_LENGTH:75$], companyId);