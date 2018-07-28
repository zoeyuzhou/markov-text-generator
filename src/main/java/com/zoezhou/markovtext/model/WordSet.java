package com.zoezhou.markovtext.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSet {

    private Set<WordNode> wordNodeSet;

    public WordSet(List<String> wordList) {
        this.wordNodeSet = buildWordNode(wordList);
    }

    private Set<WordNode> buildWordNode(List<String> words) {
        wordNodeSet = new HashSet<>();
        String starter = words.get(0);
        wordNodeSet.add(new WordNode(starter));
        for (int i = 1; i< words.size(); i++) {
            WordNode previousWordNode = getWordNode(words.get(i-1));
            if (previousWordNode == null) {
                previousWordNode = new WordNode(words.get(i-1));
                wordNodeSet.add(previousWordNode);
                previousWordNode.addNextWord(words.get(i));
            } else {
                previousWordNode.addNextWord(words.get(i));
            }
        }

        String last = words.get(words.size()-1);
        WordNode previousWordNode = getWordNode(last);
        if (previousWordNode == null) {
            previousWordNode = new WordNode(last);
            wordNodeSet.add(previousWordNode);
            previousWordNode.addNextWord(words.get(0));
        } else {
            previousWordNode.addNextWord(words.get(0));
        }

        return wordNodeSet;
    }

    public WordNode getWordNode(String word) {
        return wordNodeSet.stream()
                .filter(wn -> wn.getWord().equals(word))
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);
    }
}
