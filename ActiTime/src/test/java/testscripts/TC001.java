package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 extends BaseTest {
//bharath
	@Test(description = "add task and verify the task")
	public void test() {
		extraTimeTrackerPage.CreatenewTask("New Customer", "Toyota", "Ravindo Toyota", "car brake Task", "100", 
											"30", "April", "2022", "manufacturing");
		Assert.assertTrue(extraTimeTrackerPage.verifyTheTaskCreated("car brake Task"), "task created mismatch");
	}
}
//trail for merge confilt