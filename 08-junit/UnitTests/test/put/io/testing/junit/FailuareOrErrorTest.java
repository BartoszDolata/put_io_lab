package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FailuareOrErrorTest {
        @Test
        public void test1(){
            assertEquals(1,0);
        }
        @Test
        public void test2(){
            assertEquals(5/0, 1);
        }
        @Test
        public void test3(){
            try {
                assertEquals(1,0);
            }
            catch (Throwable e){
                System.out.println(e.getClass());
            }
        }

}