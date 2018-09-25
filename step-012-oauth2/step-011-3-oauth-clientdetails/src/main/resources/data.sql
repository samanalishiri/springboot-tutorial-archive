INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity,
 additional_information, autoapprove)
VALUES
  ('clientapp', NULL, '123456', 'read_profile,read_posts', 'authorization_code',
                'http://localhost:9000/callback', NULL, 3000, -1,
                NULL, 'false');