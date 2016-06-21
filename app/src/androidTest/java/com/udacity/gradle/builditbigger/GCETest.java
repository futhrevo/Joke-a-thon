package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by reku on 13/6/16.
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class GCETest  {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testEmptyString(){
        Log.i("---------Test--------", "testEmptyString Started");
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(new Pair<Context, String>(mainActivityRule.getActivity(), "DownloadJoke"));

        String output = null;
        try {
            output = endpointsAsyncTask.get();
            Log.i("---------Test--------", output);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertNotNull(output);
        assertFalse(output.contains("ECONNREFUSED"));
    }
}
