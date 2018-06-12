package ru.job4j.thread;

import org.junit.Test;
import java.io.IOException;
import java.util.*;


public class ParallelSearchTest {

    @Test
    public void whenParallelSearchTest() throws IOException {
        String root = "/Users/oscomp/test";
        String text = "job4j";
        List<String> exts = new ArrayList<>(Arrays.asList("txt"));
        ParallelSearch parallelSearch = new ParallelSearch(root, text, exts);
        parallelSearch.init();
        List<String> res = parallelSearch.result();
        System.out.println(res);
    }
}
