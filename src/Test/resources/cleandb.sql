delete from user;
INSERT INTO user VALUES (1,'Joe','Coyne','jcoyne','supersecret1','1964-04-01'),(2,'Fred','Hensen','fhensen','supersecret2','1988-05-08'),(3,'Barney','Curry','bcurry','supersecret3','1947-11-11'),(4,'Karen','Mack','kmack','supersecret4','1986-07-08'),(5,'Dianne','Klein','dklein','supersecret5','1991-09-22'),(6,'Dawn','Tillman','dtillman','supersecret6','1979-08-30');
delete from personal_workouts;
INSERT INTO personal_workouts VALUES (1, 1, 02012011, 06212017, null, '3x100 skimps, 4x50 IM order, 200 cooldown'), (2, 2, 07152018, 09102018, null, '400SKIMPS, 3x100 free on 1:30, cooldown choice'), (3, 3, 11202016, 02032016, null, '30 mins swim');
delete from role;
INSERT INTO role VALUES (1, 'admin', 1, 'jcoyne'), (2, 'admin', 2, 'fhensen');