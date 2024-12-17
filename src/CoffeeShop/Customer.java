package CoffeeShop;

public class Customer extends Thread {

    private final CoffeeShop coffeeShop;

    public Customer(CoffeeShop coffeeShop){
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run(){
        coffeeShop.placeOrder("coffee");
    }
}
