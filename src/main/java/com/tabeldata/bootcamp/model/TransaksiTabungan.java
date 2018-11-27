package com.tabeldata.bootcamp.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransaksiTabungan {

    public TransaksiTabungan() {
    }

    public TransaksiTabungan(Integer id, Integer tabungan_id, BigDecimal debet, BigDecimal kredit, BigDecimal saldo, Date tanggal_Transaksi) {
        this.id = id;
        this.tabungan_id = tabungan_id;
        this.debet = debet;
        this.kredit = kredit;
        this.saldo = saldo;
        this.tanggal_Transaksi = tanggal_Transaksi;
    }

    private Integer id;
    // di isi 0 = "Setoran tabungan", 1 = "Penarikan Tabungan", 2 = "Biaya Admin"
    private Integer jenisTransaksi;
    private Integer tabungan_id;
    private BigDecimal debet;
    private BigDecimal kredit;
    private BigDecimal saldo;
    private Date tanggal_Transaksi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(Integer jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public Integer getTabungan_id() {
        return tabungan_id;
    }

    public void setTabungan_id(Integer tabungan_id) {
        this.tabungan_id = tabungan_id;
    }

    public BigDecimal getDebet() {
        return debet;
    }

    public void setDebet(BigDecimal debet) {
        this.debet = debet;
    }

    public BigDecimal getKredit() {
        return kredit;
    }

    public void setKredit(BigDecimal kredit) {
        this.kredit = kredit;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getTanggal_Transaksi() {
        return tanggal_Transaksi;
    }

    public void setTanggal_Transaksi(Date tanggal_Transaksi) {
        this.tanggal_Transaksi = tanggal_Transaksi;
    }

    public String toString(){
        return String.format("{id : %s, tabungan_id : %s, debet : %s, kredit : %s, saldo : %s, tanggal_transaksi : %s}",
        this.id,
        this.tabungan_id,
        this.debet,
        this.kredit,
        this.saldo,
        this.tanggal_Transaksi);
    }
}
