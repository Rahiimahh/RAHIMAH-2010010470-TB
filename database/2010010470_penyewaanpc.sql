-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jan 2023 pada 12.28
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2010010470_penyewaanpc`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_datapc`
--

CREATE TABLE `tbl_datapc` (
  `id_pc` int(10) NOT NULL,
  `merek_pc` varchar(50) NOT NULL,
  `ram` varchar(20) NOT NULL,
  `penyimpanan` varchar(100) NOT NULL,
  `harga` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_datapc`
--

INSERT INTO `tbl_datapc` (`id_pc`, `merek_pc`, `ram`, `penyimpanan`, `harga`) VALUES
(1, 'ASUS', '8', '125', '500000'),
(2, 'LENOVO', '5', '120', '10000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_penyewa`
--

CREATE TABLE `tbl_penyewa` (
  `id_penyewa` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `email` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_penyewa`
--

INSERT INTO `tbl_penyewa` (`id_penyewa`, `nama`, `alamat`, `no_hp`, `email`) VALUES
(1, 'Rahimah', 'Jl. Panjaitan', '0898973355', 'imah@gmail.com'),
(2, 'Naila', 'Jl. Ayani', '089678542345', 'ila@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `id_transaksi` int(10) NOT NULL,
  `id_pc` int(10) NOT NULL,
  `id_penyewa` int(10) NOT NULL,
  `merek_pc` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL,
  `sewa_jam` varchar(15) NOT NULL,
  `biaya` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`id_transaksi`, `id_pc`, `id_penyewa`, `merek_pc`, `harga`, `sewa_jam`, `biaya`) VALUES
(1, 1, 1, 'ASUS', '100000', '2', '200000'),
(2, 2, 2, 'LENOVO', '200000', '2', '400000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_datapc`
--
ALTER TABLE `tbl_datapc`
  ADD PRIMARY KEY (`id_pc`);

--
-- Indeks untuk tabel `tbl_penyewa`
--
ALTER TABLE `tbl_penyewa`
  ADD PRIMARY KEY (`id_penyewa`);

--
-- Indeks untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_datapc`
--
ALTER TABLE `tbl_datapc`
  MODIFY `id_pc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tbl_penyewa`
--
ALTER TABLE `tbl_penyewa`
  MODIFY `id_penyewa` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  MODIFY `id_transaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
