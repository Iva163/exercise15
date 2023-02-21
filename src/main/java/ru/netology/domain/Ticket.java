package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String airportFrom;
    protected String airportTo;
    protected int timeTravel;


    public Ticket(int id, int price, String airportFrom, String airportTo, int timeTravel) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.timeTravel = timeTravel;
    }

    public int getId() {
        return id;
    }

    public int getTimeTravel() {
        return timeTravel;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean matches(String from, String to) {
        if (airportFrom.contains(from) && airportTo.contains(to)) {
            return true;
        } else {
            return false;
        }
    }


}
