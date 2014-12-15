package juliaSet;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;

public class JuliaSet {
	private static final int MAX_STEPS = 32;
	private static final double FWIDTH = 4;
	private static final double FHEIGHT = 4;
	private Complex c;
	
	public JuliaSet(double real, double imag) {
		c=new Complex(real, imag);
	}
	
	public Image map(int w, int h) {
		int[] pixels=new int[w*h];
		
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				double a=i*FWIDTH/w-FWIDTH/2;
				double b=j*FHEIGHT/h-FHEIGHT/2;
				Complex point=new Complex(a,b);
				
				int n=0;
				while(n<MAX_STEPS && point.abs()<2) {
					point=point.pow(2).add(c);
					n++;
				}
				
				if(point.abs()<2)
					pixels[j*w+i]=Color.black.getRGB();
				else
					pixels[j*w+i]=getColor(n);
			}
		}
		
		MemoryImageSource source = new MemoryImageSource(w,h,pixels,0,w);
		Image image = Toolkit.getDefaultToolkit().createImage(source);
		
		return image;
	}

	private int getColor(int n) {
		return Color.getHSBColor((float) n/(MAX_STEPS),1,1).getRGB();
	}

	
	
}
