//From Dr. O'Neil. This program prints the infinite pairs according to the diagonalization theory per George Canter.
public class PairLister
{
	public void listAll()
	{
		long counter = 0;
		long sum = 0;
		while (sum >= 0)
		{
			for (long i = 0; i <= sum; i++)
			{
				NaturalPair nextpair = new NaturalPair(i, sum-i);
				System.out.print("" + counter + ":");
				nextpair.print();
				System.out.println();
				counter++;
			}
			sum++;
		}
	}
	
	public NaturalPair numToPair(long index)
	{
		long counter = 0;
		long sum = 0;
		while (sum >= 0)
		{
			for (long i = 0; i <= sum; i++)
			{
				NaturalPair nextpair = new NaturalPair(i, sum-i);
				if (index == counter)
					return nextpair;
				counter++;
			}
			sum++;
		}
		return null;
	}
	
	public long pairToNum(NaturalPair pair)
	{
		long counter = 0;
		long sum = 0;
		while (sum >= 0)
		{
			for (long i = 0; i <= sum; i++)
			{
				NaturalPair nextpair = new NaturalPair(i, sum-i);
				if (nextpair.equals(pair))
					return counter;
				counter++;
			}
			sum++;
		}
		return Long.MAX_VALUE;
	}	
	
	public static void main(String [] args)
	{
		PairLister p = new PairLister();
		if (args.length == 0)
			p.listAll();
		else if (args.length == 1)
		{
			long num = Long.parseLong(args[0]);
			System.out.print("" + num + " => ");
			p.numToPair(num).print();
			System.out.println();
		}
		else if (args.length ==2)
		{
			NaturalPair pair = new NaturalPair(Long.parseLong(args[0]), Long.parseLong(args[1]));
			pair.print();
			System.out.println(" => " + p.pairToNum(pair));
		}
	}
}

class NaturalPair
{
	long num1;
	long num2;
	
	public NaturalPair(long i, long j)
	{
		num1 = i;
		num2 = j;
	}
	
	public boolean equals(NaturalPair other)
	{
		return (num1 == other.num1 && num2 == other.num2);
	}	
	
	public void print()
	{
		System.out.print("(" + num1 + "," + num2 + ")");
	}
}
