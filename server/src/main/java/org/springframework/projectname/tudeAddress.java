package org.springframework.projectname;

public class tudeAddress{
    public boolean isStartingPoint = false;
    public boolean isEndingPoint = false;

    private double lat;
    private double lon;

    tudeAddress(){}
    tudeAddress(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }

    tudeAddress(boolean isStartingPoint, boolean isEndingPoint, double lat, double lon) {
        this.isStartingPoint = isStartingPoint;
        this.isEndingPoint = isEndingPoint;
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat(){
        return lat;
    }
    public void setLat(double newLat){
        lat = newLat;
    }

    public double getLon(){
        return lon;
    }
    public void setLon(double newLon){
        lon = newLon;
    }

    @Override
    public String toString(){
        String retString = "";
        retString = String.valueOf(lat);
        retString += ",";
        retString += String.valueOf(lon);
        return retString;
    }

    @Override
    public boolean equals(Object otherObj){
        if (otherObj instanceof tudeAddress){
            tudeAddress otherAddress = (tudeAddress)otherObj;

            double otherLat = otherAddress.getLat();
            double otherLon = otherAddress.getLon();

            if (lat == otherLat && lon == otherLon){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }


}
