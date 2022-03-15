package com.alpha.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);         //prevent keyboard from popping up
    }

    private void updateText(String strToAdd){

        String oldStr = display.getText().toString();
        int cursor = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursor);
        String rightStr = oldStr.substring(cursor);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursor + strToAdd.length());
    }

    public void zeroBTN(View view){
        updateText(getResources().getString(R.string.button_0_text));
    }

    public void oneBTN(View view){
        updateText(getResources().getString(R.string.button_1_text));
    }

    public void twoBTN(View view){
        updateText(getResources().getString(R.string.button_2_text));
    }

    public void threeBTN(View view){
        updateText(getResources().getString(R.string.button_3_text));
    }

    public void fourBTN(View view){
        updateText(getResources().getString(R.string.button_4_text));
    }

    public void fiveBTN(View view){
        updateText(getResources().getString(R.string.button_5_text));
    }

    public void sixBTN(View view){
        updateText(getResources().getString(R.string.button_6_text));
    }

    public void sevenBTN(View view){
        updateText(getResources().getString(R.string.button_7_text));
    }

    public void eightBTN(View view){
        updateText(getResources().getString(R.string.button_8_text));
    }

    public void nineBTN(View view){
        updateText(getResources().getString(R.string.button_9_text));
    }

    public void plusBTN(View view){
        updateText(getResources().getString(R.string.button_plus_text));
    }

    public void minusBTN(View view){
        updateText(getResources().getString(R.string.button_minus_text));
    }

    public void multiplyBTN(View view){
        updateText(getResources().getString(R.string.button_multi_text));
    }

    public void divideBTN(View view){
        updateText(getResources().getString(R.string.button_divide_text));
    }

    public void parLeftBTN(View view){
        updateText(getResources().getString(R.string.par_Left_Text));
    }

    public void parRightBTN(View view){
        updateText(getResources().getString(R.string.par_Right_Text));
    }

    public void dotBTN(View view){
        updateText(getResources().getString(R.string.button_dot_text));
    }

    public void ACBTN(View view){
        display.setText("");
    }

    public void delBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void equalBTN(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll(getResources().getString(R.string.button_divide_text), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.button_multi_text), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void X2BTN(View view){
        updateText("^(2)");
    }

    public void XnBTN(View view){
        updateText("^(");
    }

    public void SqrtBTN(View view){
        updateText("sqrt(");
    }

    public void RootNBTN(View view){
        updateText("^(1÷");
    }

    public void SinBTN(View view) {
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("sin(");
    }

    public void CosBTN(View view){
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("cos(");
    }

    public void TanBTN(View view){
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("tan(");
    }

    public void CotBTN(View view){
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("cot(");
    }

    public void ArcSinBTN(View view){
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("arcsin(");
    }

    public void ArcCosBTN(View view){
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("arccos(");
    }

    public void ArcTanBTN(View view){
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("arctan(");
    }

    public void ArcCotBTN(View view){
        mXparser.setDegreesMode(); //change default from Rad to Deg
        updateText("arccot(");
    }

    public void expBTN(View view){
        updateText("e");
    }

    public void eXBTN(View view){
        updateText("exp(");
    }

    public void Log2BTN(View view){
        updateText("log2(");
    }

    public void lnBTN(View view){
        updateText("ln(");
    }

    public void FactBTN(View view){
        updateText("!");
    }

    public void piBTN(View view){
        updateText("pi");
    }

    public void PercentBTN(View view){
        updateText("%");
    }

    public void ModBTN(View view){
        updateText("#");
    }
}