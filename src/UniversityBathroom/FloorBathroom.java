package UniversityBathroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FloorBathroom {
    private static final int BATHROOM_STALLS = 6;
    private static final int NUM_EMPLOYEES = 100;

    public static void main(String[] args) {

        Semaphore stalls = new Semaphore(BATHROOM_STALLS);

        // Use an ExecutorService to simulate 100 users
        ExecutorService executor = Executors.newFixedThreadPool(NUM_EMPLOYEES);

        for (int i = 1; i <= NUM_EMPLOYEES; i++) {
            int employeeId = i;
            executor.execute(() -> useBathroom(employeeId, stalls));
        }
        executor.shutdown();
    }

    private static void useBathroom(int employeeId, Semaphore stalls) {
        try {
            System.out.println("Employee "+employeeId+" is waiting to use a stall");
            stalls.acquire(); // Acquire a stall
            System.out.println("Employee "+employeeId+" is using a stall");
            Thread.sleep(500);     // Simulate the time taken to use the stall
            System.out.println("Employee "+employeeId+" has finished using the stall");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Employee "+employeeId+" was interrupted");
        } finally {
            stalls.release();  // Release the stall for others to use
        }
    }
}

