package tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basetest.BaseTest;

public class LoginPageTest extends BaseTest {

	@DataProvider(name = "hashmap_dp")
	public static Object[][] loginTestData() {
		List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();
		Map<String, String> testdataMap1 = new HashMap<>();
		testdataMap1.put("username", "student");
		testdataMap1.put("password", "Password123");
		testdataMap1.put("msg", "Logged In Successfully");
		Map<String, String> testdataMap2 = new HashMap<>();
		testdataMap2.put("username", "incorrectUser");
		testdataMap2.put("password", "Password123");
		testdataMap2.put("msg", "Your username is invalid!");
		Map<String, String> testdataMap3 = new HashMap<>();
		testdataMap3.put("username", "student");
		testdataMap3.put("password", "incorrectPassword");
		testdataMap3.put("msg", "Your password is invalid!");
		listOfMaps.add(testdataMap1);
		listOfMaps.add(testdataMap2);
		listOfMaps.add(testdataMap3);

		return new Object[][] { { listOfMaps } };
	}

	@Test(dataProvider = "hashmap_dp")
	public void doLoginTest(List<Map<String, String>> data) {
		// System.out.println(data);
		for (int i = 0; i < data.size(); i++) {
			String msg = loginPage.doLoginWithInCorrectData(data.get(i).get("username"), data.get(i).get("password"));
			Assert.assertEquals(msg, data.get(i).get("msg"));
		}

	}

	@Test(dataProvider = "hashmap_dp")
	public void doGenericLoginTest1(List<Map<String, String>> data) {
		for (int i = 0; i < data.size(); i++) {
			String msg = loginPage.doGenericLogin(data.get(i).get("username"), data.get(i).get("password"));
			System.out.println(msg);
			Assert.assertEquals(msg, data.get(i).get("msg"));
		}
	}

	@DataProvider(name = "iterator_dp")
	public Iterator<Object[]> loginTestData2() {
		Collection<Object[]> dataCollection = new ArrayList<Object[]>();
		List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();
		Map<String, String> testdataMap1 = new HashMap<>();
		testdataMap1.put("username", "student");
		testdataMap1.put("password", "Password123");
		testdataMap1.put("msg", "Logged In Successfully");
		Map<String, String> testdataMap2 = new HashMap<>();
		testdataMap2.put("username", "incorrectUser");
		testdataMap2.put("password", "Password123");
		testdataMap2.put("msg", "Your username is invalid!");
		Map<String, String> testdataMap3 = new HashMap<>();
		testdataMap3.put("username", "student");
		testdataMap3.put("password", "incorrectPassword");
		testdataMap3.put("msg", "Your password is invalid!");
		listOfMaps.add(testdataMap1);
		listOfMaps.add(testdataMap2);
		listOfMaps.add(testdataMap3);
		for (Map<String, String> maps : listOfMaps) {			
			dataCollection.add(maps.values().toArray(new Object[0]));	
		}
		return dataCollection.iterator();
	}

	@Test(dataProvider = "iterator_dp")
	public void doGenericLoginTest(Map<String, String> map) {
		String msg = loginPage.doGenericLogin(map.get("username"), map.get("password"));
		System.out.println(msg);
		Assert.assertEquals(msg, map.get("msg"));
	}

}
