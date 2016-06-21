package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.util.Log;
import android.util.Pair;

import java.util.concurrent.ExecutionException;

/**
 * Created by reku on 13/6/16.
 */
public class GCETest extends ApplicationTestCase {
    public GCETest(Class applicationClass) {
        super(applicationClass);
    }

    @SuppressWarnings("unchecked")
    public void testEmptyString(){
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "DownloadJoke"));

        String output = null;
        try {
            output = endpointsAsyncTask.get();
            Log.i("GCMTest", output);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertNotNull(output);
    }
}
