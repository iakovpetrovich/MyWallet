/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author jasap
 */
public class DBUtil {

    Properties properties;

    public DBUtil() throws IOException {
        getProperties();
    }
    
    

    private void getProperties() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src\\dataBase.properties"));
    }
    
    String getURL(){
        return properties.getProperty("url");
    }
    
    String getUser(){
        return properties.getProperty("user");
    }
    
    String getPassword(){
        return properties.getProperty("pwd");
    }

}
