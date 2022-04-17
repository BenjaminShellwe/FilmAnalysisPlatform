/*
 Navicat Premium Data Transfer

 Source Server         : localhost0
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : benjamin

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 24/03/2022 20:20:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for abbreviation
-- ----------------------------
DROP TABLE IF EXISTS `abbreviation`;
CREATE TABLE `abbreviation`  (
  `prefix` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前缀标识码',
  `ID` int NOT NULL COMMENT '缩写表中字段编号',
  `abbreviation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩写所代表含义',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更多注释',
  `examplesOrCodeLocations` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '示例或代码位置',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of abbreviation
-- ----------------------------
INSERT INTO `abbreviation` VALUES ('G', 10, 'GID', '2022-02-01 22:13:31', '2022-02-11 13:40:49', 'global ID缩写,用于数据字典的唯一识别数值的识别使用,G表示该代码或字段为整个项目全局标识', '表user中GID字段');
INSERT INTO `abbreviation` VALUES ('D', 11, '*suggestion1', '2022-02-01 22:16:20', '2022-02-11 13:25:56', '所有相关字段都用英语驼峰命名组合而来,请谨慎使用并小心修改,若是缩写请一定在此处说明', '无');
INSERT INTO `abbreviation` VALUES ('D', 12, '*suggestion2', '2022-02-01 22:42:53', '2022-02-11 13:42:05', '此表从10开始排列,0-9为数据库中保留整型值,10-16为本表说明建议列,17+为项目代码所使用变量说明,由GID进行区分', '无');
INSERT INTO `abbreviation` VALUES ('D', 13, '*suggestion3', '2022-02-01 22:52:52', '2022-02-11 13:26:01', '所有代码一般为,不含中文的半角字符,在半角逗号后都默认添加一个半角状态的空格', '*fip, *bip, abc,');
INSERT INTO `abbreviation` VALUES ('D', 14, 'prefix', '2022-02-11 13:30:02', '2022-02-11 13:44:03', '本表中prefix所使用记录的值与本表ID一起组合成GID,其它表组成情况类似', '*B *D *F');
INSERT INTO `abbreviation` VALUES ('D', 15, '*字段名称组成方式', '2022-02-11 13:45:41', '2022-02-11 13:58:09', '多单词情况驼峰 首字母必须小写 大写开头说明整个名称都是缩写', 'updateTime');
INSERT INTO `abbreviation` VALUES ('D', 16, '*命名方式', '2022-02-11 13:58:06', '2022-02-11 14:07:52', '同一表内命名:使用英文表示,如使用一个单词尽量使用名词;所用单词重复在前面添加修饰(表/谓+宾,宾+补;减少使用主谓形式,尽量避免歧义)', '无');
INSERT INTO `abbreviation` VALUES ('D', 17, '*', '2022-02-01 22:17:03', '2022-02-11 13:26:02', '带 * 号说明该值不是数据库中使用的缩写字段记录或者是项目中的变量值', '*fip, *bip');
INSERT INTO `abbreviation` VALUES ('D', 18, '*fip', '2022-02-01 22:28:56', '2022-02-11 14:07:55', 'Front end interactive platform  即 HR BackgroundAdminRedesign by shellwe 项目中的前端源码代码', '无');
INSERT INTO `abbreviation` VALUES ('D', 19, '*bip', '2022-02-01 22:29:03', '2022-02-11 14:07:57', 'Back end interactive platform  即 HR BackgroundAdminRedesign by shellwe 项目中的后端源码代码', '无');
INSERT INTO `abbreviation` VALUES ('B', 20, '←', '2022-02-01 22:32:45', '2022-02-11 14:07:59', '带←代表其后所接的是*fip中所使用的变量名称', '无');
INSERT INTO `abbreviation` VALUES ('B', 21, '→', '2022-02-01 22:38:58', '2022-02-11 14:10:44', '带→代表其后所接的是*bip中所使用的变量名称', '无');
INSERT INTO `abbreviation` VALUES ('G', 22, '.*', '2022-02-01 23:06:27', '2022-02-11 13:39:16', '正则表达式通配符,为防止出现指代对象一样,名称不一样等的冗余情况,在使用通用代码时保持一致。搜索以 ab开头，以eq结尾的内容，例如 ab1321eq，abeq，abeqeqeq等等', 'ab.*eq');
INSERT INTO `abbreviation` VALUES ('F', 23, '!!.*!!', '2022-02-09 14:50:24', '2022-02-11 13:26:21', 'fip占位通用符号 .* 可为任意字符', '!!预留!!');

-- ----------------------------
-- Table structure for basicAvatar
-- ----------------------------
DROP TABLE IF EXISTS `basicAvatar`;
CREATE TABLE `basicAvatar`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '图像表内标识',
  `caption` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表述',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `userID` int NULL DEFAULT NULL COMMENT '关联账户',
  `image` longblob NULL COMMENT '图像本身',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图像名称',
  `data` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传时附带的额外参数',
  `headers` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传的请求头部',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传的图片地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2022002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basicAvatar
-- ----------------------------
INSERT INTO `basicAvatar` VALUES (2022001, NULL, NULL, 202200, 0x30, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for informationEnterpriseDepartment
-- ----------------------------
DROP TABLE IF EXISTS `informationEnterpriseDepartment`;
CREATE TABLE `informationEnterpriseDepartment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识',
  `departmentID` bigint NOT NULL COMMENT '部门规则ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `enterpriseID` bigint NULL DEFAULT NULL COMMENT '企业标识ID',
  `enterprise` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `UIDD` int NULL DEFAULT NULL COMMENT '主管ID',
  `director` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主管',
  `phoneD` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主管电话',
  `UIDM` int NULL DEFAULT NULL COMMENT '经理ID',
  `manager` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经理',
  `phoneM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经理电话',
  `departmentStatus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门状态',
  PRIMARY KEY (`id`, `departmentID`) USING BTREE,
  INDEX `EnterpriseDepartment`(`enterpriseID`, `enterprise`) USING BTREE,
  INDEX `DepartmentManager`(`UIDM`, `manager`) USING BTREE,
  INDEX `DepartmentDirector`(`UIDD`, `director`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `departmentID`(`departmentID`) USING BTREE,
  CONSTRAINT `DepartmentDirector` FOREIGN KEY (`UIDD`, `director`) REFERENCES `basicUser` (`id`, `userRealName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `DepartmentManager` FOREIGN KEY (`UIDM`, `manager`) REFERENCES `basicUser` (`id`, `userRealName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `EnterpriseDepartment` FOREIGN KEY (`enterpriseID`, `enterprise`) REFERENCES `enterprise` (`id`, `name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of informationEnterpriseDepartment
-- ----------------------------
INSERT INTO `informationEnterpriseDepartment` VALUES (0, 22000001, 'Management', 1, '默认公司设置', 20220012, 'NoEnterprise1', '1345', 20220012, 'NoEnterprise1', '117', 'sufficiency(已达部门标准人数)');
INSERT INTO `informationEnterpriseDepartment` VALUES (1, 22000002, 'Personal', 1, '默认公司设置', 20220013, 'NoEnterprise2', '116', 20220013, 'NoEnterprise2', '118', 'sufficiency(已达部门标准人数)');
INSERT INTO `informationEnterpriseDepartment` VALUES (3, 20220303, 'Software', 202202192128, NULL, 20220006, 'Employee', '1654321', 20220016, 'ManagerTPT', '1654321', '(未达部门标准人数)');
INSERT INTO `informationEnterpriseDepartment` VALUES (4, 20220304, 'Personal', 202202192128, 'TernaryProject', 20220011, 'Employee1', '1654321', 20220016, 'ManagerTPT', '1654321', '(未达部门标准人数)');
INSERT INTO `informationEnterpriseDepartment` VALUES (5, 20220302, 'Education', 202202192128, 'TernaryProject', 20220017, 'DirectorTPT', '1654321', 20220016, 'ManagerTPT', '1654321', 'overstaffed(已超部门最大人数)');
INSERT INTO `informationEnterpriseDepartment` VALUES (6, 20220301, 'SeniorManagement', 202202192128, 'TernaryProject', 20220003, 'Director', '1654321', 202200, 'BenjaminThomasShellwe', '1654321', 'overstaffed(已超部门最大人数)');
INSERT INTO `informationEnterpriseDepartment` VALUES (7, 20220305, 'Placeholder', 0, '无归属公司', 202201, 'Placeholdor', '123321', 202201, 'Placeholdor', '123321', 'placeholdor');

-- ----------------------------
-- Table structure for dictionaryGlobal
-- ----------------------------
DROP TABLE IF EXISTS `dictionaryGlobal`;
CREATE TABLE `dictionaryGlobal`  (
  `prefix` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'G' COMMENT '全局ID前缀',
  `id` int NOT NULL AUTO_INCREMENT COMMENT '全局表内标识id 数据库内不得重复',
  `uniqueID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表内标识id 表内不得重复',
  `typeCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表内识别代码',
  `typeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表内代码类型对应语言显示名称',
  `valueID` int NOT NULL COMMENT '表内识别ID 表内可重复',
  `valueName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表内识别ID 对应中文显示名称',
  `valueStatus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'efficient' COMMENT '模板启用状态',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `editable` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 1 COMMENT '可否编辑',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'group' COMMENT '模板种类',
  PRIMARY KEY (`id`, `prefix`) USING BTREE,
  INDEX `globalUniqueID_2`(`id`, `valueID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2124 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dictionaryGlobal
-- ----------------------------
INSERT INTO `dictionaryGlobal` VALUES ('G', 101, '1000', 'Certificate_Type', '证件类型', 1, '身份证号', 'efficient', '组规则 预设 有效 不可修改', 0, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 102, '1000', 'Certificate_Type', '证件类型', 2, '驾驶证号', 'inefficient', '组规则 预设 有效 不可修改', 0, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('A', 110, '1003', 'Account', '账户号码', 0, '账户号码', 'efficient', '单规则 预设 有效 不可修改', 0, 'single');
INSERT INTO `dictionaryGlobal` VALUES ('L', 111, '1001', 'LoginName_Type', '登入名称', 1, '登录名称', 'efficient', '组规则 预设 有效 不可修改', 0, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('L', 112, '1001', 'LoginName_Type', '登入名称', 2, '用户名称', 'inefficient', '组规则 预设 有效 不可修改', 0, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('L', 113, '1001', 'LoginName_Type', '登入名称', 3, '注册名称', 'inefficient', '组规则 预设 无效 不可修改', 0, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('L', 114, '1001', 'LoginName_Type', '登入名称', 4, '账户名称', 'inefficient', '组规则 预设 有效 不可修改', 0, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('R', 120, '1002', 'RealName', '真实名称', 0, '真实姓名', 'efficient', '单规则 预设 有效 不可修改', 0, 'single');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2100, '2052', 'Examples_Type', '示例类型', 3, '示例类型1', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2101, '2001', 'Examples_Type', '示例类型', 2, '示例类型2', 'inefficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2111, '2011', 'Examples_Type', '示例', 1, '示例', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2112, '2012', 'Examples_Type', '示例', 2, '示例', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2113, '2014', 'Examples_Type', '用于删除', 1, '示例', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2114, '2014', 'Examples_Type', '用于删除', 2, '示例', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2115, '2014', 'Examples_Type', '用于删除', 3, '示例', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2116, '2014', 'Examples_Type', '用于删除', 6, '示例', 'efficient', '组规 示例 可修 可删', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2117, '2015', 'example', '用于删除', 0, '0000', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2118, '2014', 'Examples_Type', '用于删除', 4, '1111', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2119, '2014', 'Examples_Type', '用于删除', 0, '1111', 'efficient', '组规则 示例 可修改 可删除', 0, 'single');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2120, '2014', 'Examples_Type', '用于删除', 5, '1111', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2121, '2014', 'Examples_Type', '用于删除', 7, '1111', 'efficient', '组规则 示例 可修改 可删除', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2122, '2014', 'Examples_Type', '用于删除', 8, '8', 'efficient', '8', 1, 'group');
INSERT INTO `dictionaryGlobal` VALUES ('G', 2123, '2014', 'Examples_Type', '用于删除', 9, '9', 'efficient', '9', 1, 'group');

-- ----------------------------
-- Table structure for informationEnterpriseEmployees
-- ----------------------------
DROP TABLE IF EXISTS `informationEnterpriseEmployees`;
CREATE TABLE `informationEnterpriseEmployees`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识符',
  `userID` int NOT NULL COMMENT '账号唯一标识ID',
  `enterprise` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属企业',
  `realName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `enterpriseID` bigint NOT NULL COMMENT '所属公司标识码',
  `informationEnterpriseDepartment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业内所属部门',
  `phone` bigint NULL DEFAULT NULL COMMENT '电话号码',
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工职位',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工状态',
  `remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `political` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '政治面貌',
  `birth` date NULL DEFAULT NULL COMMENT '生日',
  `entry` date NULL DEFAULT NULL COMMENT '入职时间',
  `salary` decimal(9, 2) NULL DEFAULT NULL COMMENT '工资',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入职方式',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '性别',
  PRIMARY KEY (`id`, `userID`, `enterpriseID`) USING BTREE,
  INDEX `userInfo`(`userID`, `realName`) USING BTREE,
  INDEX `enterpriseInfo`(`enterpriseID`, `enterprise`) USING BTREE,
  CONSTRAINT `enterpriseInfo` FOREIGN KEY (`enterpriseID`, `enterprise`) REFERENCES `enterprise` (`id`, `name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userInfo` FOREIGN KEY (`userID`, `realName`) REFERENCES `basicUser` (`id`, `userRealName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of informationEnterpriseEmployees
-- ----------------------------
INSERT INTO `informationEnterpriseEmployees` VALUES (1, 202200, 'TernaryProject', 'BenjaminThomasShellwe', 202202192128, 'SeniorManagement', 8617600002321, 'ChairmanOfTheBoard', 'activity', 'HR-admin项目总负责人 TernaryProjectTeam负责人', '团员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (2, 20220001, '测试1公司名称', 'Manager', 202202192132, 'SeniorManagement', 8617600001234, 'Manager', 'activity', 'Tester', '党员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (3, 20220002, '测试2公司名称', 'Webmaster', 202202192135, 'Personnel', 8617600004321, 'Webmaster', 'activity', 'Tester', '群众', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (4, 20220003, '测试3公司名称', 'Director', 202202192136, 'Personnel', 8617600002152, 'Supervisor', 'negative', 'Tester', '团员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (5, 20220004, '测试4公司名称', 'Tester', 202202192137, 'Software', 8617600051426, 'Tester', 'negative', 'Tester', '党员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (6, 20220005, '测试5公司名称', 'Tutor', 202202192138, 'education', 8617600009586, 'Tutor', 'negative', 'Tester', '群众', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (7, 20220006, '测试6公司名称', 'Employee', 202202192334, 'Personnel', 8617600001542, 'Employee', 'negative', 'Tester', '团员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (8, 20220007, 'TernaryProject', 'PleaseChangeInTableUser', 202202192128, 'education', 8610000000000, 'Employee', 'negative', 'Tester', '党员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (9, 20220008, 'TernaryProject', 'Manager1', 202202192128, 'SeniorManagement', 8610000000000, 'Manager', 'activity', 'Tester', '群众', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (10, 20220009, 'TernaryProject', 'Webmaster1', 202202192128, 'Personnel', 8610000000000, 'Webmaster', 'activity', 'Tester', '团员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (11, 20220010, 'TernaryProject', 'Supervisor1', 202202192128, 'Personnel', 8610000000000, 'Supervisor', 'activity', 'Tester', '党员', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (12, 20220011, 'TernaryProject', 'Employee1', 202202192128, 'Software', 8610000000000, 'Employee', 'activity', 'Tester', '群众', '2022-03-04', '2022-03-04', 20000.00, NULL, '0');
INSERT INTO `informationEnterpriseEmployees` VALUES (13, 20220012, '无归属公司', 'NoEnterprise1', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0');

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise`  (
  `id` bigint NOT NULL DEFAULT 0 COMMENT '企业识别码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业名称',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业地址',
  `representative` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '法定代表人',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司类型',
  `createTime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入驻时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省市',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '审核' COMMENT '企业经营状态',
  PRIMARY KEY (`id`, `name`) USING BTREE,
  INDEX `id`(`id`, `name`) USING BTREE,
  INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES (0, '无归属公司', NULL, '用户自身', NULL, '2022-02-21 00:57:20', NULL, '停业');
INSERT INTO `enterprise` VALUES (1, '默认公司设置', '无', '默认法人', '默认类型', '2022-03-01 17:34:45', '默认地址', '审核');
INSERT INTO `enterprise` VALUES (202202192128, 'TernaryProject', '广东省湛江市霞山区东新街道***', 'Benjamin Thomas Shellwe', '有限责任公司', '2022-02-19 22:33:40', '广东湛江', '在业');
INSERT INTO `enterprise` VALUES (202202192132, '测试1公司名称', '测试1公司地址', '测试1公司法人', '股份有限公司', '2022-02-19 21:40:10', '测试1公司省市', '吊销');
INSERT INTO `enterprise` VALUES (202202192135, '测试2公司名称', '测试2公司地址', '测试2公司法人', '联营企业', '2022-02-19 23:32:22', '测试2公司省市', '注销');
INSERT INTO `enterprise` VALUES (202202192136, '测试3公司名称', '测试3公司地址', '测试3公司法人', '外商投资企业', '2022-02-19 23:32:22', '测试3公司省市', '迁入');
INSERT INTO `enterprise` VALUES (202202192137, '测试4公司名称', '测试4公司地址', '测试4公司法人', '个人独资企业', '2022-02-19 23:32:23', '测试4公司省市', '迁出');
INSERT INTO `enterprise` VALUES (202202192138, '测试5公司名称', '测试5公司地址', '测试5公司法人', '股份合作企业', '2022-02-19 23:32:28', '测试5公司省市', '存续');
INSERT INTO `enterprise` VALUES (202202192334, '测试6公司名称', '测试6公司地址', '测试6公司法人', '有限合伙企业', '2022-02-19 23:32:34', '测试6公司省市', '清算');

-- ----------------------------
-- Table structure for logsystem
-- ----------------------------
DROP TABLE IF EXISTS `logsystem`;
CREATE TABLE `logsystem`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '表内标识符号',
  `date` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `model_requestID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'NoData' COMMENT '请求ID',
  `model_serviceName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '服务名称',
  `model_readWriteType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '读写类型',
  `model_userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '用户名称',
  `model_accountName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名称',
  `model_realName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '真实名称',
  `model_resourceType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '资源类型',
  `model_resourceName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '资源类型',
  `model_operationName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '操作类型',
  `model_keyValue` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '键值',
  PRIMARY KEY (`id`, `model_requestID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logsystem
-- ----------------------------
INSERT INTO `logsystem` VALUES (1, '2022-02-22 02:11:53', '202201172025', '毕设2022', '订单生成写入', 'BenjaminThomasShellwe', 'shellweTheAdmin', 'wjw', '软件资源', '软件工程系毕业设计', '毕设创建生成写入', 'null');
INSERT INTO `logsystem` VALUES (2, '2022-02-22 02:09:13', '202202220205', '德语教育辅导', '订单生成写入', 'BenjaminThomasShellwe', 'admin', 'NoData', '人力资源', '基础德语', '课程输出', '1');
INSERT INTO `logsystem` VALUES (3, '2022-02-22 02:09:19', '202202220206', '法语教育辅导', '订单生成写入', 'Alex', 'Alex', 'Alex', '人力资源', '基础法语', '课程输出', '2');
INSERT INTO `logsystem` VALUES (4, '2022-02-22 02:10:30', '202202220207', '粤语正字辅导', '订单生成写入', 'Jeff', 'Jeff', 'Jeff', '人力资源', '基础汉语', '课程输出', '3');
INSERT INTO `logsystem` VALUES (5, '2022-02-22 02:11:31', '202202220208', '英语发音辅导', '订单生成写入', 'Nancy', 'Nancy', 'Nancy', '人力资源', '基础英语', '课程输出', '4');
INSERT INTO `logsystem` VALUES (6, '2022-02-22 02:12:23', '202202220209', '英语教育辅导', '订单生成写入', 'Joe', 'Joe', 'Joe', '人力资源', '基础英语', '课程输出', '5');
INSERT INTO `logsystem` VALUES (7, '2022-02-22 02:13:22', '202202220210', '软件开发设计', '订单生成写入', 'Thomas', 'Thomas', 'Thomas', '物力资源', '软件工程', '服务输出', '6');

-- ----------------------------
-- Table structure for monitor
-- ----------------------------
DROP TABLE IF EXISTS `monitor`;
CREATE TABLE `monitor`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表中标识符',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监控表中用户名',
  `userID` int NULL DEFAULT NULL COMMENT '用户账号',
  `GID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'G10001' COMMENT '操作标识符',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NotSet' COMMENT '操作类型',
  `date` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `monitorUser`(`userName`, `userID`) USING BTREE,
  CONSTRAINT `monitorUser` FOREIGN KEY (`userName`, `userID`) REFERENCES `basicUser` (`userName`, `id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monitor
-- ----------------------------
INSERT INTO `monitor` VALUES (1, 'admin', 202200, 'G10001', '更改信息', '2022-02-22 03:11:55');
INSERT INTO `monitor` VALUES (2, 'manager', 20220001, 'G10001', '更改信息', '2022-02-22 03:12:10');
INSERT INTO `monitor` VALUES (3, 'webmaster', 20220002, 'G10001', 'NotSet', '2022-02-22 03:11:17');
INSERT INTO `monitor` VALUES (4, 'supervisor', 20220003, 'G10001', '更改信息', '2022-02-22 03:12:11');
INSERT INTO `monitor` VALUES (5, 'tester', 20220004, 'G10001', '更改信息', '2022-02-22 03:54:31');
INSERT INTO `monitor` VALUES (6, 'tutor', 20220005, 'G10001', 'NotSet', '2022-02-22 03:11:41');

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识',
  `affairID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '(now() + 0)' COMMENT '事务ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `informationEnterpriseDepartment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `rules` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则',
  `expression` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表现',
  `proportion` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '占比',
  `completion` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '完成度',
  `data1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'data1',
  `data2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'data2',
  `data3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'data3',
  `data4` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'data4',
  PRIMARY KEY (`id`, `affairID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of performance
-- ----------------------------

-- ----------------------------
-- Table structure for personaldic
-- ----------------------------
DROP TABLE IF EXISTS `personaldic`;
CREATE TABLE `personaldic`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识',
  `prefix` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'P' COMMENT '前缀码',
  `uniqueID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表内标识id 表内不得重复',
  `typeCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表内识别代码',
  `typeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表内代码类型对应语言显示名称',
  `valueID` int NULL DEFAULT NULL COMMENT '表内识别ID 表内可重复',
  `valueName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表内识别ID 对应中文显示名称',
  `valueStatus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'efficient' COMMENT '模板启用状态',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `editable` tinyint(1) NULL DEFAULT 1 COMMENT '可否编辑',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'group' COMMENT '模板种类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personaldic
-- ----------------------------
INSERT INTO `personaldic` VALUES (0, 'P', '2022', 'personal_type', '个人类型', 1, '个人模板示例1', 'efficient', NULL, 1, 'group');
INSERT INTO `personaldic` VALUES (1, 'P', '20023', 'personal_type', '个人类型', 2, '个人模板示例2', 'efficient', NULL, 1, 'group');
INSERT INTO `personaldic` VALUES (3, 'P', '20022', 'personal', '个人属性', 0, '个人属性示例1', 'efficient', NULL, 1, 'single');

-- ----------------------------
-- Table structure for informationPersonal
-- ----------------------------
DROP TABLE IF EXISTS `informationPersonal`;
CREATE TABLE `informationPersonal`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识',
  `userID` int NOT NULL COMMENT '账号唯一标识ID',
  `realName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `nickName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户自定义名称',
  `homeUrl` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '主页连接',
  `wechat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '微信号码',
  `qq` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq号码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号码',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NotSet' COMMENT '用户性别',
  `occupationStatus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '职业状况',
  `enterprise` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NoData' COMMENT '所属企业',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间',
  `birth` date NULL DEFAULT NULL COMMENT '出生日期',
  `habitation` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`, `userID`) USING BTREE,
  INDEX `userPersonInfo`(`userID`, `realName`) USING BTREE,
  CONSTRAINT `userPersonInfo` FOREIGN KEY (`userID`, `realName`) REFERENCES `basicUser` (`id`, `userRealName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of informationPersonal
-- ----------------------------
INSERT INTO `informationPersonal` VALUES (1, 202200, 'BenjaminThomasShellwe', 'shellwe', 'shellwe.top', 'same as phone', '774830022', '1760002321', 'Male', 'Incumbency', 'TernaryProject', '2022-02-18 15:15:35', '2022-02-18', '湛江市', '广东省湛江市霞山区东新街道', 'HR-admin项目总负责人 TernaryProjectTeam负责人');
INSERT INTO `informationPersonal` VALUES (2, 20220001, 'Manager', 'TestAccount', 'No Data', 'No Data', '123456', '110', 'Male', 'Incumbency', 'TernaryProject', '2022-02-19 14:32:26', '2022-02-19', '湛江市', '广东省湛江市霞山区东新街道', 'HR-admin项目测试负责人 ');
INSERT INTO `informationPersonal` VALUES (3, 20220002, 'Webmaster', 'TestAccount', 'No Data', 'No Data', '123456', '120', 'Female', 'Incumbency', 'TernaryProject', '2022-02-19 23:02:36', '2022-02-19', '湛江市', '广东省湛江市霞山区东新街道', 'HR-admin项目测试负责人');
INSERT INTO `informationPersonal` VALUES (4, 20220003, 'Director', 'TestAccount', 'No Data', 'No Data', '123456', '119', 'Female', 'Job-hunting', 'No Data', '2022-02-19 23:53:54', '2022-02-19', 'No Data', 'No Data', 'No Data');
INSERT INTO `informationPersonal` VALUES (5, 20220004, 'Tester', 'TestAccount', 'No Data', 'No Data', '123456', '114', 'Male', 'Job-hunting', 'No Data', '2022-02-19 23:53:55', '2022-02-19', 'No Data', 'No Data', 'No Data');
INSERT INTO `informationPersonal` VALUES (6, 20220005, 'Tutor', 'TestAccount', 'No Data', 'No Data', '123456', '123', 'Female', 'Job-hunting', 'No Data', '2022-02-19 23:53:55', '2022-02-19', 'No Data', 'No Data', 'No Data');
INSERT INTO `informationPersonal` VALUES (7, 20220006, 'Employee', 'TestAccount', 'No Data', 'No Data', '123456', '10086', 'Female', 'Job-hunting', 'No Data', '2022-02-20 00:41:20', '2022-02-19', 'No Data', 'No Data', 'No Data');
INSERT INTO `informationPersonal` VALUES (8, 20220007, 'PleaseChangeInTableUser', 'TestAccount', 'NoData', 'NoData', '0', '0', 'NotSet', 'NoData', 'NoData', '2022-02-21 00:33:17', '2022-02-21', 'NoData', 'NoData', 'NoData');
INSERT INTO `informationPersonal` VALUES (9, 20220008, 'Manager1', 'TestAccount', 'NoData', 'NoData', '0', '0', 'NotSet', 'NoData', 'NoData', '2022-02-21 00:33:30', '2022-02-21', 'NoData', 'NoData', 'NoData');
INSERT INTO `informationPersonal` VALUES (10, 20220009, 'Webmaster1', 'TestAccount', 'NoData', 'NoData', '0', '0', 'NotSet', 'NoData', 'NoData', '2022-02-21 00:33:51', '2022-02-21', 'NoData', 'NoData', 'NoData');
INSERT INTO `informationPersonal` VALUES (11, 20220010, 'Supervisor1', 'TestAccount', 'NoData', 'NoData', '0', '0', 'NotSet', 'NoData', 'NoData', '2022-02-21 00:33:59', '2022-02-21', 'NoData', 'NoData', 'NoData');
INSERT INTO `informationPersonal` VALUES (12, 20220011, 'Employee1', 'TestAccount', 'NoData', 'NoData', '0', '0', 'NotSet', 'NoData', 'NoData', '2022-02-21 00:34:09', '2022-02-21', 'NoData', 'NoData', 'NoData');
INSERT INTO `informationPersonal` VALUES (13, 20220012, 'NoEnterprise1', 'TestAccount', 'NoData', 'NoData', '0', '0', 'NotSet', 'NoData', 'NoData', '2022-02-21 00:57:54', '2022-02-21', 'NoData', 'NoData', 'NoData');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识',
  `positionID` int NOT NULL COMMENT '表规则ID',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'No' COMMENT '职称',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `additional` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NotSet' COMMENT '附加说明',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `positionID`(`positionID`) USING BTREE,
  INDEX `seniorTitle`(`title`, `positionID`, `name`, `additional`) USING BTREE,
  INDEX `seniorTitle_2`(`title`, `name`, `additional`) USING BTREE,
  INDEX `seniorTitle_3`(`title`) USING BTREE,
  INDEX `seniorTitle_4`(`title`, `name`) USING BTREE,
  INDEX `intermediateTitle`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20221308 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (6, 22001006, 'general', 'Tutor', 'NotSet');
INSERT INTO `position` VALUES (8, 22001008, 'general', 'Engineer', 'NotSet');
INSERT INTO `position` VALUES (3, 22001003, 'intermediate', 'Webmaster', 'No');
INSERT INTO `position` VALUES (4, 22001004, 'intermediate', 'Director', 'NotSet');
INSERT INTO `position` VALUES (5, 22001005, 'intermediate', 'Engineer', 'NotSet');
INSERT INTO `position` VALUES (7, 22001007, 'No', 'Employee', 'NotSet');
INSERT INTO `position` VALUES (9, 22001009, 'No', 'Programmer', 'NotSet');
INSERT INTO `position` VALUES (10, 22001010, 'No', 'Tester', 'NotSet');
INSERT INTO `position` VALUES (11, 22001011, 'No', 'Placeholder', 'PlaceholderNotRealPosition');
INSERT INTO `position` VALUES (0, 22002020, 'No', 'No position', 'NotSet');
INSERT INTO `position` VALUES (1, 22001001, 'senior', 'Chairman', 'Executive');
INSERT INTO `position` VALUES (2, 22001002, 'senior', 'Manager', 'Staff');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识符',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '已注册账户分配角色',
  `enterprisePermission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NotSet' COMMENT '角色在企业中所分配的权限',
  `enterpriseAdd` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '企业增加',
  `enterpriseAlter` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业修改',
  `enterpriseQuery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '企业查询',
  `enterpriseDelete` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '企业删除',
  `basicPermission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NotSet' COMMENT '角色在网页中所分配的权限',
  `basicAdd` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '基本增加',
  `basicAlter` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '基本修改',
  `basicQuery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '基本查询',
  `basicDelete` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '基本删除',
  `personalPermission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NotSet' COMMENT '角色个人信息页权限',
  `personalAdd` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '个人增加',
  `personalAlter` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人修改',
  `personalQuery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '个人查询',
  `personalDelete` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人删除',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此账号目前状态',
  PRIMARY KEY (`id`, `role`) USING BTREE,
  INDEX `UserRole`(`role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ChairmanOwner', 'All', '1', '1', '1', '1', 'All', '1', '1', '1', '1', 'All', '1', '1', '1', '1', 'Permanent');
INSERT INTO `role` VALUES (2, 'Manager', 'Add', '1', '0', '0', '0', 'All', '1', '1', '1', '1', 'All', '1', '1', '1', '1', 'Changeable');
INSERT INTO `role` VALUES (3, 'Webmaster', 'All', '1', '1', '1', '1', 'All', '1', '1', '1', '1', 'All', '1', '1', '1', '1', 'Changeable');
INSERT INTO `role` VALUES (4, 'Director', 'Query', '0', '0', '1', '0', 'Add,Alter,Query', '1', '1', '1', '0', 'All', '1', '1', '1', '1', 'Changeable');
INSERT INTO `role` VALUES (5, 'Tester', 'NotSet', '0', '0', '0', '0', 'Alter,Query', '1', '0', '1', '0', 'All', '1', '1', '1', '1', 'Changeable');
INSERT INTO `role` VALUES (6, 'Employee', 'NotSet', '0', '0', '0', '0', 'Alter,Query', '1', '0', '1', '0', 'All', '1', '1', '1', '1', 'Changeable');
INSERT INTO `role` VALUES (7, 'Vistors', 'NotSet', '0', '0', '0', '0', 'NotSet', '0', '0', '0', '0', 'Query', '1', '1', '1', '1', 'Permanent');
INSERT INTO `role` VALUES (8, 'PleaseChangeInTableUser', 'NotSet', '0', '0', '0', '0', 'NotSet', '0', '0', '1', '0', 'All', '1', '1', '1', '1', 'Changeable');
INSERT INTO `role` VALUES (9, 'Placeholder', 'NotSet', '0', '0', '0', '0', 'NotSet', '0', '0', '0', '0', 'NotSet', '0', '0', '0', '0', 'Permanent');

-- ----------------------------
-- Table structure for setting
-- ----------------------------
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting`  (
  `id` int NOT NULL COMMENT '表内标识',
  `affairID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '事务ID',
  `createdTime` date NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`, `affairID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of setting
-- ----------------------------

-- ----------------------------
-- Table structure for basicUser
-- ----------------------------
DROP TABLE IF EXISTS `basicUser`;
CREATE TABLE `basicUser`  (
  `id` int NOT NULL COMMENT '账户唯一标识id',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账户名',
  `GID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获取GID GID将作为记录用户数据字典喜好应用',
  `enterpriseID` bigint NULL DEFAULT 0 COMMENT '企业标识符',
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位规则ID',
  `userRealName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户真实名',
  `userPassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码值',
  `avatarID` int NULL DEFAULT NULL COMMENT '关联头像',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'NotSet' COMMENT '用户角色值',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间，有修改自动更新',
  PRIMARY KEY (`id`, `userName`, `userRealName`, `role`) USING BTREE,
  INDEX `userName`(`userName`) USING BTREE,
  INDEX `userRealName`(`userRealName`) USING BTREE,
  INDEX `id`(`id`, `userRealName`) USING BTREE,
  INDEX `id_2`(`id`, `userRealName`, `role`) USING BTREE,
  INDEX `id_3`(`id`) USING BTREE,
  INDEX `GID`(`GID`) USING BTREE,
  INDEX `enterpriseUserID`(`enterpriseID`) USING BTREE,
  INDEX `userName_2`(`userName`, `id`) USING BTREE,
  INDEX `UP`(`position`) USING BTREE,
  INDEX `UR`(`role`) USING BTREE,
  INDEX `UA`(`avatarID`) USING BTREE,
  CONSTRAINT `enterpriseUserID` FOREIGN KEY (`enterpriseID`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UA` FOREIGN KEY (`avatarID`) REFERENCES `basicAvatar` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UP` FOREIGN KEY (`position`) REFERENCES `position` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UR` FOREIGN KEY (`role`) REFERENCES `role` (`role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of basicUser
-- ----------------------------
INSERT INTO `basicUser` VALUES (202200, 'admin', 'G10001', 202202192128, 'Chairman', 'BenjaminThomasShellwe', '123456', NULL, 'ChairmanOwner', '2022-02-01 20:32:56', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (202201, 'placeholdor', 'G10001', 0, 'Placeholder', 'Placeholdor', '123456', NULL, 'PleaseChangeInTableUser', '2022-03-09 22:00:22', '2022-03-09 22:04:40');
INSERT INTO `basicUser` VALUES (20220001, 'manager', 'G10001', 202202192132, 'Manager', 'Manager', '123456', NULL, 'ChairmanOwner', '2022-02-11 10:39:05', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220002, 'webmaster', 'G10001', 202202192135, 'Webmaster', 'Webmaster', '123456', NULL, 'ChairmanOwner', '2022-02-19 17:30:59', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220003, 'supervisor', 'G10001', 202202192136, 'Director', 'Director', '123456', NULL, 'ChairmanOwner', '2022-02-19 23:26:44', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220004, 'tester', 'G10001', 202202192137, 'Tester', 'Tester', '123456', NULL, 'ChairmanOwner', '2022-02-19 23:27:24', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220005, 'tutor', 'G10001', 202202192138, 'Tutor', 'Tutor', '123456', NULL, 'ChairmanOwner', '2022-02-19 23:28:28', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220006, 'employee', 'G10001', 202202192334, 'Employee', 'Employee', '123456', NULL, 'ChairmanOwner', '2022-02-19 23:28:55', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220007, 'PleaseChangeInTableUser', 'G10001', 202202192128, 'Tester', 'PleaseChangeInTableUser', '123456', NULL, 'ChairmanOwner', '2022-02-20 15:26:10', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220008, 'tester1', 'G10001', 202202192128, 'Tester', 'Manager1', '123456', NULL, 'ChairmanOwner', '2022-02-21 00:25:09', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220009, 'tester2', 'G10001', 202202192128, 'Webmaster', 'Webmaster1', '123456', NULL, 'ChairmanOwner', '2022-02-21 00:26:08', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220010, 'tester3', 'G10001', 202202192128, 'Director', 'Supervisor1', '123456', NULL, 'ChairmanOwner', '2022-02-21 00:26:38', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220011, 'employeeTPT', 'G10001', 202202192128, 'Employee', 'Employee1', '123456', NULL, 'ChairmanOwner', '2022-02-21 00:27:34', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220012, 'tester5', 'G10001', 0, 'No position', 'NoEnterprise1', '123456', NULL, 'ChairmanOwner', '2022-02-21 00:57:29', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220013, 'visitor', 'G10001', 0, 'No position', 'NoEnterprise2', '123456', NULL, 'ChairmanOwner', '2022-02-21 19:51:31', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220014, 'tutorTPT', 'G10001', 202202192128, 'Employee', 'TutorTPT', '123456', NULL, 'ChairmanOwner', '2022-03-01 13:50:06', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220015, 'webmasterTPT', 'G10001', 202202192128, 'Webmaster', 'WebmasterTPT', '123456', NULL, 'ChairmanOwner', '2022-03-01 13:52:22', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220016, 'managerTPT', 'G10001', 202202192128, 'Manager', 'ManagerTPT', '123456', NULL, 'ChairmanOwner', '2022-03-01 13:53:31', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220017, 'DirectorTPT', 'G10001', 202202192128, 'Director', 'DirectorTPT', '123456', NULL, 'ChairmanOwner', '2022-03-01 13:54:22', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220018, 'employeeTPT1', 'G10001', 202202192128, 'Employee', 'employeeTPT1', '123456', NULL, 'ChairmanOwner', '2022-03-07 12:45:58', '2022-03-07 13:25:28');
INSERT INTO `basicUser` VALUES (20220018, 'employeeTPT2', 'G10001', 202202192128, 'Employee', 'employeeTPT2', '123456', NULL, 'ChairmanOwner', '2022-03-07 12:47:05', '2022-03-07 13:25:28');

-- ----------------------------
-- Table structure for seniorVacancy
-- ----------------------------
DROP TABLE IF EXISTS `seniorVacancy`;
CREATE TABLE `seniorVacancy`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识',
  `affairID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '(now() + 0)' COMMENT '事务ID',
  `enterpriseID` bigint NULL DEFAULT NULL COMMENT '企业ID',
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未指定' COMMENT '空缺职位',
  `positionStatus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未设置' COMMENT '职位状态',
  `informationEnterpriseDepartment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未指定' COMMENT '归属部门',
  `departmentID` bigint NULL DEFAULT NULL COMMENT '部门标识',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无描述' COMMENT '基本描述',
  `createdTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `salary` decimal(9, 2) NULL DEFAULT NULL COMMENT '薪资',
  `requirement` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'No requirement' COMMENT '职位要求',
  `deadline` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后期限',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `affairID`) USING BTREE,
  INDEX `EnterpriseVacancy`(`enterpriseID`) USING BTREE,
  INDEX `VDID`(`departmentID`) USING BTREE,
  CONSTRAINT `EnterpriseVacancy` FOREIGN KEY (`enterpriseID`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VDID` FOREIGN KEY (`departmentID`) REFERENCES `informationEnterpriseDepartment` (`departmentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seniorVacancy
-- ----------------------------
INSERT INTO `seniorVacancy` VALUES (1, '20220222042000', 202202192128, '德语教师', '目前空缺', '教辅部门', 20220302, '慕尼黑', '2022-02-22', 8000.00, 'No requirement', '2022-03-22 00:00:00', '[线上招聘, 线下招聘]');
INSERT INTO `seniorVacancy` VALUES (2, '20220222042043', 202202192128, '法语教师', '目前空缺', '教辅部门', 20220302, '梅赛德斯', '2022-02-22', 8000.00, 'No requirement', '2022-03-22', '[线上招聘, 线下招聘, 内推招聘, 第三方商]');
INSERT INTO `seniorVacancy` VALUES (3, '20220222042138', 202202192128, '部门经理', '正在应聘', '软件部门', 20220303, '无描述', '2022-02-22', 12000.00, 'No requirement', '2022-03-22', '[线上招聘, 线下招聘, 内推招聘, 第三方商]');
INSERT INTO `seniorVacancy` VALUES (4, '20220222042218', 202202192128, '人事主管', '暂停招聘', '人事部门', 20220304, '柏林', '2022-02-22', 10000.00, 'No requirement', '2022-03-22', '[线上招聘, 线下招聘]');
INSERT INTO `seniorVacancy` VALUES (5, '20220222044049', 202202192128, '教辅员', '正在招聘', '教辅部门', 20220302, '柏林', '2022-02-22', 6000.00, 'No requirement', '2022-03-22', '[线上招聘, 线下招聘, 内推招聘, 第三方商]');
INSERT INTO `seniorVacancy` VALUES (6, '20220302010427', 202202192128, '测试用数据空缺职位名称', '空缺', '人事部门', 20220304, '123', '2022-03-30', 123.00, '123', '2022-03-23 00:28:47', '[线上招聘, 线下招聘, 内推招聘, 第三方商]');
INSERT INTO `seniorVacancy` VALUES (7, '20220302010713', 202202192128, '123456', '123342', '人事部门', 20220304, '123', '2022-03-02 00:00:00', 123.00, '123', '2022-03-23 00:28:47', '[线上招聘, 线下招聘]');
INSERT INTO `seniorVacancy` VALUES (13, '20220303133055', NULL, '123', '123', 'Personal', NULL, '123123', NULL, 123.00, '123', '2022-03-03 13:30:52', '[线上招聘]');
INSERT INTO `seniorVacancy` VALUES (14, '20220303135027', NULL, '123', '123', 'Personal', NULL, '123123', NULL, 123.00, '123', '2022-03-03 13:50:23', '[线上招聘]');
INSERT INTO `seniorVacancy` VALUES (15, '20220303140416', 202202192128, '不可见职位', NULL, '测试部门', 20220301, '000', '2022-03-03 00:00:00', NULL, NULL, '2022-04-03 00:00:00', NULL);
INSERT INTO `seniorVacancy` VALUES (16, '20220305110017', NULL, 'asdasd', 'asdasd', 'Personal', NULL, 'asdasd', NULL, 1000.00, 'asdasd', NULL, '[内推招聘]');
INSERT INTO `seniorVacancy` VALUES (17, '20220305110335', NULL, '123123', '1231', 'SeniorManagement', NULL, '123123', '2022-03-05 11:03:31', 123123.00, '123123', NULL, '[线上招聘]');

-- ----------------------------
-- Table structure for vacancycoming
-- ----------------------------
DROP TABLE IF EXISTS `vacancycoming`;
CREATE TABLE `vacancycoming`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表内标识符',
  `verify` int NULL DEFAULT 0 COMMENT '审核反馈 0未处理 1 为同意 2不同意',
  `result` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核结果内容',
  `affairID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '(now() + 0)' COMMENT '事务ID',
  `enterpriseID` bigint NULL DEFAULT NULL COMMENT '企业标识',
  `departmentID` bigint NULL DEFAULT NULL COMMENT '部门标识',
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '即将空缺职位',
  `informationEnterpriseDepartment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `estimatedTime` date NULL DEFAULT NULL COMMENT '到期时间',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `createdTime` date NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态描述',
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '性别',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`, `affairID`) USING BTREE,
  INDEX `EVC`(`enterpriseID`) USING BTREE,
  INDEX `DVC`(`departmentID`) USING BTREE,
  CONSTRAINT `DVC` FOREIGN KEY (`departmentID`) REFERENCES `informationEnterpriseDepartment` (`departmentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `EVC` FOREIGN KEY (`enterpriseID`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vacancycoming
-- ----------------------------
INSERT INTO `vacancycoming` VALUES (1, 0, '00000', '20220303222434', 202202192128, 20220303, '外语教师', '教辅部门', '2022-03-22', 'Sebastian', '2022-03-04', '赶紧离职不想干了', '男', '离开从化就行', '110');
INSERT INTO `vacancycoming` VALUES (2, 0, '00000', '20220303222436', 202202192128, 20220304, '软件工程师开发', '软件部门', '2022-03-22', 'Jack', '2022-02-22', '准备离职', '男', '法兰西普罗旺斯', '111');
INSERT INTO `vacancycoming` VALUES (3, 0, '00000', '20220303222437', 202202192128, 20220302, '软件工程师测试', '软件部门', '2022-03-22', 'Emma', '2022-02-22', '准备离职', '女', '法兰西普罗旺斯', '112');
INSERT INTO `vacancycoming` VALUES (4, 0, '00000', '20220303222439', 202202192128, 20220301, '主管', '软件部门', '2022-03-22', 'Dick', '2022-02-22', '准备离职', '男', '法兰西普罗旺斯', '113');
INSERT INTO `vacancycoming` VALUES (5, 0, '00000', '20220303222440', 202202192128, 20220303, '主管', '人事部门', '2022-03-22', 'Rose', '2022-02-22', '准备离职', '女', '法兰西普罗旺斯', '114');
INSERT INTO `vacancycoming` VALUES (6, 0, '00000', '20220303222441', 202202192128, 20220304, '主管', '教辅部门', '2022-03-22', 'Zack', '2022-02-22', '准备离职', '男', '法兰西普罗旺斯', '115');
INSERT INTO `vacancycoming` VALUES (7, 0, '00000', '20220303222808', 202202192128, 20220303, '测试职位', '测试部门', '2022-03-22', '测试人员', '2022-02-22', '准备离职', '0', '法兰西普罗旺斯', '116');
INSERT INTO `vacancycoming` VALUES (8, 0, '00000', '20220303222434', 202202192128, 20220303, '钢琴教师', '教辅部门', '2022-03-22', 'Sebastian', '2022-02-22', '准备离职', '男', '法兰西普罗旺斯', '110');

SET FOREIGN_KEY_CHECKS = 1;
