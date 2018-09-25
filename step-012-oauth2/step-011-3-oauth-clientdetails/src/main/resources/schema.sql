-- To store all the data related to the client registration
CREATE TABLE oauth_client_details (
  client_id               VARCHAR(256) PRIMARY KEY,
  resource_ids            VARCHAR(256),
  client_secret           VARCHAR(256),
  scope                   VARCHAR(256),
  authorized_grant_types  VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities             VARCHAR(256),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(256)
);

-- To store all the issued access tokens, create the following table:
CREATE TABLE oauth_access_token (
  token_id          VARCHAR(256),
  token             NUMBER(12),
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name         VARCHAR(256),
  client_id         VARCHAR(256),
  authentication    NUMBER(12),
  refresh_token     VARCHAR(256)
);

-- To store the user's approvals
CREATE TABLE oauth_approvals (
  userId         VARCHAR(256),
  clientId       VARCHAR(256),
  scope          VARCHAR(256),
  status         VARCHAR(10),
  expiresAt      TIMESTAMP,
  lastModifiedAt TIMESTAMP
);
-- To store issue refresh tokens respectively:
CREATE TABLE oauth_refresh_token (
  token_id       VARCHAR(256),
  token          NUMBER(12),
  authentication NUMBER(12)
);