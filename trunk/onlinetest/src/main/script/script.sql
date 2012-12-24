DROP TABLE IF EXISTS `user_test_ans`;
DROP TABLE IF EXISTS `user_test`;
DROP TABLE IF EXISTS `question`;
DROP TABLE IF EXISTS `test`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `class`;
DROP TABLE IF EXISTS `school`;

CREATE TABLE  `school` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(150) default NULL,
  `address` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ;

CREATE TABLE  `class` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(150) default NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE  `user` (
  `id` bigint(20) NOT NULL auto_increment,
  `first_name` varchar(75) default NULL,
  `middle_name` varchar(75) default NULL,
  `last_name` varchar(75) default NULL,
  `role` varchar(75) default NULL,
  `login_id` varchar(100) default NULL,
  `password` varchar(200) default NULL,
  `class_id` bigint(20) default NULL,
  `active` tinyint(1) default NULL,
  `school_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_user_school_id` (`school_id`),
  CONSTRAINT `fk_user_school_id` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`),
  CONSTRAINT `fk_user_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ;

CREATE TABLE  `test` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(200) default NULL,
  `school_id` bigint(20) default NULL,
  `class_id` bigint(20) default NULL,
  `no_of_question`bigint(5),
  `marks_each_questin` bigint(5),
  `negative_marks_each_questin` bigint(5),
  `is_active` bool,
  PRIMARY KEY  (`id`),
  KEY `fk_test_school_id` (`school_id`),
  CONSTRAINT `fk_test_school_id` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`),
  CONSTRAINT `fk_test_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ;

CREATE TABLE  `question` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(200) default NULL,
  `option_a` varchar(200) default NULL,
  `option_b` varchar(200) default NULL,
  `option_c` varchar(200) default NULL,
  `option_d` varchar(200) default NULL,
  `option_e` varchar(200) default NULL,
  `ans_opt` varchar(50) default NULL,
  `test_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_question_test_id` (`test_id`),
  CONSTRAINT `fk_question_test_id` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`)
) ;

CREATE TABLE  `user_test` (
  `user_id` bigint(20) default NULL,
  `test_id` bigint(20) default NULL,
  KEY `fk_user_test_user_id` (`user_id`),
  KEY `fk_user_test_test_id` (`test_id`),
  CONSTRAINT `fk_user_test_test_id` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  CONSTRAINT `fk_user_test_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ;

CREATE TABLE  `user_test_ans` (
  `id` bigint(20) NOT NULL auto_increment,
  `user_id` bigint(20) default NULL,
  `test_id` bigint(20) default NULL,
  `question_id` bigint(20) default NULL,
  `user_ans` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_user_test_ans_user_id` (`user_id`),
  KEY `fk_user_test_ans_test_id` (`test_id`),
  KEY `fk_user_test_ans_question_id` (`question_id`),
  CONSTRAINT `fk_user_test_ans_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `fk_user_test_ans_test_id` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  CONSTRAINT `fk_user_test_ans_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ;


insert into `school` (name, address) values('school1', 'school1');
insert into `class` (name) values('1st'),('2nd'),('3rd'),('4th'),('5th'),('6th'),('7th'),('8th'),('9th'),('10th'),('11th'),('12th');
insert into `user` (first_name, middle_name, last_name, role, login_id, `password`, active, school_id) values('a', 'a', 'a', 'TEACHER', 'teacher1', 'aaaaaa', true, 1);
