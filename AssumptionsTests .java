package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTests {
    @ParameterizedTest(name="Run:{index} - value:{arguments}") //How many times the test will run(Size of array)
    @ValueSource(ints ={1,5,6}) //only one parameter can be passed(type)
        //Parametrized method
    void intValues(int theParam){
        assumeTrue(theParam>4);
        System.out.println("theParam = " + theParam);
    }  @ParameterizedTest
    //for larger no of parameter values
    @CsvSource(value = {"Peter,Parker","black,widow","tony,stark"})
    void csvSource_StringString(String param1, String param2){
        assumeFalse(param1.equals("peter"),"The assumption failed for the "+"following param2"+param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value={"peter,40,false","black,32,true","tony,5,false"})
    void csvSource_StringIntBoolean(String param1,int param2, boolean param3){
       assumingThat(param2>20,()->System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", paramm3 = " + param3);
    }

}
