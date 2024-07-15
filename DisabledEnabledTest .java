package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest {
    @Test
    @Disabled(value = "Disabled for demo of @Disabled") //Test will not be run at all
    void firstTest(){
        System.out.println("This is the First Test");
    }
    @Test
    @DisabledOnOs(value = OS.WINDOWS,disabledReason = "Disabled for demo")
    void secondTest(){
        System.out.println("This is the SecondTest");
    }
    @Test
    @DisabledIfSystemProperty(named= "env",matches="staging",disabledReason = "Disable for demo")
    void thirdTest(){
        System.out.println("This is the Third Test");
    }
    @Test
    @DisabledIf(value="provider",disabledReason="Disabled for demo")
    void fourthTest(){
        System.out.println("This is the Fourth Test");
    }
    @Test
    void fifthTest(){
        System.out.println("This is the Fifth Test");
    }

boolean provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);
}

}
