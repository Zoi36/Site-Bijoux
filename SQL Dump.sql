-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  lun. 11 jan. 2021 à 17:30
-- Version du serveur :  5.7.28
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `biijoudb`
--

-- --------------------------------------------------------

--
-- Structure de la table `address_order`
--

DROP TABLE IF EXISTS `address_order`;
CREATE TABLE IF NOT EXISTS `address_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_city` varchar(255) DEFAULT NULL,
  `address_name` varchar(255) DEFAULT NULL,
  `address_street` varchar(255) DEFAULT NULL,
  `address_zipcode` varchar(255) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKao7i2gq4b5a3asten19n9a43j` (`order_product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=142 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `address_order`
--

INSERT INTO `address_order` (`id`, `address_city`, `address_name`, `address_street`, `address_zipcode`, `order_product_id`) VALUES
(141, 'Forest', 'Zoi Sotiriadou', 'Avenue maréchal joffre, 113', '1190', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `alliance`
--

DROP TABLE IF EXISTS `alliance`;
CREATE TABLE IF NOT EXISTS `alliance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `profil_alliance` varchar(255) DEFAULT NULL,
  `width_alliance` int(11) NOT NULL,
  `engraving_id` bigint(20) DEFAULT NULL,
  `finish_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpdacl6k42luhp6us4iykrsjwg` (`engraving_id`),
  KEY `FKqclb2sn9qyvff547j5jwxjnkd` (`finish_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `bijou`
--

DROP TABLE IF EXISTS `bijou`;
CREATE TABLE IF NOT EXISTS `bijou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gold_id` bigint(20) DEFAULT NULL,
  `dtype` varchar(31) NOT NULL,
  `type_ring` varchar(255) DEFAULT NULL,
  `profil_alliance` varchar(255) DEFAULT NULL,
  `width_alliance` int(11) DEFAULT NULL,
  `type_necklace` varchar(255) DEFAULT NULL,
  `type_earrings` varchar(255) DEFAULT NULL,
  `engraving_id` bigint(20) DEFAULT NULL,
  `finish_id` bigint(20) DEFAULT NULL,
  `chain_id` bigint(20) DEFAULT NULL,
  `stone_id` bigint(20) DEFAULT NULL,
  `ring_sertis_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5n50oixau37rllk6k33y7lgks` (`engraving_id`),
  KEY `FK3ejdnn7rtcc6xi3dirv38hk7` (`finish_id`),
  KEY `FKpmd7l5mpfldy19m1ikaigm6bu` (`chain_id`),
  KEY `FKbgls631vijb50ajpehrmhvrf6` (`stone_id`),
  KEY `FK710b505ex92fh8hwp1yfy59a` (`ring_sertis_id`),
  KEY `FKo6a8mn9cwh7ynrfo8nkmu28r2` (`gold_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grand_total` decimal(19,2) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=85 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cart`
--

INSERT INTO `cart` (`id`, `grand_total`, `user_id`) VALUES
(84, '0.00', 162);

-- --------------------------------------------------------

--
-- Structure de la table `chain`
--

DROP TABLE IF EXISTS `chain`;
CREATE TABLE IF NOT EXISTS `chain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_chain` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `diammand`
--

DROP TABLE IF EXISTS `diammand`;
CREATE TABLE IF NOT EXISTS `diammand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `form_diammand` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `diammand_alliance`
--

DROP TABLE IF EXISTS `diammand_alliance`;
CREATE TABLE IF NOT EXISTS `diammand_alliance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `disposition_diammand` varchar(255) DEFAULT NULL,
  `qty_diammand` int(11) NOT NULL,
  `diammand_alliance_id` bigint(20) DEFAULT NULL,
  `diammand_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt57l4xo5jvr3mj1w2acfdxc0g` (`diammand_alliance_id`),
  KEY `FKtckvl8lm42wgo22cxdfvm5h0i` (`diammand_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `earrings`
--

DROP TABLE IF EXISTS `earrings`;
CREATE TABLE IF NOT EXISTS `earrings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_earrings` varchar(255) DEFAULT NULL,
  `stone_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK82j5h88jvrodlg8w52j3rhm2k` (`stone_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `engraving`
--

DROP TABLE IF EXISTS `engraving`;
CREATE TABLE IF NOT EXISTS `engraving` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `font_engraving` varchar(255) DEFAULT NULL,
  `text_engraving` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `feed_back`
--

DROP TABLE IF EXISTS `feed_back`;
CREATE TABLE IF NOT EXISTS `feed_back` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `text_feed_back` text,
  `created_at` datetime DEFAULT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjig4jdi843wu303uvyeqt0ph` (`product_id`),
  KEY `FK6udpx3ddji8j31h2froqoay12` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `feed_back`
--

INSERT INTO `feed_back` (`id`, `product_id`, `user_id`, `text_feed_back`, `created_at`, `rating`) VALUES
(38, NULL, 162, '<p>magnifique</p>', '2021-01-08 13:05:38', 5);

-- --------------------------------------------------------

--
-- Structure de la table `finish`
--

DROP TABLE IF EXISTS `finish`;
CREATE TABLE IF NOT EXISTS `finish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_finish` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `gold`
--

DROP TABLE IF EXISTS `gold`;
CREATE TABLE IF NOT EXISTS `gold` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `color_gold` varchar(255) DEFAULT NULL,
  `quality_gold` int(11) NOT NULL,
  `price_per_gram` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `line_product`
--

DROP TABLE IF EXISTS `line_product`;
CREATE TABLE IF NOT EXISTS `line_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qty` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `subtotal` decimal(19,2) DEFAULT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3fqiesshym70xfidb799vous1` (`cart_id`),
  KEY `FKbre41bve0ip5pkjpnl00pc81` (`order_product_id`),
  KEY `FKa2gubvheqnn88cl8b2swvr8fy` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=182 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `line_product`
--

INSERT INTO `line_product` (`id`, `qty`, `size`, `subtotal`, `cart_id`, `order_product_id`, `product_id`) VALUES
(181, 1, 0, '500.00', NULL, 20, 1694);

-- --------------------------------------------------------

--
-- Structure de la table `necklace`
--

DROP TABLE IF EXISTS `necklace`;
CREATE TABLE IF NOT EXISTS `necklace` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_necklace` varchar(255) DEFAULT NULL,
  `chain_id` bigint(20) DEFAULT NULL,
  `stone_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8wnb4132l9bd5y9917vbii67o` (`chain_id`),
  KEY `FK67btohtlurfvh1hvfvt32lg4v` (`stone_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `option`
--

DROP TABLE IF EXISTS `option`;
CREATE TABLE IF NOT EXISTS `option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
CREATE TABLE IF NOT EXISTS `order_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_date` datetime DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `order_total` decimal(19,2) DEFAULT NULL,
  `shipping_method` varchar(255) DEFAULT NULL,
  `address_order_id` bigint(20) DEFAULT NULL,
  `payment_order_method_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK20jpqd04wtpfwlmw8wf7dneop` (`address_order_id`),
  KEY `FKo56tkta41kp52qbnv6nl50nqe` (`payment_order_method_id`),
  KEY `FKo9xn5tfed9g2dqctro3cg0h0` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `order_product`
--

INSERT INTO `order_product` (`id`, `order_date`, `order_status`, `order_total`, `shipping_method`, `address_order_id`, `payment_order_method_id`, `user_id`) VALUES
(20, '2021-01-08 13:05:13', 'en cours de traitement', '500.00', 'livraison rapide', 141, 143, 162);

-- --------------------------------------------------------

--
-- Structure de la table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
CREATE TABLE IF NOT EXISTS `password_reset_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lwtbncug84d4ero33v3cfxvl` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `payment_order_method`
--

DROP TABLE IF EXISTS `payment_order_method`;
CREATE TABLE IF NOT EXISTS `payment_order_method` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_number` varchar(255) DEFAULT NULL,
  `cvc` int(11) NOT NULL,
  `expiry_month` int(11) NOT NULL,
  `expiry_year` int(11) NOT NULL,
  `holder_name` varchar(255) DEFAULT NULL,
  `type_card` varchar(255) DEFAULT NULL,
  `order_product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9pbf3kpx2bl8vxw50ybt138y` (`order_product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=144 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `payment_order_method`
--

INSERT INTO `payment_order_method` (`id`, `card_number`, `cvc`, `expiry_month`, `expiry_year`, `holder_name`, `type_card`, `order_product_id`) VALUES
(143, '7666666666666666666', 877, 1, 2017, 'Sotiriadou Zoi', 'visa', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text,
  `price` double NOT NULL,
  `stock` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type_ring` varchar(255) DEFAULT NULL,
  `profil_alliance` varchar(255) DEFAULT NULL,
  `width_alliance` int(11) DEFAULT NULL,
  `color_gold` varchar(255) DEFAULT NULL,
  `quality_gold` int(11) DEFAULT NULL,
  `type_finish` varchar(255) DEFAULT NULL,
  `type_necklace` varchar(255) DEFAULT NULL,
  `form_stone` varchar(255) DEFAULT NULL,
  `halo_stone` varchar(255) DEFAULT NULL,
  `type_stone` varchar(255) DEFAULT NULL,
  `weight_stone` double DEFAULT NULL,
  `font_engraving` varchar(255) DEFAULT NULL,
  `text_engraving` text,
  `type_earrings` varchar(255) DEFAULT NULL,
  `gold_id` bigint(20) DEFAULT NULL,
  `engraving_id` bigint(20) DEFAULT NULL,
  `finish_id` bigint(20) DEFAULT NULL,
  `stone_id` bigint(20) DEFAULT NULL,
  `chain_id` bigint(20) DEFAULT NULL,
  `ring_sertis_id` bigint(20) DEFAULT NULL,
  `type_stones` varchar(255) DEFAULT NULL,
  `next_stones` varchar(255) DEFAULT NULL,
  `weight_metal` double DEFAULT NULL,
  `form_diammand` varchar(255) DEFAULT NULL,
  `disposition_diammand` varchar(255) DEFAULT NULL,
  `qty_diammand` int(11) DEFAULT NULL,
  `price_per_gram` double DEFAULT NULL,
  `type_chain` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmyb56ch1fboassj0yy04qrkeo` (`gold_id`),
  KEY `FKjk4ccil5t5budjwq9qqf8etsw` (`engraving_id`),
  KEY `FK57xibb4bsmtla4xuxlu1dboae` (`finish_id`),
  KEY `FKl6coevoowfgk1lhda23mv0p10` (`chain_id`),
  KEY `FKd7jxbsujy9x0fg5ux9kd5rby4` (`stone_id`),
  KEY `FKmm3x1sswcdwunno1fvnvplcpr` (`ring_sertis_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1997 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`dtype`, `id`, `description`, `price`, `stock`, `title`, `type_ring`, `profil_alliance`, `width_alliance`, `color_gold`, `quality_gold`, `type_finish`, `type_necklace`, `form_stone`, `halo_stone`, `type_stone`, `weight_stone`, `font_engraving`, `text_engraving`, `type_earrings`, `gold_id`, `engraving_id`, `finish_id`, `stone_id`, `chain_id`, `ring_sertis_id`, `type_stones`, `next_stones`, `weight_metal`, `form_diammand`, `disposition_diammand`, `qty_diammand`, `price_per_gram`, `type_chain`) VALUES
('RingSimple', 1691, '<p>ok</p>', 400, 38, 'BAGUE FLEUR DE SEL - CERCLE - OR JAUNE 18 CARATS', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1692, '<p>ok</p>', 300, 40, 'ALLIANCE OR BLANC 18 CARATS SEMI PAVÉE - SERTI BARRETTES - 1 CARATS - 6 DIAMANTS', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Gold', 1705, '<p><span style=\"color: #333333; font-family: Futurastdlight, \'Open Sans\', sans-serif, Tahoma; font-size: 12px; letter-spacing: 1px; background-color: #ffffff;\">L\'or 18 carats signifie que dans 24 g d\'alliage il y a 18g soit 75.01% d\' &laquo; or pur &raquo;. Il est &eacute;galement appel&eacute; or 750/1000&egrave;me.</span></p>', 0, 0, NULL, NULL, NULL, NULL, 'Jaune', 18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 38, NULL),
('Gold', 1704, '<p><span style=\"color: #333333; font-family: Futurastdlight, \'Open Sans\', sans-serif, Tahoma; font-size: 12px; letter-spacing: 1px; background-color: #ffffff;\">L\'or 9 carats signifie que dans 24 g d\'alliage il y a 9g soit 37.5% d\' &laquo; or pur &raquo;. Il est &eacute;galement appel&eacute; or 375/1000&egrave;me.</span></p>', 0, 0, NULL, NULL, NULL, NULL, 'Jaune', 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL),
('RingSertis', 1709, '', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1710, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>', 1050, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Sans', 'Diamant', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1727, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;&nbsp;</p>', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Sans', 'Rubis', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Chain', 1784, '<p><span style=\"color: rgba(17, 17, 17, 0.7); font-family: Lato, Arial, sans-serif; font-size: 15px; letter-spacing: 0.8px; text-align: justify; background-color: #fcfcfc;\">La&nbsp;</span><span style=\"box-sizing: border-box; margin: 0px; padding: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; line-height: inherit; font-family: Lato, Arial, sans-serif; font-size: 15px; vertical-align: baseline; color: rgba(17, 17, 17, 0.7); letter-spacing: 0.8px; text-align: justify; background-color: #fcfcfc;\">cha&icirc;ne for&ccedil;at</span><span style=\"color: rgba(17, 17, 17, 0.7); font-family: Lato, Arial, sans-serif; font-size: 15px; letter-spacing: 0.8px; text-align: justify; background-color: #fcfcfc;\">&nbsp;est un mod&egrave;le tr&egrave;s pris&eacute; et a l\'avantage de convenir &agrave; tous les styles.</span></p>', 100, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Forcat'),
('Chain', 1785, '<p><span style=\"color: #111111; font-family: Roboto, sans-serif; font-size: 18px; background-color: #ffffff;\">La cha&icirc;ne v&eacute;nitienne est un&nbsp;</span><span style=\"color: #111111; font-family: Roboto, sans-serif; font-size: 18px; background-color: #ffffff;\">enchev&ecirc;trement de petits maillons carr&eacute;s</span><span style=\"color: #111111; font-family: Roboto, sans-serif; font-size: 18px; background-color: #ffffff;\">. La maille v&eacute;nitienne est tr&egrave;s r&eacute;sistante. Ind&eacute;modable et unisexe, cette cha&icirc;ne s&rsquo;accordera avec tous les pendentifs et toutes les m&eacute;dailles.&nbsp;</span></p>', 150, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Venitienne'),
('RingSertis', 1798, '<p>16 pierres diamants ,poids 0.16 carat qualit&eacute; HSI</p>', 200, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('RingSertis', 1799, '<p>16 pierres rubis ,haute qualit&eacute; 0.16 carat</p>', 100, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('RingSertis', 1800, '<p>16 pierres saphir blue ,haute qualit&eacute; 0.16 carat</p>', 100, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1801, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;</p>', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1802, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>', 2150, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Sans', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1803, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;</p>', 350, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1804, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;</p>', 350, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1805, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute HSI</p>', 3350, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Sans', 'Diamant', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1806, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute quali&eacute;</p>', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1807, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;</p>', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1808, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>', 7850, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1809, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;</p>', 550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1810, '<p>Diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;</p>', 550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1811, '<p>Halo diamant 16 pierres 0.13 carat .Qualit&eacute; HSI</p>\r\n<p>Pierre centrale diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>', 2250, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Diamant', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1812, '<p>Halo rubis 16 pierres 0.13 carat.Haute qualit&eacute;</p>\r\n<p>Pierre centrale rubis naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.</p>', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1813, '<p>Pierre centrale saphir blue naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Haute qualit&eacute;</p>\r\n<p>Halo 16 pierres saphir 0.13 carat .Haute qualit&eacute;</p>', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', 'Saphir', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1814, '<p>Pierre centrale diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>\r\n<p>Pierres de cote diamant 0,12 carat.Qualit&eacute; HSI</p>', 1250, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Sans', 'Diamant', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1815, '<p>Pierre centrale diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>\r\n<p>Pierres de cote diamant 0,12 carat.Qualit&eacute; HSI</p>', 2350, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1816, '<p>Pierre centrale diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>\r\n<p>Pierres de cote diamant 0,12 carat.Qualit&eacute; HSI</p>', 3550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1817, '<p>Pierre centrale diamant naturel certifi&eacute; qui respest les meilleurs standards de qualit&eacute;.Qualit&eacute; HSI</p>\r\n<p>Pierres de cote diamant 0,12 carat.Qualit&eacute; HSI</p>', 8000, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1818, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1819, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1820, '', 500, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1821, '', 600, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1822, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1823, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1824, '', 500, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1825, '', 600, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1826, '', 2150, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1827, '', 2150, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Saphir', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1828, '', 550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1829, '', 550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', 'Saphir', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1830, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1831, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', 'Emeraude', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1832, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rond', 'Saphir', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1833, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', 'Saphir', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1834, '', 450, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1835, '', 550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1836, '', 650, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1837, '', 850, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1838, '', 450, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1839, '', 550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1840, '', 650, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1841, '', 850, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Saphir', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1842, '', 450, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1843, '', 550, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1844, '', 650, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1845, '', 850, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Diamant', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1846, '', 1150, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1847, '', 2250, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1848, '', 3450, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1849, '', 7850, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1850, '', 1150, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1851, '', 2250, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1852, '', 3450, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1853, '', 7850, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1854, '', 1150, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1855, '', 2250, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1856, '', 3450, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1857, '', 7850, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Diamant', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1858, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1859, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1860, '', 500, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1861, '', 600, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1862, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1863, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1864, '', 500, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1865, '', 600, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Rubis', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1866, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1867, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1868, '', 500, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1869, '', 600, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rubis', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1870, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1871, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1872, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1873, '', 500, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1874, '', 600, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Saphir', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1875, '', 300, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1876, '', 400, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1877, '', 500, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 0.7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Stone', 1878, '', 600, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sans', 'Emeraude', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Emeraude', NULL, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1894, '', 200, 0, NULL, NULL, 'Fin', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1895, '', 200, 0, NULL, NULL, 'Fin', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1896, '', 200, 0, NULL, NULL, 'Fin', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1897, '', 200, 0, NULL, NULL, 'Fin', 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1898, '', 300, 0, NULL, NULL, 'Standard', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1899, '', 300, 0, NULL, NULL, 'Standard', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1900, '', 300, 0, NULL, NULL, 'Standard', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1901, '', 300, 0, NULL, NULL, 'Standard', 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1902, '', 350, 0, NULL, NULL, 'Ruban', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1903, '', 350, 0, NULL, NULL, 'Ruban', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1904, '', 350, 0, NULL, NULL, 'Ruban', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1905, '', 350, 0, NULL, NULL, 'Ruban', 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1906, '', 400, 0, NULL, NULL, 'Bombee', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1907, '', 400, 0, NULL, NULL, 'Bombee', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1908, '', 400, 0, NULL, NULL, 'Bombee', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, NULL, NULL),
('Alliance', 1909, '', 400, 0, NULL, NULL, 'Bombee', 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `ring`
--

DROP TABLE IF EXISTS `ring`;
CREATE TABLE IF NOT EXISTS `ring` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_ring` varchar(255) DEFAULT NULL,
  `profil_alliance` varchar(255) DEFAULT NULL,
  `width_alliance` int(11) DEFAULT NULL,
  `engraving_id` bigint(20) DEFAULT NULL,
  `finish_id` bigint(20) DEFAULT NULL,
  `ring_sertis_id` bigint(20) DEFAULT NULL,
  `stone_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKostf0joq2vxnm3hoponib478` (`engraving_id`),
  KEY `FKnwmy7hjpctso3clt35qtp0aj6` (`finish_id`),
  KEY `FKfgm75brtth6asxlpqfnb0u5w0` (`ring_sertis_id`),
  KEY `FKe68iu2unkvvhuyvaf41qojp9l` (`stone_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ring_sertis`
--

DROP TABLE IF EXISTS `ring_sertis`;
CREATE TABLE IF NOT EXISTS `ring_sertis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_stones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ring_simple`
--

DROP TABLE IF EXISTS `ring_simple`;
CREATE TABLE IF NOT EXISTS `ring_simple` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ring_sertis_id` bigint(20) DEFAULT NULL,
  `stone_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5f0v20rr0bstw7l9gsjo49dyq` (`ring_sertis_id`),
  KEY `FKt6j4rblba19byt514a4v60p65` (`stone_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`role_id`, `name`) VALUES
(1, 'ROLE_USER'),
(0, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Structure de la table `stone`
--

DROP TABLE IF EXISTS `stone`;
CREATE TABLE IF NOT EXISTS `stone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `form_stone` varchar(255) DEFAULT NULL,
  `halo_stone` varchar(255) DEFAULT NULL,
  `type_stone` varchar(255) DEFAULT NULL,
  `weight_stone` double NOT NULL,
  `next_stones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=163 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
(162, 'ZSot@gmail.com', b'1', 'Zoi', 'Sot', '$2a$12$Hae/hpiWkInAILg0Nqxd2egQyc4KGszSKoGSQ2BXH7.VELr3xqcsy', 'z'),
(161, 'admin@gmail.com', b'1', NULL, NULL, '$2a$12$Hae/hpiWkInAILg0Nqxd2eRkW9SfPtyq2X/.HBpttfp9/1TzPMApW', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=140 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_role`
--

INSERT INTO `user_role` (`user_role_id`, `role_id`, `user_id`) VALUES
(138, 0, 161),
(139, 1, 162);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
