package com.zoezhou.markovtext.model;

import com.zoezhou.markovtext.MarkovTextApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarkovTextApplication.class)
@WebAppConfiguration
public class WordNodeTest {

    @MockBean
    private RandomCollection randomCollection;

    @Before
    public void setUp() {
        Mockito.when(randomCollection.next()).thenReturn("banana");
    }

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
        Assert.assertEquals(nextWords.size(), 2);
        Assert.assertTrue( nextWords.keySet().containsAll(nextkeySet));
        Assert.assertEquals(nextWords.get("banana").intValue(), 3);
        Assert.assertEquals(nextWords.get("orange").intValue(), 2);
        Assert.assertEquals(wordNode.getRandomNextWord(), "banana");
    }
}
