package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ParameterizedTests_CSV {
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
    @ParameterizedTest
    //for larger no of parameter values
    @CsvSource(value = {"Peter,Parker","black,widow","tony,stark"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value={"peter,40,false","black,32,true","tony,77,false"})
    void csvSource_StringIntBoolean(String param1,int param2, boolean paarm3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", paarm3 = " + paarm3);
    }
    @ParameterizedTest
    @CsvSource(value={"SpiderMan,'Peter,Parker'","IronMan,'tony,stark'"})
void csvSource_StringWithComa(String param1,String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value={"Steve?rogers","bucky?barnes"},delimiter='?')
    void csvSourse_StringWithSiffDelimiter(String param1,String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

}
