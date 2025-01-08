package CoffeeShop;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    Queue<String> orderQueue;
    int capacity;

    public CoffeeShop(int capacity){
        orderQueue = new LinkedList<String>();
        this.capacity = capacity;
    }

    public synchronized void placeOrder(String order) {
        while (orderQueue.size()==capacity){
            try {
                System.out.println("waiting, queue is full");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        orderQueue.add(order);
        System.out.println("Customer "+Thread.currentThread().getName()+
                " ordered: "+ order);
        notifyAll();
    }

    public synchronized String prepareOrder()  {
        while (orderQueue.isEmpty()){
            try {
                System.out.println("waiting, queue is empty");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String order = orderQueue.poll();
        notifyAll();
        return order;
    }

}
