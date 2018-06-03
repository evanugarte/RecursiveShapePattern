import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
   @author Evan Ugarte
   @version 1.0
*/

public class RecursionSquares extends JPanel{

	private final static int WIDTH = 500, HEIGHT = 500;
	private int MIN_SIZE = 2, START_SIZE = 250;

	
	public RecursionSquares(int max, int min) {
		super();
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		START_SIZE = max;
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
		JFrame frame = new JFrame("Recursive Squares!");
		JLabel startLbl = new JLabel();
		startLbl.setText("Indicate Shape Start Size:");
		JLabel endLbl = new JLabel();
		endLbl.setText("Indicate Smallest Shape Size:");
		JLabel errLbl = new JLabel();
		errLbl.setText("Please Enter A Positive Numeric Value");
		JTextField startSize = new JTextField(20);
		JButton startBtn = new JButton("Start");
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(startLbl);
		//frame.getContentPane().add(endLbl);
		frame.getContentPane().add(startSize);
		frame.getContentPane().add(startBtn);
		frame.getContentPane().add(errLbl);
		errLbl.setVisible(false);
		startBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  String startVal = startSize.getText();
				  if(isInt(startVal)){
					  RecursionSquares panel = new RecursionSquares(Integer.parseInt(startVal), 
							  2);
					  frame.setContentPane(panel);
					  frame.invalidate();
					  frame.validate();
				  }else {
					  errLbl.setVisible(true);
				  }
			  }
			});
		frame.pack();
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
