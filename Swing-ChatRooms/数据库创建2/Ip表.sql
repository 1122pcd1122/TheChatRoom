/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.20 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `ip` (
	`id` char (60),
	`address` char (60),
	`port` int (20)
); 
insert into `ip` (`id`, `address`, `port`) values('82006','/127.0.0.1','5022');
insert into `ip` (`id`, `address`, `port`) values('88211','/127.0.0.1','5600');
insert into `ip` (`id`, `address`, `port`) values('95221','/127.0.0.1','5022');
