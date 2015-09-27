package someExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Launcher {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		List<String> tests = Arrays.asList("A", "B", "C", "D");
		final int thread_count = 1;

		for (int j = 0; j < tests.size(); j = j + thread_count) {
			ExecutorService pool = Executors.newFixedThreadPool(thread_count);
			List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
			for (int i = 0; i < thread_count; i++) {
				if (i + j == tests.size())
					return;
				Callable<Integer> d = new Demo(tests.get(i + j));
				Future<Integer> f = pool.submit(d);
				futures.add(f);
			}
			for (Future<Integer> f : futures) {
				f.get();
			}
			pool.shutdown();
			System.out.println("Joined");
		}

	}
}
 class Demo implements Callable<Integer> {
	String tests;

	Demo(String tests) {
		this.tests = tests;
	}

	@Override
	public Integer call() throws Exception {

		System.out.println("Started " + tests);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Stop");

		return null;
	}
}
