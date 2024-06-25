package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basetest.BaseTest;

public class LoginPageTest extends BaseTest{

	@DataProvider
	public Object[][] loginTestData(){
		List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();
		Map<String, String> testdataMap1 = new HashMap<>();
		testdataMap1.put("username", "student");
		testdataMap1.put("password", "Password123");
		testdataMap1.put("successMsg", "Logged In Successfully");
		Map<String, String> testdataMap2 = new HashMap<>();
		testdataMap2.put("username", "incorrectUser");
		testdataMap2.put("password", "Password123");
		testdataMap2.put("errorMsg", "Your username is invalid!");
		Map<String, String> testdataMap3 = new HashMap<>();
		testdataMap3.put("username", "student");
		testdataMap3.put("password", "incorrectPassword");
		testdataMap3.put("errorMsg", "Your password is invalid!");
		listOfMaps.add(testdataMap1);
		listOfMaps.add(testdataMap2);
		listOfMaps.add(testdataMap3);
		Object[][] testData = new Object[1][1];
		testData[0][0] = listOfMaps;
		return testData;
	}
	
	@Test(dataProvider = "loginTestData")
	public void doLoginTest(List<Map<String, String>> data) {
		System.out.println(data);	
		for(int i=0; i<data.size(); i++) {
			String msg = loginPage.doLogin(data.get(i).get("username"), data.get(i).get("password"));
			System.out.println(msg);
		}
		
		
	}
	
}
