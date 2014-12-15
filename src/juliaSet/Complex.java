package juliaSet;

public class Complex {
	private double a;
	private double b;
	
	public Complex(double a, double b) {
		this.a=a;
		this.b=b;
	}
	
	public Complex(double a) {
		this.a=a;
		this.b=0;
	}
	
	public double real() {
		return a;
	}
	
	public double imaginary() {
		return b;
	}
	
	public Complex add(Complex other) {
		double newA=a+other.a;
		double newB=b+other.b;
		return new Complex(newA, newB);
	}
	
	public Complex subtract(Complex other) {
		double newA=a-other.a;
		double newB=b-other.b;
		return new Complex(newA, newB);
	}
	
	public Complex multiply(Complex other) {
		double newA=a*other.a-b*other.b;
		double newB=a*other.b+b*other.a;
		return new Complex(newA, newB);
	}
	
	public Complex pow(int x) {
		Complex newComplex=new Complex(1);
		
		for(int i=0;i<x;i++) {
			newComplex=newComplex.multiply(this);
		}
		
		return newComplex;
		
	}
	
	public double abs() {
		return Math.sqrt(a*a+b*b);
	}
	
	
}
