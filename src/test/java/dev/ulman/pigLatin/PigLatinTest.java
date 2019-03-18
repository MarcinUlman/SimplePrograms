package dev.ulman.pigLatin;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dev.ulman.pigLatin.PigLatin;

public class PigLatinTest {
	PigLatin piglatin;
	
	@Before
	public void setUp() {
		piglatin = new PigLatin();
	}

	@Test
	public void vowelsTranslateForLognWordTest() {
		Assert.assertThat("alwaysway", Matchers.comparesEqualTo(piglatin.vowelsTranslate("always")));
	}
	
	@Test
	public void vowelsTranslateForShortWordTest() {
		Assert.assertThat("Iway", Matchers.comparesEqualTo(piglatin.vowelsTranslate("I")));
	}
	
	@Test
	public void consonantTranslateTest() {
		Assert.assertThat("appyhay", Matchers.comparesEqualTo(piglatin.consonantTranslate("happy")));
	}
	
	@Test
	public void clustersTranslateTest() {
		Assert.assertThat("ilesmay", Matchers.comparesEqualTo(piglatin.clustersTranslate("smile")));
	}

	@Test
	public void translateUseClustersTranslateTest() {
		Assert.assertThat(piglatin.clustersTranslate("glove"), Matchers.comparesEqualTo(piglatin.translate("glove")));
	}
	
	@Test
	public void translateUseConsonantTranslateTest() {
		Assert.assertThat(piglatin.consonantTranslate("happy"), Matchers.comparesEqualTo(piglatin.translate("happy")));
	}
	
	@Test
	public void translateUseVowelsTranslateTest() {
		Assert.assertThat(piglatin.vowelsTranslate("explain"), Matchers.comparesEqualTo(piglatin.translate("explain")));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void translateWordBeginingNumberTest() {
		piglatin.translate("5pigs");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void translateWordBeginingSpecialTest() {
		piglatin.translate("@word");
	}
	
	@Test
	public void makeLatinTest() {
		Assert.assertThat("igpay ootay ilesmay orestay eatway Iway ", Matchers.comparesEqualTo(piglatin.makeLatin("pig too smile store eat I")));
	}
	@Test
	public void makeLatinEmptyStringTest() {
		Assert.assertThat(" ", Matchers.comparesEqualTo(piglatin.makeLatin("")));
	}
}
