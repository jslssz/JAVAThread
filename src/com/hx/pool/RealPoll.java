package com.hx.pool;

import java.util.concurrent.*;

/**
 * 策略1：AbortPolicy，超过直接报异常
 * 策略2：CallerRunsPolicy，超过返回给main线程
 * 策略3：DiscardPolicy，直接放弃执行不了的
 * 策略3：DiscardOldestPolicy，放弃等待很久的
 */
public class RealPoll {
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 5, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
		try{
			for (int i = 1; i < 20; i++) {
				int finalI = i;
				threadPoolExecutor.execute(() ->{
					System.out.println(Thread.currentThread().getName()+"\t"+"处理"+ finalI +"号业务");
				});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			threadPoolExecutor.shutdown();
		}
	}
}
