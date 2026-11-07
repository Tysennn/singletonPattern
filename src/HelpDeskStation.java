public class HelpDeskStation {
    private int stationId;
    private CentralizedQueue queue;
  
    public HelpDeskStation(int stationId) {
        this.stationId = stationId;
        this.queue = CentralizedQueue.getInstance();
    }

    public int issueQueueNumber() {
        int number = queue.getNextQueueNumber();
        System.out.println("[Station " + stationId + "] Issued queue number: " + number);
        return number;
    }

    public void resetQueue(int number) {
        System.out.println("[Station " + stationId + "] Requesting queue reset to: " + number);
        queue.resetQueueNumber(number);
    }

    public int getStationId() {
        return stationId;
    }
}
