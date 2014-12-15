package juliaSet;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class JuliaSetFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	protected static final int IMAGE_WIDTH = 550;
	protected static final int IMAGE_HEIGHT = 550;
	private ImagePanel imagePanel=new ImagePanel();
	private JTextField real;
	private JTextField imag;
	private JButton draw;
	private JToolBar tb;
	
	private double a=0, b=0;
	
	public JuliaSetFrame() {
		tb=new JToolBar();
		real=new JTextField("0", 5);
		imag=new JTextField("0", 5);
		
		draw=new JButton("Draw");
		ActionListener drawListener=new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				a=Double.valueOf(real.getText());
				b=Double.valueOf(real.getText());
				
				JuliaSet j=new JuliaSet(a,b);
				Image i=j.map(IMAGE_WIDTH, IMAGE_HEIGHT);
				
				imagePanel.addImage(i);
			}
		};
		draw.addActionListener(drawListener);
		
		tb.add(real);
		tb.add(imag);
		tb.add(draw);
		
		JuliaSet j=new JuliaSet(0,0);
		Image i=j.map(IMAGE_WIDTH, IMAGE_HEIGHT);
		
		imagePanel.addImage(i);
		
		setLayout(new BorderLayout());
		add(imagePanel, BorderLayout.CENTER);
		add(tb, BorderLayout.NORTH);
	}

	public static void main(String args[]) {
		JuliaSetFrame frame=new JuliaSetFrame();
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Julia Set");
		frame.setVisible(true);
	}
}
