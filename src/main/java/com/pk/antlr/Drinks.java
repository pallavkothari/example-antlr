package com.pk.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Sample usage of the generated listener
 *
 * Created by pallav.kothari on 4/24/17.
 */
public class Drinks {
    public Listener parse(String order) {
        DrinksLexer drinksLexer = new DrinksLexer(new ANTLRInputStream(order));
        CommonTokenStream tokenStream = new CommonTokenStream(drinksLexer);
        DrinksParser parser = new DrinksParser(tokenStream);
        DrinksParser.DrinkSentenceContext sentenceContext = parser.drinkSentence();
        ParseTreeWalker walker = new ParseTreeWalker();
        Listener listener = new Listener();
        walker.walk(listener, sentenceContext);
        return listener;
    }

    static class Listener extends DrinksBaseListener {
        private String drink;
        private String vessel;

        @Override
        public void enterDrink(DrinksParser.DrinkContext ctx) {
            drink = ctx.getText();
        }

        @Override
        public void enterDrinkSentence(DrinksParser.DrinkSentenceContext ctx) {
            vessel = ctx.DRINKING_VESSEL().getText();
        }

        String getDrink() {
            return drink;
        }

        String getVessel() {
            return vessel;
        }
    }
}
