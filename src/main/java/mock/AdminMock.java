package mock;

import dtos.*;
import etos.LoginException;
import etos.NotFoundException;
import etos.UnexpectedErrorException;
import interfaces.AdminInterface;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by MS on 29-11-2016.
 */
public class AdminMock implements AdminInterface {

    public static HashMap<Long, DepartureDetail> map = new HashMap<>();

    private long counter;

    public AdminMock() {

        RouteSummary rs1 = new RouteSummary(30, "Greymouth Harbor", "Whitehaven Harbor", 0);
        RouteSummary rs2 = new RouteSummary(45, "Hermite Creek Piers", "Oceanview Harbor", 1);
        DepartureDetail dt1 = new DepartureDetail(LocalDateTime.now(), rs1, 0);
        DepartureDetail dt2 = new DepartureDetail(LocalDateTime.now(), rs2, 1);

        map.put(1l, dt1);
        map.put(2l, dt2);

        counter = map.size();
    }

    @Override
    public AdminDetail login(String s, String s1) throws LoginException, UnexpectedErrorException {
        if (s == null || s1 == null) {
            throw new UnexpectedErrorException("Variables cannot be null");
        }
        if (s.equals("user") && s1.equals("password")) {
            return new AdminDetail("user", "password");
        }
        throw new LoginException("Username or password is incorrect, try user : password ;)");
    }

    @Override
    public DepartureIdentifier createDeparture(RouteIdentifier routeIdentifier, LocalDateTime localDateTime) throws UnexpectedErrorException {
        counter++;
        RouteSummary routeSummary = (RouteSummary) routeIdentifier;
        DepartureDetail departureDetail = new DepartureDetail(localDateTime, routeSummary, counter);
        DepartureIdentifier identifier = map.put(counter, departureDetail);
        if (identifier == null) {
            throw new UnexpectedErrorException("Couldn't created departure");
        }
        return identifier;
    }

    @Override
    public List<DepartureIdentifier> getAllDepartures() throws UnexpectedErrorException {
        //if NO database connection ect, throw UnexpectedErrorException.
        return new ArrayList<>(map.values());
    }

    @Override
    public DepartureIdentifier getDeparture(long l) throws NotFoundException, UnexpectedErrorException {
        DepartureIdentifier departureIdentifier = map.get(l);
        if (departureIdentifier == null) {
            throw new NotFoundException("Departure not found");
        }
        return departureIdentifier;
    }

    @Override
    public DepartureIdentifier updateDeparture(DepartureIdentifier departureIdentifier) throws NotFoundException, UnexpectedErrorException {
        //Missing id?
        if (departureIdentifier == null) {
            throw new UnexpectedErrorException("departureIdentifier cannot be null");
        }
        DepartureDetail departureDetail = (DepartureDetail) departureIdentifier;
        DepartureIdentifier identifier = map.put(1l, departureDetail);
        if (departureIdentifier == null) {
            throw new NotFoundException("Departure not found");
        }
        return identifier;
    }

    @Override
    public DepartureIdentifier deleteDeparture(long l) throws NotFoundException, UnexpectedErrorException {
        DepartureIdentifier departureIdentifier = map.remove(l);
        if (departureIdentifier == null) {
            throw new NotFoundException("Departure not found");
        }
        return departureIdentifier;
    }
}
