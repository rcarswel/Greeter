package edu.westga.cs6242.greeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testReverseDisabled() {
        MainActivity activity = getActivity();

        // Tap "Reverse" button
        // ----------------------

        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);

        assertEquals(false, reverseButton.isEnabled());
    }

    public void testGreet() {
        MainActivity activity = getActivity();

        // Type name in text input
        // ----------------------

        final EditText nameEditText =
                (EditText) activity.findViewById(R.id.greet_edit_text);

        // Send string input value
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");
        getInstrumentation().waitForIdleSync();

        // Tap "Greet" button
        // ----------------------

        Button greetButton =
                (Button) activity.findViewById(R.id.greet_button);

        TouchUtils.clickView(this, greetButton);

        // Verify greet message
        // ----------------------

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);
    }

    public void testReverseEnabled() {
        MainActivity activity = getActivity();

        // Tap "Reverse" button
        // ----------------------

        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);

        assertEquals(false, reverseButton.isEnabled());
    }

    public void testReverse() {
        MainActivity activity = getActivity();

        // Type name in text input
        // ----------------------

        final EditText nameEditText =
                (EditText) activity.findViewById(R.id.greet_edit_text);

        // Send string input value
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");
        getInstrumentation().waitForIdleSync();

        // Tap "Greet" button
        // ----------------------

        Button greetButton =
                (Button) activity.findViewById(R.id.greet_button);

        TouchUtils.clickView(this, greetButton);

        // Verify greet message
        // ----------------------

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);

        // Tap "Reverse" button
        // ----------------------

        Button reverseButton =
                (Button) activity.findViewById(R.id.reverse_button);

        TouchUtils.clickView(this, reverseButton);

        // Verify reverse message
        // ----------------------

        TextView reverseMessage = (TextView) activity.findViewById(R.id.message_text_view);
        String reverseText = reverseMessage.getText().toString();
        assertEquals("!ekaJ ,olleH", reverseText);
    }
}