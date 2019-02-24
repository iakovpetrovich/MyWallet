/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import db.DBBroker;
import domain.DomainObject;
import domain.Transaction;
import java.util.LinkedList;

/**
 *
 * @author jasap
 */
public class OperationGetTransactions extends Operation {

    private LinkedList<DomainObject> results;

    @Override
    protected void executeOperation(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("Querry has not been passed, transaction required.");
        }
        Transaction t = (Transaction) obj;
        if (t.getAccountID() == 0) {
            throw new Exception("Querry has not been passed, bad search input.");
        }
        results = DBBroker.getDBBroker().select(t);
        if (results == null || results.isEmpty()) {
            throw new Exception("Transaction was not found or wasn't properly read from the database.");
        }
    }
    
    public LinkedList getResult(){
        LinkedList<Transaction> transactions = new LinkedList<>();
        for (DomainObject result : results) {
            transactions.add((Transaction) result);
        }
        return transactions;

    }

    @Override
    public String toString() {
        return "Operation Get Transactions";
    }
}

