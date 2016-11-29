/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dtos.*;
import etos.NotFoundException;
import etos.UnexpectedErrorException;

/**
 *
 * @author Soren
 */
public class TestRunner {
    
    public static void main(String[] args) throws NotFoundException, UnexpectedErrorException {
        UserMock um = new UserMock();
        DepartureDetail dt1 = (DepartureDetail)um.getDeparture(0);
        System.out.println(dt1.getRouteSummary().getHarbourDestination());
    }
    
    
}
