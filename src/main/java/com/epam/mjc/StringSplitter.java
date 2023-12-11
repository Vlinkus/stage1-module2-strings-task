package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String del : delimiters) stringBuilder.append(del);
        StringTokenizer tokenizer = new StringTokenizer(source, stringBuilder.toString());
        List<String> stringList = new ArrayList<>();
        while(tokenizer.hasMoreElements()) stringList.add(tokenizer.nextToken());
        return stringList;
    }
}
