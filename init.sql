CREATE ROLE ssodev WITH LOGIN PASSWORD 'sso2022ok' CREATEDB;


create table sso_user_test
(
    request_date          timestamp not null
        constraint pk_sso_user_test
            primary key,
    ssotype               varchar(50),
    systemid              varchar(50),
    systemname            varchar(250),
    systemtransactions    varchar(250),
    systemprivileges      varchar(250),
    systemusergroup       varchar(50),
    systemlocationgroup   varchar(50),
    userid                varchar(200),
    userfullname          varchar(500),
    userrdofficecode      varchar(250),
    userofficecode        varchar(250),
    clientlocation        varchar(250),
    locationmachinenumber varchar(500),
    tokenid               varchar(1000)
);
