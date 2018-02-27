package com.haozi.demo.algorithm.audition;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTry
{
	private Future<String> future;

	interface ArchiveSearcher
	{
		String search(String target);
	}

	public static class App
	{
		ExecutorService executor = Executors.newFixedThreadPool(5);

		ArchiveSearcher searcher = new ArchiveSearcher()
		{

			@Override
			public String search(String target)
			{
				try
				{
					Thread.sleep(5000L);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				return "search result:" + target + new Date();
			}
		};

		void showSearch(final String target) throws InterruptedException
		{
			Callable<String> call = new Callable<String>()
			{
				@Override
				public String call()
				{
					return searcher.search(target);
				}
			};
			Future<String> future = executor.submit(call);
			FutureTask<String> future2 = new FutureTask<String>(call);
			executor.execute(future2);

			displayOtherThings(); // do other things while searching
			try
			{
				displayText(future.get()); // use future
				displayText(future2.get());
			}
			catch (ExecutionException ex)
			{
				cleanup();
				return;
			}
		}

		private void cleanup()
		{
			// TODO Auto-generated method stub
		}

		private void displayText(Object object)
		{
			System.out.println(object);
		}

		private void displayOtherThings()
		{
			for (int i = 0; i < 5; i++)
			{
				System.out.println("display: " + new Date());
				try
				{
					Thread.sleep(1000L);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException
	{
		App app = new FutureTry.App();
		app.showSearch("test");
	}
}
