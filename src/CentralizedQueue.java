public class CentralizedQueue {

    private static CentralizedQueue instance;
    private int currentQueueNumber;
  
    private CentralizedQueue() {
        this.currentQueueNumber = 0;
    }
  
    public static synchronized CentralizedQueue getInstance() {
        if (instance == null) {
            instance = new CentralizedQueue();
        }
        return instance;
    }
  
    public synchronized int getNextQueueNumber() {
        currentQueueNumber++;
        return currentQueueNumber;
    }

    public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber;
    }
  
    public synchronized void resetQueueNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Queue number cannot be negative.");
        }
        this.currentQueueNumber = number;
        System.out.println("[System] Queue number has been reset to: " + number);
    }
}
