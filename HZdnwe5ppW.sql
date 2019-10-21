-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 14, 2019 at 04:03 PM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.19-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `HZdnwe5ppW`
--

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `sid` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Session ID',
  `status` varchar(1) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Session Status',
  `init_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Initial Session Date and Time',
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Session Update Date and Time',
  `token` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Session Unique ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT 'Owner ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Keeping User Session Details' ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `signin`
--

CREATE TABLE `signin` (
  `signin_id` int(11) NOT NULL COMMENT 'Unique Sign-in ID',
  `access_name` text COLLATE utf8_unicode_ci COMMENT 'Site Accessed Name/Keyword',
  `access_password` text COLLATE utf8_unicode_ci COMMENT 'Site Accessed Password',
  `site` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'Site Name',
  `description` text COLLATE utf8_unicode_ci COMMENT 'Sign-In/Credential Description',
  `user_id` int(11) NOT NULL COMMENT 'Owner ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL COMMENT 'User Unique ID',
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'User Unique Name',
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'User Unique Password'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Keeping User Detail';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `signin`
--
ALTER TABLE `signin`
  ADD PRIMARY KEY (`signin_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `signin`
--
ALTER TABLE `signin`
  MODIFY `signin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique Sign-in ID';

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'User Unique ID';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
