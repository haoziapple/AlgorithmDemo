package com.haozi.demo.algorithm.audition;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class ExecutorTry
{
	class DirectExecutor implements Executor
	{
		@Override
		public void execute(Runnable r)
		{
			r.run();
		}
	}

	class ThreadPerTaskExecutor implements Executor
	{
		@Override
		public void execute(Runnable r)
		{
			new Thread(r).start();
		}
	}

	class SerialExecutor implements Executor
	{
		final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
		final Executor executor;
		Runnable active;

		SerialExecutor(Executor executor)
		{
			this.executor = executor;
		}

		@Override
		public synchronized void execute(final Runnable r)
		{
			tasks.offer(new Runnable()
			{
				public void run()
				{
					try
					{
						r.run();
					}
					finally
					{
						scheduleNext();
					}
				}
			});
			if (active == null)
			{
				scheduleNext();
			}
		}

		protected synchronized void scheduleNext()
		{
			if ((active = tasks.poll()) != null)
			{
				executor.execute(active);
			}
		}
	}
}
