-- 表的结构 `dept`
CREATE TABLE `dept` (
                        `deptno` int(11) NOT NULL,
                        `deptname` varchar(50) NOT NULL,
                        `dbsource` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `dept` (`deptno`, `deptname`, `dbsource`) VALUES
                                                          (2, '财务部', 'deptmanage01'),
                                                          (3, '行政部', 'deptmanage01'),
                                                          (4, '研发部', 'deptmanage01');

ALTER TABLE `dept` ADD PRIMARY KEY (`deptno`);

ALTER TABLE `dept` MODIFY `deptno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;