-- To store all the data related to the client registration
CREATE TABLE oauth_client_details (
  client_id               VARCHAR(255) PRIMARY KEY,
  resource_ids            VARCHAR(255),
  client_secret           VARCHAR(255),
  scope                   VARCHAR(255),
  authorized_grant_types  VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities             VARCHAR(255),
  access_token_validity   INT,
  refresh_token_validity  INT,
  additional_information  TEXT,
  autoapprove             VARCHAR(255)
);

-- To store all the issued access tokens, create the following table:
CREATE TABLE oauth_access_token (
  authentication_id VARCHAR(255) PRIMARY KEY,
  token_id          VARCHAR(255),
  token             INT,
  user_name         VARCHAR(255),
  client_id         VARCHAR(255),
  authentication    BIGINT,
  refresh_token     VARCHAR(255)
);

-- To store the user's approvals
CREATE TABLE oauth_approvals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(255),
    client_id VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(255),
    expires_at TIMESTAMP,
    last_modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- To store issue refresh tokens respectively:
CREATE TABLE oauth_refresh_token (
  id             INT AUTO_INCREMENT PRIMARY KEY,
  token_id       VARCHAR(255),
  token          INT,
  authentication INT
);