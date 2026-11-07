public class Main {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println(" Pag-ibig Office Centralized Queuing System ");
        System.out.println("============================================\n");

        HelpDeskStation station1 = new HelpDeskStation(1);
        HelpDeskStation station2 = new HelpDeskStation(2);
        HelpDeskStation station3 = new HelpDeskStation(3);

        // Create the online monitor
        OnlineMonitor monitor = new OnlineMonitor();

        System.out.println("--- Issuing Queue Numbers ---");
        station1.issueQueueNumber(); // Queue #1
        station2.issueQueueNumber(); // Queue #2
        station1.issueQueueNumber(); // Queue #3
        station3.issueQueueNumber(); // Queue #4
        station2.issueQueueNumber(); // Queue #5

        System.out.println();
        System.out.println("--- Online Monitor Check ---");
        monitor.displayCurrentQueueNumber();

        System.out.println();
        System.out.println("--- Queue Reset by Station 2 (reorganization scenario) ---");
        station2.resetQueue(10);

        System.out.println();
        System.out.println("--- Continuing after Reset ---");
        station1.issueQueueNumber(); 
        station3.issueQueueNumber(); 

        System.out.println();
        System.out.println("--- Online Monitor Check after Reset ---");
        monitor.displayCurrentQueueNumber();

        System.out.println();
        System.out.println("--- Brief Real-Time Monitoring Simulation (3 polls) ---");
        monitor.startMonitoring(3, 500);

        System.out.println();
        System.out.println("============================================");
        System.out.println(" System session complete.");
        System.out.println("============================================");
    }
}
