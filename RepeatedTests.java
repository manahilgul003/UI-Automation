package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {
    @RepeatedTest(5)
    void firstRepeatedMethod(){
        System.out.println("We are repeating this test ");
    }
    @RepeatedTest(value =
    3,name = "Running repetition:{currentRepetition}."+"Total is:{totalRepetitions}")
   @DisplayName("This is a repeated test Method")
    void secondRepeatedMethod(){
        System.out.println("We are repeating this test");
    }
    @RepeatedTest(3)
    void thirdRepeatedMethod(RepetitionInfo repetieionInfo){
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repetieionInfo.getCurrentRepetition()==3,()-> System.out.println("This code will only run on repetition 3"));

    }
}
