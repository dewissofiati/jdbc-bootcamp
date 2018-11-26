package com.tabeldata.bootcamp.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tabungan {
    public Tabungan() {

    }

    public Tabungan(Integer id, Nasabah nasabah, String namaTabungan, BigDecimal saldo, List<Tabungan> listTabungan) {
        this.id = id;
        this.nasabah = nasabah;
        this.namaTabungan = namaTabungan;
        this.saldo = saldo;
        this.listTabungan = listTabungan;
    }

    private Integer id;
    private Nasabah nasabah;
    private String namaTabungan;
    private BigDecimal saldo;
    private List<Tabungan> listTabungan = new ArrayList<Tabungan>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public String getNamaTabungan() {
        return namaTabungan;
    }

    public void setNamaTabungan(String namaTabungan) {
        this.namaTabungan = namaTabungan;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Tabungan> getListTabungan() {
        return listTabungan;
    }

    public void setListTabungan(List<Tabungan> listTabungan) {
        this.listTabungan = listTabungan;
    }
}
