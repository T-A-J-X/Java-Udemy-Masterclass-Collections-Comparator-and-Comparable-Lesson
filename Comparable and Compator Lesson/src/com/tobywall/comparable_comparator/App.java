package com.tobywall.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Theatre tuchinski = new Theatre("Tuchinski", 8, 12);

        if (tuchinski.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("D12 is unavailable");
        }

        if (tuchinski.reserveSeat("B12")) {
            System.out.println("Please pay for B12");
        } else {
            System.out.println("B12 is unavailable");
        }

        //Demonstrating Collections.reverse method
        List<Theatre.Seat> reverseSeats = new ArrayList<>(tuchinski.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(tuchinski.getSeats());
        priceSeats.add(tuchinski.new Seat("B00", 13.00));
        priceSeats.add(tuchinski.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list){
            System.out.println(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("===========================");
    }
}

