-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 22, 2019 at 04:05 PM
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
-- Database: `nfb_bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `tr_his`
--

CREATE TABLE `tr_his` (
  `uClId` int(11) NOT NULL,
  `trid` varchar(50) NOT NULL,
  `des` varchar(255) NOT NULL,
  `deb` float NOT NULL,
  `crd` float NOT NULL,
  `bal` float NOT NULL,
  `trDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tr_his`
--

INSERT INTO `tr_his` (`uClId`, `trid`, `des`, `deb`, `crd`, `bal`, `trDate`) VALUES
(1, '01694f17be3b621', 'NSU e-Wallet. Debit', 110, 0, 1290, '2019-12-12 18:10:13'),
(10, '044eea3d2bb7d86', 'NSU e-Wallet. Credit', 0, 230, 845, '2019-12-13 14:22:06'),
(16, '0f3dace2b940b39', 'Balance credited', 0, 500, 500, '2019-12-12 15:26:23'),
(10, '177b19ce74b699e', 'NSU e-Wallet. Credit', 0, 50, 615, '2019-12-13 13:34:31'),
(10, '18e6ba9aaec555b', 'NSU e-Wallet. Credit', 0, 980, 1825, '2019-12-16 12:17:36'),
(1, '1dfbce558240961', 'Balance credited', 0, 15, 1545, '2019-12-13 03:47:25'),
(16, '2849672a2e43aff', 'Balance credited', 0, 900, 1400, '2019-12-12 18:08:30'),
(16, '422920b4df62a00', 'initial', 0, 0, 0, '2019-12-12 13:33:19'),
(16, '4274bea9e6bc3eb', 'NSU e-Wallet. Debit', 980, 0, 100225, '2019-12-16 12:17:36'),
(1, '512eb0830c4e18c', 'NSU e-Wallet. Debit', 150, 0, 1250, '2019-12-13 12:06:33'),
(16, '6bdfc734ba092ce', 'Balance credited', 0, 100000, 101205, '2019-12-16 12:15:09'),
(1, '732ae2efe32c3eb', 'initial', 0, 0, 0, '2019-12-01 06:53:35'),
(16, '77117f643ba8658', 'Balance credited', 0, 100000, 200225, '2019-12-16 12:24:00'),
(10, '7e9f8986c3793ca', 'NSU e-Wallet. Credit', 0, 110, 110, '2019-12-12 18:02:11'),
(1, '892a1276426c06d', 'Balance credited', 0, 1400, 1400, '2019-12-12 18:09:32'),
(1, '8dd2eaa0681bdfc', 'NSU e-Wallet. Debit', 230, 0, 970, '2019-12-13 14:22:06'),
(10, '992eca86319e1a0', 'NSU e-Wallet. Credit', 0, 110, 220, '2019-12-12 18:10:13'),
(10, '99ffba325df79bc', 'NSU e-Wallet. Credit', 0, 195, 415, '2019-12-13 07:11:54'),
(16, '9a0ce027cc2df47', 'NSU e-Wallet. Debit', 195, 0, 1205, '2019-12-13 07:11:54'),
(10, '9aaa22f5a123ab9', 'NSU e-Wallet. Credit', 0, 145, 560, '2019-12-13 03:49:32'),
(10, 'b635bbe42634d77', 'initial', 0, 0, 0, '2019-12-11 06:55:30'),
(1, 'b9b9c8b9abbf350', 'Balance credited', 0, 20, 1530, '2019-12-13 03:40:08'),
(10, 'bb52978dd8dd359', 'NSU e-Wallet. Credit', 0, 150, 565, '2019-12-13 12:06:33'),
(1, 'bc0b3ed6e6f9fa9', 'NSU e-Wallet. Debit', 145, 0, 1400, '2019-12-13 03:49:32'),
(1, 'f030867c77e4051', 'Balance credited', 0, 200, 1490, '2019-12-12 18:19:36'),
(1, 'f2ce8e763202a57', 'NSU e-Wallet. Debit', 50, 0, 1200, '2019-12-13 13:34:31'),
(15, 'fba2a307f559e62', 'initial', 0, 0, 0, '2019-12-11 07:09:46');

-- --------------------------------------------------------

--
-- Table structure for table `user_map`
--

CREATE TABLE `user_map` (
  `clId` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_map`
--

INSERT INTO `user_map` (`clId`, `name`, `gId`) VALUES
(1, 'one', 1722231042),
(10, 'KAsundi', 123452),
(15, 'Stf 1', 12212777),
(16, 'Amik', 1721277042);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tr_his`
--
ALTER TABLE `tr_his`
  ADD PRIMARY KEY (`trid`),
  ADD KEY `tr_his_fk0` (`uClId`);

--
-- Indexes for table `user_map`
--
ALTER TABLE `user_map`
  ADD PRIMARY KEY (`clId`,`gId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_map`
--
ALTER TABLE `user_map`
  MODIFY `clId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tr_his`
--
ALTER TABLE `tr_his`
  ADD CONSTRAINT `tr_his_fk0` FOREIGN KEY (`uClId`) REFERENCES `user_map` (`clId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
