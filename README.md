# ultrasound2
springboot+mysql 对超声波数据增删改查


数据库建表：
CREATE TABLE IF NOT EXISTS `table_ultrasound_2`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `waveform` text NOT NULL,
   `equipment` VARCHAR(200) NOT NULL,
   `constructionSite` VARCHAR(200) NOT NULL,
   `section` VARCHAR(50) NOT NULL,
   `author` VARCHAR(20) NOT NULL,
   `uploadDate` VARCHAR(50) NOT NULL,
   `foundDate` VARCHAR(50) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO table_ultrasound_2 
 VALUES
 ("1", "28.1", "1号设备", "上海", "1号", "赵", "2019年10月17日", "2019年10月17日"),
("2", "28.2", "2号设备", "上海", "1号", "赵", "2019年10月17日", "2019年10月17日"),
("3", "28.3", "3号设备", "北京", "1号", "赵", "2019年10月17日", "2019年10月17日"),
("4", "28.4", "4号设备", "上海", "1号", "赵", "2019年10月17日", "2019年10月17日"),
("5", "28.5", "5号设备", "上海", "1号", "赵", "2019年10月17日", "2019年10月17日"),
("6", "28.6", "6号设备", "山西", "1号", "赵", "2019年10月17日", "2019年10月17日"),
("7", "28.7", "7号设备", "上海", "1号", "赵", "2019年10月17日", "2019年10月17日");
