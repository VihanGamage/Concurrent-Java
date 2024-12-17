package CoffeeShop;

public class Barista extends Thread{

    private final CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop){
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run(){
        coffeeShop.prepareOrder();
    }
}
