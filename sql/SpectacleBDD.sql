-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 21 Mars 2018 à 08:22
-- Version du serveur :  5.7.21-0ubuntu0.16.04.1
-- Version de PHP :  7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `Spectacle`
--

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `adresse` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Client`
--

INSERT INTO `Client` (`idClient`, `nom`, `prenom`, `email`, `adresse`) VALUES
(1, 'Guyon', 'Wilfried', 'wilfried.guyon@reseau.eseo.fr', '116 Boulevard Jean Moulin'),
(3, 'Guillou', 'Charles-Alexandre', 'charlesalexandre.guillou@reseau.eseo.fr', '6 rue Louis Blériot'),
(4, 'Guibal', 'Xavier', 'xavier.guibal@reseau.eseo.fr', '20 allée des codeurs');

-- --------------------------------------------------------

--
-- Structure de la table `Reservation`
--

CREATE TABLE `Reservation` (
  `idReservation` int(11) NOT NULL,
  `idSpectacle` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  `nombresPlaces` int(11) DEFAULT NULL,
  `booleanPaiementEffectue` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Reservation`
--

INSERT INTO `Reservation` (`idReservation`, `idSpectacle`, `idClient`, `nombresPlaces`, `booleanPaiementEffectue`) VALUES
(1, 1, 1, 1, 0),
(2, 5, 1, 2, 0),
(3, 6, 1, 245, 0);

-- --------------------------------------------------------

--
-- Structure de la table `Spectacles`
--

CREATE TABLE `Spectacles` (
  `idSpectacle` int(11) NOT NULL,
  `typeSpectale` varchar(50) DEFAULT NULL,
  `titreSpectacle` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `dateSpectacle` date DEFAULT NULL,
  `prixSpectacle` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Spectacles`
--

INSERT INTO `Spectacles` (`idSpectacle`, `typeSpectale`, `titreSpectacle`, `ville`, `dateSpectacle`, `prixSpectacle`) VALUES
(1, 'Comique', 'L\'étrange histoire de WIlfried Guyon', 'Angers', '2018-03-14', 139.99),
(3, 'Médical', 'La cheville disparue de Wilfried Guyon', 'Angers', '2018-03-30', 3.99),
(4, 'SYFY', 'La machine à remonter le temps de Wilfried Guyon', 'Nantes', '2018-05-23', 8000),
(5, 'Histoire', 'Fujitsu mai 68 : Ou l\'histoire d\'un pavé', 'Bordeaux', '2019-02-15', 59.99),
(6, 'Documentaire', 'Xavier Guibal quand son front rencontre un clavier', 'Lyon', '2018-03-30', 39.99);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`idReservation`),
  ADD KEY `idSpectacle` (`idSpectacle`),
  ADD KEY `idClient` (`idClient`);

--
-- Index pour la table `Spectacles`
--
ALTER TABLE `Spectacles`
  ADD PRIMARY KEY (`idSpectacle`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Client`
--
ALTER TABLE `Client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `Reservation`
--
ALTER TABLE `Reservation`
  MODIFY `idReservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Spectacles`
--
ALTER TABLE `Spectacles`
  MODIFY `idSpectacle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `Reservation_ibfk_1` FOREIGN KEY (`idSpectacle`) REFERENCES `Spectacles` (`idSpectacle`),
  ADD CONSTRAINT `Reservation_ibfk_2` FOREIGN KEY (`idClient`) REFERENCES `Client` (`idClient`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
