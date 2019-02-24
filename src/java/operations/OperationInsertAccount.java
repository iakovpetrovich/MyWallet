/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import db.DBBroker;
import domain.Account;

/**
 *
 * @author jasap
 */
public class OperationInsertAccount extends Operation {

    Account account;
    boolean inserted = false;
    @Override
    protected void executeOperation(Object obj) throws Exception {
        if(obj == null) throw new Exception("Querry has not been passed, account required.");
        Account a = (Account) obj;
        if(a.getAccountID() == 0) throw new Exception("Querry has not been passed, ACCOUNTID required.");
        inserted = DBBroker.getDBBroker().insert(a);        
    }

    public Account getResult() {
        return account;
    }
    
    public boolean getInserted(){
        return inserted;
    }

    @Override
    public String toString() {
        return "Operation Insert Account";
    }
    
    

}
