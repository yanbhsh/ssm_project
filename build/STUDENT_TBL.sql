
DROP TABLE IF EXISTS `STUDENT_TBL`;
CREATE TABLE `STUDENT_TBL` (
  `STUDENT_ID` varchar(255) COLLATE utf8_bin NOT NULL,
  `STUDENT_NAME` varchar(10) COLLATE utf8_bin NOT NULL,
  `STUDENT_SEX` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `STUDENT_BIRTHDAY` date DEFAULT NULL,
  `CLASS_ID` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`STUDENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `STUDENT_TBL` VALUES ('YBH123', '111', '111', '2016-03-08', '111');
INSERT INTO `STUDENT_TBL` VALUES ('ybh1', 'ybh', 'b', '2016-03-08', 'no2');