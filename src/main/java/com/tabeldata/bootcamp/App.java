package com.tabeldata.bootcamp;

import com.tabeldata.bootcamp.model.Region;
//import org.joda.time.LocalDateTime;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    static String url = "jdbc:postgresql://127.0.0.1:5432/hr";
    static String username = "hr";
    static String password = "hr";
//    static String query = "insert into mst_nasabah(nama_nasabah, alamat) value(?, ?)";
    static String query = "create table if not exists mst_nasabah(id serial not null primary key, nama_nasabah varchar(50) not null, alamat varchar(50) not null)";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
//            statement.setString(1,"Dewi Syarah Sofiati");
//            statement.setString(2, "Jl Baturaden");

            statement.executeUpdate(query);



            conn.commit();
            statement.close();
            conn.close();
            System.out.println("Berhasil terkoneksi ke database");
        } catch (SQLException e) {
            System.out.println("Tidak bisa konek ke database");
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }
}