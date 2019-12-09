-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2019 at 07:16 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `change_e_wallet_pin`
--

CREATE TABLE `change_e_wallet_pin` (
  `rdsPass` varchar(20) NOT NULL,
  `oldWalletPin` int(5) NOT NULL,
  `newWalletPin` int(5) NOT NULL,
  `confirmWalletPin` int(5) NOT NULL,
  `securityQuestion` varchar(50) NOT NULL,
  `securityQuestionAnswer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `change_e_wallet_pin`
--

INSERT INTO `change_e_wallet_pin` (`rdsPass`, `oldWalletPin`, `newWalletPin`, `confirmWalletPin`, `securityQuestion`, `securityQuestionAnswer`) VALUES
('asdasd', 0, 0, 0, 'asdasdasdas', 'asdasdasdas'),
('111111111111111', 2147483647, 2147483647, 2147483647, 'wwwwwwwwwwww', 'qqqqqqqqqqq'),
('asdasdas', 1111111111, 1111111111, 1111111111, 'aaaaaaaaaaa', 'sssssssssssss');

-- --------------------------------------------------------

--
-- Table structure for table `create_e_wallet`
--

CREATE TABLE `create_e_wallet` (
  `rdsPass` varchar(50) NOT NULL,
  `newWalletPin` int(11) NOT NULL,
  `confirmWalletPin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `create_e_wallet`
--

INSERT INTO `create_e_wallet` (`rdsPass`, `newWalletPin`, `confirmWalletPin`) VALUES
('asdasdasd', 111111, 111111),
('sdasdas', 0, 0),
('abcde', 111111, 111111),
('yugfi68gfoyug', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `off_transaction`
--

CREATE TABLE `off_transaction` (
  `walletPin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `off_transaction`
--

INSERT INTO `off_transaction` (`walletPin`) VALUES
(11111111),
(0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
