package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordCounterTest {

	private SimpleWordCounter filteredWordCounter;
	@Mock
	private WordRecognition wordRecognition;

	@BeforeEach
	public void setup() {
		this.filteredWordCounter = new SimpleWordCounter(wordRecognition);
	}

	@Test
	public void shouldCountWords() {
		when(wordRecognition.recognizeWords(anyString())).thenReturn(List.of("Mary", "had", "little", "lamb"));
		Collection<WordCountResult> actual = filteredWordCounter.count("Mary had a little lamb");
		verify(wordRecognition).recognizeWords(anyString());
		assertThat(actual, is(Collections.singletonList(new WordCountResult("Number of words", 4))));
	}
}
