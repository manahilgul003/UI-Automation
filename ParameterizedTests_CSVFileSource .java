package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ParameterizedTests_CSVFileSource {

    @ParameterizedTest
    @CsvFileSource(files={"src\\test\\resourses\\params\\shoppinglist.csv","src/test/resourses/params/shoppinglist2.csv"},numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name,double price,int qty,String uom,String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }
    @ParameterizedTest
    @CsvFileSource(files={"src\\test\\resourses\\params\\shoppinglist.csv"},numLinesToSkip = 1,delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name,double price,int qty,String uom,String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }


}
