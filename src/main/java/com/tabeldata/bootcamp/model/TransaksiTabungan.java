package com.tabeldata.bootcamp.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransaksiTabungan {
    public TransaksiTabungan() {
    }

    public TransaksiTabungan(Integer id, Integer jenisTransksi, Date tanggalTransaksi, BigDecimal kredit, BigDecimal debet, BigDecimal saldo) {
        this.id = id;
        this.jenisTransksi = jenisTransksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.kredit = kredit;
        this.debet = debet;
        this.saldo = saldo;
    }

    private Integer id;
    // di isi 0 = "Setoran tabungan", 1 = "Penarikan Tabungan", 2 = "Biaya Admin"
    private Integer jenisTransksi;
    private Date tanggalTransaksi;
    private BigDecimal kredit;
    private BigDecimal debet;
    private BigDecimal saldo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJenisTransksi() {
        return jenisTransksi;
    }

    public void setJenisTransksi(Integer jenisTransksi) {
        this.jenisTransksi = jenisTransksi;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public BigDecimal getKredit() {
        return kredit;
    }

    public void setKredit(BigDecimal kredit) {
        this.kredit = kredit;
    }

    public BigDecimal getDebet() {
        return debet;
    }

    public void setDebet(BigDecimal debet) {
        this.debet = debet;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
