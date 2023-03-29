package practice;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class InvocationCount_practice {
	@Test(invocationCount = 1)
	public void create() {
		System.out.println("create");
		
	}
	@Test(dependsOnMethods = "create")
	public void update() {
		System.out.println("upddate");
	}
	@Test
	public void delete() {
		System.out.println("delete");
	}

}
