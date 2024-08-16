import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.util.Collections;
import java.util.List;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        findPlanesLeavingInTheNextTwoHours(airport);

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals().stream()
                .flatMap(t -> t.getFlights().stream())
                .filter(d -> d.getDate().after(Date.from(Instant.now())) &&
                                        d.getDate().before(Date.from(Instant.now()
                                                        .plus(2,ChronoUnit.HOURS)))
                        && d.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());
    }
}
