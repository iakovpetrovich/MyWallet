/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import db.DBBroker;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasap
 */
public abstract class Operation {

    private void connect() throws SQLException, Exception {
        DBBroker.getDBBroker().openConnection();

    }

    private void diconnect() throws Exception {
        DBBroker.getDBBroker().closeConnection();

    }

    private void commitOperation() throws SQLException, Exception {
        DBBroker.getDBBroker().commit();
    }

    private void rollbackOperation() throws SQLException, Exception {
        DBBroker.getDBBroker().rollback();
    }

    protected abstract void executeOperation(Object obj) throws Exception;

    public final void execute(Object o) throws Exception {
        try {
            connect();
            executeOperation(o);
            commitOperation();
        } catch (Exception ex) {
            rollbackOperation();
            diconnect();
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, "Error during operation "+this.toString()
                    +" Exceprion message: "+ex.getMessage(), ex);
            System.out.println("Error during operation "+this.toString()
                    +" Exceprion message: "+ex.getMessage());
            throw ex;
        } finally {
            diconnect();
        }
    }
}
