create table sutainable (
	id varchar(100) not null primary key,
    user_id varchar(100) not null,
    title varchar(100) not null,
    description text not null,
    category varchar(100) not null,
    created_at datetime not null,
    points integer(100) not null
);