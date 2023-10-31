package testng.org1;

import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	
	@Test (dataProvider = "sampleData")
	//@Parameters({"a","b"})
	public static void add(int a,int b) {
		int result = a+b;
		System.out.println(result);	
			}
	@DataProvider(name = "sampleData")
	private Object sampleData(){
		Object a[][] = {{10,20},{30,40},{50,60}};
		return a;
	}
}
