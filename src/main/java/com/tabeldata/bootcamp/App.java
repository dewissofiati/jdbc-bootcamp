package com.tabeldata.bootcamp;

import com.tabeldata.bootcamp.model.Nasabah;
import java.math.BigDecimal;
import com.tabeldata.bootcamp.model.Tabungan;
import com.tabeldata.bootcamp.model.TransaksiTabungan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    static String url = "jdbc:postgresql://127.0.0.1:5432/hr";
    static String username = "hr";
    static String password = "hr";

    public static void main(String[] args) {
        Connection conn = null;
        try{
            List<Nasabah> mst_nasabah = new ArrayList<Nasabah>();
            List<Tabungan> mst_tabungan = new ArrayList<Tabungan>();
            List<TransaksiTabungan> trx_transaksi_tabungan = new ArrayList<TransaksiTabungan>();
//            open a connection
            System.out.println("Connecting to database . . .");
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);

//            begin creating mst_nasabah
            System.out.println("Creating mst_nasabah table. . .");
            String query = "CREATE TABLE MST_NASABAH " +
                    "(id SERIAL not NULL, " +
                    " nama_nasabah VARCHAR(255), " +
                    " alamat VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("mst_nasabah table created successfully!");
//            end creating mst_nasabah

//            begin inserting mst_nasabah
            System.out.println("Inserting into mst_nasabah table . . .");
            query = "insert into mst_nasabah (id, nama_nasabah, alamat) values(?, ?, ?)";
            statement = conn.prepareStatement(query);
            statement.setInt(1,1);
            statement.setString(2, "Dimas Maryanto");
            statement.setString(3, "Jalan Bukit Indah");
            statement.addBatch();
            statement.setInt(1,2);
            statement.setString(2, "Hilman Ramadhan");
            statement.setString(3, "Ujung Berung");
            statement.addBatch();
            statement.setInt(1,3);
            statement.setString(2, "Dewi Syarah Sofiati");
            statement.setString(3, "Jl Baturaden");
            statement.addBatch();

            statement.executeBatch();
            System.out.println("mst_nasabah table inserted successfully!");
//            enc inserting mst_nasabah

//            begin selecting mst_nasabah
            System.out.println("Selecting mst_nasabah table . . .");
            query = "select * from mst_nasabah";
            statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("id \t | nama_nasabah \t | alamat ");
            while (resultSet.next()) {
                Nasabah nasabah = new Nasabah(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                System.out.println(nasabah.toString());
                mst_nasabah.add(nasabah);
            }
            System.out.println("mst_nasabah table selected successfully!");
//            end selecting mst_nasabah

//            begin creating mst_tabungan
            System.out.println("Creating mst_tabungan table . . .");
            query = "CREATE TABLE mst_tabungan " +
                    "(id SERIAL not NULL, " +
                    " nasabah_id int, " +
                    " saldo int, " +
                    " nama_tabungan VARCHAR(225)," +
                    " PRIMARY KEY (id))";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("mst_tabungan table created successfully!");
//            end creating mst_tabungan

//            begin inserting mst_tabungan
            System.out.println("Inserting mst_tabungan table . . .");
            query = "insert into mst_tabungan (id, nasabah_id, saldo, nama_tabungan) values(?,?,?,?)";
            statement = conn.prepareStatement(query);
            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setString(4, "Tabungan Umroh");
            statement.addBatch();

            statement.setInt(1, 2);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(0));
            statement.setString(4, "Tabungan Mapan");
            statement.addBatch();

            statement.setInt(1, 3);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(500000));
            statement.setString(4, "Tabungan Umroh");
            statement.addBatch();

            statement.executeBatch();
            System.out.println("mst_tabungan table inserted successfully!");
//            end inserting mst_tabungan

//            begin selecting mst_tabungan
            System.out.println("Selecting mst_tabungan table . . .");
            query = "select * from mst_tabungan";
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
            System.out.println("id \t | nasabah_id  \t | saldo \t | nama_tabungan ");
            while (resultSet.next()) {
                Tabungan tabungan = new Tabungan(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getBigDecimal(3),
                        resultSet.getString(4));
                System.out.println(tabungan.toString());
                mst_tabungan.add(tabungan);
            }
            System.out.println("mst_tabungan selected successfully!");
