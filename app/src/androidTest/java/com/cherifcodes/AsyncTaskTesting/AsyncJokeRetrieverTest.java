package com.cherifcodes.AsyncTaskTesting;

import android.support.test.annotation.UiThreadTest;

import com.udacity.gradle.builditbigger.AsyncJokeRetriever;
import com.udacity.gradle.builditbigger.JokeRetrievalListener;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AsyncJokeRetrieverTest extends TestCase implements JokeRetrievalListener {
    private String retrievedJoke = null;
    private AsyncJokeRetriever asyncJokeRetriever;
    private CountDownLatch signal;

    private static String[] jokes = {
            "Last year I was sitting in a bar when a gentleman worked in, wearing a nice suite. He asked for a drink, and suddenly the bar-tender passed out. Everyone else held their noses and looked for a skunk.  Frustrated, the man yelled, " +
                    "'What's wrong with people in this town?!!' Then everybody passed out.",
            "joke 2: Under creation!",
            "joke 3: Coming soon to a meetUp near you.",
            "joke 4: Has some bugs, so requires maintenance.",
            "joke 5: Gone to get some Artificial Intelligence training."};

    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);
        asyncJokeRetriever = new AsyncJokeRetriever(this);
    }

    @UiThreadTest
    public void testReturnedJokeIsNotNull() throws InterruptedException
    {
        asyncJokeRetriever.fetchRandomJoke();
        signal.await(30, TimeUnit.SECONDS);

        //Ensure that the returned string is not null
        assertNotNull(retrievedJoke);

        //Ensure that the returned String matches one of the expected jokes
        boolean isExpectedJoke = false;
        for (String joke : jokes) {
            if (joke.equals(retrievedJoke)) {
                isExpectedJoke = true;
                break;
            }
        }
        assertTrue(isExpectedJoke);
    }

    @Override
    public void jokeRetrievalCompleted(String joke) {
        assertNotNull(joke);
        retrievedJoke = joke;
    }
}
