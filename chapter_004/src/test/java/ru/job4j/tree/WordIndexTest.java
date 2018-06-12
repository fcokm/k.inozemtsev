package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class WordIndexTest {
    private WordIndex wordIndex;
    private String filename;
    private String seachWord;
    private Set<Integer> expect;


    @Before
    public void beforeTest() {
        wordIndex = new WordIndex();
        filename = "/Users/oscomp/word.txt";
        seachWord = "java";
        expect = new HashSet<>();
        expect.add(40);
        expect.add(284);
        expect.add(77);
    }

    @Test
    public void whenLoadFileThenFindPositionInFileForSeachWord() {
        WordIndex wordIndex = new WordIndex();
        wordIndex.loadFile(filename);
        Set<Integer> result = wordIndex.getIndexes4Word(seachWord);
        assertThat(result, is(expect));
    }
    @Test
    public void whenLoadFileThenNotFindSeachWordResultNull() {
        WordIndex wordIndex = new WordIndex();
        wordIndex.loadFile(filename);
        seachWord = "jv";
        Set<Integer> result = wordIndex.getIndexes4Word(seachWord);
        assertNull(result);
    }
}
