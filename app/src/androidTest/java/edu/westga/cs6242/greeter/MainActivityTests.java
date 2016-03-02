package edu.westga.cs6242.greeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    private Button reverseButton;
    private EditText nameEditText;
    private Button greetButton;
    private TextView greetMessage;

    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testReverseDisabled() {
        MainActivity activity = getActivity();
        setupScenario(activity);

        // "Reverse" button disabled
        assertEquals(false, reverseButton.isEnabled());
    }

    public void testGreet() {
        MainActivity activity = getActivity();
        setupScenario(activity);

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

        TouchUtils.clickView(this, greetButton);

        // Verify greet message
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);
    }

    public void testReverseEnabled() {
        MainActivity activity = getActivity();
        setupScenario(activity);

        // "Reverse" button enabled
        assertEquals(false, reverseButton.isEnabled());
    }

    public void testReverse() {
        MainActivity activity = getActivity();
        setupScenario(activity);

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
        TouchUtils.clickView(this, greetButton);

        // Verify greet message
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);

        // Tap "Reverse" button
        TouchUtils.clickView(this, reverseButton);

        // Verify reverse message
        // ----------------------

        //TextView reverseMessage = (TextView) activity.findViewById(R.id.message_text_view);
        String reverseText = greetMessage.getText().toString();
        assertEquals("!ekaJ ,olleH", reverseText);
    }

    private void setupScenario(MainActivity activity) {
        reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        nameEditText = (EditText) activity.findViewById(R.id.greet_edit_text);
        greetButton = (Button) activity.findViewById(R.id.greet_button);
        greetMessage = (TextView) activity.findViewById(R.id.message_text_view);
    }
}