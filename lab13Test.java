import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lab13Test {
	
	lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";
	
	@BeforeEach
	void setUp() throws Exception {
		lab = new lab13();
		lab.readData(inputFilename);
		ArrayList<ArrayList<Integer>> jTestList = new ArrayList<>();
		for( int k = 0; k < 3; k++ )
		{
			jTestList.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int j = 0; j < jTestList.size(); j++ )
			{
				ArrayList<Integer> currentjTestList = jTestList.get(j); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentjTestList.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				jTestList.set(j, currentjTestList);
				System.out.println("jTestList.get(" + j + ").size() = " + jTestList.get(j).size());
			}
			input.close();
			
			// put code here to populate expectedResult1 with the values in jTestList.get(0)
			// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
			expectedResult1 = new Integer[jTestList.get(0).size()];
			for (int p = 0; p < jTestList.get(0).size(); p++) 
			{
				expectedResult1[p] = jTestList.get(0).get(p);
			}
			
			
			// put code here to populate expectedResult2 with the values in jTestList.get(1)
			// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
			expectedResult2 = new Integer[jTestList.get(1).size()];
			for (int n = 0; n < jTestList.get(1).size(); n++) 
			{
				expectedResult2[n] = jTestList.get(1).get(n);
			}
			
			
			// put code here to populate expectedResult3 with the values in jTestList.get(2)
			// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
			expectedResult3 = new Integer[jTestList.get(2).size()];
			for (int o = 0; o < jTestList.get(2).size(); o++) 
			{
				expectedResult3[o] = jTestList.get(2).get(o);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	@Test
	public void getTotalCountTest() {
		assertEquals(lab.getTotalCount(), 1000);
	}
	
	@Test
	public void getOddCount() {
		assertEquals(lab.getOddCount(), 507);
	}
	
	@Test
	public void getEvenCount() { 
		assertEquals(lab.getEvenCount(), 493);
	}
	
	@Test
	public void getDistinctGreaterThanFiveCount() {
		assertEquals(lab.getDistinctGreaterThanFiveCount(), 94);
	}
	
	@Test
	public void getResult1() {
		assertArrayEquals(lab.getResult1(), expectedResult1);	
	}
	
	@Test
	public void getResult2() {
		assertArrayEquals(lab.getResult2(), expectedResult2);	
	}
	
	@Test
	public void getResult3() {
		assertArrayEquals(lab.getResult3(), expectedResult3);	
	}
	

}
