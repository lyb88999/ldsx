/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.60 : Database - haxinxi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`haxinxi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `haxinxi`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` int(4) NOT NULL,
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`deptno`,`dname`,`loc`) values (10,'ACCOUNTING','NEW YORK'),(20,'RESEARCH','DALLAS'),(30,'SALES','CHICAGO'),(40,'OPERATIONS','BOSTON');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `empno` int(4) NOT NULL,
  `ename` varchar(10) DEFAULT NULL,
  `job` varchar(9) DEFAULT NULL,
  `mgr` int(4) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(2) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `fk_deptno` (`deptno`),
  CONSTRAINT `fk_deptno` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (7369,'SMITH',NULL,NULL,NULL,NULL,NULL,NULL),(7499,'ALLEN','SALESMAN',7698,'1981-02-20','1600.00','300.00',30),(7521,'WARD','SALESMAN',7698,'1981-02-22','1250.00','500.00',30),(7566,'JONES','MANAGER',7839,'1981-04-02','2975.00',NULL,20),(7654,'MARTIN','SALESMAN',7698,'1981-09-28','1250.00','1400.00',30),(7698,'BLAKE','MANAGER',7839,'1981-05-01','2850.00',NULL,30),(7782,'CLARK','MANAGER',7839,'1981-06-09','2450.00',NULL,10),(7788,'SCOTT','ANALYST',7566,'1987-04-19','3000.00',NULL,20),(7839,'KING','PRESIDENT',NULL,'1981-11-17','5000.00',NULL,10),(7844,'TURNER','SALESMAN',7698,'1981-09-08','1500.00','0.00',30),(7876,'ADAMS','CLERK',7788,'1987-05-23','1100.00',NULL,20),(7900,'JAMES','CLERK',7698,'1981-12-03','950.00',NULL,30),(7902,'FORD','ANALYST',7566,'1981-12-03','3000.00',NULL,20),(7934,'MILLER','CLERK',7782,'1982-01-23','1300.00',NULL,10);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rid` int(10) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`rid`,`rolename`) values (5,'flora'),(6,'chance'),(7,'julian'),(8,'colin'),(9,'ella');

/*Table structure for table `salgrade` */

DROP TABLE IF EXISTS `salgrade`;

CREATE TABLE `salgrade` (
  `grade` int(1) DEFAULT NULL,
  `losal` decimal(7,2) DEFAULT NULL,
  `hisal` decimal(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salgrade` */

insert  into `salgrade`(`grade`,`losal`,`hisal`) values (1,'700.00','1200.00'),(2,'1201.00','1400.00'),(3,'1401.00','2000.00'),(4,'2001.00','3000.00'),(5,'3001.00','9999.00');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`) values (1,'lisi','666666'),(2,'zhangsan','555555'),(3,'wangwu','777777'),(4,'zhaoliu','666666'),(5,'jack','123456'),(6,'tom','888999'),(7,'tom1','33333');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
