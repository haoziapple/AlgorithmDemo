package com.haozi.demo.algorithm.audition;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTry
{
	// producer
	static class Producer implements Runnable
	{
		private final BlockingQueue<String> queue;

		Producer(BlockingQueue<String> q)
		{
			queue = q;
		}

		@Override
		public void run()
		{
			try
			{
				while (true)
				{

					queue.put(produce());

				}
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		String produce()
		{
			try
			{
				Thread.sleep(1000L);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return new Date().toString();
		}
	}

	// consumer
	static class Consumer implements Runnable
	{
		private final BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> q)
		{
			queue = q;
		}

		@Override
		public void run()
		{
			try
			{
				while (true)
				{
					consume(queue.take());
				}
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		void consume(String x)
		{
			try
			{
				Thread.sleep(2000L);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Now is:" + new Date() + " produce Date:" + x);
		}
	}

	public static void main(String[] args)
	{
		BlockingQueue<String> q = new ArrayBlockingQueue<String>(20);
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}
