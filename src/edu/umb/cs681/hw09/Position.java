package edu.umb.cs681.hw09;

import java.util.ArrayList;
import java.util.List;

public record Position(double latitude, double longitude, double altitude) {

    List<Double> coordinates() {
        List<Double> coordinate = new ArrayList<Double>();
        coordinate.add(latitude);
        coordinate.add(longitude);
        coordinate.add(altitude);
        return coordinate;
    }

    Position change(double newLat, double newLon, double newAlt){
        return new Position(newLat, newLon, newAlt);
    }

    boolean higherAltThan(Position anotherPosition){
        if(altitude>anotherPosition.altitude){
            return true;
        }
        else return false;
    }

    boolean lowerAltThan(Position anotherPosition){
        if(altitude<anotherPosition.altitude){
            return true;
        }
        else return false;
    }
    boolean northOf(Position anotherPosition){
        if(anotherPosition.longitude > longitude){
            return true;
        }
        else return false;
    }

    boolean southOf(Position anotherPosition){
        if(anotherPosition.longitude < longitude){
            return true;
        }
        else return false;
    }


}



