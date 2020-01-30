-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-01-2020 a las 04:35:35
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `escuela`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosevaluacion`
--

CREATE TABLE `datosevaluacion` (
  `idevaluacion` int(11) NOT NULL,
  `tiempo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `planeacion` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coordinacion` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuerza_muscular` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sensibilidad` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrodocentes`
--

CREATE TABLE `registrodocentes` (
  `Id` int(11) NOT NULL,
  `usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `last_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `registrodocentes`
--

INSERT INTO `registrodocentes` (`Id`, `usuario`, `password`, `nombre`, `correo`, `last_time`) VALUES
(1, 'jg', '123', 'Juan', 'jua@gmail.com', '0000-00-00 00:00:00'),
(2, 'Milo', 'eadc1dd8fc279583d5552700ae5d248e3fa123bd', 'MILO TORRES', 'ml@gmail.com', '0000-00-00 00:00:00'),
(3, 'admin', '5f6955d227a320c7f1f6c7da2a6d96a851a8118f', 'Lu', 'micorreo@gmail.com', '2020-01-24 02:14:07'),
(4, 'Cesar', 'f10e2821bbbea527ea02200352313bc059445190', 'Cesar', 'micorreo@gmail.com', '2020-01-24 09:40:27'),
(5, 'Joselo', '91dfde1d6e005e422f64a59776234f1f4c80b5e4', 'Jose Lituma', 'micorreo@gmail.com', '2020-01-26 11:40:04'),
(6, 'Pancho', 'ca243a94064c2f041f9fde93234f90e501889260', 'Francisco', 'micorreo@gmai.com', '2020-01-26 18:06:15'),
(7, 'hoy', 'ec80f5690620d23ab137502f24165195009d9466', 'jol', 'micorreo@gmail.com', '2020-01-27 08:43:40'),
(8, 'toyo', '061dc12dc25d1085afeeebb75fc34fd822971ef1', 'Teodoro', 'micorreo@gmail.com', '2020-01-28 17:37:48'),
(9, 'Mariano', 'd2401f7b52ac6314c67d77b76c984dcc78772f5a', 'Mariano Rivas', 'micorreo@gmail.com', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registroestudiantes`
--

CREATE TABLE `registroestudiantes` (
  `IdEstudiantes` int(11) NOT NULL,
  `nombres` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `apellidos` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `ci` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `edad` int(10) NOT NULL DEFAULT '5',
  `curso` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `registroestudiantes`
--

INSERT INTO `registroestudiantes` (`IdEstudiantes`, `nombres`, `apellidos`, `ci`, `edad`, `curso`) VALUES
(1, 'Nico Mauricio', 'Fernandez Lituma', '010232453', 12, '4to Basica'),
(2, 'Pedro Sergio', 'Ramos', '2432321', 13, '5to Basica'),
(3, 'Carina ', 'Aldas', '002049495', 12, '3ro Basica'),
(4, 'Cesar Leonardo', 'Hidalgo Orosco', '0301954333', 12, '3ro Basica'),
(5, 'John Carlos', 'Gomez Guartazaca', '0106170942', 13, '3ro Basica');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datosevaluacion`
--
ALTER TABLE `datosevaluacion`
  ADD PRIMARY KEY (`idevaluacion`);

--
-- Indices de la tabla `registrodocentes`
--
ALTER TABLE `registrodocentes`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `registroestudiantes`
--
ALTER TABLE `registroestudiantes`
  ADD PRIMARY KEY (`IdEstudiantes`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `datosevaluacion`
--
ALTER TABLE `datosevaluacion`
  MODIFY `idevaluacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `registrodocentes`
--
ALTER TABLE `registrodocentes`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `registroestudiantes`
--
ALTER TABLE `registroestudiantes`
  MODIFY `IdEstudiantes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
