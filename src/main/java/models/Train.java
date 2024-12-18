package models;

public class Train {
    private String name;
    private int fare;

    public Train(String name, int fare) {
        this.name = name;
        this.fare = fare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
