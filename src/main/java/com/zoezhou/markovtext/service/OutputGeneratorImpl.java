package com.zoezhou.markovtext.service;

import com.zoezhou.markovtext.model.WordNode;
import com.zoezhou.markovtext.model.WordSet;

public class OutputGeneratorImpl implements OutputGenerator {
    private WordSet wordSet;

    public OutputGeneratorImpl(WordSet wordSet) {
        this.wordSet = wordSet;
    }

    @Override
    public String generateText(String prefix, int numWords) {
        if (numWords < 0) {
            return null;
        }
        StringBuilder output = new StringBuilder();
        WordNode prev = wordSet.getWordNode(prefix);
        if (prev == null) {
            return null;
        }
        for (int i = 0; i < numWords; i++) {
            String word = prev.getRandomNextWord();
            output.append(word);
            output.append(" ");
            prev = wordSet.getWordNode(word);
        }
        return output.toString();
    }
}
