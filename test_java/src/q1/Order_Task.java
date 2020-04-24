package q1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Order_Task {

	public class Worker implements Callable<Worker> {
	    Object content;
	    public Worker(Object content) {
	        super();
	        this.content = content;
	    }

	    public Worker call() throws Exception {
	        // getContent() + do your processing
	        return this;
	    }
	}
	public class Producer implements Runnable {
	    private static final int THREADS_TO_USE = 0;

		public Producer() {
	        super();
	        ArrayBlockingQueue<Future<Worker>> workerQueue = new ArrayBlockingQueue<Future<Worker>>(THREADS_TO_USE);
	        ExecutorCompletionService<Worker> completionService = new ExecutorCompletionService<Worker>(Executors.newFixedThreadPool(THREADS_TO_USE));
	        Thread workerThread = new Thread(new Producer(workerQueue));
	        workerThread.start();
	    }

	    public Producer(ArrayBlockingQueue<Future<Worker>> workerQueue) {
			// TODO Auto-generated constructor stub
		}

		public void send(Object o) throws Exception {
	        Worker workItem = new Worker(o);
	        ExecutorCompletionService<Worker> completionService = null;
			Future<Worker> future = completionService.submit(workItem);
	        ArrayBlockingQueue<Future<Worker>> workerQueue = null;
			workerQueue.put(future);
	    }
	}
}