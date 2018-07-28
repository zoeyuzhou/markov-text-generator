package com.zoezhou.markovtext.service;

import com.zoezhou.markovtext.model.WordNode;

import java.util.Set;

public interface OutputGenerator {
    String generateText(String prefix, int numWords);
}
