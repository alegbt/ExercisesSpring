package co.develhope.customqueries1.services;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.enums.Status;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    public void do50Flights(){
        int i=0;
        Random r = new Random();
        while(i<50){
            flightRepository.save(new Flight(
                    randomStr(6),
                    randomStr(6),
                    randomStr(6),
                    Status.ONTIME
                    )
            );
            i++;
        }
    }


    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static String randomStr(int length){
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for(int i=0; i<length; i++){
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }


}







