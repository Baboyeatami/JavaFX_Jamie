/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication_jamie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class DBConnection {

    private static Connection Myconnection;

    public static void init() {
        try {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Class not found");
            }
            Myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcaa_database?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static Connection getConnection() {
        if (Myconnection != null) {
            return Myconnection;
        } else {
            try {

                Myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcaa_databse?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

            } catch (Exception ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Myconnection;

    }

    public static void close(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void Destroy() {
        if (Myconnection != null) {

            try {
                Myconnection.close();
            } catch (Exception e) {
            }

        }

    }

    DatabaseMetaData getMetaData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
