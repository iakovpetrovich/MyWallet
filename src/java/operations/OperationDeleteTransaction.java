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
public class OperationDeleteTransaction extends Operation{

    boolean deleted = false;

    @Override
    protected void executeOperation(Object obj) throws Exception {
        if(obj == null) throw new Exception("Querry has not been passed, account required.");
        Transaction a = (Transaction) obj;
        if(a.getTransactioID()== 0) throw new Exception("Querry has not been passed, TRANSACTIONID required.");
        deleted = DBBroker.getDBBroker().delete(a);     
    }
    
    public boolean getDeleted(){
        return deleted;
    }
    
}
