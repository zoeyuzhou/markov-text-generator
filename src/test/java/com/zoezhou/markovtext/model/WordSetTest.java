package com.zoezhou.markovtext.model;

import com.zoezhou.markovtext.MarkovTextApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarkovTextApplication.class)
@WebAppConfiguration
public class WordSetTest {
    @Test
    public void testGetWordNode() {
        String[] words = {"apple","banana","cake","donut","eon"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);

        WordSet wordSet = new WordSet(wordList);

        WordNode wordNode = wordSet.getWordNode("apple");

        Assert.assertEquals("apple", wordNode.getWord());
        Assert.assertEquals("banana", wordNode.getRandomNextWord());
    }
}
