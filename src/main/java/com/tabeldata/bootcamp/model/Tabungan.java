package com.tabeldata.bootcamp.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tabungan {
    public Tabungan() {

    }

    public Tabungan(Integer id, Integer nasabah, BigDecimal saldo, String namaTabungan) {
        this.id = id;
        this.nasabah = nasabah;
        this.saldo = saldo;
        this.namaTabungan = namaTabungan;
    }

    private Integer id;
    private Integer nasabah;
    private BigDecimal saldo;
    private String namaTabungan;
    private List<Tabungan> listTabungan = new ArrayList<Tabungan>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNasabah() {
        return nasabah;
    }

    public void setNasabah(Integer nasabah) {
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

    public String toString(){
        return String.format("%s \t | %s \t\t | %s \t | %s \t ",
                this.id,
                this.nasabah,
                this.saldo,
                this.namaTabungan
        );
    }
}
