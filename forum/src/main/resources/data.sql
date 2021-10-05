INSERT INTO FORUM_USER(name, email, password) VALUES('Student', 'student@email.com', '$2a$10$tTP1WEMnPT.vPvEMf2Th9OALQ0u4vo9pDTn0v/M33csv3aNWv0Oxy');
INSERT INTO FORUM_USER(name, email, password) VALUES('Moderator', 'moderator@email.com', '$2a$10$tTP1WEMnPT.vPvEMf2Th9OALQ0u4vo9pDTn0v/M33csv3aNWv0Oxy');

INSERT INTO PROFILE(id, name) VALUES('1', 'ROLE_STUDENT');
INSERT INTO PROFILE(id, name) VALUES('2', 'ROLE_MODERATOR');

INSERT INTO FORUM_USER_PROFILE(forum_user_id, profile_id) VALUES('1', '1');
INSERT INTO FORUM_USER_PROFILE(forum_user_id, profile_id) VALUES('2', '2');

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Programming');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('doubt', 'I was not able to create the project', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('doubt 2', 'Project does not compile', '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('doubt 3', 'Tag HTML', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);