package com.example.erikkjernlie.tdt4140project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowDialog;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Jørgen on 05.04.2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class Sign_inBtnTest {

    Sign_in in;

    @Before
    public void setUp() throws Exception {
        in = Robolectric.setupActivity(Sign_in.class);
    }

    @Test
    public void switchToRegisterBtnTest() throws Exception {
        in.findViewById(R.id.switchLoginToRegister).performClick();

        Intent expectedIntent = new Intent(in, Register_user.class);

        ShadowActivity shadowActivity = Shadows.shadowOf(in);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @Test
    public void forgotPasswordBtnTest() throws Exception {
        View v = in.findViewById(R.id.forgotPassword);
        v.performClick();

        Dialog alert = ShadowDialog.getLatestDialog();

        assertNotNull(alert);

    }

    @After
    public void tearDown() throws Exception {
        in = null;
    }

}
