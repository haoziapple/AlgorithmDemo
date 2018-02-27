package com.haozi.demo.algorithm.generic;

import java.util.Comparator;

public class FindMax
{
	// Generic findMax, with a function object
	// 函数对象
	public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp)
	{
		int maxIndex = 0;

		for (int i = 1; i < arr.length; i++)/*-?|add|Administrator|c0|?*/
		{
			if (cmp.compare(arr[i], arr[maxIndex]) > 0)
			{
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}

	static class CaseInsensitiveCompare implements Comparator<String>/*-?|add|Administrator|c1|*/
	{
		@Override
		public int compare(String lhs, String rhs)
		{
			return lhs.compareToIgnoreCase(rhs);
		}
	}/*-|add|Administrator|c1|?*/

	public static void main(String[] args)
	{
		String[] arr = { "ZEBRA", "alligator", "crocodile" };
		System.out.println(findMax(arr, new CaseInsensitiveCompare()));
	}

}
