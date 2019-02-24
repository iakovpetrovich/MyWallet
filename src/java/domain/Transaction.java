/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasap
 */
public class Transaction implements DomainObject {
    
    private int transactioID;
    private double amount;
    private Timestamp transactionDate;
    private boolean incomeOutcome;
    private String transactionalInfo;
    //private int typeID;
    private int accountID;
    private Account account;
    //private TransactionType transactionType;

    public int getTransactioID() {
        return transactioID;
    }

    public void setTransactioID(int transactioID) {
        this.transactioID = transactioID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIncomeOutcome() {
        return incomeOutcome;
    }

    public void setIncomeOutcome(boolean incomeOutcome) {
        this.incomeOutcome = incomeOutcome;
    }
    
    public void setIncomeOutcome(int incomeOutcome) {
        if(incomeOutcome > 0) {
            this.incomeOutcome = true;
        }
        this.incomeOutcome = false;
    }

    public String getTransactionalInfo() {
        return transactionalInfo;
    }

    public void setTransactionalInfo(String transactionalInfo) {
        this.transactionalInfo = transactionalInfo;
    }

//    public int getTypeID() {
//        return typeID;
//    }
//
//    public void setTypeID(int typeID) {
//        this.typeID = typeID;
//    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /*public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }*/

    @Override
    public LinkedList<DomainObject> select(ResultSet rs) {
     LinkedList<DomainObject> domainOnjects = new LinkedList<>();
        try {
            while (rs.next()) {
                Transaction t = new Transaction();
                t.transactioID = rs.getInt(1);
                t.amount = rs.getFloat(2);
                t.transactionDate = rs.getTimestamp(3);
                t.accountID = rs.getInt(4);
                t.incomeOutcome = rs.getBoolean(5);
                t.transactionalInfo = rs.getString(6);                
                System.out.println("TRANSACTION IS READ");
                domainOnjects.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return domainOnjects;
    }

    @Override
    public String insert() {
        int income = 0;
        if(incomeOutcome) income = 1;
        String querry = "INSERT INTO AccountTransaction (Amount,TransactionDate,AccountID,IncomeOutcome,TransactionInfo)  VALUES("
                +amount+",'"
                +transactionDate+"',"
                +accountID+","
                +income+",'"
                +transactionalInfo+"')";
        return querry;
    }

    @Override
    public String delete() {
        return "DELETE FROM AccountTransaction WHERE TransactionID = "+transactioID;
    }

    @Override
    public String update() {
        return "UPDATE AccountTransaction SET Amount = "+amount+", TransactionDate = "+transactionDate
                +" WHERE TransactionID = "+transactioID;
    }

    @Override
    public String getSelect() {
        if (transactionDate == null) {
            String querry = "SELECT * FROM AccountTransaction WHERE "
                 +"AccountID = '"+accountID+"'"
                 +"and TransactionDate > DATEADD(d,-14,SYSDATETIME())";
        return querry;
        }
        String querry = "SELECT * FROM AccountTransaction WHERE "
                 +"AccountID = '"+accountID+"'"
                 +"and TransactionDate > '"+transactionDate+"'";
        return querry;
    }
    
    
    
}
