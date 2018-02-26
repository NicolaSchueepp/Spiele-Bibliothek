package Junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Spiel;

public class GameNameTest {
	private static Spiel a;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GameNameTest.a = new Spiel();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		GameNameTest.a = null;
	}

	@Test
	public void test() {
		final String gameName = "testGameName";
		a.setBezeichnung(gameName);
		Assert.assertEquals(gameName, a.getBezeichnung());
	}

}
