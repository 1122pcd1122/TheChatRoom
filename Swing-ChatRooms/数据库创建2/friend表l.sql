/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.20 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `friends` (
	`id` char (60),
	`friendId` char (60)
); 
insert into `friends` (`id`, `friendId`) values('95221','88211');
insert into `friends` (`id`, `friendId`) values('95221','82006');
insert into `friends` (`id`, `friendId`) values('88211','95221');
insert into `friends` (`id`, `friendId`) values('82006','95221');
insert into `friends` (`id`, `friendId`) values('88211','82006');
insert into `friends` (`id`, `friendId`) values('82006','88211');
