package Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Bewertung;


public class BewertungTest {
	private static Bewertung b;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BewertungTest.b = new Bewertung();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BewertungTest.b = null;
	}

	@Test
	public void test() {
		final int bewertungGame = 4;
		final int fBewertungGame = 3;
		final int game_ID = 1;
		final int benutzer_ID = 2;
		b.setBewertung(bewertungGame);
		Assert.assertNotEquals(b.getBewertung(), fBewertungGame);
		Assert.assertEquals(b.getBewertung(), bewertungGame);
	}

}
