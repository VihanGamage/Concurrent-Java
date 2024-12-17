package CoffeeShop;

public class CoffeeShopExample {

    public static void main(String[] args) throws InterruptedException {
        CoffeeShop coffeeShop = new CoffeeShop(4);
        Customer customer1 = new Customer(coffeeShop);
        Customer customer2 = new Customer(coffeeShop);
        Customer customer3 = new Customer(coffeeShop);

        Barista barista1 = new Barista(coffeeShop);

        customer1.start();
        customer2.start();
        customer3.start();
        barista1.start();

        customer1.join();
        customer2.join();
        customer3.join();
        barista1.join();

        System.out.println("Main Thread Terminated");
        System.out.println("Queue: "+coffeeShop.orderQueue);
    }
}
