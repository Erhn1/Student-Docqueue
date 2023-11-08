package project;

import java.util.LinkedList;
import java.util.Queue;

public class ReservationQueue {
    private Queue<String> reservationQueue;

    public ReservationQueue() {
        reservationQueue = new LinkedList<>();
    }

    public void enqueue(String reservation) {
        reservationQueue.offer(reservation);
    }

    public String dequeue() {
        return reservationQueue.poll();
    }

    public boolean isEmpty() {
        return reservationQueue.isEmpty();
    }

    public int size() {
        return reservationQueue.size();
    }

    public String peek() {
        return reservationQueue.peek();
    }
}
