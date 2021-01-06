-- begin NEWPOC_EMPLOYEE
create table NEWPOC_EMPLOYEE (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID integer,
    EMPLOYEE_NAME varchar(255),
    --
    primary key (ID)
)^
-- end NEWPOC_EMPLOYEE
-- begin NEWPOC_AUDIT_LOG
create table NEWPOC_AUDIT_LOG (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255),
    DATE_ date,
    --
    primary key (ID)
)^
-- end NEWPOC_AUDIT_LOG
