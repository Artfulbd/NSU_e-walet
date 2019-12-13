-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2019 at 05:52 PM
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
-- Database: `bank`
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
(16, '0f3dace2b940b39', 'Balance credited', 0, 500, 500, '2019-12-12 15:26:23'),
(16, '2849672a2e43aff', 'Balance credited', 0, 900, 1400, '2019-12-12 18:08:30'),
(16, '422920b4df62a00', 'initial', 0, 0, 0, '2019-12-12 13:33:19'),
(1, '732ae2efe32c3eb', 'initial', 0, 0, 0, '2019-12-01 06:53:35'),
(10, '7e9f8986c3793ca', 'NSU e-Wallet. Credit', 0, 110, 110, '2019-12-12 18:02:11'),
(1, '892a1276426c06d', 'Balance credited', 0, 1400, 1400, '2019-12-12 18:09:32'),
(10, '992eca86319e1a0', 'NSU e-Wallet. Credit', 0, 110, 220, '2019-12-12 18:10:13'),
(10, '99ffba325df79bc', 'NSU e-Wallet. Credit', 0, 195, 415, '2019-12-13 07:11:54'),
(16, '9a0ce027cc2df47', 'NSU e-Wallet. Debit', 195, 0, 1205, '2019-12-13 07:11:54'),
(10, 'b635bbe42634d77', 'initial', 0, 0, 0, '2019-12-11 06:55:30'),
(1, 'f030867c77e4051', 'Balance credited', 0, 200, 1490, '2019-12-12 18:19:36'),
(15, 'fba2a307f559e62', 'initial', 0, 0, 0, '2019-12-11 07:09:46'),
(1, 'ff237b4793b83b3', 'Balance credited', 0, 20, 1510, '2019-12-13 17:48:15');

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
