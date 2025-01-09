package UniversityBathroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FloorBathroom {
    private static final int BathroomStalls = 6;  //6 stalls
    private static final int NumOfEmployees = 100; //100 employees

    public static void main(String[] args) {

        Semaphore stalls = new Semaphore(BathroomStalls); //creating semaphore

        //ExecutorService creating 100 employees
        ExecutorService executor = Executors.newFixedThreadPool(NumOfEmployees);

        for (int i = 1; i <= NumOfEmployees; i++) {
            int employeeId = i;
            executor.execute(() -> usingBathroom(employeeId, stalls));
        }
        executor.shutdown();
    }

    private static void usingBathroom(int employeeId, Semaphore stalls) {
        try {
            System.out.println("Employee "+employeeId+" is waiting to use a stall");
            stalls.acquire(); // Acquire a stall
            System.out.println("Employee "+employeeId+" is using a bathroom stall");
            Thread.sleep(500);     //time takes to use the stall
            System.out.println("Employee "+employeeId+" has finished using the stall");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Employee "+employeeId+" was interrupted");
        } finally {
            stalls.release();  // Release the stall for others to use
        }
    }
}

