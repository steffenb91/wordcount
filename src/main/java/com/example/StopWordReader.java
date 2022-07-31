package com.example;

import java.util.Collection;

public interface StopWordReader {

    Collection<String> getStopwords() throws StopWordListReadFailedException;
}
