-- Write all the sql queries that should be run when the docker container is initialized
-- For example creating database, user for specific database

-- Insert the Amin role with the valid email and admin password
INSERT INTO app_user VALUES (
  -1, 'ADMIN', 'admin@com', true, 'Admin', 'Admin', false, '$2a$10$KJYulQ8AngCOu74G6sVnPeIG5vhcpHvuGvkUHQuVLj8VtfB9c77Ya'
);