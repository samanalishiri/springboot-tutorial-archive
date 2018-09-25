
CREATE TABLE client_user(
  id bigint auto_increment PRIMARY KEY,
  username VARCHAR(100),
  password VARCHAR(50),
  access_token VARCHAR(100) NULL,
  access_token_validity DATETIME NULL,
  refresh_token VARCHAR(100) NULL
);