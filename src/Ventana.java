
import javax.swing.*;

public class Ventana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame = new JFrame();
        Juego juego = new Juego();
        frame.setBounds(0,0,1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Simulador semaforos");
        frame.add(juego);
        frame.setVisible(true);
        juego.start();
	}

}
