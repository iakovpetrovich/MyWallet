/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import db.DBBroker;
import domain.Account;
import domain.DomainObject;
import java.util.LinkedList;

/**
 *
 * @author jasap
 */
public class OperationGetAccount extends Operation{
    
    private LinkedList<DomainObject> results;

    @Override
    protected void executeOperation(Object obj) throws Exception{
        if(obj == null) throw new Exception("Querry has not been passed, account required.");
        Account a = (Account) obj;
        if(a.getOwnerName() == null && a.getAccountID() == -1){
            throw new Exception("Querry has not been passed, bad search input.");
        }
        results = DBBroker.getDBBroker().select(a);
        if(results == null || results.isEmpty()) throw new Exception("Account was not found or wasn't properly read from the database.");
    }
    
    public Account getResult(){
        Account a = (Account) results.get(0);
        return a;
    }
    
    public LinkedList getAccounts(){
        LinkedList<Account> accounts = new LinkedList<>();
        for (DomainObject result : results) {
            accounts.add((Account) result);
        }
        return accounts;
    }

    @Override
    public String toString() {
        return "Operation Get Acount";
    }
    
    
}
