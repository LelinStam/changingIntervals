delete from locations;
insert into locations values (1, '345 Market St', 'Milwaukee', 'WI', '45660'), (2, '2402 Columbus Ln', 'Madison', 'WI', '54482'), (3, '14 Gingerbread Ln', 'North Pole', 'AC', '70001');

delete from user;
INSERT INTO user VALUES (1,'Joe','Coyne','jcoyne','supersecret1','1964-04-01', null, 'jcoyne@aol.com'),(2,'Fred','Hensen','fhensen','supersecret2','1988-05-08', 3, 'fhensen@yahoo.com'),(3,'Barney','Curry','bcurry','supersecret3','1947-11-11', null, 'bubba@myworkingfarm.org'),(4,'Karen','Mack','kmack','supersecret4','1986-07-08', null, 'catlover33@gmail.com'),(5,'Dianne','Klein','dklein','supersecret5','1991-09-22', 2, 'Dianne@kleingardens.com'),(6,'Dawn','Tillman','dtillman','supersecret6','1979-08-30', 1, '2399tillman@aol.com');

delete from my_workouts;
INSERT INTO my_workouts VALUES (1, '3x100 skimps, 4x50 IM order, 200 cooldown', '2011-02-01', '2017-06-21', 1,  3), (2, '400SKIMPS, 3x100 free on 1:30, cooldown choice', '2018-07-15', '2018-09-10', 2,  2), (3, '30 mins swim', '2016-11-20', '2016-02-03', 3,  1);

delete from role;
INSERT INTO role VALUES (11, 'admin', 1, 'jcoyne'), (12, 'admin', 2, 'fhensen');

delete from blog;
insert into blog values (1, 'title', 'Swim fast', '2020-01-20', 1), (2, 'Swim', 'Swim slow', '2020-01-22', 2);
