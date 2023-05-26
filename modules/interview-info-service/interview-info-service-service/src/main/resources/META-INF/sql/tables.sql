create table RMS_InterviewInfo (
	uuid_ VARCHAR(75) null,
	interviewId LONG not null primary key,
	interviewName VARCHAR(75) null,
	postingTitleId LONG,
	candidateId LONG,
	clientId LONG,
	interviewFrom LONG,
	interviewTo LONG,
	interviewers VARCHAR(75) null,
	interviewOwner LONG,
	scheduleComments VARCHAR(75) null,
	location VARCHAR(75) null,
	attachmentId LONG,
	createdBy LONG,
	createdDate LONG,
	modifiedBy LONG,
	modifiedDate LONG
);