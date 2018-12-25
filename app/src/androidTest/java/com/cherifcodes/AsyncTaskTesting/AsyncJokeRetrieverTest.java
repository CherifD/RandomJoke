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

        assertNotNull(retrievedJoke);
    }

    @Override
    public void jokeRetrievalCompleted(String joke) {
        assertNotNull(joke);
        retrievedJoke = joke;
    }
}
