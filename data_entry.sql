INSERT INTO role (id, `name`) VALUES (1, "superuser");
INSERT INTO role (id, `name`) VALUES (2, "user");

INSERT INTO permission (id, perm) VALUES (1, '*');
INSERT INTO permission (id, perm) VALUES (2, 'person:get');

INSERT INTO role_permission (Role_id, permissions_id) VALUES (1, 1);
INSERT INTO role_permission (Role_id, permissions_id) VALUES (2, 2);

INSERT INTO `user` (id, username, `password`) VALUES (1, 'admin', '123456');
INSERT INTO `user` (id, username, `password`) VALUES (2, 'navid', '1234');

INSERT INTO user_role (User_id, roles_id) VALUES (1, 1);
INSERT INTO user_role (User_id, roles_id) VALUES (2, 2);
