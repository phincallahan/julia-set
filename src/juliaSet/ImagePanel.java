package juliaSet;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel{
	 private JLabel imagelbl=new JLabel();

	 public ImagePanel() {
		 this.imagelbl.setHorizontalAlignment(JLabel.CENTER);
		 setLayout(new BorderLayout());
		 add(imagelbl, BorderLayout.CENTER);
	 }
	 
	 public void addImage(Image image) {
		 imagelbl.setIcon(new ImageIcon(image));
	 }


}
