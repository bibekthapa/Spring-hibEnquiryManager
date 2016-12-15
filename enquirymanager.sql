-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2016 at 02:10 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enquirymanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(100) NOT NULL,
  `course_fee` varchar(100) NOT NULL,
  `course_description` varchar(100) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_id`, `course_name`, `course_fee`, `course_description`, `added_date`, `modified_date`) VALUES
(1, 'Core Java', '12000', 'Core java conecpts', '2016-12-21 08:00:00', NULL),
(2, 'Advanced Java', '20000', 'Advanced java concepts', '2016-12-20 08:00:00', NULL),
(3, 'Python', '12000', 'teaches about python', '2016-12-21 08:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `enquirystatus`
--

CREATE TABLE `enquirystatus` (
  `enquirystatus_id` int(11) NOT NULL,
  `enquirystatus_type` varchar(100) NOT NULL,
  `enquirystatus_color` enum('info','danger','warning','success') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enquirystatus`
--

INSERT INTO `enquirystatus` (`enquirystatus_id`, `enquirystatus_type`, `enquirystatus_color`) VALUES
(1, 'Interested', 'info'),
(2, 'Not Interested', 'danger'),
(3, 'Pending', 'warning'),
(4, 'Enrolled', 'success');

-- --------------------------------------------------------

--
-- Table structure for table `enquirytable`
--

CREATE TABLE `enquirytable` (
  `enquiry_id` int(11) NOT NULL,
  `enquiry_firstName` varchar(100) NOT NULL,
  `enquiry_lastName` varchar(100) NOT NULL,
  `enquiry_email` varchar(100) NOT NULL,
  `enquiry_contactNo` varchar(50) NOT NULL,
  `course_id` int(11) NOT NULL,
  `enquirystatus_id` int(11) NOT NULL,
  `enquiry_addedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enquiry_message` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enquirytable`
--

INSERT INTO `enquirytable` (`enquiry_id`, `enquiry_firstName`, `enquiry_lastName`, `enquiry_email`, `enquiry_contactNo`, `course_id`, `enquirystatus_id`, `enquiry_addedDate`, `enquiry_message`) VALUES
(3, 'dafsnkj', 'hafdkjh', 'bibek.thapahere@gmail.com', '979079-', 1, 1, '2016-12-13 03:52:17', 'nasdkjfnakj'),
(4, 'Bibek', 'Bagdash', 'bibek.thapahere1@gmail.com', '7897897', 2, 3, '2016-12-13 03:54:32', 'I like the advanced java course'),
(14, 'Sangarsha', 'Chaulagain', 'bibek.thapahere@gmail.com', '8788798797', 2, 4, '2016-12-14 03:01:52', 'I am very interested in advanced java'),
(19, 'Ruman', 'Dangol', 'bibek.thapahere@gmail.com', '8788798797', 2, 2, '2016-12-14 10:18:48', 'I am very interested in advanced java. class time are not good'),
(20, 'Ruman', 'Dangol', 'ruman@gmail.com', '8788798797', 2, 1, '2016-12-14 11:22:39', 'I am very interested in advanced java. class time are not good'),
(22, 'Kripesh', 'Lamichhane', 'krip@gmail.com', '8937854889', 2, 2, '2016-12-14 16:16:55', 'I am very interested in advanced java\r\n\r\ntelephone: said i will call later but not called again');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `name` varchar(100) NOT NULL,
  `value` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`name`, `value`) VALUES
('MSG_FROM', 'dixanta@gmail.com'),
('MSG_HOST', 'smtp.ntc.net.np');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `enquirystatus`
--
ALTER TABLE `enquirystatus`
  ADD PRIMARY KEY (`enquirystatus_id`);

--
-- Indexes for table `enquirytable`
--
ALTER TABLE `enquirytable`
  ADD PRIMARY KEY (`enquiry_id`),
  ADD KEY `course_id` (`course_id`),
  ADD KEY `enquirystatus_id` (`enquirystatus_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`),
  ADD KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `enquirystatus`
--
ALTER TABLE `enquirystatus`
  MODIFY `enquirystatus_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `enquirytable`
--
ALTER TABLE `enquirytable`
  MODIFY `enquiry_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `enquirytable`
--
ALTER TABLE `enquirytable`
  ADD CONSTRAINT `enquirytable_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  ADD CONSTRAINT `enquirytable_ibfk_2` FOREIGN KEY (`enquirystatus_id`) REFERENCES `enquirystatus` (`enquirystatus_id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
