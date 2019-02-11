-- insert username=admin, passwd=password
INSERT INTO USERS (users_id, username, passwd, email, ENABLED, NON_EXPIRED, NON_LOCKED, PASSWORD_NON_EXPIRED)
  VALUES (1, 'admin', '$2a$12$c2XKXvREascoRbqMfFg76ODmFezVFR2qXrZ/hfAnc7E08frcp0enm', 'admin@gmail.com', true, true, true, true);

INSERT INTO  AUTHORITY(AUTHORITY_ID, AUTHORITY, DESCRIPTION, ENABLED)
    VALUES (1,'USER', 'description', true);

INSERT INTO USERS_AUTHORITY(USERS_ID, AUTHORITY_ID)
    VALUES (1, 1);