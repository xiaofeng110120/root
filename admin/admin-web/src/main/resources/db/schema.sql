-- 用户表
create table if not exists sys_user
(
	id varchar(40) not null, -- 主键id
	account_no varchar(40) unique not null, -- 账号
	name varchar(50) not null, -- 姓名
	password varchar(200) not null, --密码
	phone varchar(20) not null, -- 电话
	email varchar(50), -- email
	remark varchar(300), -- 备注
	enabled char(1) default 'Y' not null, -- 是否可用【Y:可用；N：不可用】
	create_user varchar(40)  not null, -- 创建人
	create_time timestamp  not null, -- 创建时间
	update_user varchar(40) not null, -- 修改人
	update_time timestamp not null, -- 修改时间
	constraint pk_sys_user primary key (id)
);


-- 用户角色
create table if not exists sys_user_role(
  id varchar(40) not null, -- 主键id
  user_id varchar(40) not null, -- 用户id
  role_id varchar(40) not null, -- 角色id
	create_user varchar(40)  not null, -- 创建人
	create_time timestamp  not null, -- 创建时间
	update_user varchar(40) not null, -- 修改人
	update_time timestamp not null, -- 修改时间
	constraint pk_sys_user_role primary key (id)
);


-- 角色表
create table if not exists sys_role
(
	id varchar(40) not null, -- 主键id
	role_code varchar(40) unique not null, -- 角色编码
	role_name varchar(50) not null, -- 角色名
	remark varchar(300), -- 备注
	enabled char(1) default 'Y' not null, -- 是否可用【Y:可用；N：不可用】
	create_user varchar(40)  not null, -- 创建人
	create_time timestamp  not null, -- 创建时间
	update_user varchar(40) not null, -- 修改人
	update_time timestamp not null, -- 修改时间
	constraint pk_sys_role primary key (id)
);


-- 角色权限表
create table if not exists sys_role_privilege(
  id varchar(40) not null, -- 主键id
  role_id varchar(40) not null, -- 角色id
  privilege_id varchar(40) not null, -- 权限id
	create_user varchar(40)  not null, -- 创建人
	create_time timestamp  not null, -- 创建时间
	update_user varchar(40) not null, -- 修改人
	update_time timestamp not null, -- 修改时间
	constraint pk_sys_role_privilege primary key (id)
);


-- 权限表
create table if not exists sys_privilege
(
	id varchar(40) not null, -- 主键id
	privilege_code varchar(40) unique not null, -- 角色编码
	privilege_name varchar(50) not null, -- 角色名
	remark varchar(300), -- 备注
	enabled char(1) default 'Y' not null, -- 是否可用【Y:可用；N：不可用】
	create_user varchar(40) not null, -- 创建人
	create_time timestamp  not null, -- 创建时间
	update_user varchar(40) not null, -- 修改人
	update_time timestamp not null, -- 修改时间
	constraint pk_sys_privilege primary key (id)
);

--
create sequence seq_sys start with 1 increment by 1;
alter table sys_user alter column id set default nextval('seq_sys');
alter table sys_role alter column id set default nextval('seq_sys');
alter table sys_user_role alter column id set default nextval('seq_sys');
alter table sys_privilege alter column id set default nextval('seq_sys');
alter table sys_role_privilege alter column id set default nextval('seq_sys');