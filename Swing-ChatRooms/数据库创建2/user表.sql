/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.20 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`id` char (60),
	`email` char (96),
	`password` char (96),
	`nickname` char (96),
	`autograph` char (96),
	`create_time` datetime ,
	`gender` char (96),
	`phone` char (96)
); 
insert into `user` (`id`, `email`, `password`, `nickname`, `autograph`, `create_time`, `gender`, `phone`) values('82006','123','1','1','在线','2021-01-05 00:00:00','男','123');
insert into `user` (`id`, `email`, `password`, `nickname`, `autograph`, `create_time`, `gender`, `phone`) values('88211','123','2','2','在线','2021-01-05 00:00:00','男','123');
insert into `user` (`id`, `email`, `password`, `nickname`, `autograph`, `create_time`, `gender`, `phone`) values('95221','113242795@qq.com','123','大人物','在线','2021-01-05 00:00:00','男','17836595685');
