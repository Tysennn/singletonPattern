public class OnlineMonitor {
    private CentralizedQueue queue;
  
    public OnlineMonitor() {
        this.queue = CentralizedQueue.getInstance();
    }

    public void displayCurrentQueueNumber() {
        int current = queue.getCurrentQueueNumber();
        System.out.println("[Online Monitor] Current queue number being served: " + current);
    }
  
    public void startMonitoring(int polls, long intervalMs) {
        System.out.println("[Online Monitor] Starting real-time monitoring...");
        for (int i = 0; i < polls; i++) {
            displayCurrentQueueNumber();
            try {
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Online Monitor] Monitoring interrupted.");
                break;
            }
        }
        System.out.println("[Online Monitor] Monitoring session ended.");
    }
}
