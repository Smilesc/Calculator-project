package com.example.calculator_miles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView calc_entry;

    Button clear;
    Button clear_everything;
    Button percent;
    Button divide;

    Button seven;
    Button eight;
    Button nine;
    Button multiply;

    Button four;
    Button five;
    Button six;
    Button minus;

    Button one;
    Button two;
    Button three;
    Button plus;

    Button toggle_negative;
    Button zero;
    Button point;
    Button equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc_entry = findViewById(R.id.calc_entry);

        clear = findViewById(R.id.clear);
        clear_everything = findViewById(R.id.clear_everything);
        percent = findViewById(R.id.percent);
        divide = findViewById(R.id.divide);

        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        multiply = findViewById(R.id.multiply);

        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        minus = findViewById(R.id.minus);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        plus = findViewById(R.id.plus);

        toggle_negative = findViewById(R.id.toggle_negative);
        zero = findViewById(R.id.zero);
        point = findViewById(R.id.point);
        equals = findViewById(R.id.equals);
    }

    private View.OnClickListener myOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.clear:
                    calc_entry.setText(calc_entry.getText().subSequence(0, calc_entry.getText().length() - 2));

                case R.id.clear_everything:
                    calc_entry.setText("");

                case R.id.percent:
                    calc_entry.append(getResources().getString(R.string.percent));

                case R.id.divide:
                    calc_entry.append(getResources().getString(R.string.divide));


                case R.id.seven:
                    calc_entry.append(getResources().getString(R.string.seven));

                case R.id.eight:
                    calc_entry.append(getResources().getString(R.string.eight));

                case R.id.nine:
                    calc_entry.append(getResources().getString(R.string.nine));

                case R.id.multiply:
                    calc_entry.append(getResources().getString(R.string.multiply));


                case R.id.four:
                    calc_entry.append(getResources().getString(R.string.four));

                case R.id.five:
                    calc_entry.append(getResources().getString(R.string.five));

                case R.id.six:
                    calc_entry.append(getResources().getString(R.string.six));

                case R.id.minus:
                    calc_entry.append(getResources().getString(R.string.minus));


                case R.id.one:
                    calc_entry.append(getResources().getString(R.string.one));

                case R.id.two:
                    calc_entry.append(getResources().getString(R.string.two));

                case R.id.three:
                    calc_entry.append(getResources().getString(R.string.three));

                case R.id.plus:
                    calc_entry.append(getResources().getString(R.string.plus));


                case R.id.toggle_negative:
                    int lastNonDigitIndex = -1;
                    calc_entry.getText();
                    for (int i = calc_entry.getText().length()-1; i >= 0; i--) {
                        if (!(Character.isDigit(calc_entry.getText().toString().charAt(i)))) {
                            lastNonDigitIndex = i + 1;
                            break;
                        }
                    }

                    if (lastNonDigitIndex < calc_entry.getText().length()){
                        String str = calc_entry.getText().toString();
                        str = new StringBuilder(str).insert(lastNonDigitIndex, getResources().getString(R.string.minus)).toString();
                        calc_entry.setText(str);
                    }
                    else{
                        calc_entry.append(getResources().getString(R.string.minus));
            }

                case R.id.zero:
                    calc_entry.append(getResources().getString(R.string.zero));

                case R.id.point:
                    calc_entry.append(getResources().getString(R.string.point));

                case R.id.equals:
                    //this is the hard part

            }
        }
    };
}
