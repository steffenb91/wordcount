package com.example;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IndexPrinterTest {

	private IndexPrinter indexPrinter;
	@Mock
	private Messenger messenger;
	@Mock
	private WordRecognition wordRecognition;

	@BeforeEach
	public void setup() {
		this.indexPrinter = new IndexPrinter(wordRecognition, messenger);
	}
	@Test
	public void shouldPrintIndex() {
		String text = "Mary had a little lamb";
		when(wordRecognition.recognizeWords(text)).thenReturn(List.of("Mary", "had", "little", "lamb", "lamb"));
		indexPrinter.printIndex(text);
		verify(messenger).print("Index:\nhad\nlamb\nlittle\nMary\n");

	}
}
