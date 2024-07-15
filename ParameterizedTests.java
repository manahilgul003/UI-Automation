package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {
    @ParameterizedTest(name="Run:{index} - value:{arguments}") //How many times the test will run(Size of array)
    @ValueSource(ints ={1,5,6}) //only one parameter can be passed(type)
    //Parametrized method
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }
    @ParameterizedTest
 @NullAndEmptySource //donot use with int,float,booleans
    @ValueSource(strings={"firstString","SecondString"})
    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }
}
