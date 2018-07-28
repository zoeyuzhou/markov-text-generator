package com.zoezhou.markovtext.service;

import com.zoezhou.markovtext.model.WordSet;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
public class MarkovChainService {

    public String getMarkovChainText(InputStream inputStream, String prefix, Integer outputSize) {
        String result;
        WordListGenerator wordListGenerator = new WordListGeneratorImpl(inputStream);
        WordSet wordSet = new WordSet(wordListGenerator.getWordList());
        OutputGenerator outputGenerator = new OutputGeneratorImpl(wordSet);

        result = outputGenerator.generateText(prefix,outputSize);
        return result;
    }

}
