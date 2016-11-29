/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dtos.*;
import etos.LoginException;
import etos.NoAvailableDateException;
import etos.NotFoundException;
import etos.UnexpectedErrorException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Soren
 */
public class TestRunner {

    public static void main(String[] args) throws NotFoundException, UnexpectedErrorException, NoAvailableDateException {
        UserMock um = new UserMock();

        DepartureDetail dt1 = (DepartureDetail) um.getDeparture(0);
        System.out.println(dt1.getRouteSummary().getHarbourDestination());

        List<DepartureIdentifier> depatures = um.getDepartures(LocalDate.now(), new RouteSummary(30, "SomeHarbourStart", "SomeHarbourEnd", 0));
        System.out.println(depatures.size());

        List<RouteIdentifier> routeSummaries = um.getAllRouteSummaries();
        RouteSummary rs = (RouteSummary) routeSummaries.get(0);
        System.out.println(rs.getHarbourOrigin());


        //Admin Mock
        System.out.println("////////////////AdminMock/////////////////");
        AdminMock adminMock = new AdminMock();

        RouteSummary routeSummary = new RouteSummary(30, "Tortoise Shell Harbor", "Oakland Harbor", 0);
        DepartureDetail departureDetail = new DepartureDetail(LocalDateTime.now(), routeSummary, 0);


        //login
        try {
            System.out.println(adminMock.login("user", "password").getUserName());
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }

        // Get all
        System.out.println(adminMock.getAllDepartures().size());

        //To lazy right now.
       // RouteIdentifier routeIdentifier = new RouteDetail( );
       // adminMock.createDeparture(routeIdentifier,LocalDateTime.now());

        // Get single
        DepartureDetail detail = (DepartureDetail) adminMock.getDeparture(1l);

        System.out.println(detail.getRouteSummary().getHarbourOrigin());

        // Update

        adminMock.updateDeparture(departureDetail);
        DepartureDetail updatedDetail = (DepartureDetail) adminMock.getDeparture(1l);
        System.out.println(updatedDetail.getRouteSummary().getHarbourOrigin());

        // Delete
        DepartureDetail deletedDetail = (DepartureDetail) adminMock.deleteDeparture(1l);
        System.out.println(adminMock.getAllDepartures().size());

    }


}
