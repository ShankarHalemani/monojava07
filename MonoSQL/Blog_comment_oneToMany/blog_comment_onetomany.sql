CREATE DATABASE blog_comment_onetomany;
USE blog_comment_onetomany;

drop table blogs;
truncate table blogs;
INSERT INTO `blog_comment_onetomany`.`blogs` (`category`, `data`, `published`, `publishedDate`, `title`) 
VALUES 
('Technology', 'An overview of the latest advancements in technology for 2024.', 1, '2024-04-01 10:00:00', 'Advancements in Technology 2024'),
('Health', 'Tips and strategies for maintaining good health and wellness.', 1, '2024-03-15 12:30:00', 'Health and Wellness Tips'),
('Travel', 'Explore the best travel destinations for summer 2024.', 1, '2024-02-20 14:00:00', 'Top Travel Destinations for Summer 2024');

truncate table comments;
drop table comments;
-- Comments for Blog ID 1
INSERT INTO `blog_comment_onetomany`.`comments` (`description`, `blog_id`) 
VALUES 
('Great overview of technological advancements!', 1),
('I found the insights on AI very useful.', 1);

-- Comments for Blog ID 2
INSERT INTO `blog_comment_onetomany`.`comments` (`description`, `blog_id`) 
VALUES 
('This article provided some excellent tips for better health.', 2),
('I love the advice on mental wellness.', 2);

-- Comments for Blog ID 3
INSERT INTO `blog_comment_onetomany`.`comments` (`description`, `blog_id`) 
VALUES 
('The travel destinations mentioned are fantastic.', 3),
('I’m planning to visit a few of these places this summer!', 3);