/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author jasap
 */
public class DBBroker {
    
    private static DBBroker instance;
    private String hostURL;
    private String user;
    private String pwd;
    private Connection conn;
    
    private DBBroker() throws Exception{
        try {
            DBUtil util = new DBUtil();
            hostURL = util.getURL();
            user = util.getUser();
            pwd  = util.getPassword();
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, "Properties for DB connetion not loaded properly or not found. ", ex);
            throw new Exception("Properties for DB connetion not loaded properly or not found.");
        }
        
    }
    
    public static DBBroker getDBBroker() throws Exception{
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }
    
    
    public void opentConnection() throws SQLException{
        conn = DriverManager.getConnection(hostURL, user, pwd);
        conn.setAutoCommit(false);
        Logger.getLogger(DBBroker.class.getName()).log(Level.INFO, "Conection to DB established " + (new SimpleDateFormat("dd.MM.yyy. HH:mm:ss").format(Calendar.getInstance().getTime())));
        System.out.println("Connection to DB established");
    }
    
    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
        }
    }
}
