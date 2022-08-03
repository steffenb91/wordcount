package com.example;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordCounterAppTest {
	
	@Mock
	private InputHandler inputHandler;
	@Mock
	private Messenger messenger;
	@Mock
	private WordCounter wordCounter;

	private WordCounterApp wordCounterApp;

	@BeforeEach
	public void setup() {
		this.wordCounterApp = new WordCounterApp(inputHandler, messenger, wordCounter);
	}
	@Test
	public void shouldRun() throws GetUserInputFailedException {
		String userInput = "A simple test";
		when(inputHandler.getUserInput()).thenReturn(userInput);
		wordCounterApp.run();
		verify(messenger, times(2)).print(anyString());
		verify(inputHandler).getUserInput();
		verify(wordCounter).count(userInput);
	}
}
