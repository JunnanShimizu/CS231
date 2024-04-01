/**
 * File: WordFrequency.java
 * Author: Junnan Shimizu
 * Date: 11/08/2021
 */

import java.io.IOException;

//used to test the writeWordCountFile method and the readWordCountFile method
public class WCTester {
    public static void main(String[] args) throws IOException {
        WordCounter test = new WordCounter();
        WordCounter copy = new WordCounter();
        test.analyze("/Users/junnanshimizu/IdeaProjects/WordFrequency/src/counttest");
        test.writeWordCountFile("counts_ct.txt");
        copy.readWordCountFile("counts_ct.txt");
        copy.writeWordCountFile("counts_ct_v2.txt");
    }
}
