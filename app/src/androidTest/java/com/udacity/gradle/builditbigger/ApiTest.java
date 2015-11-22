package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by sengopal on 11/22/15.
 */
public class ApiTest  extends AndroidTestCase {
    public void testApiResponse() {
        try {
            String s = new EndpointsAsyncTask(new EndpointsAsyncTask.OnCompletionListener() {
                @Override
                public void onComplete(String result) {
                    assertNotNull(result);
                }
            }).execute().get();
            assertNotNull(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("Failed attempting to get the joke from API");
        } catch (ExecutionException e) {
            e.printStackTrace();
            fail("Failed attempting to get the joke from API");
        }
    }
}