import java.awt.Color;
import java.awt.Graphics;

public class Semaforo {

	int xPos,yPos;
	int oldColor = 0;
	int numColor;
	int dimensionColor = 20;
	
	public Semaforo(int xPos, int yPos, int numColor) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.numColor = numColor;
	}
	
    public void dibujar(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(this.xPos, this.yPos, 30,80);
    	
    	
    	// color rojo
    	g.setColor(numColor == 0 ? Color.RED : Color.GRAY);
    	g.fillRect(this.xPos+5, this.yPos+ (dimensionColor + 5) * 0 + 5 ,dimensionColor,dimensionColor);
    	
    	// color amarillo
    	g.setColor(numColor == 1 ? Color.YELLOW : Color.GRAY);
    	g.fillRect(this.xPos+5, this.yPos+(dimensionColor + 5) * 1 + 5,dimensionColor,dimensionColor);
    	
    	// color verde
    	g.setColor(numColor == 2 ? Color.GREEN : Color.GRAY);
    	g.fillRect(this.xPos+5, this.yPos+(dimensionColor + 5) * 2 + 5 ,dimensionColor,dimensionColor);
    }
	
    public void cambiarColor() {
    	if(numColor == 0 || numColor == 2) {
    		oldColor = numColor;
    		numColor = 1;
    	} else {
    		if(oldColor == 0) {
    			numColor = 2;
    		}else {
    			numColor = 0;
    		}
    	}
    }

	
	
}
