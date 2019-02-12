-- insert username=admin, passwd=password
INSERT INTO USERS (users_id, username, passwd, email, ENABLED, NON_EXPIRED, NON_LOCKED, PASSWORD_NON_EXPIRED)
  VALUES (1, 'admin', '$2a$12$Gd3AEtxdoWkz3Et34N/sCuI/s5dv2.AYndX2jRoJGqQtu2gGqABSC', 'admin@gmail.com', true, true, true, true);

INSERT INTO  AUTHORITY(AUTHORITY_ID, AUTHORITY, DESCRIPTION, ENABLED)
    VALUES (1,'USER', 'description', true);

INSERT INTO USERS_AUTHORITY(USERS_ID, AUTHORITY_ID)
    VALUES (1, 1);