package com.daniilamark.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextResult = (EditText) findViewById(R.id.editTextResult);
        MyKeyboard keyboard = (MyKeyboard) findViewById(R.id.keyboard);

        // prevent system keyboard from appearing when EditText is tapped
        editTextResult.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editTextResult.setTextIsSelectable(true);

        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = editTextResult.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);


    }
    /*
    <color name="purple_200">#FFBB86FC</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700B3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
     */

}