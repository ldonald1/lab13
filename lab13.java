import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class lab13 {
	
	ArrayList<Integer> intValues = new ArrayList<>();
	
	public void readData(String filename)
	{
		
		try 
		{
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String inn;
			
				while((inn = input.readLine()) != null)
				{
					StringTokenizer st = new StringTokenizer(inn, "\n");
	                while(st.hasMoreTokens())
	                {
	                    // Parse data from string
	                    int currentVal = Integer.parseInt(st.nextToken());
	                    intValues.add(currentVal);
	                }
				}
				input.close();
		}
		catch(Exception e){}
	}
	public long getTotalCount()
	{
		return intValues.stream().count();
	}
	public long getOddCount()
	{
		return intValues.stream().filter(x -> x%2 == 1).count();
	}
	public long getEvenCount()
	{
		return intValues.stream().filter(x -> x%2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount()
	{
		return intValues.stream().distinct().filter(x -> x > 5).count();
	}
	public Integer[] getResult1()
	{
		return intValues.stream().sorted().filter(x -> x % 2 == 0 && x > 5 && x < 50).toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return intValues.stream().map(x -> x * x * 3).limit(50).toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return intValues.stream().filter(x -> x % 2 != 0).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}		
}
