import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Carro {

	int xPos, yPos;
	int VELOCIDAD = 50;
	String path;

	public Carro(int xPos, int yPos, String path) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.path = path; 
	}

	public void dibujar(Graphics g) {
		Image imagenInterna = new ImageIcon(getClass().getResource(this.path)).getImage();
		g.drawImage(imagenInterna, this.xPos, this.yPos, null);
	}
}
