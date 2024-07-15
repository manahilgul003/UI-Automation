package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class paramProvider {
    static Stream<Arguments> sourceStream_StringDouble(){
        return Stream.of(arguments("tomato",2.0), arguments("potato",3.0), arguments("cabbage",2.5));
    }
  static   List<Arguments> sourceList_StringDouble(){
        ////processing
        return Arrays.asList(arguments("tomato",2.0), arguments("potato",3.0), arguments("cabbage",2.5));
    }
   static List<String> sourceString() {
        //processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }
    static Stream<String> sourceStringAsStream(){
        return Stream.of("beetroot","apple","pear");

    }
}
