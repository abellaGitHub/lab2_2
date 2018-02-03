package pl.com.bottega.ecommerce;

import static org.junit.Assert.assertThat;

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
}
