package CoffeeShop;

public class Customer extends Thread {

    private final CoffeeShop coffeeShop;

    public Customer(CoffeeShop coffeeShop){
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run(){
        try {
            coffeeShop.placeOrder("coffee");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
