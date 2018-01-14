package pl.com.bottega.ecommerce.sharedkernel;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2018-01-14.
 */
public class MoneyTest {

    @Test
    public void multiplyByTen(){
        Money money = new Money(100, "GBH");
        assertThat(money.multiplyBy(10), Matchers.is(new Money(1000, "GBH")));
    }



}