package com.cherifcodes.javajokelib;

import java.util.Random;

public class MyJoke {

    public static String[] jokes = {
            "Last year I was sitting in a bar when a gentleman worked in, wearing a nice suite. He asked for a drink, and suddenly the bar-tender passed out. Everyone else held their noses and looked for a skunk.  Frustrated, the man yelled, " +
                "'What's wrong with people in this town?!!' Then everybody passed out.",
            "joke 2: Under creation!",
            "joke 3: Coming soon to a meetUp near you.",
            "joke 4: Has some bugs, so requires maintenance.",
            "joke 5: Gone to get some Artificial Intelligence training."};
    public String getJoke(){
        return jokes[new Random().nextInt(jokes.length)];
    }
}
