package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static put.io.testing.audiobooks.Customer.LoyaltyLevel;

class AudiobookPriceCalculatorTest {
    AudiobookPriceCalculator calculator = null;

    @BeforeEach
    public void setUp(){
        calculator = new AudiobookPriceCalculator();

    }
    @Test
    public void testCalculateStandardSubscriber(){
        Audiobook audiobook = new Audiobook("Abc", 1);
        Customer customer = new Customer("ABC",LoyaltyLevel.STANDARD ,true);
        assertEquals(calculator.calculate(customer, audiobook),0.0);
    }

    @Test
    public void testCalculateSilverSubscriber(){
        Audiobook audiobook = new Audiobook("Abc", 1);
        Customer customer = new Customer("ABC",LoyaltyLevel.SILVER,true);
        assertEquals(calculator.calculate(customer, audiobook),0.0);
    }
    @Test
    public void testCalculateGoldSubscriber(){
        Audiobook audiobook = new Audiobook("Abc", 1);
        Customer customer = new Customer("ABC",LoyaltyLevel.GOLD,true);
        assertEquals(calculator.calculate(customer, audiobook),0.0);
    }
    @Test
    public void testCalculateStandardNotSubscriber(){
        Audiobook audiobook = new Audiobook("Abc", 1);
        Customer customer = new Customer("ABC",LoyaltyLevel.STANDARD ,false);
        assertEquals(calculator.calculate(customer, audiobook),1);
    }

    @Test
    public void testCalculateSilverNotSubscriber(){
        Audiobook audiobook = new Audiobook("Abc", 1);
        Customer customer = new Customer("ABC",LoyaltyLevel.SILVER,false);
        assertEquals(calculator.calculate(customer, audiobook),0.9);
    }
    @Test
    public void testCalculateGoldNotSubscriber(){
        Audiobook audiobook = new Audiobook("Abc", 1);
        Customer customer = new Customer("ABC",LoyaltyLevel.GOLD,false);
        assertEquals(calculator.calculate(customer, audiobook),0.8);
    }
}