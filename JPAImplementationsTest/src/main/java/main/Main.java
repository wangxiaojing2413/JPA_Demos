package main;

public class Main {
	public static void main(String[] args) {
		JPAManager jpam = new JPAManager();
		jpam.getEntityManager().close();

		System.out.println("Starting threads...");

		// Inserting threads
		for (int i = 1; i <= 2; i++) {
			(new Thread(new JPAInsertingThread(i))).start();
		}
		// Querying threads
		for (int i = 1; i <= 18; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			(new Thread(new JPAQueryingThread(i))).start();
		}
		System.out.println("Sending stop signal to threads and waiting 15 minutes........................");
		JPAQueryingThread.setStop(true);
		JPAInsertingThread.setStop(true);

	}
}