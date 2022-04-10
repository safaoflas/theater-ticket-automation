-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 10 Nis 2022, 08:18:32
-- Sunucu sürümü: 10.4.21-MariaDB
-- PHP Sürümü: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `tiyatro_otomasyon`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `biletci`
--

CREATE TABLE `biletci` (
  `BILETCI_ID` int(11) NOT NULL,
  `B_AD` varchar(50) NOT NULL,
  `B_TELEFON` varchar(50) NOT NULL,
  `B_MAAS` int(11) NOT NULL,
  `B_BASLANGIC` varchar(50) NOT NULL,
  `B_IZIN` int(11) NOT NULL,
  `B_ADRES` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `biletci`
--

INSERT INTO `biletci` (`BILETCI_ID`, `B_AD`, `B_TELEFON`, `B_MAAS`, `B_BASLANGIC`, `B_IZIN`, `B_ADRES`) VALUES
(1, 'ABDULLAH YAR', '05458350734', 4500, '12/03/2022', 14, 'ELAZIĞ MERKEZ');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `fiyat`
--

CREATE TABLE `fiyat` (
  `FIYAT_ID` int(11) NOT NULL,
  `SALON_AD` varchar(50) NOT NULL,
  `OYUN_AD` varchar(50) NOT NULL,
  `SEANS_SAATI` varchar(50) NOT NULL,
  `TAM_FIYAT` int(11) NOT NULL,
  `OGRENCI_FIYAT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `fiyat`
--

INSERT INTO `fiyat` (`FIYAT_ID`, `SALON_AD`, `OYUN_AD`, `SEANS_SAATI`, `TAM_FIYAT`, `OGRENCI_FIYAT`) VALUES
(1, 'SALON1', 'TATAR RAMAZAN', '09:00-11:00', 28, 20);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `KULLANICI`
--

CREATE TABLE `KULLANICI` (
  `KULLANICI_ID` int(11) NOT NULL,
  `KULLANICI_AD` varchar(50) NOT NULL,
  `SIFRE` varchar(50) NOT NULL,
  `AD` varchar(50) NOT NULL,
  `SOYAD` varchar(50) NOT NULL,
  `TELEFON` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `KULLANICI`
--

INSERT INTO `KULLANICI` (`KULLANICI_ID`, `KULLANICI_AD`, `SIFRE`, `AD`, `SOYAD`, `TELEFON`) VALUES
(1, 'admin', '12345', 'abdullah', 'yar', '05458350734');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `musteriler`
--

CREATE TABLE `musteriler` (
  `MUSTERI_ID` int(11) NOT NULL,
  `M_AD_SOYAD` varchar(50) NOT NULL,
  `M_CEP` varchar(50) NOT NULL,
  `M_MAIL` varchar(50) NOT NULL,
  `M_OKUL` varchar(50) NOT NULL,
  `M_CINSIYET` varchar(50) NOT NULL,
  `UCRET` int(11) NOT NULL,
  `M_KOLTUK` varchar(50) NOT NULL,
  `SALON_AD` varchar(50) NOT NULL,
  `SEANS_SAATI` varchar(50) NOT NULL,
  `OYUN_AD` varchar(50) NOT NULL,
  `TARIH` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `musteriler`
--

INSERT INTO `musteriler` (`MUSTERI_ID`, `M_AD_SOYAD`, `M_CEP`, `M_MAIL`, `M_OKUL`, `M_CINSIYET`, `UCRET`, `M_KOLTUK`, `SALON_AD`, `SEANS_SAATI`, `OYUN_AD`, `TARIH`) VALUES
(1, 'ahmet arslan', '05467898976', 'asd@gmail.com', 'erkek', 'tam', 14, '4', 'SALON2', '11:30-13:15', 'ARSLAN KRAL', '09 Nisan 2022'),
(4, 'abdullah yar', '5458350734', 'abdullahyar23@gmail.com', 'erkek', 'tam', 17, '1', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022'),
(5, 'ufuk kılıç', '05456788990', 'ufuk@gmail.com', 'erkek', 'öğrenci', 17, '7', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022'),
(6, 'mehmet sait yar', '05525026823', 'mehmetsait23@gmail.com', 'erkek', 'tam', 18, '23', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022'),
(7, 'aa', 'aa', 'aa', 'erkek', 'tam', 15, '78', 'SALON1', '09:00-11:00', 'BİR DEMET TİYATRO', '10 Nisan 2022'),
(8, 'ak', '067', 'q', 'kadın', 'tam', 14, '62', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022'),
(9, 'ak', '067', 'q', 'kadın', 'tam', 14, '62', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '10 Nisan 2022'),
(10, 'ak', '067', 'q', 'kadın', 'tam', 14, '18', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022'),
(11, 'ak', '067', 'q', 'kadın', 'tam', 14, '19', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022'),
(12, 'ak', '067', 'q', 'kadın', 'tam', 14, '20', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022'),
(13, 'ak', '067', 'q', 'kadın', 'tam', 14, '53', 'SALON1', '11:30-13:15', 'TATAR RAMAZAN', '09 Nisan 2022'),
(14, 'ak', '067', 'q', 'kadın', 'tam', 14, '54', 'SALON1', '11:30-13:15', 'TATAR RAMAZAN', '09 Nisan 2022'),
(15, 'ak', '067', 'q', 'kadın', 'tam', 14, '55', 'SALON1', '11:30-13:15', 'TATAR RAMAZAN', '09 Nisan 2022'),
(16, 'erhan', '111', 'sss', 'erkek', 'tam', 17, '17', 'SALON1', '09:00-11:00', 'TATAR RAMAZAN', '09 Nisan 2022');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `oyun`
--

CREATE TABLE `oyun` (
  `OYUN_ID` int(11) NOT NULL,
  `SALON_AD` varchar(50) NOT NULL,
  `SEANS_SAATI` varchar(50) NOT NULL,
  `OYUN_AD` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `oyun`
--

INSERT INTO `oyun` (`OYUN_ID`, `SALON_AD`, `SEANS_SAATI`, `OYUN_AD`) VALUES
(1, 'SALON1', '09:00-11:00', 'TATAR RAMAZAN'),
(2, 'SALON1', '11:30-13:15', 'BİR DEMET TİYATRO');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `salon`
--

CREATE TABLE `salon` (
  `SALON_ID` int(11) NOT NULL,
  `AD` varchar(50) NOT NULL,
  `KAPASITE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `salon`
--

INSERT INTO `salon` (`SALON_ID`, `AD`, `KAPASITE`) VALUES
(4, 'SALON1', 91),
(5, 'SALON2', 91),
(6, 'SALON3', 91),
(7, 'SALON4', 91);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `seans`
--

CREATE TABLE `seans` (
  `SEANS_ID` int(11) NOT NULL,
  `SEANS_SAATI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `seans`
--

INSERT INTO `seans` (`SEANS_ID`, `SEANS_SAATI`) VALUES
(1, '09:00-11:00'),
(2, '11:30-13:15'),
(3, '13:45-15:45'),
(4, '16:00-18:15'),
(5, '18:30-20:30'),
(6, '21:00-23:30');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `biletci`
--
ALTER TABLE `biletci`
  ADD PRIMARY KEY (`BILETCI_ID`);

--
-- Tablo için indeksler `fiyat`
--
ALTER TABLE `fiyat`
  ADD PRIMARY KEY (`FIYAT_ID`);

--
-- Tablo için indeksler `KULLANICI`
--
ALTER TABLE `KULLANICI`
  ADD PRIMARY KEY (`KULLANICI_ID`);

--
-- Tablo için indeksler `musteriler`
--
ALTER TABLE `musteriler`
  ADD PRIMARY KEY (`MUSTERI_ID`);

--
-- Tablo için indeksler `oyun`
--
ALTER TABLE `oyun`
  ADD PRIMARY KEY (`OYUN_ID`);

--
-- Tablo için indeksler `salon`
--
ALTER TABLE `salon`
  ADD PRIMARY KEY (`SALON_ID`);

--
-- Tablo için indeksler `seans`
--
ALTER TABLE `seans`
  ADD PRIMARY KEY (`SEANS_ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `biletci`
--
ALTER TABLE `biletci`
  MODIFY `BILETCI_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `fiyat`
--
ALTER TABLE `fiyat`
  MODIFY `FIYAT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `KULLANICI`
--
ALTER TABLE `KULLANICI`
  MODIFY `KULLANICI_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `musteriler`
--
ALTER TABLE `musteriler`
  MODIFY `MUSTERI_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Tablo için AUTO_INCREMENT değeri `oyun`
--
ALTER TABLE `oyun`
  MODIFY `OYUN_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `salon`
--
ALTER TABLE `salon`
  MODIFY `SALON_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `seans`
--
ALTER TABLE `seans`
  MODIFY `SEANS_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
