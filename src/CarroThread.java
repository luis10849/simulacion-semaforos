
public class CarroThread implements Runnable {

	public Semaforo semaforo;
	public Carro carro;
	public int V = 2;
	public int direccion;
	private Thread thread;
	public int x,y;

	public CarroThread(Carro carro, Semaforo semaforo, int direccion) {
		super();
		this.semaforo = semaforo;
		this.carro = carro;
		this.direccion = direccion;
		this.x = carro.xPos;
		this.y = carro.yPos;
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {

			try {
				Thread.sleep(5);
				
			    if((carro.xPos < semaforo.xPos - 96 && carro.yPos < semaforo.yPos - 48) || (carro.xPos > semaforo.xPos - 96 || carro.yPos > semaforo.yPos - 48)) {
			    	this.moverse();
			    } else {
			    	if(semaforo.numColor == 2 || semaforo.numColor == 1 && semaforo.oldColor == 2){
			    		this.moverse();
			    	}   	
			    }
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		}
	}
	
	public void moverse() {
		if (direccion == 1) {
			carro.yPos += V;
		} else {
			carro.xPos += V;
		}
		if(carro.yPos >= 800 || carro.xPos >= 1000) {
			carro.yPos = this.y;
			carro.xPos = this.x;
		}
	}

}
