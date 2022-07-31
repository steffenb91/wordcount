package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StopwordFilterTest {

	@Test
	public void shouldCountWords() {
		Collection<String> stopWords = Collections.singleton("a");
		StopwordFilter withStopwordWordCounter = new StopwordFilter(stopWords);
		Collection<String> input = List.of("Mary", "had", "a", "little", "lamb");

		Collection<String> expected = List.of("Mary", "had", "little", "lamb");

		assertThat(withStopwordWordCounter.filter(input), is(expected));
	}
}
