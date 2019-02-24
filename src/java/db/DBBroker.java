/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.DomainObject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    public void openConnection() throws SQLException{
        conn = DriverManager.getConnection(hostURL, user, pwd);
        conn.setAutoCommit(false);
        Logger.getLogger(DBBroker.class.getName()).log(Level.INFO, "Conection to DB established " + (new SimpleDateFormat("dd.MM.yyy. HH:mm:ss").format(Calendar.getInstance().getTime())));
        System.out.println("Connection to DB established");
    }
    
    public void closeConnection(){
        try {
            conn.close();
            Logger.getLogger(DBBroker.class.getName()).log(Level.INFO, "Conection to DB closed " + (new SimpleDateFormat("dd.MM.yyy. HH:mm:ss").format(Calendar.getInstance().getTime())));
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
        }
    }
    
    public LinkedList<DomainObject> select(DomainObject domainObject) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(domainObject.getSelect());
        System.out.println(domainObject.getSelect());
        return domainObject.select(ps.executeQuery());
    }
    
    public boolean insert(DomainObject domainObject) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(domainObject.insert());
        System.out.println(domainObject.insert());
        ps.executeUpdate();
        return true;
    }
    
    public boolean delete(DomainObject domainObject) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(domainObject.delete());
        System.out.println(domainObject.delete());
        ps.executeUpdate();
        return true;
    }
    
    public void commit() throws SQLException{
        conn.commit();
    }
    
    public void rollback() throws SQLException{
        conn.rollback();
    }
}
