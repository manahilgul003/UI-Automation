package junit5tests;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests_MethodSource {
   
    @ParameterizedTest
  @MethodSource(value = "junit5tests.paramProvider#sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);
    }
  @ParameterizedTest
    @MethodSource(value = "junit5tests.paramProvider#sourceStringAsStream")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = " + param1);
    }


@ParameterizedTest
    @MethodSource(value = "junit5tests.paramProvider#sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1,Double param2){
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
}

    @ParameterizedTest
    @MethodSource(value = "junit5tests.paramProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1,Double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
}
