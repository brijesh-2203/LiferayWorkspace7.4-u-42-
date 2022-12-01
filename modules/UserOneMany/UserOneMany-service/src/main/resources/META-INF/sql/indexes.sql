create index IX_778D8542 on UserDetails_Address (uuid_[$COLUMN_LENGTH:75$]);

create index IX_FAA8A271 on UserDetails_User (groupId);
create index IX_EDB0E40D on UserDetails_User (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_864D09CF on UserDetails_User (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B9B58AB1 on UserDetails_User_Address (addressId);
create index IX_ED7FBEBA on UserDetails_User_Address (companyId);