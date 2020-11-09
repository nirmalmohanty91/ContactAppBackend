CREATE TABLE customer_information (
     id BIGSERIAL       NOT NULL PRIMARY KEY,
     first_name         VARCHAR(50) NOT NULL,
     last_name          VARCHAR(50) NOT NULL,
     gender             VARCHAR(7) NOT NULL,
     date_of_birth      DATE NOT NULL,
     email              VARCHAR(150),
     src_sys_cd         BIGINT NOT NULL,
     record_version_nb  BIGINT NOT NULL,
     created_ts         DATE NOT NULL,
     updated_ts         DATE
);


INSERT INTO customer_information(first_name,last_name,gender,date_of_birth,email)
VALUES('Nirmal','Mohanty','M','1991-06-05','nirmalmhnt@gmail.com')