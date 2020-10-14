-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2020 at 03:05 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbregister`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblbooks`
--

CREATE TABLE `tblbooks` (
  `BID` int(100) NOT NULL,
  `BNAME` varchar(100) NOT NULL,
  `AUTHOR` varchar(100) NOT NULL,
  `GENRE` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblbooks`
--

INSERT INTO `tblbooks` (`BID`, `BNAME`, `AUTHOR`, `GENRE`) VALUES
(1001, 'Alchemist', 'Paulo', 'Drama'),
(1002, 'Rumi', 'Alex', 'Poetry'),
(1003, 'Solitude', 'Marquiz', 'Novel'),
(1004, 'Java', 'Max', 'Textbook'),
(1005, 'Networking', 'David', 'Textbook'),
(1006, 'Chemistry', 'Albert', 'Science'),
(1007, 'MathS', 'John', 'Textbook'),
(1008, 'CS50', 'Ali', 'Science'),
(1010, 'programming', 'Ali ', 'Textbook'),
(1011, 'java', 'ahmad', 'Textbook');

-- --------------------------------------------------------

--
-- Table structure for table `tblissued`
--

CREATE TABLE `tblissued` (
  `ISSUE_ID` int(100) NOT NULL,
  `USER_ID` int(100) DEFAULT NULL,
  `BOOK_ID` int(100) DEFAULT NULL,
  `ISSUE_DATE` date DEFAULT NULL,
  `RETURN_DATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblissued`
--

INSERT INTO `tblissued` (`ISSUE_ID`, `USER_ID`, `BOOK_ID`, `ISSUE_DATE`, `RETURN_DATE`) VALUES
(101, 2, 1003, '2020-06-10', '2020-06-30'),
(102, 1, 1001, '2020-06-09', '2020-06-29'),
(103, 4, 1004, '2020-06-10', '2020-07-02'),
(105, 5, 1005, '2020-06-01', NULL),
(106, 4, 1005, '2020-06-08', NULL),
(107, 5, 1006, '2020-05-31', NULL),
(108, 3, 1007, '2020-06-23', NULL),
(109, 4, 1007, '2020-06-02', NULL),
(110, 7, 1009, '2020-06-09', NULL),
(111, 5, 1010, '2020-06-16', '2020-07-09'),
(112, 8, 1011, '2020-06-17', '2020-07-10');

-- --------------------------------------------------------

--
-- Table structure for table `tblregister`
--

CREATE TABLE `tblregister` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PHONE` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblregister`
--

INSERT INTO `tblregister` (`ID`, `NAME`, `USERNAME`, `PASSWORD`, `EMAIL`, `PHONE`) VALUES
(1, 'Ali', 'aaa', '123', 'ali@gmail.com', '0742342342'),
(2, 'Ahmad', 'aab', '123', 'ahmad@gmail.com', '0743423453'),
(3, 'Ala', 'aac', '123', 'ala@gmail.com', '0743234323'),
(4, 'Zaki', 'aad', '123', 'zaki@gmail.com', '0742342333'),
(5, 'Mohd', 'aaf', '123', 'mohd@gmail.com', '0734234027'),
(6, 'Kumail', 'aah', '123', 'aah@gmail.com', '0794383259'),
(7, 'mahdi', 'aai', '123', 'aai@gmail.com', '0782432934'),
(8, 'mahdi', 'mah', '123', 'mah@gmail.com', '07838347'),
(9, 'mahdi', 'mahdi', '123', 'mahdi@auaf.edu', '0932472384'),
(10, 'ali', 'ali', '123', 'ali@gmail.com', '0957394593');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblbooks`
--
ALTER TABLE `tblbooks`
  ADD PRIMARY KEY (`BID`);

--
-- Indexes for table `tblissued`
--
ALTER TABLE `tblissued`
  ADD PRIMARY KEY (`ISSUE_ID`);

--
-- Indexes for table `tblregister`
--
ALTER TABLE `tblregister`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblregister`
--
ALTER TABLE `tblregister`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
