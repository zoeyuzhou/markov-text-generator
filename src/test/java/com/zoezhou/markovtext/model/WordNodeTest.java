package com.zoezhou.markovtext.model;

import com.zoezhou.markovtext.MarkovTextApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarkovTextApplication.class)
@WebAppConfiguration
public class WordNodeTest {

    @Test
    public void testWordNode() {
        Set<String> nextkeySet = new HashSet<>();
        nextkeySet.add("banana");
        nextkeySet.add("orange");

        WordNode wordNode = new WordNode("apple");
        wordNode.addNextWord("banana");
        wordNode.addNextWord("banana");
        wordNode.addNextWord("banana");
        wordNode.addNextWord("orange");
        wordNode.addNextWord("orange");
        wordNode.getRandomNextWord();

        Map<String,Integer> nextWords = wordNode.getNextWords();
        Assert.assertEquals(2, nextWords.size());
        Assert.assertTrue( nextWords.keySet().containsAll(nextkeySet));
        Assert.assertEquals(3, nextWords.get("banana").intValue());
        Assert.assertEquals(2, nextWords.get("orange").intValue());
    }
}
