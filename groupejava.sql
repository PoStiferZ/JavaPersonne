-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 24, 2023 at 07:46 PM
-- Server version: 5.7.24
-- PHP Version: 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `groupejava`
--

-- --------------------------------------------------------

--
-- Table structure for table `avocat`
--

CREATE TABLE `avocat` (
  `ID_Avocat` int(11) NOT NULL,
  `nombreAffaires` int(11) NOT NULL,
  `adresseCabinet` varchar(255) NOT NULL,
  `ID_Personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `avocat`
--

INSERT INTO `avocat` (`ID_Avocat`, `nombreAffaires`, `adresseCabinet`, `ID_Personne`) VALUES
(6, 6, '1 rue des potiers, 94033', 8),
(7, 2, 'DEED', 16);

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

CREATE TABLE `enseignant` (
  `ID_Enseignant` int(11) NOT NULL,
  `nombreCours` int(11) NOT NULL,
  `specialite` varchar(255) NOT NULL,
  `ID_Personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`ID_Enseignant`, `nombreCours`, `specialite`, `ID_Personne`) VALUES
(1, 9, 'Sport', 14),
(2, 3, 'Yoga', 15);

-- --------------------------------------------------------

--
-- Table structure for table `permanent`
--

CREATE TABLE `permanent` (
  `ID_Permanent` int(11) NOT NULL,
  `numeroBureau` int(11) NOT NULL,
  `ID_Enseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `permanent`
--

INSERT INTO `permanent` (`ID_Permanent`, `numeroBureau`, `ID_Enseignant`) VALUES
(1, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

CREATE TABLE `personne` (
  `ID_Personne` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `numeroSecu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`ID_Personne`, `nom`, `numeroSecu`) VALUES
(8, 'Samy', '039ID3E4D'),
(9, 'Olivier', '8HF393XE'),
(10, 'Patoche', '3E32'),
(11, 'Eren', '12'),
(12, 'LePerma', '73F83D9H'),
(13, 'LePerma', '73F83D9H'),
(14, 'unEnseignant', '3FH0J93KXE'),
(15, 'Sophie', 'EC3432SZ'),
(16, 'RFR', 'FRF');

-- --------------------------------------------------------

--
-- Table structure for table `vacataire`
--

CREATE TABLE `vacataire` (
  `ID_Vacataire` int(11) NOT NULL,
  `nombreVacations` int(11) NOT NULL,
  `ID_Enseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vacataire`
--

INSERT INTO `vacataire` (`ID_Vacataire`, `nombreVacations`, `ID_Enseignant`) VALUES
(1, 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `vendeur`
--

CREATE TABLE `vendeur` (
  `ID_Vendeur` int(11) NOT NULL,
  `anciennete` date NOT NULL,
  `nomDuStand` varchar(255) NOT NULL,
  `ID_Personne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vendeur`
--

INSERT INTO `vendeur` (`ID_Vendeur`, `anciennete`, `nomDuStand`, `ID_Personne`) VALUES
(1, '2023-10-20', 'Polsa', 11);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avocat`
--
ALTER TABLE `avocat`
  ADD PRIMARY KEY (`ID_Avocat`),
  ADD KEY `ID_Personne` (`ID_Personne`);

--
-- Indexes for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`ID_Enseignant`),
  ADD KEY `ID_Personne` (`ID_Personne`);

--
-- Indexes for table `permanent`
--
ALTER TABLE `permanent`
  ADD PRIMARY KEY (`ID_Permanent`),
  ADD KEY `permanent_ibfk_1` (`ID_Enseignant`);

--
-- Indexes for table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`ID_Personne`);

--
-- Indexes for table `vacataire`
--
ALTER TABLE `vacataire`
  ADD PRIMARY KEY (`ID_Vacataire`),
  ADD KEY `ID_Enseignant` (`ID_Enseignant`);

--
-- Indexes for table `vendeur`
--
ALTER TABLE `vendeur`
  ADD PRIMARY KEY (`ID_Vendeur`),
  ADD KEY `ID_Personne` (`ID_Personne`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avocat`
--
ALTER TABLE `avocat`
  MODIFY `ID_Avocat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `ID_Enseignant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `permanent`
--
ALTER TABLE `permanent`
  MODIFY `ID_Permanent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `personne`
--
ALTER TABLE `personne`
  MODIFY `ID_Personne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `vacataire`
--
ALTER TABLE `vacataire`
  MODIFY `ID_Vacataire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `vendeur`
--
ALTER TABLE `vendeur`
  MODIFY `ID_Vendeur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `avocat`
--
ALTER TABLE `avocat`
  ADD CONSTRAINT `avocat_ibfk_1` FOREIGN KEY (`ID_Personne`) REFERENCES `personne` (`ID_Personne`);

--
-- Constraints for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`ID_Personne`) REFERENCES `personne` (`ID_Personne`);

--
-- Constraints for table `permanent`
--
ALTER TABLE `permanent`
  ADD CONSTRAINT `permanent_ibfk_1` FOREIGN KEY (`ID_Enseignant`) REFERENCES `enseignant` (`ID_Enseignant`);

--
-- Constraints for table `vacataire`
--
ALTER TABLE `vacataire`
  ADD CONSTRAINT `vacataire_ibfk_1` FOREIGN KEY (`ID_Enseignant`) REFERENCES `enseignant` (`ID_Enseignant`);

--
-- Constraints for table `vendeur`
--
ALTER TABLE `vendeur`
  ADD CONSTRAINT `vendeur_ibfk_1` FOREIGN KEY (`ID_Personne`) REFERENCES `personne` (`ID_Personne`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
