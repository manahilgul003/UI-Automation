package junit5tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsTest_Hamcrest {
   
    @Test
    void assertForMapTest(){
        Map<String,Integer> theMap= new HashMap<>();
        theMap.put("firstKey",1);
        theMap.put("secondKey",2);
        theMap.put("thirdKey",3);
        assertThat(theMap, hasValue(2));

        assertThat(theMap, hasKey("secondKey"));

    }
    @Test
    void assertForList(){
        List<String> theList = Arrays.asList("firstString","secondString");
        assertThat(theList, hasItems("firstString"));


    }
    @Test
    void assertForAnyof(){
        List<String> theList = Arrays.asList("firstString","secondString");
        assertThat(theList, anyOf(Matchers.hasItem("firstString"),Matchers.hasItem("thirdString")));


    }
    @Test
    void assertForContainsAnyOrder(){
        List<String> theList = Arrays.asList("firstString","secondString");
        assertThat(theList, containsInAnyOrder("secondString","firstString"));


    }


}
