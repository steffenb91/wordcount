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

import java.util.ArrayList;
import java.util.Collection;

@ExtendWith(MockitoExtension.class)
public class ObservableWordCounterTest {
	
	private WordRecognition wordRecognition = new WordRecognition();

	private ObservableWordCounter observableWordCounter;
	@Mock
	private WordCountObserver uniqWordCountObserver;

	@BeforeEach
	public void setup() {
		this.observableWordCounter = new ObservableWordCounter(wordRecognition, uniqWordCountObserver);
	}

	@Test
	public void shouldNotifyObservers() {
		String text = "humpy-Dumpy sat on a wall. Humpy dumpy had a great fall.";
		observableWordCounter.count(text);
		verify(uniqWordCountObserver).notify(anyCollection());		
	}
}
