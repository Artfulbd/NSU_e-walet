-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2019 at 12:42 PM
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
(1, '732ae2efe32c3eb', 'initial', 0, 0, 0, '2019-12-01 06:53:35'),
(1, 'a1d1861a37d8582', 'e-Wallet', 110, 0, 390, '2019-12-09 11:46:00'),
(10, 'b635bbe42634d77', 'initial', 0, 0, 0, '2019-12-11 06:55:30'),
(1, 'f77733b766711d3', 'e-Wallet', 110, 0, 500, '2019-12-09 11:42:08'),
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
(15, 'Stf 1', 12212777);

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
  MODIFY `clId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

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
