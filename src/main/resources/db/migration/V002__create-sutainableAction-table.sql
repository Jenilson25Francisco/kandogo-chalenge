create table sutainableAction (
	id varchar(100) not null primary key,
    user_id varchar(100) not null,
    category_id varchar(100) not null,
    title varchar(100) not null,
    description text not null,
    points int(100)
);