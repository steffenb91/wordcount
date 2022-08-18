package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class WordRecognitionTest {

	@Test
	public void shouldRecognizeWords() {
		String text = "a text to recognize words in";
		Collection<String> actualValue = new WordRecognition().recognizeWords(text);
		assertThat(actualValue, hasItems("a", "text", "to", "recognize", "words", "in"));
	}

	@Test
	void shouldApplyFilter() {
		String text = "a text to recognize words in";
		WordFilter wordFilterMock = mock(WordFilter.class);
		new WordRecognition().withFilter(wordFilterMock).recognizeWords(text);
		verify(wordFilterMock).filter(anyCollection());
	}
}
