select * from dba_tables;

desc ALL_USERS;
SELECT USERNAME FROM ALL_USERS 
    WHERE USERNAME='APP_DEV_USER';
    
--ALTER USER
alter user hr identified by hr account unlock;

CREATE USER APP_DEV_USER IDENTIFIED BY DEV_USER_PWD;
GRANT CONNECT, RESOURCE TO APP_DEV_USER;
GRANT CREATE ANY EDITION,UPDATE ANY TABLE, DROP ANY EDITION to APP_DEV_USER;

SELECT USERNAME FROM ALL_USERS 
    WHERE USERNAME='app_user';
    
--ALTER SESSION IS IMPORTANT BEFORE CREATING USER
 alter session set "_ORACLE_SCRIPT"=true;  
 CREATE USER APP_DEV_USER IDENTIFIED BY DEV_USER_PWD;
GRANT CONNECT, RESOURCE TO APP_DEV_USER;
GRANT CREATE ANY EDITION,UPDATE ANY TABLE, DROP ANY EDITION to APP_DEV_USER;

SELECT * FROM TABLES;

--create user for app
alter session set "_ORACLE_SCRIPT"=true;  --cannot create without altering the session
CREATE USER app_user IDENTIFIED BY appuserpwd;
GRANT CONNECT, RESOURCE TO app_user;
GRANT CREATE ANY EDITION,UPDATE ANY TABLE, DROP ANY EDITION to app_user;


--
show user;
desc GREETING;
select * from GREETING;