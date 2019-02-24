/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasap
 */
public class Account implements DomainObject {

    private int accountID;
    private String accountNumber;
    private String accountName;
    private String ownerName;
    private String bankName;
    private String currency;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public LinkedList<DomainObject> select(ResultSet rs) {
        LinkedList<DomainObject> domainOnjects = new LinkedList<>();
        try {
            while (rs.next()) {
                Account a = new Account();
                a.accountID = rs.getInt(1);
                a.accountNumber = rs.getString(2);
                a.accountName = rs.getString(3);
                a.ownerName = rs.getString(4);
                a.bankName = rs.getString(5);
                a.currency = rs.getString(6);                
                System.out.println("ACCOUNT IS READ");
                domainOnjects.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return domainOnjects;
    }

    @Override
    public String insert() {
        String querry = "INSERT INTO Account values('"
                +accountNumber+"','"
                +accountName+"','"
                +ownerName+"','"
                +bankName+"','"
                +currency+"')";
        return querry;
    }

    @Override
    public String delete() {
        return "delete from Account where AccountID = "+accountID;
    }

    @Override
    public String update() {
        return "update Account set AccountNumber = "+accountNumber+" where AccountID = "+accountID;
    }

    @Override
    public String getSelect() {
        if(accountID == 0) return "SELECT * from Account where OwnerName = "+"'"+ownerName+"'";
        String querry ="SELECT * from Account " 
                +"where AccountID = '"+accountID+"'" 
                +"or AccountNumber = '"+accountNumber+"'" 
                +"or OwnerName = '"+ownerName+"'" 
                +"or AccountName = '"+accountName+"'" 
                +"or BankName = '"+bankName+"'";
        return querry;
    }

}
