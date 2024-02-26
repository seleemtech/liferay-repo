create index IX_F5D6F4FD on API_ApiMapKey (name[$COLUMN_LENGTH:75$]);
create index IX_5E65A5F8 on API_ApiMapKey (userId);
create unique index IX_13B8A534 on API_ApiMapKey (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D88AB1F8 on API_ConnectedAccounts (appName[$COLUMN_LENGTH:75$], emailAddress[$COLUMN_LENGTH:75$]);
create index IX_4D6D706A on API_ConnectedAccounts (userId);
create index IX_A3CE1E24 on API_ConnectedAccounts (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_11CFDDA6 on API_ConnectedAccounts (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5ED4DE10 on API_MasterMetaData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_691DA892 on API_MasterMetaData (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_36983AEE on API_MasterUrl (appName[$COLUMN_LENGTH:75$]);
create index IX_472323C2 on API_MasterUrl (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3B45B2C4 on API_MasterUrl (uuid_[$COLUMN_LENGTH:75$], groupId);