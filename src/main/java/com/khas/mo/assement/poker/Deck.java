package com.khas.mo.assesment.poker;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Random;
import java.util.Arrays;
import java.util.Optional;

import lombok.Value;

@Value
public class Deck {
    private List<Card> deck = new ArrayList<Card>();
    
    public Deck(){
        Stream.of(Card.Suit.values()).forEach(suit -> {
		    Stream.of(Card.Rank.values()).forEach(rank -> {
			    deck.add(new Card(rank, suit));
		    });
	    });
    }

    public void shuffle() {
        Card swapDeck[] = deck.toArray(new Card[deck.size()]);
        Random random = new Random();

        /**
         * Loop through replacing current top card
         * with randomly selected card within card
         * deck range (with cards left to swap)
         * till bottom of deck is reached.
         */
        for(int i=swapDeck.length-1; i>0; i--) {
            int j = random.nextInt(i);
	        Card swapCard = swapDeck[i]; 
            swapDeck[i] = swapDeck[j];     // Swap current top card with randomly selected card.
            swapDeck[j] = swapCard;        
	    } 

        /** 
         * Place elements back in original list.
         * Keep it simple.
         */
        deck.clear();
        deck.addAll(Arrays.asList(swapDeck));
    }

    public Optional<Card> dealOneCard() {
        if(!deck.isEmpty()) 
            return Optional.of(deck.remove(0));

        return Optional.empty();
    }

}
