-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 22, 2019 at 04:04 PM
-- Server version: 5.7.27
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nfb_ewallet`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `Bank_name` varchar(255) NOT NULL,
  `bankId` int(11) NOT NULL,
  `api_key` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`Bank_name`, `bankId`, `api_key`) VALUES
('SEBL', 1, '$2y$10$Vvfl956vRnFfFqYzTfnCCOFEXSQkw55Cl3Jhwmb1ck1I/KrVIQZwi'),
('IFIC Bank', 2, ''),
('DBBL Bank', 3, ''),
('UCB Bnak', 4, ''),
('Sonali Bank', 5, '');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `trid` varchar(18) NOT NULL,
  `list` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`trid`, `list`) VALUES
('01694f17be3b621', ' Time 23:10  Date:12.12.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Tea          2X10  =  20<br> Burger       1X90  =  90<br>------------------------------<br> Total payable amount:110 '),
('4274bea9e6bc3eb', ' Time 10:16  Date:17.12.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Tea          3X10  =  30<br> Coffee       3X25  =  75<br> Sandwich     3X50  =  150<br> Set Menu     3X145 =  435<br> Burger       2X90  =  180<br> Pizza        1X110 =  110<br>------------------------------<br> Total payable amount:980 '),
('512eb0830c4e18c', ' Time 10:06  Date:14.12.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Tea          1X10  =  10<br> Sandwich     1X50  =  50<br> Burger       1X90  =  90<br>------------------------------<br> Total payable amount:150 '),
('8dd2eaa0681bdfc', ' Time 12:21  Date:14.12.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Coffee       2X25  =  50<br> Burger       2X90  =  180<br>------------------------------<br> Total payable amount:230 '),
('9a0ce027cc2df47', ' Time 12:11  Date:13.12.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Coffee       2X25  =  50<br> Set Menu     1X145 =  145<br>------------------------------<br> Total payable amount:195 '),
('bc0b3ed6e6f9fa9', ' Time 01:49  Date:14.12.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Set Menu     1X145 =  145<br>------------------------------<br> Total payable amount:145 '),
('f2ce8e763202a57', ' Time 11:34  Date:14.12.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Coffee       2X25  =  50<br>------------------------------<br> Total payable amount:50 ');

-- --------------------------------------------------------

--
-- Table structure for table `manual_job`
--

CREATE TABLE `manual_job` (
  `qry` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `port`
--

CREATE TABLE `port` (
  `bankId` int(11) DEFAULT NULL,
  `serviceId` int(11) DEFAULT NULL,
  `acNo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `regusers`
--

