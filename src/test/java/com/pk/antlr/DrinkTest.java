package com.pk.antlr;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by pallav.kothari on 4/24/17.
 */
public class DrinkTest {
    @Test
    public void testDrinks() {
        Drinks.Listener coffee = new Drinks().parse("a cup of coffee");
        assertThat(coffee.getDrink(), is("coffee"));
        assertThat(coffee.getVessel(), is("cup"));

        Drinks.Listener beer = new Drinks().parse("a pint of beer");
        assertThat(beer.getDrink(), is("beer"));
        assertThat(beer.getVessel(), is("pint"));
    }
}
