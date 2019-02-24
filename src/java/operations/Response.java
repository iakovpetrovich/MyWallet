/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import domain.DomainObject;
import java.util.LinkedList;

/**
 *
 * @author jasap
 */
public class Response {
    
    private DomainObject domainObject;
    private LinkedList<DomainObject> domainObjects;
    private String message;
    private boolean OK;

    public Response(DomainObject domainObject, LinkedList<DomainObject> domainObjects, String message, boolean OK) {
        this.domainObject = domainObject;
        this.domainObjects = domainObjects;
        this.message = message;
        this.OK = OK;
    }
    
    

    public DomainObject getDomainObject() {
        return domainObject;
    }

    public void setDomainObject(DomainObject domainObject) {
        this.domainObject = domainObject;
    }

    public LinkedList<DomainObject> getDomainObjects() {
        return domainObjects;
    }

    public void setDomainObjects(LinkedList<DomainObject> domainObjects) {
        this.domainObjects = domainObjects;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOK() {
        return OK;
    }

    public void setOK(boolean OK) {
        this.OK = OK;
    }
    
    
    
    
}
