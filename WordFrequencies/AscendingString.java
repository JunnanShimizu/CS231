/**
 * File: WordFrequency.java
 * Author: Junnan Shimizu
 * Date: 11/08/2021
 */

import java.util.Comparator;

//used to compare keys int eh BSTMap class
public class AscendingString implements Comparator<String>{
    public int compare(String a, String b){
        return a.compareTo(b);
    }
}
