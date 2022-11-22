import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Juego extends Canvas implements ActionListener, Runnable {

	private Thread thread;
	private boolean running = false;
	public static int xPos = 40, yPos = 40;
	public static int velX, velY;
	public static BufferStrategy bs;
	public static Graphics g;
	public static ArrayList<Semaforo> semaforos = new ArrayList<>();
	public static ArrayList<Carro> carros = new ArrayList<>();

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		Semaforo semaforo1 = new Semaforo(370, 450,2);
        Semaforo semaforo2 = new Semaforo(550, 220,0);
        new SemaforoThread(semaforo1).start();
        new SemaforoThread(semaforo2).start();	
        
        Carro carro1 = new Carro(-100, 350, "images/carroH.png");
		Carro carro2 = new Carro(450, -100, "images/carroV.png");
		new CarroThread(carro1, semaforo1, 0).start();
		new CarroThread(carro2, semaforo2, 1).start();
        
		carros.add(carro1);
		carros.add(carro2);
		
        semaforos.add(semaforo1);
        semaforos.add(semaforo2);
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.toString();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		while (running) {
			try {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while (delta >= 1) {

					delta--;
				}
				if (running) {
					paintComponent();
				}

				frames++;

				if (System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					System.out.println("FPS:  " + frames);
					frames = 0;
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
			}

		}
	}

	private void paintComponent() {
		bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// fondo
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1000, 800);

		// carretea vertical
		g.setColor(Color.GRAY);
		g.fillRect(400, 0, 150, 800);

		// carretea horizontal
		g.setColor(Color.GRAY);
		g.fillRect(0, 300, 1000, 150);
		
		for (Semaforo semaforo : semaforos) {
			semaforo.dibujar(g);
		}
		
		for (Carro carro : carros) {
			carro.dibujar(g);
		}
	 	
		g.dispose();
		bs.show();
	}
}
