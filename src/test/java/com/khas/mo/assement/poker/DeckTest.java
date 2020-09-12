package com.khas.mo.assesment.poker;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeckTest {

    private static final int DECK_SIZE = 52;

    @Test
    public void testConstructor() {
        Deck deck = new Deck();
	    assertEquals(DECK_SIZE, deck.getDeck().size());
    }

    @Test
    public void testShuffle() {
	    Deck deck = new Deck();
        List<Card> unshuffled = new ArrayList<Card>(deck.getDeck());
        deck.shuffle();
	    List<Card> shuffled = new ArrayList<Card>(deck.getDeck());
	    assertNotEquals(unshuffled, shuffled);
    }

    @Test
    public void testShuffleDuplicates() {
        Deck deck = new Deck();
        deck.shuffle();
        Set<Card> cardSet = new HashSet<Card>(deck.getDeck());
        assertEquals(cardSet.size(), deck.getDeck().size());      
    } 

    @Test
    public void testShuffleSize() {
	    Deck deck = new Deck();
        deck.shuffle();
        assertEquals(DECK_SIZE, deck.getDeck().size());
    }

    @Test
    public void testDealOneCard() {
        Deck deck = new Deck();
        deck.shuffle();
        for(int i=0; i<DECK_SIZE; i++) {
            Optional<Card> card = deck.dealOneCard();
            assertTrue(card.isPresent());
    	}
	    Optional<Card> card = deck.dealOneCard();
	    assertFalse(card.isPresent());
    }

}