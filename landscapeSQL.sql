-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2020 at 06:15 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `landscape`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `customer_ID` int(11) NOT NULL,
  `service` varchar(500) NOT NULL,
  `customer_bill` int(11) NOT NULL,
  `amt_paid` int(11) NOT NULL,
  `bill_date` datetime NOT NULL,
  `date_paid` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`customer_ID`, `service`, `customer_bill`, `amt_paid`, `bill_date`, `date_paid`) VALUES
(20311, 'Lawn mowing', 100, 50, '2020-12-01 11:50:43', '2020-12-04 11:50:43'),
(20312, 'Plant trees', 200, 300, '2020-12-02 11:51:24', '2020-12-05 11:51:24'),
(20310, 'Landscape', 1000, 1000, '2020-12-09 11:52:16', '2020-12-18 11:52:16');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_ID` int(11) NOT NULL,
  `customer_L_Name` varchar(100) NOT NULL,
  `customer_F_Name` varchar(100) NOT NULL,
  `customer_Title` varchar(3) NOT NULL,
  `street_Address` varchar(500) NOT NULL,
  `city_State_Zip` int(11) NOT NULL,
  `customer_Phone` bigint(20) NOT NULL,
  `customer_Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_ID`, `customer_L_Name`, `customer_F_Name`, `customer_Title`, `street_Address`, `city_State_Zip`, `customer_Phone`, `customer_Email`) VALUES
(20310, 'John', 'Billy', 'Mr', 'streat address sample', 893787, 847873873, 'some mail'),
(20311, 'Billy', 'Joe', 'Mr', 'some address', 893787, 343454, 'billyjoebob@gmail.com'),
(20312, 'Miller', 'Sherry', '', 'Yellow Brick Rd', 17366, 1111111111, 'sherry@email.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD KEY `customer_ID` (`customer_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20313;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billing`
--
ALTER TABLE `billing`
  ADD CONSTRAINT `billing_ibfk_1` FOREIGN KEY (`customer_ID`) REFERENCES `customer` (`customer_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
