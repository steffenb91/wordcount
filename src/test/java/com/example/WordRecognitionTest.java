package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class WordRecognitionTest {

	@Test
	public void shouldRecognizeWords() {
		String text = "a text to recognize words in";
		Collection<String> actualValue = new WordRecognition().recognizeWords(text);
		assertThat(actualValue, hasItems("a", "text", "to", "recognize", "words", "in"));
	}
}
