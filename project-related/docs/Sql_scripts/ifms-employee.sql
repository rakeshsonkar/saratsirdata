show user;

DROP TABLE EMPLOYEE;
DROP TABLE ADDRESS;
DROP SEQUENCE EMP_ID_SEQ;

SELECT * FROM ADDRESS;
EMP_ID_SEQ
--create employee
create TABLE EMPLOYEE(
    EMPLOYEE_ID INT,
    ADDRESS_ID VARCHAR2(10),
    EMPLOYEE_NAME VARCHAR2(10),
    EMAIL VARCHAR2(30),
    primary key(EMPLOYEE_ID)
);

--EMPLOYEE sequence
CREATE SEQUENCE EMPLOYEE_ID_SEQ
  INCREMENT BY 1
  MINVALUE 1001
  MAXVALUE 9999
  NOCACHE
  NOCYCLE;


--create ADDRESS
create TABLE ADDRESS(
    ADDRESS_ID INT,
    EMPLOYEE_ID INT REFERENCES EMPLOYEE(EMPLOYEE_ID),
    STREET VARCHAR2(30),
    CITY VARCHAR2(10),
    COUNTRY VARCHAR2(15),
    primary key(ADDRESS_ID)
); 

CREATE SEQUENCE ADDRESS_ID_SEQ
  INCREMENT BY 1
  MINVALUE 1001
  MAXVALUE 9999
  NOCACHE
  NOCYCLE;

--INSERT EMPLOYEE DETAILS
INSERT INTO EMPLOYEE 
    VALUES(
       101 ,
        'JOHN',
        'AD101',
        'john@hotmail.com'
    );
INSERT INTO EMPLOYEE 
    VALUES(
       102 ,
        'AISHA',
        'AD102',
        'alisha@aol.com'
    );
INSERT INTO EMPLOYEE 
    VALUES(
       103 ,
        'KALYAN',
        'AD103',
        'kalyan123456@gmail.com'
    );
    INSERT INTO EMPLOYEE 
    VALUES(
       104 ,
        'ALANA',
        'AD104',
        'alana789456@gmail.com'
    );
   
--INSERT INTO ADDRESS
    INSERT INTO ADDRESS 
    VALUES(
       'AD101' ,
       101,
        'ST.456, KREMLIN ROAD',
        'KANSAS',
        'UNITED STATES'
    );

    INSERT INTO ADDRESS 
    VALUES(
       'AD102' ,
       101,
        'ST. 890',
        'NYC',
        'UNITED STATES'
    );
    
     INSERT INTO ADDRESS 
    VALUES(
       'AD103' ,
       102,
        'ST. 101, AVENUE PARK',
        'NYC',
        'UNITED STATES'
    );
    
     INSERT INTO ADDRESS 
    VALUES(
       'AD104' ,
       102,
        '3RD STREET, BLUE BAY COMMUNITY',
        'LOUSIANA',
        'UNITED STATES'
    );
    
     INSERT INTO ADDRESS 
    VALUES(
       'AD105' ,
       103,
        '6TH STREET, ST. LUIS ROAD',
        'NYC',
        'UNITED STATES'
    );
    
     INSERT INTO ADDRESS 
    VALUES(
       'AD106' ,
       103,
        'MAIN AVENUE, HOTEL HIGHWAY',
        'TEXAS',
        'UNITED STATES'
    );
    
     INSERT INTO ADDRESS 
    VALUES(
       'AD107' ,
       104,
        'MARTIN ROAD, PINK PARK',
        'CF',
        'UNITED STATES'
    );
    
     INSERT INTO ADDRESS 
    VALUES(
       'AD108' ,
       104,
        'BAILEY ROAD, NATURE AVENUE',
        'CF',
        'UNITED STATES'
    );
    
    --
    select * from EMPLOYEE;
    select * from ADDRESS;
    
     
 select
        employee0_.EMP_ID as EMP_ID1_0_0_,
        employee0_.ADDRESS_ID as ADDRESS_ID2_0_0_,
        employee0_.EMAIL as EMAIL3_0_0_,
        employee0_.EMP_NAME as EMP_NAME4_0_0_ 
    from
        EMPLOYEE employee0_ 
    where
        employee0_.EMP_ID=1004

delete from EMPLOYEE where EMP_ID in (1004);


show user;

select * from EMPLOYEE EMP, 
    ADDRESS ADDR 
    WHERE EMP.EMPLOYEE_ID=ADDR.EMPLOYEE_ID;
select * from address;

alter session set "_ORACLE_SCRIPT"=true;  
 CREATE USER appuser1 IDENTIFIED BY appuserpwd;
GRANT CONNECT, RESOURCE TO appuser1;
GRANT CREATE ANY EDITION,UPDATE ANY TABLE, DROP ANY EDITION to appuser1;
GRANT CREATE SESSION TO appuser1;
GRANT UNLIMITED TABLESPACE TO appuser1;
GRANT ALL PRIVILEGES TO appuser1;

























    
