package CoffeeShop;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    Queue<String> orderQueue;   //buffer
    int capacity;

    public CoffeeShop(int capacity){
        orderQueue = new LinkedList<String>();
        this.capacity = capacity;
    }

    public synchronized void placeOrder(String order) {
        while (orderQueue.size()==capacity){ //checking if the queue is full
            try {
                System.out.println("waiting, queue is full");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        orderQueue.add(order);   //adding order to buffer
        System.out.println("Customer "+Thread.currentThread().getName()+
                " ordered: "+ order);
        notifyAll();
    }

    public synchronized String prepareOrder()  {
        while (orderQueue.isEmpty()){  //checking if the queue is empty
            try {
                System.out.println("waiting, queue is empty");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String order = orderQueue.poll();  //removing order from buffer
        notifyAll();
        return order;
    }

}
