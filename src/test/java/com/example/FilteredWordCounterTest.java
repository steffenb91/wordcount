package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FilteredWordCounterTest {

	private FilteringWordCounter filteredWordCounter;
	@Mock
	private WordFilter filter;

	@BeforeEach
	public void setup() {
		this.filteredWordCounter = new FilteringWordCounter(filter);
	}
	@Test
	public void shouldCompile() {
		when(filter.filter(anyCollection())).thenReturn(List.of("Mary", "had", "little", "lamb"));
		int actual = filteredWordCounter.count("Mary had a little lamb");
		verify(filter).filter(anyCollection());
		assertThat(actual, is(4));
	}
}
