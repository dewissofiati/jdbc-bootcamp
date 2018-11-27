package com.tabeldata.bootcamp.model;

public class Nasabah {

    public Nasabah() {

    }

    public Nasabah(Integer id, String namaNasabah, String alamat) {
        this.id = id;
        this.namaNasabah = namaNasabah;
        this.alamat = alamat;
    }

    private Integer id;
    private String namaNasabah;
    private String alamat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
//    @Override
    public String toString() {
        return String.format("%s \t | %s \t | %s \t ",
                this.id,
                this.namaNasabah,
                this.alamat);
    }
}
