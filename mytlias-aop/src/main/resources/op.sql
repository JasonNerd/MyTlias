create table operateLog (
    id int unsigned primary key auto_increment comment 'ID',
    operateUser int unsigned not null comment '操作人 id',
    operateTime datetime comment '操作时间',
    className varchar(100) comment '操作的类名',
    methodName varchar(100) comment '方法名',
    methodParams varchar(100) comment '方法参数',
    returnValue varchar(100) comment '返回值',
    costTime long comment '操作耗时'
) comment '操作日志表';