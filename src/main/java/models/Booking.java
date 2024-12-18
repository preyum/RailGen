package models;

public class Booking {
    private String passengerName;
    private String trainName;
    private String origin;       
    private String destination;  
    private int fare;

    // Constructor updated to reflect new field names
    public Booking(String passengerName, String trainName, int fare, String origin, String destination) {
        this.passengerName = passengerName;
        this.trainName = trainName;
        this.fare = fare;
        this.origin = origin;
        this.destination = destination;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

   
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
