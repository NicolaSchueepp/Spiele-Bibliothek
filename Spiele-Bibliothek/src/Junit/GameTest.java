package Junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Spiel;

public class GameTest {
	private static Spiel a;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GameTest.a = new Spiel();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		GameTest.a = null;
	}

	@Test
	public void test() {
		final String gameName = "testGameName";
		a.setBezeichnung(gameName);
		Assert.assertEquals(gameName, a.getBezeichnung());
	}

}
