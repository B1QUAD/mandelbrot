public class complexNum {

	double real, img;

	public complexNum() {
		real = 0;
		img = 0;
	}

	public complexNum(double r, double i) {
		real = r;
		img = i;
	}

	public double getReal() {
		return real;
	}

	public double getImaginary() {
		return img;
	}

	public void setReal(double in) {
		real = in;
	}

	public void setImaginary(double in) {
		img = in;
	}
	//https://stackoverflow.com/a/24555176
	public complexNum multiply(complexNum z1, complexNum z2) {
		double _real = z1.getReal() * z2.getReal() - z1.getImaginary() * z2.getImaginary();
		double _imaginary = z1.getReal() * z2.getImaginary() + z1.getImaginary() * z2.getReal();
		return new complexNum(_real, _imaginary);

	}

//	public complexNum multiply(complexNum cn2) {
//		double e = (this.getReal() * cn2.getReal()) + (this.getImaginary() * cn2.getImaginary());
//		double f = (this.getReal() * cn2.getImaginary()) + (this.getImaginary() + cn2.getReal());
//		return new complexNum(e, f);
//	}

	public complexNum add(complexNum cn1, complexNum cn2) {
		return new complexNum(cn1.getReal() + cn2.getReal(), cn1.getImaginary() + cn2.getImaginary());
	}
}
