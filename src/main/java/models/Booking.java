package models;

public class Booking {
    private String passengerName;
    private String trainName;

    public Booking(String passengerName, String trainName) {
        this.passengerName = passengerName;
        this.trainName = trainName;
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
}
