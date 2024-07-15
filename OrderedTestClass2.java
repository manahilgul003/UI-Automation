package junit5tests;

import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {
    @BeforeAll
    void beforeAll(){
        System.out.println("---This is the before all method");

    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----This is the before Each Method");
    }

    @Test
    @Order(2)
    void  firstMethod(){
        System.out.println("This is the first test method");
    }
    @AfterAll
    void afterAll(){
        System.out.println("---this is the after All method");
    }
    @AfterEach
    void afterEach(){
        System.out.println("---This is the after each method");
    }


    @Test

    @DisplayName("Manahil Gul-TC12-this method is the second one")
    void secondMethod() {
        System.out.println("This is the second test Method");
    }
    @Test
    @Order(1)
    void thirdTest(){
        System.out.println("This is the third method");
    }
}

