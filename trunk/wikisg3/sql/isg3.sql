-- phpMyAdmin SQL Dump
-- version 2.11.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 26-05-2008 a las 19:48:14
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de datos: `isg3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `article`
--
DROP DATABASE IF EXISTS isg3;
CREATE DATABASE isg3;

CREATE TABLE IF NOT EXISTS isg3.`article` (
  `oid` varchar(30) NOT NULL,
  `title` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `lastRevision` date NOT NULL,
  `visits` int(11) default NULL,
  `underDiscussion` tinyint(1) default NULL,
  `categoryOID` varchar(30) default NULL,
  PRIMARY KEY  (`oid`),
  UNIQUE KEY `title` (`title`),
  KEY `categoryOID` (`categoryOID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `article`
--

INSERT INTO isg3.`article` (`oid`, `title`, `content`, `lastRevision`, `visits`, `underDiscussion`, `categoryOID`) VALUES
('8A', 'Sevilla F. C.', '<p>El Sevilla Fútbol Club es un club de fútbol profesional español que juega en la Primera División de España. El club fue fundado oficialmente el 14 de octubre de 1905, convirtiéndose en el club más antiguo de la ciudad de Sevilla y el segundo más antiguo de la Comunidad Autónoma de Andalucía.</p>\r\n\r\n<p>El Sevilla FC es el vigente campeón de la Supercopa de España. En Octubre de 2007, pasa a formar parte del G-14. Ha sido ratificado por la IFFHS, como mejor club del mundo ha sido el unico equipo de conseguir dicha distincion dos años. Siendo líder del Top25 de la IFFHS.</p>\r\n\r\n<p>Es el equipo andaluz con más títulos regionales, nacionales, y el único que consiguió títulos internacionales oficiales, además de ser el de dicha región que más veces ha militado en Primera División y el único que ha llegado a ser considerado el mejor club del mundo por la IFFHS por un año completo, liderando de esta manera el Top 25 de la IFFHS del 2006, y también es el mejor club del mundo en su clasificación mensual, que lidera desde septiembre de 2006. Además tiene tres títulos europeos, siendo el único club de Andalucía que posee algún título internacional.</p>\r\n\r\n<p>El Sevilla FC está ubicado en la séptima posición de la clasificación histórica de la Liga Española de Fútbol.</p>\r\n\r\n<p>El club es uno de los protagonistas del conocido derbi sevillano, que lo enfrenta al otro equipo de la ciudad de Sevilla, el Real Betis Balompié. </p>		', '2008-05-26', 0, 0, '1C'),
('9A', 'El padrino', 'Gran película sobre la cosa nostra .Gran papel de Marlon Brando', '2008-05-24', 0, 0, '3C'),
('10A', 'Tabla periodica', 'El conjunto de elementos', '2008-05-23', 0, 0, '2C'),
('11A', 'F. C. Barcelona', 'Tot el camp es un clam', '2008-05-23', 0, 0, '1C'),
('121157192920361dd391c', 'Betis', '<p>Real Betis Balompié, equipo de fútbol profesional de la ciudad de Sevilla. Actualmente el Real Betis Balompié juega en la Primera División de España. Está clasificado en la 10ª posición en el ranking histórico de la liga,[3] con 45 temporadas en la máxima categoría, 3 títulos oficiales, 1 Campeonato de Liga, 2 Copas del Rey y 4 finales de Copa del Rey hasta 2007.</p>\r\n\r\n<p>De los equipos andaluces, fue el primero que jugó en Primera División, que ganó la Final de la Copa del Rey, que ganó el Campeonato Nacional de Liga y el que jugó en Liga de Campeones, en el formato moderno. Desde 1970 es el equipo andaluz que se ha clasificado entre los cuatro primeros puestos de Primera División en más ocasiones (3 veces) en 1995, 1997 y 2005.</p>\r\n\r\n<p>Posee en sus vitrinas 6 Campeonatos de Sevilla, 1 Campeonato de Andalucía, 9 Subcampeonatos de Andalucía, 1 Campeonato Nacional de Liga, 2 Campeonatos de la Copa del Rey, 2 Subcampeonatos de la Copa del Rey, 1 Subcampeonato de la Supercopa de España y 1 Subcampeonato de la Copa de la Liga.</p>\r\n\r\n<p>Fue el 4º equipo en conseguir la Liga Española (1934/35).</p>\r\n\r\n<p>El Real Betis Balompié fue el 7º equipo en conseguir los 2 títulos más importantes del país, la Liga y la Copa del Rey, 1935 y 1977 respectivamente.</p>\r\n\r\n<p>Logró el vigésimo puesto en el TOP 25 de la clasificación de clubes del mundo de la IFFHS en 1995,[4] 1997,[5] y 2005,[6] siendo el segundo club andaluz que más veces ha figurado en ella.</p>\r\n\r\n<p>Es el 6º equipo en número de aficionados en España (3,3%), según encuesta del CIS de mayo de 2007, por detrás de Real Madrid (32,8%), Barcelona (25,7%), Valencia (5,3%), Athletic (5,1%) y Atlético de Madrid (4,3%).[7]</p>\r\n\r\n<p>Es el equipo andaluz con mayor número de peñas(362 peñas).</p>\r\n\r\n<p>Disputa el Derbi sevillano contra el Sevilla FC, club con el cual mantiene una gran rivalidad histórica.</p>\r\n\r\n<p>Tanto el Rey Don Juan Carlos de Borbón como su difunta madre y su hijo el Príncipe Don Felipe de Borbón son socios honoríficos del Real Betis Balompié.</p>				', '2008-05-26', 0, 1, '1C'),
('1211657286890fffffffff266e7b2', 'null', 'hola', '2008-05-26', 0, 1, '2C'),
('1211657416968ffffffffe7f3f80e', 'malaga', 'mierda malaga					', '2008-05-26', 0, 1, '4C'),
('12116574666873ff8de3e', 'probando', '								\r\n		probando					', '2008-05-25', 0, 1, '6C'),
('1211744653968ffffffffde5d51ea', 'jola', '								\r\n		fdgh					', '2008-05-25', 0, 1, '6C'),
('1211751234562ffffffffeb8733b6', 'pandilla', 'pandilleros					', '2008-05-25', 0, 0, '6C'),
('121175303414071749389', 'isg3', 'Bonita asignatura impartida por David Benavides			', '2008-05-26', 0, 0, '2C'),
('1211755348125ffffffffdc9f7a36', 'javascript', 'illa illa illa, javascript maravilla!			', '2008-05-26', 0, 0, '5C'),
('1211803723687ffffffffa258c3ef', 'nba', '<p>La NBA o National Basketball Association es la liga de baloncesto profesional de Estados Unidos de América. Los mejores jugadores del mundo juegan en la NBA y, gracias a ello, se la considera, con gran diferencia, la mejor liga de baloncesto del mundo.</p>\r\n\r\n<p>La NBA se fundó en Nueva York el 6 de junio de 1946 como la Basketball Association of America. Adoptó el nombre actual en 1949, tras la unión de varios clubes de la desaparecida National Basketball League. El partido inaugural fue un New York Knicks - Toronto Huskies, el 1 de noviembre de 1946 con el Maple Leaf Gardens de Toronto como escenario. El partido fue visto por 7.090 espectadores. La liga tiene sus oficinas oficiales situadas en la Olympic Tower en la Quinta Avenida 645 de New York. Los estudios de la NBA Entertainment y NBA TV están localizados en Secaucus, Nueva Jersey.</p>', '2008-05-26', 0, 0, '1C'),
('1211823471859ffffffffb10299d4', 'España', '<p>España,[9] oficialmente Reino de España, es un país soberano miembro de la Unión Europea, constituido en Estado social y democrático de Derecho, y cuya forma de gobierno es la monarquía parlamentaria. Su territorio, con capital en Madrid, ocupa la mayor parte de la península Ibérica, al que se añaden los archipiélagos de las Islas Baleares, en el mar Mediterráneo occidental, y el de las Islas Canarias, en el océano Atlántico nororiental, así como en el norte del continente africano, las plazas de soberanía de las ciudades autónomas de Ceuta y Melilla, además de los distritos y posesiones menores de las islas Chafarinas, el peñón de Vélez de la Gomera y el peñón de Alhucemas. El enclave de Llivia, en los Pirineos, completa el conjunto de territorios junto con la isla de Alborán, las islas Columbretes y una serie de islas e islotes frente a sus propias costas.</p>\r\n\r\n<p>Tiene una extensión de 504.645 km², siendo el cuarto país más extenso del continente, tras Rusia, Ucrania y Francia.[10] Con una altitud media de 650 metros sobre el nivel del mar, es el segundo país más montañoso de Europa, tras Suiza. Su población es de 45.200.737 habitantes, según datos del padrón municipal de 2007.</p>\r\n\r\n<p>De acuerdo a la Constitución Española, el castellano o español es la lengua oficial del Estado y es la lengua común de todos los españoles. Otras lenguas son reconocidas como cooficiales en sus respectivas comunidades autónomas conforme a sus Estatutos de autonomía. Las modalidades lingüísticas de España son uno de sus patrimonios culturales, objeto de especial respeto y protección.</p>\r\n\r\n<p>El territorio peninsular comparte fronteras terrestres con Francia y con el principado de Andorra al norte, con Portugal al oeste y con el territorio británico de Gibraltar al sur. En sus territorios africanos, comparte fronteras terrestres y marítimas con Marruecos. Comparte con Francia la soberanía sobre la isla de los Faisanes en la desembocadura del río Bidasoa y cinco facerías pirenaicas.</p>', '2008-05-26', 0, 0, '4C'),
('1211823882140443d447c', 'Guerra Civil', 'Se denomina guerra civil a cualquier confrontamiento bélico cuyos participantes no son en su mayoría fuerzas militares regulares, si no que están formadas u organizadas por personas generalmente de la población civil. Su característica más común es que el conflicto armado se desarrolla en un mismo país, enfrentándose entre sí personas de un mismo lugar: ciudad, pueblo, comunidad, defendiendo, generalmente, dos ideologías o intereses distintos. En esta conflagración, llega a veces la intervención de unidades extranjeras de distintos países, incluso, ayudando o colaborando con los distintos bandos de esa misma guerra civil, cuyos individuos llegan a ser voluntarios civiles que apoyan la ideología del bando seleccionado. En el siglo XXI el continente africano es un nido de guerras civiles en muchos de sus países debido generalmente a luchas por el poder de las etnias más importantes de cada país, llamadas guerras olvidadas, ya que son conocidas por el público cuando hay un genocidio o una gran masacre de personas.', '2008-05-26', 0, 0, '7C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE IF NOT EXISTS isg3.`category` (
  `oid` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY  (`oid`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `category`
--

INSERT INTO isg3.`category` (`oid`, `name`, `description`) VALUES
('7C', 'Historia', 'Categoria de historia'),
('1C', 'Deportes', 'Categoria de deportes'),
('2C', 'Ciencia', 'Categoria de cienca'),
('3C', 'Cine', 'Categoria de cine'),
('4C', 'Sociedad', 'Categoria de sociedad'),
('5C', 'Tecnologia', 'Categoria de tecnologia'),
('6C', 'Sucesos', 'Categoria de sucesos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `message`
--

CREATE TABLE IF NOT EXISTS isg3.`message` (
  `oid` varchar(30) NOT NULL,
  `senderUserOID` varchar(30) NOT NULL,
  `receiverUserOID` varchar(30) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `dateSend` date default NULL,
  PRIMARY KEY  (`oid`),
  KEY `senderUserOID` (`senderUserOID`),
  KEY `receiverUserOID` (`receiverUserOID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `message`
--

INSERT INTO isg3.`message` (`oid`, `senderUserOID`, `receiverUserOID`, `subject`, `content`, `dateSend`) VALUES
('121175166268739913523', '1U', '2U', 'jojojo', ' vamos a ver', '2008-05-25'),
('1211811665234ffffffffbcc8da3f', '1U', '3U', 'hola otr avez', ' ', '2008-05-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rate`
--

CREATE TABLE IF NOT EXISTS isg3.`rate` (
  `oid` varchar(30) NOT NULL,
  `articleOID` varchar(30) NOT NULL,
  `userOID` varchar(30) NOT NULL,
  `rate` int(2) default NULL,
  `reason` varchar(100) default NULL,
  PRIMARY KEY  (`oid`),
  UNIQUE KEY `articleOID` (`articleOID`,`userOID`),
  KEY `userOID` (`userOID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `rate`
--

INSERT INTO isg3.`rate` (`oid`, `articleOID`, `userOID`, `rate`, `reason`) VALUES
('1211557799031ffffffff9c9a0c86', '9A', '12115564623124ac6e4ef', 5, 'pos ahora si me gusta'),
('12116510217503043deb7', '8A', '1U', 0, 'mu mal :(		'),
('12116552742961d49a1f0', '8A', '2U', 3, 'bueno	'),
('1211707866687360f1b52', '9A', '2U', 5, 'dfhfhfhfg				'),
('12117378772652b4bcd0c', '8A', '3U', 5, 'Crack\r\n	'),
('12117443827345d3cd5fc', '12116574666873ff8de3e', '1U', 0, '							\r\n						'),
('1211744659781324fe93a', '1211744653968ffffffffde5d51ea', '3U', 0, '							\r\n						'),
('1211755509687ffffffffce4f079c', '1211755348125ffffffffdc9f7a36', '1U', 4, 'dsdsfs				'),
('12118037693597234ea95', '121157192920361dd391c', '2U', 0, 'esto no es realmente cierto...'),
('121181876628168fa60e5', '1211657286890fffffffff266e7b2', '3U', 0, 'bien'),
('121182393779623aec8cc', '1211657416968ffffffffe7f3f80e', '2U', 0, 'que falta de respeto...');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS isg3.`user` (
  `oid` varchar(30) NOT NULL,
  `nick` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `registeredDate` date NOT NULL,
  PRIMARY KEY  (`oid`),
  UNIQUE KEY `nick` (`nick`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `user`
--

INSERT INTO isg3.`user` (`oid`, `nick`, `pass`, `mail`, `registeredDate`) VALUES
('1U', 'practica', 'practica', 'practica@us.es', '2008-05-23'),
('2U', 'jesus', 'jesusito', 'mastermate@gmail.com', '2008-05-23'),
('3U', 'alberto', 'a', 'alberto@hotmail.com', '2008-05-23'),
('1211556357890ffffffffddeef49a', 'pepito', 'pepito', 'pepito@us.es', '0000-00-00'),
('12115564623124ac6e4ef', 'juanito', 'juanito', 'juanito@us.es', '2008-05-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userarticle`
--

CREATE TABLE IF NOT EXISTS isg3.`userarticle` (
  `oid` varchar(30) NOT NULL,
  `userOID` varchar(30) NOT NULL,
  `articleOID` varchar(30) NOT NULL,
  PRIMARY KEY  (`oid`),
  KEY `userOID` (`userOID`),
  KEY `articleOID` (`articleOID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `userarticle`
--

INSERT INTO isg3.`userarticle` (`oid`, `userOID`, `articleOID`) VALUES
('1UA', '1U', '8A'),
('2UA', '2U', '8A'),
('3UA', '3U', '9A'),
('4UA', '1U', '10A'),
('5UA', '1U', '11A'),
('121157192923450ae86e7', '2U', '121157192920361dd391c'),
('1211585261796ffffffffc38823bb', '2U', '9A'),
('1211651011890487dc151', '1U', '8A'),
('12116523144215efe347e', '2U', '8A'),
('1211653663015ffffffff9e4d49e7', '2U', '8A'),
('121165728690643c6a5f7', '2U', '1211657286890fffffffff266e7b2'),
('1211657416984ffffffffd8c45423', '2U', '1211657416968ffffffffe7f3f80e'),
('1211657466687118e9a58', '2U', '12116574666873ff8de3e'),
('121172669953128fc696d', '3U', '8A'),
('12117267147185892e411', '3U', '8A'),
('1211726728203ffffffff825fdb7b', '3U', '8A'),
('1211726939703ffffffffe5e9e463', '3U', '8A'),
('12117270234846ba05e2b', '3U', '8A'),
('12117273894536922f94c', '3U', '8A'),
('121173783837537607e03', '3U', '8A'),
('121174445121816838ae7', '1U', '12116574666873ff8de3e'),
('12117446539843213fa8', '3U', '1211744653968ffffffffde5d51ea'),
('121174466385955232e37', '3U', '1211744653968ffffffffde5d51ea'),
('1211751234578ffffffffcf0847d1', '1U', '1211751234562ffffffffeb8733b6'),
('12117530341565370ec14', '1U', '121175303414071749389'),
('1211755348140ffffffff8c5a81bb', '1U', '1211755348125ffffffffdc9f7a36'),
('12118008015157515a527', '2U', '8A'),
('12118008568906043e0b5', '2U', '8A'),
('121180090340610699452', '2U', '8A'),
('121180117325055869bb2', '2U', '121157192920361dd391c'),
('1211803723687ffffffffdf4e84df', '2U', '1211803723687ffffffffa258c3ef'),
('1211803774421e4e6dbb', '2U', '121157192920361dd391c'),
('121181111459332bfd821', '1U', '1211755348125ffffffffdc9f7a36'),
('1211818757546ffffffffd5094816', '3U', '1211657286890fffffffff266e7b2'),
('12118187843435c094e9f', '3U', '1211657286890fffffffff266e7b2'),
('1211820281078fffffffffc1268aa', '3U', '8A'),
('1211822169656ffffffffeb4debbe', '3U', '8A'),
('1211823471875ffffffffb932e415', '1U', '1211823471859ffffffffb10299d4'),
('1211823882156ffffffff91c2dc75', '2U', '1211823882140443d447c'),
('1211823920265ffffffffe10ad0bf', '2U', '1211657416968ffffffffe7f3f80e'),
('121182394051553a4c536', '2U', '1211657416968ffffffffe7f3f80e');
