package com.udacity.jokes.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class JokeBuilder {
    private static final Logger logger = Logger.getLogger(JokeBuilder.class.getSimpleName());
    private static Random random = new Random();
    static List<String> jokeList = new ArrayList<>();

    static {
        init();
    }

    private static void init() {
        jokeList.add("Two aerials meet on a roof - fall in love - get married.  The ceremony was rubbish - but the reception was brilliant.");
        jokeList.add("Another one was:  Doc, I can't stop singing the 'Green Green Grass of Home'. He said: 'That sounds like Tom Jones syndrome'. 'Is it common?'I asked.  'It's not unusual' he replied.");
        jokeList.add("I'm on a whiskey diet. I've lost three days already.");
        jokeList.add("A man walks into a bar with a roll of tarmac under his arm and says: \"Pint please, and one for the road.\"");
        jokeList.add("I went to the doctors the other day and I said, 'Have you got anything for wind?' So he gave me a kite.");
        jokeList.add("My mother-in-law fell down a wishing well, I was amazed, I never knew they worked.");
        jokeList.add("I saw this bloke chatting up a cheetah; I thought, \"He's trying to pull a fast one\".");
        jokeList.add("There's two fish in a tank, and one says \"How do you drive this thing?");
        jokeList.add("I went to buy some camouflage trousers the other day but I couldn't find any.");
        jokeList.add("When Susan's boyfriend proposed marriage to her she said: \"I love the simple things in life, but I don't want one of them for my husband\".");
        jokeList.add("\"My therapist says I have a preoccupation with vengeance. We'll see about that.\"");
        jokeList.add("I rang up British Telecom, I said, \"I want to report a nuisance caller\", he said \"Not you again\". ");
    }

    public static String get() {
        int size = jokeList.size();
        int nextInt = random.nextInt(size);
        return jokeList.get(Math.abs(nextInt));
    }
}