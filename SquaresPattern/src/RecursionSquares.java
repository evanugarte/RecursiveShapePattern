import java.awt.*;
import javax.swing.*;
/**
   @author Evan Ugarte
   @version 1.0
*/

public class RecursionSquares extends JPanel {

private final static int WIDTH = 500, HEIGHT = 500, START_SIZE = 200, MIN_SIZE = 15;
	
	public RecursionSquares() {
		super();
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));

	}
	
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		recursionSquare(pen, WIDTH/4, HEIGHT/4, START_SIZE);
	}
	
	public void recursionSquare(Graphics pen, int x, int y, int size) {
		if(size > MIN_SIZE) {
			drawSquareByPoint(pen, x, y, size);
			recursionSquare(pen, x - size/4, y - size/4, size / 2);
			recursionSquare(pen, x - size/4 + size, y - size/4, size / 2);
			recursionSquare(pen, x - size/4, y - size/4 + size, size / 2);
			recursionSquare(pen, x - size/4 + size, y - size/4 + size, size / 2);
		}
	}
	
	public void drawSquareByPoint(Graphics pen, int x, int y, int size) {
			pen.setColor(Color.black);
			pen.drawRect(x, y, size, size);
			pen.setColor(new Color(220,170,122));
			pen.fillRect(x, y, size, size);
	}
	
	
	public static void main(String[] args) {
		RecursionSquares panel = new RecursionSquares();
	
		JFrame frame = new JFrame("Recursive Squares!");
		frame.getContentPane().add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
