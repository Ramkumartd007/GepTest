package testng.org1;

import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterDemo {

	
	@Test 
	@Parameters({"a","b"})
	public static void add(int a,int b) {
		int result = a+b;
		System.out.println(result);	
			}
	}

