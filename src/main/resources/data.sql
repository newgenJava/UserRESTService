INSERT INTO "PUBLIC"."'user_data'"("ID","BIRTH_DATE","NAME")VALUES(1001, current_date(), 'Name1');
INSERT INTO "PUBLIC"."'user_data'"("ID","BIRTH_DATE","NAME")VALUES(1002, current_date(), 'Name2');
INSERT INTO "PUBLIC"."'user_data'"("ID","BIRTH_DATE","NAME")VALUES(1003, current_date(), 'Name3');
INSERT INTO "PUBLIC"."'user_data'"("ID","BIRTH_DATE","NAME")VALUES(1004, current_date(), 'Name4');
INSERT INTO POST("ID","DESCRIPTION","user_id")VALUES(11001, 'Post_description1', 1001);
INSERT INTO POST("ID","DESCRIPTION","user_id")VALUES(11004, 'Post_description12', 1001);
INSERT INTO POST("ID","DESCRIPTION","user_id")VALUES(11002, 'Post_description2', 1002);
INSERT INTO POST("ID","DESCRIPTION","user_id")VALUES(11003, 'Post_description3', 1003);