package CoffeeShop;

public class Barista extends Thread{

    private final CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop){
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run(){
        try {
            coffeeShop.prepareOrder();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
