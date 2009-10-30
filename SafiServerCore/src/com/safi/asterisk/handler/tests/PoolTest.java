package com.safi.asterisk.handler.tests;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolTest {
	private ThreadPoolExecutor executor;
	
	public PoolTest() {
		executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>(10+10), new RejectedExecutionHandler() {
					
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.err.println("Oh shit runna "+((Runna)r).num+" couldn't git dunn!");
					}
				});
  }
	
	public void test(){
		int i = 0;
		for (; i < 31; i++){
			System.err.println("Trying to start thread "+(i+1));
			executor.execute(new Runna(i+1));
		}
		System.err.println("Trying to start last thread "+(i+1));
		executor.execute(new Runna(i+1));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PoolTest test = new PoolTest();
		test.test();

	}
	
	
	class Runna implements Runnable {
		private int num;
		public Runna(int i){
			this.num = i;
		}
		public void run() {
			System.err.println("job "+num+" starting...");
			try {
        Thread.sleep(10000);
      } catch (Exception e) {
      }
			System.err.println("job "+num+" exiting...");
		};
	}

}
