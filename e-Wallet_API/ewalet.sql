-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2019 at 02:08 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ewalet`
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
('33a568c790a4a98', ' Time 13:41  Date:21.11.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Tea          1X10  =  10<br> Burger       1X90  =  90<br> Pizza        1X110 =  110<br>------------------------------<br> Total payable amount:210 '),
('61b917ebfc142b6', ' Time 13:13  Date:21.11.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Tea          2X10  =  20<br> Coffee       2X25  =  50<br> Sandwich     1X50  =  50<br>------------------------------<br> Total payable amount:120 '),
('67d28e0843544bd', ' Time 01:51  Date:21.11.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Pizza        1X110 =  110<br>------------------------------<br> Total payable amount:110 '),
('b1b0c14cd25354b', ' Time 13:55  Date:21.11.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Tea          1X10  =  10<br> Set Menu     1X145 =  145<br>------------------------------<br> Total payable amount:155 '),
('ce1298f2fdc6e42', ' Time 01:49  Date:21.11.19<br> Item  (qty X rate) = price<br>-----------------------------<br> Tea          1X10  =  10<br> Sandwich     1X50  =  50<br>------------------------------<br> Total payable amount:60 ');

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
('E6F8CF7', 1721277042),
('716C75D5', 1722231042);

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
  `ans` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_data`
--

INSERT INTO `user_data` (`nsuId`, `name`, `hasPass`, `address`, `secQues`, `ans`) VALUES
(12212777, 'Stf 1', 'JadduMiya1234', 'Mirpur 2', 'Areh rakh beta', 'ki rakhmu'),
(17213142, 'Sir', 'anik1234', 'Mirpur10', 'Eto qstn kn!!!!!!!', 'Thabor !!!!!!!!khabi'),
(17222342, 'Sir Sir', 'LadduMiya1234', 'Mirpur100', 'Eto qstn kn', 'Thabor khabi'),
(1221277042, 'Laddu', 'Laddu1234', 'Mirpur', 'Eto qstn kn', 'Thabor khabi'),
(1521277032, 'Nut boltu', 'nutboltu!789', 'chander desh', 'Areh rakh beta', 'ki rakhmu'),
(1721277042, 'Amik', 'amik1234', 'Mirpur', 'Eto qstn kn', 'Thabor khabi'),
(1722231042, 'Artful', '$2y$10$kNL5vtlsNzs/en/yGRzA0uTf5ygSbGFvB3I.jR5tbnDhM1LkDsRf6', 'chander desh', 'Areh rakh beta', 'ki rakhmu');

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
(1722231042, '$2y$10$Qc.i0/BcUQT/CYjwThl7/uagvSVqH2q8V/iGT.lwSRFmIDhPXqqiC', 1);

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
