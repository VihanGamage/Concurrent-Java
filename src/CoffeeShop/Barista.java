package CoffeeShop;

public class Barista extends Thread{

    private final CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop){
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run(){
        try {
            System.out.println("Barista "+Thread.currentThread().getName()+
                    " prepared order: "+coffeeShop.prepareOrder());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
