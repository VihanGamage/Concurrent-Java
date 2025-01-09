package CoffeeShop;

public class CoffeeShopExample {

    public static void main(String[] args) throws InterruptedException {
        CoffeeShop coffeeShop = new CoffeeShop(4);  //queue size is 4
        Customer customer1 = new Customer(coffeeShop);
        Customer customer2 = new Customer(coffeeShop);
        Customer customer3 = new Customer(coffeeShop);

        Barista barista1 = new Barista(coffeeShop);

        customer1.start(); //customer threads runs
        customer2.start(); //customer threads runs
        customer3.start(); //customer threads runs
        barista1.start();  //barista threads runs

        customer1.join();
        customer2.join();
        customer3.join();
        barista1.join();

        System.out.println("Main Thread Terminated");
        System.out.println("Queue: "+coffeeShop.orderQueue);
    }
}
