package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ParameterizedTests_CSV {
   
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
