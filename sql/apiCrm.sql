/*
PROJECT Table
*/
CREATE TABLE project(
project_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
project_name VARCHAR(50)
);

/*
TEAM Table
*/

CREATE TABLE team(
team_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
project_id BIGINT,
team_name VARCHAR(100),
FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE
);


/*
TLC Table
*/
CREATE TABLE tlc(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tlc_id VARCHAR(100),
address VARCHAR(255),
customer_name VARCHAR(100),
contact_number VARCHAR(255),
site_access_info VARCHAR(255),
tlc_date DATE,
time VARCHAR(5),
scope_doc_sent INT,
project_name VARCHAR(255),
chorus_portal_order VARCHAR(100),
icms_service_order VARCHAR(100),
team_id INT,
status_id INT,
site_visit_outcome VARCHAR(255),
comments TEXT,
schedule_once INT,
scoping_doc_count INT,
appointment_date DATE,
FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE CASCADE
);



/*
status
*/

CREATE TABLE status (
status_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
status_name VARCHAR(100)
);

/*
 tlc_user table 
 */

CREATE TABLE dk_user(
dk_user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(100),
last_name VARCHAR(100),
email_address VARCHAR(100),
password VARCHAR(255),
role_name VARCHAR(100),
status_name VARCHAR(100)
);

/*
 * role table
 */

CREATE TABLE role (
role_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
role_name VARCHAR(100)
);
/*
 * tlc_user_status table
 */
CREATE TABLE dk_user_status(
dk_user_status_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
status_name VARCHAR(100)
);

  /*
 * secret keys table
 */
CREATE TABLE secret_key(
secret_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
secret_key VARCHAR(100),
status INT
);


/*
 * secret keys table
 */
CREATE TABLE token(
token_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
token VARCHAR(100),
expiration_date DATE,
status INT
);

/* 
Insert default values in secret table
*/
INSERT INTO secret_key (secret_key, status)
VALUES ("ABCD2323KDF3DSS3J",1);
