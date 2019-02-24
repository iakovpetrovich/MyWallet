/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controler.Controler;
import db.DBBroker;
import domain.Account;
import domain.DomainObject;
import domain.Transaction;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasap
 */
public class Test {
    
    public static void main(String[] args) {
        /*try {
            DBBroker db = DBBroker.getDBBroker();
            db.opentConnection();
            db.closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }*/
        Account a = new Account();
        a.setOwnerName("Jak");
        a = (Account) Controler.getInstance().getAccounts(a).getDomainObjects().get(0); 
        System.out.println(a.getAccountName());
        a.setAccountNumber("2059001");
        
        Controler.getInstance().insertAccount(a);
        
      
        
//          Transaction t = new Transaction();
//          t.setAccountID(4);
//          for(DomainObject elem: Controler.getInstance().getTransactions(t).getDomainObjects()){
//                  System.out.println(((Transaction) elem).getAmount());
//                  t = (Transaction) elem;
//          }
//          t.setTransactionDate(new Timestamp(System.currentTimeMillis()));
//          t.setAmount(223);
//          t.setTransactionalInfo("Some infro");
//          Controler.getInstance().insertTransactions(t);
//          
          
    }
    
}
