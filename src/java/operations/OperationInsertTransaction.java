/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import db.DBBroker;
import domain.Transaction;

/**
 *
 * @author jasap
 */
public class OperationInsertTransaction extends Operation {

    Transaction transaction;
    boolean inserted = false;
    
    @Override
    protected void executeOperation(Object obj) throws Exception {
        if(obj == null) throw new Exception("Querry has not been passed, transaction required.");
        Transaction a = (Transaction) obj;
        inserted = DBBroker.getDBBroker().insert(a);        
    }

    public Transaction getResult() {
        return transaction;
    }
    
    public boolean getInserted(){
        return inserted;
    }
    
}
