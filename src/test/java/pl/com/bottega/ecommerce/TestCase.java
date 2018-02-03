package pl.com.bottega.ecommerce;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TestCase {

    @Test
    public void moneyAddDefaultCurrencies() {
        Money money1 = new Money(100);
        Money money2 = new Money(100);

        assertThat(money1.add(money2), Matchers.is(new Money(200)));
    }

    @Test
    public void moneyAddSpecifiedCurrencies() {
        Money money1 = new Money(100, "EUR");
        Money money2 = new Money(100, "EUR");

        assertThat(money1.add(money2), Matchers.is(new Money(200, "EUR")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void moneyAddDifferentCurrencies() {
        Money money1 = new Money(100, "EUR");
        Money money2 = new Money(100, "PLN");
        money1.add(money2);
    }

    @Test
    public void moneySubtractDefaultCurrencies() {
        Money money1 = new Money(200);
        Money money2 = new Money(100);

        assertThat(money1.subtract(money2), Matchers.is(new Money(100)));
    }

    @Test
    public void moneySubtractSpecifiedCurrencies() {
        Money money1 = new Money(200, "EUR");
        Money money2 = new Money(100, "EUR");

        assertThat(money1.subtract(money2), Matchers.is(new Money(100, "EUR")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void moneySubtractDifferentCurrencies() {
        Money money1 = new Money(100, "EUR");
        Money money2 = new Money(100, "PLN");
        money1.subtract(money2);
    }

    @Test
    public void moneyMultiplyDefaultCurrencies() {
        Money money1 = new Money(10);

        assertThat(money1.multiplyBy(new BigDecimal(10)), Matchers.is(new Money(100)));
        assertThat(money1.multiplyBy(10), Matchers.is(new Money(100)));
    }

    @Test
    public void moneyMultiplySpecifiedCurrencies() {
        Money money1 = new Money(10, "PLN");

        assertThat(money1.multiplyBy(new BigDecimal(10)), Matchers.is(new Money(100, "PLN")));
        assertThat(money1.multiplyBy(10), Matchers.is(new Money(100, "PLN")));
    }
}
