package com.zoezhou.markovtext.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WordListGeneratorImpl implements WordListGenerator {
    private InputStream inputStream;

    public WordListGeneratorImpl(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<String> getWordList() {
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .parallel()
                .map(s-> Arrays.asList(s.split("[ ]+")))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
