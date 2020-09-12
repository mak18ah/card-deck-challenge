package com.khas.mo.assesment.poker;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Card {
    public enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
	    TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { HEARTS, SPADES, CLUBS, DIAMONDS }

    private final Rank rank;
    private final Suit suit;    

}
