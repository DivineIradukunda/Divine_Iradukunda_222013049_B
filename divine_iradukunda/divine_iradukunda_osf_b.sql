-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:12 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `divine_iradukunda_osf_b`
--

-- --------------------------------------------------------

--
-- Table structure for table `command`
--

CREATE TABLE `command` (
  `Command_id` int(10) NOT NULL,
  `Command_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `Status` varchar(30) DEFAULT NULL,
  `Furniture_id` int(11) DEFAULT NULL,
  `Customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `command`
--

INSERT INTO `command` (`Command_id`, `Command_date`, `Status`, `Furniture_id`, `Customer_id`) VALUES
(22, '2023-03-22 22:00:00', 'pending', 1, 2),
(31, '2023-01-24 22:00:00', 'shipped', 1, 3),
(33, '2023-01-24 22:00:00', 'pending', 2, 4),
(34, '2023-08-11 22:00:00', 'pending', 3, 2),
(35, '2022-09-02 22:00:00', 'delivered', 5, 2),
(37, '2023-09-28 22:00:00', 'pending', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` int(10) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Email` varchar(35) DEFAULT NULL,
  `Phonenumber` varchar(15) DEFAULT NULL,
  `Address` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_id`, `Name`, `Email`, `Phonenumber`, `Address`) VALUES
(2, 'Akaliza Diane', 'dianeakaliza@gmail.com', '0786547021', 'Rusizi'),
(3, 'RWEMA Fiston', 'fiston2023@gmail.com', '0789467230', 'Kenya'),
(4, 'INEZA Liza', 'lizaineza@gmail.com', '0788650943', 'Karongi'),
(5, 'Rwibutso Emile', 'rwibutso123@gmail.com', '0788650236', 'Uganda'),
(8, 'Uwase Belyse', 'belyse@gmail,com', '0783670124', 'Kenya');

-- --------------------------------------------------------

--
-- Table structure for table `furniture`
--

CREATE TABLE `furniture` (
  `Furniture_id` int(10) NOT NULL,
  `Type` varchar(30) DEFAULT NULL,
  `Category` varchar(15) DEFAULT NULL,
  `Name` varchar(15) DEFAULT NULL,
  `Size` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `furniture`
--

INSERT INTO `furniture` (`Furniture_id`, `Type`, `Category`, `Name`, `Size`) VALUES
(1, 'timber', 'medium', 'chair', 'medium'),
(2, 'Office ', 'Seating', 'Sofa', 'Medium'),
(3, 'Wooden furniture', 'Diningroom', 'Table', 'Large'),
(4, 'sleeping furniture', 'beds', 'sofa', 'large'),
(5, 'cabinets', 'cupboards', 'stockcabinets', 'large'),
(6, 'home furniture', 'tables', 'work  table', 'medium'),
(7, 'office furniture', 'chairs', 'conferencechair', 'small'),
(9, 'officefurniture', 'chairs', 'conferenechair', 'large'),
(11, 'sleepingfurniture', 'beds', 'sofa', 'large'),
(12, '35467', 'dgfgj', 'ghfhgg', '4354'),
(15, 'woodenfurniture', 'kitchen', 'table', 'medium'),
(16, 'officefurniture', 'worktable', 'table', 'medium');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_id` int(10) NOT NULL,
  `Total_amount` varchar(35) DEFAULT NULL,
  `Payment_method` varchar(30) DEFAULT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Furniture_id` int(11) DEFAULT NULL,
  `Customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_id`, `Total_amount`, `Payment_method`, `Date`, `Furniture_id`, `Customer_id`) VALUES
(16, '500000', 'cheque', '2023-09-29 22:00:00', 3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stock_id` int(10) NOT NULL,
  `Address` varchar(15) DEFAULT NULL,
  `Furniture_id` int(11) DEFAULT NULL,
  `Quantity` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stock_id`, `Address`, `Furniture_id`, `Quantity`) VALUES
(1, 'Kigali', 1, 1000),
(2, 'Huye', 2, 60),
(3, 'Huye', 1, 700),
(4, 'Kigali', 2, 9000);

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

CREATE TABLE `user_account` (
  `User_id` int(10) NOT NULL,
  `User_name` varchar(30) DEFAULT NULL,
  `Password` varchar(15) DEFAULT NULL,
  `Email` varchar(35) DEFAULT NULL,
  `Phonenumber` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`User_id`, `User_name`, `Password`, `Email`, `Phonenumber`) VALUES
(3, 'Umuhoza aline', '', 'alineumuhoza@gmail.com', '0789678012'),
(4, 'Munyaneza leonce', '', 'leoncemu@gmail.com', '0782365701'),
(5, 'IRADUKUNDA Irene', '', 'ireneira12@gmail.com', '0785612078'),
(6, 'Gatesi Deborah', '', 'deborah@gmail.com', '0780965313'),
(7, 'IRADUKUNDA aline', '', 'alineiradukunda@gmail.com', '0781267064'),
(8, 'Hirwa mourice', '', 'mouricehirwa23@gmail.com', '0791440867');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `command`
--
ALTER TABLE `command`
  ADD PRIMARY KEY (`Command_id`),
  ADD KEY `Furniture_id` (`Furniture_id`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `furniture`
--
ALTER TABLE `furniture`
  ADD PRIMARY KEY (`Furniture_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_id`),
  ADD KEY `Furniture_id` (`Furniture_id`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stock_id`),
  ADD KEY `Furniture_id` (`Furniture_id`);

--
-- Indexes for table `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`User_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `command`
--
ALTER TABLE `command`
  MODIFY `Command_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `furniture`
--
ALTER TABLE `furniture`
  MODIFY `Furniture_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stock_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user_account`
--
ALTER TABLE `user_account`
  MODIFY `User_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `command`
--
ALTER TABLE `command`
  ADD CONSTRAINT `command_ibfk_1` FOREIGN KEY (`Furniture_id`) REFERENCES `furniture` (`Furniture_id`),
  ADD CONSTRAINT `command_ibfk_2` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Furniture_id`) REFERENCES `furniture` (`Furniture_id`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`Furniture_id`) REFERENCES `furniture` (`Furniture_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
