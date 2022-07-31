package com.example;

import java.util.Collection;

public interface WordFilter {

    Collection<String> filter(Collection<String> input);
}
