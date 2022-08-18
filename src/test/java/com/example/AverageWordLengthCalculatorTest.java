package com.example;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AverageWordLengthCalculatorTest {

	private AverageWordLengthCalculator averageWordLengthCalculator;

	@BeforeEach
	public void setup() {
		this.averageWordLengthCalculator = new AverageWordLengthCalculator();
	}

	@Test
	public void shouldCalculateAverageWordLength() {
		Collection<String> words = List.of("A", "text", "for", "testing", "purposes");
		WordCountResult actualValue = averageWordLengthCalculator.notify(words);
		double expectedResult = 4.6;
		assertThat(actualValue.getResult(), is(String.format("average word length: %s", expectedResult)));

	}
}
