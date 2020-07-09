
create table `user` (
`user_id` int not null auto_increment,
`user_name` varchar(45) CHARACTER SET utf8 not null ,
`user_phone` varchar(45) not null,
`user_password` varchar(45) not null,
`is_deleted` int default 0,
primary key(`user_id`)
);
create table `card` (
`user_id` int not null comment 'user primary key',
`card_id` int not null auto_increment,
`card_number` varchar(45) not null,
`card_password` varchar(45) not null,
`card_money` varchar(45) default '0',
`is_deleted` int default 0,
primary key(`card_id`)
);
-- 时区问题总是出错，所以用varchar类型
create table `transform` (
`card_id` int not null comment 'card primary key',
`transform_id` int not null auto_increment,
`transform_type` int not null,
`transform_money` varchar(45) not null,
`transform_date` varchar(45) not null,
`is_deleted` int default 0,
primary key(`transform_id`)
)