/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dtos.*;
import etos.NoAvailableDateException;
import etos.NotFoundException;
import etos.UnexpectedErrorException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Soren
 */
public class TestRunner {
    
    public static void main(String[] args) throws NotFoundException, UnexpectedErrorException, NoAvailableDateException {
        UserMock um = new UserMock();
        
        DepartureDetail dt1 = (DepartureDetail)um.getDeparture(0);
        System.out.println(dt1.getRouteSummary().getHarbourDestination());
        
        List<DepartureIdentifier> depatures = um.getDepartures(LocalDate.now(), new RouteSummary(30, "SomeHarbourStart", "SomeHarbourEnd", 0));
        System.out.println(depatures.size());
        
        List<RouteIdentifier> routeSummaries = um.getAllRouteSummaries();
        RouteSummary rs = (RouteSummary)routeSummaries.get(0);
        System.out.println(rs.getHarbourOrigin());
        
    }
    
    
}
