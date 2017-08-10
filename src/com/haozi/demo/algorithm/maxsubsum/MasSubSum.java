package com.haozi.demo.algorithm.maxsubsum;

/**
 * @className:com.haozi.demo.algorithm.maxsubsum.MasSubSum
 * @description:Cubic maximum contiguous subsequence sum
 * @version:v1.0.0
 * @date:2016年9月21日 下午4:03:13
 * @author:WangHao
 */
public class MasSubSum
{
	/**
	 * O(N3)
	 */
	public static int maxSubSum1(int[] a)
	{
		int maxSum = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = i; j < a.length; j++)
			{
				int thisSum = 0;

				for (int k = i; k <= j; k++)
				{
					thisSum += a[k];
				}

				if (thisSum > maxSum)
				{
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

	/**
	 * O(N2)
	 */
	public static int maxSubSum2(int[] a)
	{
		int maxSum = 0;

		for (int i = 0; i < a.length; i++)
		{
			int thisSum = 0;
			for (int j = i; j < a.length; j++)
			{
				thisSum += a[j];
				if (thisSum > maxSum)
				{
					maxSum = thisSum;
				}
			}
		}

		return maxSum;
	}

	/**
	 * Recursive maximum contiguous subsequence sum algorithm. Finds maximux sum
	 * in subarray spanning a[left...right]. Does not attempt to maintain actual
	 * best sequence.
	 */
	private static int maxSumRec(int[] a, int left, int right)
	{
		if (left == right) // Base case
			if (a[left] > 0)
				return a[left];
			else
				return 0;

		int center = (left + right) / 2;
		int maxLeftSum = maxSumRec(a, left, center);
		int maxRightSum = maxSumRec(a, center + 1, right);

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--)
		{
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++)
		{
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}

		return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}

	/**
	 * 查找三个int的最大值
	 */
	private static int max3(int i, int j, int k)
	{
		return i > j ? (i > k ? i : k) : (j > k ? j : k);
	}

	/**
	 * Driver for divide-and-conquer maximum contiguous subsequence sum
	 * algorithm. O(NlogN)
	 */
	public static int maxSubSum3(int[] a)
	{
		return maxSumRec(a, 0, a.length - 1);
	}

	/**
	 * Linear-time contiguous subsequence sum algorithm.
	 */
	public static int maxSubSum4(int[] a)
	{
		int maxSum = 0, thisSum = 0;

		for (int j = 0; j < a.length; j++)
		{
			thisSum += a[j];

			if (thisSum > maxSum)
				maxSum = thisSum;
			else if (thisSum < 0)
				thisSum = 0;
		}

		return maxSum;
	}

	public static void main(String[] args)
	{
		int[] a = { 2, 35, -3, 44, -67 };
		System.out.println(max3(1, 4, 4));
		System.out.println(maxSubSum4(a));
	}
}
