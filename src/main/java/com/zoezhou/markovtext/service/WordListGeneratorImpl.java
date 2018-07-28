package com.zoezhou.markovtext.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<String> getWordListFromFile(Path path) {
        List<String> wordList = new ArrayList<>();

        //read file into stream, try-with-resources
        try (Stream<String> lines = Files.lines(path)) {
            wordList = lines.map(s-> Arrays.asList(s.split("[ ]+")))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }
}
