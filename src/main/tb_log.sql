create table if not exists dept_log(
    id int auto_increment comment '主键id' primary key ,
    create_time datetime null comment '创建时间',
    description varchar(300) null comment '日志内容'
) comment '部门操作记录日志';