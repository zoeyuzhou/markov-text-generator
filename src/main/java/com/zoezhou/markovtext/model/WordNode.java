package com.zoezhou.markovtext.model;

import java.util.HashMap;
import java.util.Map;

public class WordNode {
    // The word that is linking to the next words
    private String word;

    private Map<String, Integer> nextWords;

    private RandomCollection<String> randomNextWordCollection;

    WordNode(String word)
    {
        this.word = word;
        nextWords = new HashMap<>();
    }

    public String getWord()
    {
        return word;
    }

    public void addNextWord(String word)
    {
        if ( nextWords.containsKey(word) ) {
            nextWords.put(word, nextWords.get(word)+1);
        } else {
            nextWords.put(word, 1);
        }
    }

    private void setRandomNextWordCollection() {
        if( randomNextWordCollection == null ) {
            randomNextWordCollection = new RandomCollection<>();
        }

        nextWords.forEach((k,v)->
                randomNextWordCollection.add(v,k)
        );
    }

    public Map<String, Integer> getNextWords() {
        return nextWords;
    }

    public String getRandomNextWord()
    {
        setRandomNextWordCollection();
        return randomNextWordCollection.next();
    }
}
