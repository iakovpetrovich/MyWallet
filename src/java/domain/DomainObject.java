/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author jasap
 */
public interface DomainObject {
    
    LinkedList<DomainObject> select(ResultSet rs);
    String insert();
    String delete();
    String update();
    String getSelect();
    
}
