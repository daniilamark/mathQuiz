package com.daniilamark.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MathActivity extends AppCompatActivity {

    EditText editTextResult;
    TextView tvTask, tvResult, tvCountNum;
    MyKeyboard keyboard;
    Button mButtonEnter;
    Calculations calc = new Calculations();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        editTextResult = (EditText) findViewById(R.id.editTextResult);
        editTextResult.setShowSoftInputOnFocus(false);
        editTextResult.setFocusableInTouchMode(false);
        editTextResult.setTextIsSelectable(false);

        tvTask= findViewById(R.id.tvTask);
        tvResult = findViewById(R.id.tvResult);
        tvCountNum = findViewById(R.id.tvCountNum);
        keyboard = (MyKeyboard) findViewById(R.id.keyboard);
        mButtonEnter = (Button) findViewById(R.id.button_enter);

        // prevent system keyboard from appearing when EditText is tapped
        editTextResult.setRawInputType(InputType.TYPE_CLASS_TEXT);

        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = editTextResult.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);

        //
        setTask();

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
    public void onClickGoMain(View view){
        Intent i = new Intent(MathActivity.this, MainActivity.class);
        startActivity(i);
    }
    public void onButtonClickEnter(View view)
    {
        checkTask();
        setTask();
    }

    public void setTask() {
        tvCountNum.setText(calc.getStrCount());
        tvTask.setText(calc.getStrNum1() + " + " + calc.getStrNum2() + " =");
        editTextResult.setText("");
    }
    public int getIntResult() {
        int _result = Integer.parseInt(String.valueOf(editTextResult.getText()));
        String result = String.valueOf(_result);
        return _result;
    }

    public void checkTask() {
        try {
            int _result = calc.getResult();
            if(_result == getIntResult()){
                tvResult.setText("правильно");
                calc.setCountPlus();
            }else{
                tvResult.setText("неправильно");
                calc.setCountMinus();
            }
        }catch (Exception e){
            tvResult.setText("Вы не ввели ответ :(");
            calc.setCountMinus();
        }
    }

}