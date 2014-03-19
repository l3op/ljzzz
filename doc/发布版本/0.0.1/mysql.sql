create table `act_conf` (
	`act_id` int(6) not null auto_increment comment '活动ID', 
	`type` int(4) not null comment '活动类型',
	`start` datetime NOT NULL COMMENT '活动开始时间',
	`end_pull` datetime NOT NULL COMMENT '数据拉取结束时间',
	`end` datetime NOT NULL COMMENT '活动结束时间',
	`statu` varchar(12) not null default 'TEST' comment '活动状态',
	`prompt` varchar(108) not null default '' comment '暂停提示语',
	`ratio` int(6) not null default '200' comment '多少钱参加一次活动',
	`data_level` varchar(12) not null comment '数据级别, 平台,游戏,区服',
	`other` varchar(1024) default '' comment '其它配置, json格式',
	PRIMARY KEY (`act_id`),
	KEY `I_type` (`type`),
	KEY `I_time` (`start`, `end_pull`, `end`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动配置';

create table `template` (
	`tid` int(6) not null auto_increment comment '模板ID', 
	`desc` varchar(128) default '' comment '模板描述',
	`metas` varchar(256) default '' comment '模板元信息列表',
	`privilegs` varchar(128) default '' comment '权限列表',
	PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动模板';

create table `template_meta` (
	`mid` int(8) not null auto_increment comment '元信息ID', 
	`key` varchar(16) not null comment 'KEY名',
	`type` varchar(16) not null comment 'key的类型',
	`description` varchar(64) default '' comment 'key的描述',
	`default_value` varchar(32) default '' comment 'key的默认值',
	PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板元信息';

create table `issue_statu` (
	`award_id` int(6) not null comment '奖品ID', 
	`total` int(8) not null comment '奖品总量', 
	`issue` int(8) not null comment '奖品已放量', 
	PRIMARY KEY (`award_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖品发放状态';

create table `groovy_source` (
	`class_name` varchar(32) not null comment '类名',
	`desc` varchar(128) default '' comment '类注释',
	`source` varchar(10280) not null comment '代码',
	`creater` varchar(32) not null comment '创建者',
	`create` datetime NOT NULL COMMENT '创建时间',
	`updater` varchar(32) not null comment '更新者',
	`update` datetime NOT NULL COMMENT '更新时间',
	PRIMARY KEY (`class_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='groovy代码';

create table `rate_table` (
	`act_id` int(6) not null comment '活动ID', 
	`from` int(6) not null comment '条件起始值',
	`to` int(6) not null comment '条件结束值',
	`award_id` int(6) not null comment '奖品ID', 
	`rate` int(4) not null comment '概率权重',
	PRIMARY KEY (`act_id`, `from`, `to`, `award_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='概率表';

