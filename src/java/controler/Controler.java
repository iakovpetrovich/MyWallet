/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import db.DBBroker;
import domain.Account;
import domain.DomainObject;
import domain.Transaction;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import operations.Operation;
import operations.OperationDeleteAccount;
import operations.OperationDeleteTransaction;
import operations.OperationGetAccount;
import operations.OperationGetTransactions;
import operations.OperationInsertAccount;
import operations.OperationInsertTransaction;
import operations.Response;
import sun.java2d.pipe.hw.AccelDeviceEventListener;

/**
 *
 * @author jasap
 */
public class Controler {

    private static Controler instance;
    private Operation operation;
    private Response response;

    private Controler() {

    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public Response getAccount(Account a) {
        OperationGetAccount operation = new OperationGetAccount();
        try {
            operation.execute(a);
            response = new Response(operation.getResult(), null, "Account has been found.", true);
            return response;
        } catch (Exception ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new Response(null, null, ex.getMessage(), false);
        }
    }
    
        public Response getAccounts(Account a) {
        OperationGetAccount operation = new OperationGetAccount();
        try {
            operation.execute(a);
            response = new Response(null, operation.getAccounts(), "Account has been found.", true);
            return response;
        } catch (Exception ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new Response(null, null, ex.getMessage(), false);
        }
    }

    public Response getTransactions(Transaction t) {
        OperationGetTransactions operation = new OperationGetTransactions();
        try {
            operation.execute(t);
            response = new Response(null, operation.getResult(), "Transactions had been found.", true);
            return response;
        } catch (Exception ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new Response(null, null, ex.getMessage(), false);
        }
    }

    public Response insertAccount(Account a) {
        OperationInsertAccount operation = new OperationInsertAccount();
        try {
            operation.execute(a);
            response = new Response(operation.getResult(), null, "Account has been added.", operation.getInserted());
            return response;
        } catch (Exception ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new Response(null, null, ex.getMessage(), false);
        }
    }
    
    public Response insertTransactions(Transaction t) {
        OperationInsertTransaction operation = new OperationInsertTransaction();
        try {
            operation.execute(t);
            response = new Response(operation.getResult(), null, "Transactions had been added.", operation.getInserted());
            return response;
        } catch (Exception ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new Response(null, null, ex.getMessage(), false);
        }
    }
    
        public Response deleteAccount(Account a) {
            OperationDeleteAccount operation = new OperationDeleteAccount();
        try {
            operation.execute(a);
            response = new Response(null, null, "Account has been deleted.", operation.getDeleted());
            return response;
        } catch (Exception ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new Response(null, null, ex.getMessage(), false);
        }
    }
        public Response deleteTransactions(Transaction t) {
            OperationDeleteTransaction operation = new OperationDeleteTransaction();
        try {
            operation.execute(t);
            response = new Response(null, null, "Transactions had been deleted.", operation.getDeleted());
            return response;
        } catch (Exception ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new Response(null, null, ex.getMessage(), false);
        }
    }
        
}