CREATE TABLE `regusers` (
  `card_no` varchar(11) NOT NULL,
  `nsu_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regusers`
--

INSERT INTO `regusers` (`card_no`, `nsu_id`) VALUES
('1F5F7D4', 12212777),
('815BDD5', 17213142),
('36817DF7', 17222342),
('511ED5', 171234567),
('E6F8CF7', 1721277042),
('716C75D5', 1722231042);

-- --------------------------------------------------------

--
-- Table structure for table `req_data`
--

CREATE TABLE `req_data` (
  `hostName` varchar(25) NOT NULL,
  `appKey` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `req_data`
--

INSERT INTO `req_data` (`hostName`, `appKey`) VALUES
('android', '12222'),
('webapp', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `service_data`
--

CREATE TABLE `service_data` (
  `serviceId` int(11) NOT NULL,
  `name` varchar(35) DEFAULT NULL,
  `hasPass` varchar(200) DEFAULT NULL,
  `address` varchar(70) DEFAULT NULL,
  `secQues` varchar(50) DEFAULT NULL,
  `ans` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service_data`
--

INSERT INTO `service_data` (`serviceId`, `name`, `hasPass`, `address`, `secQues`, `ans`) VALUES
(123456786, 'Madchef', 'paglakukur!789', 'chirakhanar desh', 'how are you dude', 'i am fine'),
(123456787, 'cfc', 'cFC!789', 'vingroho desh', 'Amar tk poysa sob niya ja', 'amr tk dimuna '),
(123456788, 'bfc', 'bFC!789', 'chander desh', 'Areh rakh beta', 'ki rakhmu'),
(123456789, 'KFC', 'KFC!789', 'chander desh', 'Areh rakh beta', 'ki rakhmu'),
(172127765, 'Kashundi', 'kashundi1234', 'Bashundhara', 'how much money do you have?', 'koyeksho koti');

-- --------------------------------------------------------

--
-- Table structure for table `user_data`
--

CREATE TABLE `user_data` (
  `nsuId` int(11) NOT NULL,
  `name` varchar(35) DEFAULT NULL,
  `hasPass` varchar(200) DEFAULT NULL,
  `address` varchar(70) DEFAULT NULL,
  `secQues` varchar(50) DEFAULT NULL,
  `ans` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_data`
--

INSERT INTO `user_data` (`nsuId`, `name`, `hasPass`, `address`, `secQues`, `ans`) VALUES
(123452, 'KAsundi', '$2y$10$ZTcAaowJzlmDeAGTa/xGaueviTtwZ.ILFu86aKFs4vLzfOLXjEPkW', 'NSU campus', 'Qstn', '$2y$10$ZTcAaowJzlmDeAGTa/xGaueviTtwZ.ILFu86aKFs4vLzfOLXjEPkW'),
(12212777, 'Stf 1', '$2y$10$4XRzbRQS6biidlGUpjswV.jpj0XANdzMWsKu3N1izzK3D3Y4pX.kq', 'Mirpur 2', 'qn', '$2y$10$n2en5/UrMszwA1AwVHffVub39VDiJrmOuXdrne9bQEsfFJ3wNz4Hq'),
(17213142, 'Sir', '$2y$10$4XRzbRQS6biidlGUpjswV.jpj0XANdzMWsKu3N1izzK3D3Y4pX.kq', 'Mirpur10', '', ''),
(17222342, 'Sir Sir', '$2y$10$4XRzbRQS6biidlGUpjswV.jpj0XANdzMWsKu3N1izzK3D3Y4pX.kq', 'Mirpur100', '', ''),
(171234567, 'Someone', '$2y$10$4XRzbRQS6biidlGUpjswV.jpj0XANdzMWsKu3N1izzK3D3Y4pX.kq', 'Dhanmondi', NULL, NULL),
(1721277042, 'Amik', '$2y$10$4XRzbRQS6biidlGUpjswV.jpj0XANdzMWsKu3N1izzK3D3Y4pX.kq', 'Mirpur', 'asdf', '$2y$10$jX2aGaaap8TwJAVBeIxM/e2NHWn0wN4Uo3Vt/B2CdmKYLwuyWeqjq'),
(1722231042, 'Artful', '$2y$10$4XRzbRQS6biidlGUpjswV.jpj0XANdzMWsKu3N1izzK3D3Y4pX.kq', 'chander desh', 'Name', '$2y$10$ZTcAaowJzlmDeAGTa/xGaueviTtwZ.ILFu86aKFs4vLzfOLXjEPkW');

-- --------------------------------------------------------

--
-- Table structure for table `wallet`
--

CREATE TABLE `wallet` (
  `nsuId` int(11) NOT NULL,
  `hashPin` varchar(255) DEFAULT NULL,
  `onOrOf` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wallet`
--

INSERT INTO `wallet` (`nsuId`, `hashPin`, `onOrOf`) VALUES
(123452, '$2y$10$ZTcAaowJzlmDeAGTa/xGaueviTtwZ.ILFu86aKFs4vLzfOLXjEPkW', 1),
(12212777, '$2y$10$LsfO4SvWgj/bzL/gkiiWVOPIzgpZf2eHIoNQ4NavfTC9M9xElI9au', 1),
(1721277042, '$2y$10$pB3PlZ7pxT43XHqR5s7DXOPH6xYGxqktW2Qnk3zHchyA11gN.VXZK', 1),
(1722231042, '$2y$10$IMHEpQ7UsNClyD9tvhwjVe8dtxEManP4n2sW5fUKch9//drY0wRbm', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`bankId`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`trid`);

--
-- Indexes for table `port`
--
ALTER TABLE `port`
  ADD KEY `bankId` (`bankId`),
  ADD KEY `serviceId` (`serviceId`);

--
-- Indexes for table `regusers`
--
ALTER TABLE `regusers`
  ADD PRIMARY KEY (`card_no`),
  ADD KEY `nsu_id` (`nsu_id`);

--
-- Indexes for table `req_data`
--
ALTER TABLE `req_data`
  ADD PRIMARY KEY (`hostName`);

--
-- Indexes for table `service_data`
--
ALTER TABLE `service_data`
  ADD UNIQUE KEY `id` (`serviceId`);

--
-- Indexes for table `user_data`
--
ALTER TABLE `user_data`
  ADD PRIMARY KEY (`nsuId`);

--
-- Indexes for table `wallet`
--
ALTER TABLE `wallet`
  ADD PRIMARY KEY (`nsuId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `port`
--
ALTER TABLE `port`
  ADD CONSTRAINT `port_ibfk_1` FOREIGN KEY (`bankId`) REFERENCES `bank` (`bankId`),
  ADD CONSTRAINT `port_ibfk_2` FOREIGN KEY (`serviceId`) REFERENCES `service_data` (`serviceId`);

--
-- Constraints for table `regusers`
--
ALTER TABLE `regusers`
  ADD CONSTRAINT `regusers_ibfk_1` FOREIGN KEY (`nsu_id`) REFERENCES `user_data` (`nsuId`);

--
-- Constraints for table `wallet`
--
ALTER TABLE `wallet`
  ADD CONSTRAINT `wallet_ibfk_1` FOREIGN KEY (`nsuId`) REFERENCES `user_data` (`nsuId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
