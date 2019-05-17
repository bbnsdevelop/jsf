/*insert no banco de dados ao iniciar o sistema*/


INSERT INTO professor (id, name, email) VALUES (1001, 'Bruno Santos', 'brunno1808@hotmail.com');
INSERT INTO professor (id, name, email) VALUES (1002, 'Bruno Batista', 'bbnsdevelop@gmail.com');
INSERT INTO professor (id, name, email) VALUES (1003, 'Bruno Nascimento', 'brunno150888@gmail.com');

INSERT INTO application_user (id, user_name, password, professor_id) VALUES (1001, 'bsanto20', '$2a$10$o00zmIFZ4gAxNf.6MmuUquVS0we0sTrKiEdHRBgyK1J4u7m5Muq9e', 1002);

