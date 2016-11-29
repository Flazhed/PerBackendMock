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
    private List<TravellingEntity> travellingEntities;
    
    public UserMock(){
        
        
        
        //Route summary
        this.routeSummaries = new ArrayList<RouteIdentifier>();
        RouteSummary rs1 = new RouteSummary(30, "SomeHarbourStart", "SomeHarbourEnd", 0);
        RouteSummary rs2 = new RouteSummary(45, "SomeOtherHarbourStart", "SomeOtherHarbourEnd", 1);
        this.routeSummaries.add(rs1);
        this.routeSummaries.add(rs2);
        //Route Summary end
        
        //Add Departures
        this.departures = new ArrayList<DepartureIdentifier>();
        DepartureDetail dt1 = new DepartureDetail(LocalDateTime.now(), rs1, 0);
        DepartureDetail dt2 = new DepartureDetail(LocalDateTime.now(), rs2, 1);
        this.departures.add(dt1);
        this.departures.add(dt2);
        //Departures end1
        
        //TravellingEntities
        this.travellingEntities = new ArrayList<TravellingEntity>();
        this.travellingEntities.add(new TravellingEntity());
    }
    
    
    @Override
    public List<DepartureIdentifier> getDepartures(LocalDate departureDate, RouteIdentifier route) throws NoAvailableDateException, UnexpectedErrorException {
        
        List<DepartureIdentifier> tempDepartures = new ArrayList<DepartureIdentifier>();
        
        for (DepartureIdentifier tempDeparture : this.departures) {
                DepartureDetail tempDetail = (DepartureDetail)tempDeparture;
                if(tempDetail.getRouteSummary().getRouteId() == route.getRouteId()) //&& tempDetail.getDepartureTime() == departureDate LocalDate and LocalDateTime, RIP
                    tempDepartures.add(tempDeparture);
            }
        
        
        return tempDepartures;
    }

    @Override
    public DepartureIdentifier getDeparture(long departureId) throws NotFoundException, UnexpectedErrorException {
        
        return this.departures.get((int)departureId);
    }

    @Override
    public List<RouteIdentifier> getAllRouteSummaries() throws UnexpectedErrorException {
        return this.routeSummaries;
    }

    @Override
    public ReservationIdentifier createReservation(PersonDetail person, long departureId, List<TravellingEntity> travellingEntities) throws InvalidReservationException, UnexpectedErrorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TravellingEntity> getTravellingEntities() throws UnexpectedErrorException {
        return this.travellingEntities;
    }
    
}
