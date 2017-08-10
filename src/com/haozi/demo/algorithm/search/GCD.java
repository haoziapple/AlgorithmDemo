package com.haozi.demo.algorithm.search;

/**
 * @className:com.haozi.demo.algorithm.search.GCD
 * @description:欧几里得算法计算最大公因数
 * @version:v1.0.0
 * @date:2016年9月21日 下午5:31:32
 * @author:WangHao
 */
public class GCD
{
	public static long gcd(long m, long n)
	{
		while (n != 0)
		{
			long rem = m % n;
			m = n;
			n = rem;
		}
		return m;
	}
}
