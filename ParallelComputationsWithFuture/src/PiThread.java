import java.util.concurrent.Callable;

public class PiThread implements Callable<Double>{
	private double [] table;
	private int index;
	private int myrank;
    private int myblock;
    double sum;
	double step;
	
	
	
	public PiThread(double[] array, int rank, int ind, int blck,double step) {
		table = array;
		index = ind;
		myrank = rank;
        myblock = blck;
        this.step=step;
	}
	

	public Double call() throws Exception {
		int stop = myrank*myblock + myblock;
		for(int i=index; i<stop; i++) {
			double x = ((double)table[i]+0.5)*step;
			sum += 4.0/(1.0+x*x);
		}
			
			
		return sum;
	}

}
