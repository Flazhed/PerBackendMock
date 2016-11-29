/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dtos.DepartureDetail;
import dtos.DepartureIdentifier;
import dtos.PersonDetail;
import dtos.ReservationIdentifier;
import dtos.RouteDetail;
import dtos.RouteIdentifier;
import dtos.RouteSummary;
import entities.TravellingEntity;
import etos.InvalidReservationException;
import etos.NoAvailableDateException;
import etos.NotFoundException;
import etos.UnexpectedErrorException;
import interfaces.UserInterface;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soren
 */
public class UserMock implements UserInterface{

    private List<DepartureIdentifier> departures;
    private List<RouteIdentifier> routeSummaries;
    
    public UserMock(){
        
        this.routeSummaries = new ArrayList<RouteIdentifier>();
        
        //Add Departures
        this.departures = new ArrayList<DepartureIdentifier>();
        DepartureDetail dt1 = new DepartureDetail(LocalDateTime.now(),);
        dt1.setDepartureId(0);
        dt1.setDepartureTime();
        RouteSummary rs1 = new RouteSummary();
        rs1.setHarbourDestination("Kundby");
        dt1.setRouteSummary(rs1);
        this.departures.add(dt1);
        //Departures end1
    }
    
    
    @Override
    public List<DepartureIdentifier> getDepartures(LocalDate departureDate, RouteIdentifier route) throws NoAvailableDateException, UnexpectedErrorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DepartureIdentifier getDeparture(long departureId) throws NotFoundException, UnexpectedErrorException {
        
        return this.departures.get((int)departureId);
    }

    @Override
    public List<RouteIdentifier> getAllRouteSummaries() throws UnexpectedErrorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservationIdentifier createReservation(PersonDetail person, long departureId, List<TravellingEntity> travellingEntities) throws InvalidReservationException, UnexpectedErrorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TravellingEntity> getTravellingEntities() throws UnexpectedErrorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
