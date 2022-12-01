create table App_App (
	uuid_ VARCHAR(75) null,
	appId VARCHAR(75) not null primary key,
	description VARCHAR(75) null,
	link VARCHAR(75) null,
	logoUrl VARCHAR(75) null,
	name VARCHAR(75) null
);

create table App_UserApp (
	uuid_ VARCHAR(75) null,
	appId VARCHAR(75) not null primary key,
	description VARCHAR(75) null,
	link VARCHAR(75) null,
	logoUrl VARCHAR(75) null,
	name VARCHAR(75) null
);