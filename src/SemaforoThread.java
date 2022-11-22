
public class SemaforoThread implements Runnable {

	public Semaforo semaforo;
	private Thread thread;
	
	public SemaforoThread(Semaforo semaforo) {
		super();
		this.semaforo = semaforo;
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(5000);
				semaforo.cambiarColor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

}
