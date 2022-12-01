create table UserDetails_Address (
	uuid_ VARCHAR(75) null,
	addressId LONG not null primary key,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null
);

create table UserDetails_User (
	uuid_ VARCHAR(75) null,
	usId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	language VARCHAR(75) null
);

create table UserDetails_User_Address (
	companyId LONG not null,
	addressId LONG not null,
	usId LONG not null,
	primary key (addressId, usId)
);