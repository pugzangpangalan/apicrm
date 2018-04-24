/*
TLC Table
*/
CREATE TABLE tlc(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tlc_id VARCHAR(100),
address VARCHAR(255),
customer_name VARCHAR(100),
contact_number VARCHAR(255),
site_access_info VARCHAR(255),
tlc_date DATE,
time VARCHAR(5),
scope_doc_sent INT,
chorus_portal_order VARCHAR(100),
icms_service_order VARCHAR(100),
team_id INT,
status_id INT,
comments TEXT,
schedule_once INT,
scoping_doc_count INT,
appointment_date DATE
);

/*
PROJECT Table
*/
CREATE TABLE project(
project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
project_name VARCHAR(50)
);

/*
TEAM Table
*/

CREATE TABLE team(
team_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
project_id INT,
team_name VARCHAR(100),
FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE
);

/*
status
*/

CREATE TABLE status (
status_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
status_name VARCHAR(100)
);
