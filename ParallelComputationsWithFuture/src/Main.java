import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class Main {

	public static void main(String[] args) {
		int numSteps = 10000000;
		double sum = 0.0;
		
		//table a (contains number of steps,more steps means more precise calculation)
		double[] a= new double[numSteps];
		for(int i = 0; i < numSteps; i++) {
			a[i] = i; 
		}
		
		//cores
		int cores = Runtime.getRuntime().availableProcessors();
		

		/* start timing */
		long startTime = System.currentTimeMillis();
	
		//step
		double step = 1.0 / (double)numSteps;
		
		//thread start
		int numTasks = 10*cores;
		
		ExecutorService executor= Executors.newFixedThreadPool(cores);
		
		ArrayList<Future<Double>> results= new ArrayList<Future<Double>>();
		for(int i=0;i<numTasks;i++) {
			Callable<Double> callable = new PiThread(a, i, i, i, step);
			Future<Double> future = executor.submit(callable);
			results.add(future);
			
		}
		executor.shutdown();
		for(Future<Double> r: results) {
			try {
				sum +=r.get();
				}
			catch (ExecutionException e) {System.err.println("should not happen");}
			catch (InterruptedException e) {System.err.println("should not happen");}
		
		}

		double pi = sum * step;

		/* end timing and print result */
		long endTime = System.currentTimeMillis();
		System.out.printf("sequential program results with %d steps\n", numSteps);
		System.out.printf("computed pi = %22.20f\n" , pi);
		System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
		System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);

	}

	

}
