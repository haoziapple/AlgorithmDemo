package com.haozi.demo.algorithm.java;

import java.util.Collection;
import java.util.List;

public class SourceCollection
{
	public static <AnyType> void print(Collection<AnyType> coll)
	{
		for (AnyType item : coll)
			System.out.println(item);
	}

	public static void makeList1(List<Integer> lst, int N)
	{
		lst.clear();
		for (int i = 0; i < N; i++)
			lst.add(i);
	}

	public static void makeList2(List<Integer> lst, int N)
	{
		lst.clear();
		for (int i = 0; i < N; i++)
			lst.add(0, i);
	}
	
}
