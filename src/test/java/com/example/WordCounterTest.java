package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WordCounterTest 
{

    @Test
    public void shouldCountAllWords()
    {
        WordCounter wordCounter = new TotalWordsCounter();
        assertThat(wordCounter.count("A sample sentence."), is(3));
    }
}