//            end selecting mst_tabungan

//            begin creating trx_transaksi_tabungan
            System.out.println("Creating trx_transaksi_tabungan table . . .");
            query = "CREATE TABLE trx_transaksi_tabungan" +
                    "(id SERIAL not NULL, " +
                    " tabungan_id int, " +
                    " debet int, " +
                    " kredit int, " +
                    " saldo int, " +
                    " tanggal_transaksi date, " +
                    " PRIMARY KEY (id))";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("trs_transaksi_tabungan table created successfully!");
//            end creating trx_transaksi_tabungan

//            begin inserting trx_transaksi_tabungan
            System.out.println("Inserting trx_transaksi_tabungan table . . .");
            query = "insert into trx_transaksi_tabungan (id, tabungan_id, debet, kredit, saldo, tanggal_transaksi) values(?,?,?,?,?,?)";
            statement = conn.prepareStatement(query);
            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setBigDecimal(4, BigDecimal.valueOf(0));
            statement.setBigDecimal(5, BigDecimal.valueOf(500000));
            statement.setDate(6, Date.valueOf("2017-03-20"));
            statement.addBatch();

            statement.setInt(1, 2);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(0));
            statement.setBigDecimal(4, BigDecimal.valueOf(250000));
            statement.setBigDecimal(5, BigDecimal.valueOf(250000));
            statement.setDate(6, Date.valueOf("2017-03-21"));
            statement.addBatch();

            statement.setInt(1, 3);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(200000));
            statement.setBigDecimal(4, BigDecimal.valueOf(0));
            statement.setBigDecimal(5, BigDecimal.valueOf(200000));
            statement.setDate(6, Date.valueOf("2017-03-22"));
            statement.addBatch();

            statement.setInt(1, 4);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(200000));
            statement.setBigDecimal(4, BigDecimal.valueOf(0));
            statement.setBigDecimal(5, BigDecimal.valueOf(400000));
            statement.setDate(6, Date.valueOf("2017-03-23"));
            statement.addBatch();

            statement.setInt(1, 5);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(0));
            statement.setBigDecimal(4, BigDecimal.valueOf(400000));
            statement.setBigDecimal(5, BigDecimal.valueOf(0));
            statement.setDate(6, Date.valueOf("2017-03-24"));
            statement.addBatch();

            statement.setInt(1, 6);
            statement.setInt(2, 3);
            statement.setBigDecimal(3, BigDecimal.valueOf(500000));
            statement.setBigDecimal(4, BigDecimal.valueOf(0));
            statement.setBigDecimal(5, BigDecimal.valueOf(500000));
            statement.setDate(6, Date.valueOf("2017-03-25"));
            statement.addBatch();

            statement.executeBatch();
            System.out.println("trx_transaksi_tabungan inserted successfully!");
//            end inserting trx_transaksi_tabungan

//            begin selecting trx_transaksi_tabungan
            System.out.println("Selecting trx_transaksi_tabungan table . . .");
            query = "select * from trx_transaksi_tabungan";
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
            System.out.println("id \t | tabungan_id \t | debet \t | kredit \t | saldo \t | tanggal_transaksi");
            while(resultSet.next()){
                TransaksiTabungan transaksiTabungan = new TransaksiTabungan(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getBigDecimal(3),
                        resultSet.getBigDecimal(4),
                        resultSet.getBigDecimal(5),
                        resultSet.getDate(6));
                System.out.println(transaksiTabungan.toString());
                trx_transaksi_tabungan.add(transaksiTabungan);
            }
            System.out.println("trx_transaksi_tabungan selected successfully!");
//            end selecting trx_transaksi_tabungan
            conn.commit();
            statement.close();
            conn.close();
            System.out.println("Berhasil terkoneksi ke database");
        }catch (SQLException e){
            System.out.println("Tidak bisa konek ke database");
            e.printStackTrace();
            if(conn != null){
                try{
                    conn.rollback();
                } catch(SQLException e1){
                    e1.printStackTrace();
                }
            }
        }
    }
}