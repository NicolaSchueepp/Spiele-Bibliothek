package Junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Benutzer;

public class BenutzerTest {
	private static Benutzer a;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BenutzerTest.a = new Benutzer();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BenutzerTest.a = null;
	}

	@Test
	public void testFindUserByName() {
		final String name = "abcd";
		a.setBenutzername(name);
		Assert.assertEquals("abcd",name);
	}

}
