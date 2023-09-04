package com.tobywall.comparable_comparator;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    //A static final PRICE_ORDER comparator, which is an instance of the Comparator<Seat> interface.
    //It is used to compare Seat objects based on their prices.
    //The Collections.sort method is employed to sort a list of seats based on the PRICE_ORDER comparator.
    //This demonstrates how a custom comparator can be used to sort objects in a specific order different
    //from their natural ordering.
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2){
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()){
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    ;

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                   price = 14.00; 
                } else if ((row > 'F') || (seatNum < 4) || seatNum > 9){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else{
            System.out.println("There is no seat " + seatNumber);
        return false;
        }

        //INNER WORKINGS OF THE BINARY SEARCH ABOVE
        // int low = 0;
        // int high = seats.size()-1;

        // while (low <= high) {
        //     System.out.print(".");
        //     int mid = (low + high) / 2;
        //     Seat midVal = seats.get(mid);
        //     int cmp = midVal.getSeatNumber().compareTo(seatNumber);

        //     if (cmp < 0) {
        //         low = mid + 1;
        //     } else if (cmp > 0) {
        //         high = mid - 1;
        //     } else {
        //         return seats.get(mid).reserve();
        //     }
        // }
        
    }

    // for testing
    public Collection<Seat> getSeats() {
        return seats;
    }

    //Comparable interface: It overrides the compareTo method to define the natural ordering of seats based
    //on their seat numbers (case-insensitive).
    //This allows instances of the Seat class to be compared and sorted using methods like Collections.sort
    //or Collections.reverse.
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        //we're sorting by seat number
        //must override compareTo()
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
