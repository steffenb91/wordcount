package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.io.File;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class TextfileStopWordReaderTest {

	private File textfileWithStopwords = new File("src/test/resources/stopwords.txt");

	@Test
	public void shouldGetStopwords() throws StopWordListReadFailedException {
		TextfileStopWordReader textfileStopWordReader = new TextfileStopWordReader(textfileWithStopwords);
		Collection<String> actualValue = textfileStopWordReader.getStopwords();
		assertThat(actualValue, hasItem("a"));
	}
}
