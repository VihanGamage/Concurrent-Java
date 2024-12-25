package UniversityBathroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FloorBathroom {
    private static final int BATHROOM_STALLS = 6;
    private static final int NUM_USERS = 100;

    public static void main(String[] args) {

        Semaphore stalls = new Semaphore(BATHROOM_STALLS);

        // Use an ExecutorService to simulate 100 users
        ExecutorService executor = Executors.newFixedThreadPool(NUM_USERS);

        for (int i = 1; i <= NUM_USERS; i++) {
            int userId = i;
            executor.execute(() -> useBathroom(userId, stalls));
        }

        // Shutdown the executor after all tasks are submitted
        executor.shutdown();
    }

    private static void useBathroom(int userId, Semaphore stalls) {
        try {
            // User tries to acquire a stall
            System.out.println("User " + userId + " is waiting to use a stall.");
            stalls.acquire(); // Acquire a stall

            System.out.println("User " + userId + " is using a stall.");
            // Simulate the time taken to use the stall
            Thread.sleep(500);
            System.out.println("User " + userId + " has finished using the stall.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("User " + userId + " was interrupted.");
        } finally {
            // Release the stall for others to use
            stalls.release();
        }
    }
}

