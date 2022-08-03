package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TextfileInputHandlerTest {
	
	private File inputFile = new File("src/test/resources/input.txt");

	@Test
	public void shouldGetUserInput() throws GetUserInputFailedException {
		TextfileInputHandler textfileInputHandler = new TextfileInputHandler(inputFile);
		String actualValue = textfileInputHandler.getUserInput();
		assertThat(actualValue, is("Mary had a little lamb"));
	}

	@Test
	public void shouldThrowOnError() {
		TextfileInputHandler textfileInputHandler = new TextfileInputHandler(new File("src/notexisting.txt"));
		assertThrows(GetUserInputFailedException.class, () -> textfileInputHandler.getUserInput());
	}
}
