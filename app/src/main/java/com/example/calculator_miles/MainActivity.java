package com.example.calculator_miles;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView calc_entry;
    TextView mem;

    Button clear;
    Button clear_everything;
    Button point;
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

    Button zero;
    Button memSet;
    Button memGet;
    Button equals;

    double result;
    String memory;
    DecimalFormat f = new DecimalFormat("##.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc_entry = findViewById(R.id.calc_entry);
        mem = findViewById(R.id.mem);

        clear = findViewById(R.id.clear);
        clear_everything = findViewById(R.id.clear_everything);
        point = findViewById(R.id.point);
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

        zero = findViewById(R.id.zero);
        memSet = findViewById(R.id.memSet);
        memGet = findViewById(R.id.memGet);
        equals = findViewById(R.id.equals);

        clear.setOnClickListener(myOnClickListener);
        clear_everything.setOnClickListener(myOnClickListener);
        point.setOnClickListener(myOnClickListener);
        divide.setOnClickListener(myOnClickListener);

        seven.setOnClickListener(myOnClickListener);
        eight.setOnClickListener(myOnClickListener);
        nine.setOnClickListener(myOnClickListener);
        multiply.setOnClickListener(myOnClickListener);

        four.setOnClickListener(myOnClickListener);
        five.setOnClickListener(myOnClickListener);
        six.setOnClickListener(myOnClickListener);
        minus.setOnClickListener(myOnClickListener);

        one.setOnClickListener(myOnClickListener);
        two.setOnClickListener(myOnClickListener);
        three.setOnClickListener(myOnClickListener);
        plus.setOnClickListener(myOnClickListener);

        zero.setOnClickListener(myOnClickListener);
        memSet.setOnClickListener(myOnClickListener);
        memGet.setOnClickListener(myOnClickListener);
        equals.setOnClickListener(myOnClickListener);
    }

    private View.OnClickListener myOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.clear:
                    calc_entry.setText(calc_entry.getText().subSequence(0, calc_entry.getText().length() - 1));
                    break;

                case R.id.clear_everything:
                    calc_entry.setText("");
                    break;

                case R.id.point:
                    calc_entry.append(getResources().getString(R.string.point));
                    break;

                case R.id.divide:
                    boolean lastCharIsDigit = Character.isDigit(calc_entry.getText().charAt(calc_entry.getText().length() - 1));

                    if (calc_entry.getText().length() != 0 && lastCharIsDigit) {
                        calc_entry.append(getResources().getString(R.string.divide));
                    } else if (!lastCharIsDigit) {
                        calc_entry.setText(calc_entry.getText().subSequence(0, calc_entry.getText().length() - 1));
                        calc_entry.append(getResources().getString(R.string.divide));
                    }
                    break;

                case R.id.seven:
                    calc_entry.append(getResources().getString(R.string.seven));
                    break;

                case R.id.eight:
                    calc_entry.append(getResources().getString(R.string.eight));
                    break;

                case R.id.nine:
                    calc_entry.append(getResources().getString(R.string.nine));
                    break;

                case R.id.multiply:
                    lastCharIsDigit = Character.isDigit(calc_entry.getText().charAt(calc_entry.getText().length() - 1));

                    if (calc_entry.getText().length() != 0 && lastCharIsDigit) {
                        calc_entry.append(getResources().getString(R.string.multiply));
                    } else if (!lastCharIsDigit) {
                        calc_entry.setText(calc_entry.getText().subSequence(0, calc_entry.getText().length() - 1));
                        calc_entry.append(getResources().getString(R.string.multiply));
                    }
                    break;

                case R.id.four:
                    calc_entry.append(getResources().getString(R.string.four));
                    break;

                case R.id.five:
                    calc_entry.append(getResources().getString(R.string.five));
                    break;

                case R.id.six:
                    calc_entry.append(getResources().getString(R.string.six));
                    break;

                case R.id.minus:
                    lastCharIsDigit = Character.isDigit(calc_entry.getText().charAt(calc_entry.getText().length() - 1));

                    if (calc_entry.getText().length() != 0 && lastCharIsDigit) {
                        calc_entry.append(getResources().getString(R.string.minus));
                    } else if (!lastCharIsDigit) {
                        calc_entry.setText(calc_entry.getText().subSequence(0, calc_entry.getText().length() - 1));
                        calc_entry.append(getResources().getString(R.string.minus));
                    }
                    break;

                case R.id.one:
                    calc_entry.append(getResources().getString(R.string.one));
                    break;

                case R.id.two:
                    calc_entry.append(getResources().getString(R.string.two));
                    break;

                case R.id.three:
                    calc_entry.append(getResources().getString(R.string.three));
                    break;

                case R.id.plus:
                    lastCharIsDigit = Character.isDigit(calc_entry.getText().charAt(calc_entry.getText().length() - 1));

                    if (calc_entry.getText().length() != 0 && lastCharIsDigit) {
                        calc_entry.append(getResources().getString(R.string.plus));
                    } else if (!lastCharIsDigit) {
                        calc_entry.setText(calc_entry.getText().subSequence(0, calc_entry.getText().length() - 1));
                        calc_entry.append(getResources().getString(R.string.plus));
                    }
                    break;

                case R.id.zero:
                    calc_entry.append(getResources().getString(R.string.zero));
                    break;

                case R.id.memSet:
                    memory = calc_entry.getText().toString();
                    mem.setText(getResources().getString(R.string.mem));
                    mem.append(memory);
                    Toast.makeText(MainActivity.this, "Memory set", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.memGet:
                    calc_entry.append(memory);
                    break;

                case R.id.equals:
                    char[] entry = calc_entry.getText().toString().toCharArray();
                    result = calculate(entry);

                    if (result == Math.round(result)) {
                        System.out.println("Int: " + Math.round(result) + "  double: " + result);
                        calc_entry.setText(String.valueOf(Math.round(result)));
                    } else {
                        System.out.println("Int: " + Math.round(result) + "  double: " + result);
                        calc_entry.setText(String.valueOf(f.format(result)));
                    }
                    break;

            }
        }
    };

    public double calculate(char[] entry) {
        String nums = "";
        int i = 0;

        while (i < entry.length && (Character.isDigit(entry[i]) || entry[i] == '.')) {
            nums += entry[i];
            i++;
        }
        result = Double.valueOf(nums);
        while (i < entry.length) {
            char op = entry[i];
            i++;

            nums = "";
            while (i < entry.length && (Character.isDigit(entry[i]) || entry[i] == '.')) {
                nums += entry[i];
                i++;
                System.out.println("i: " + i + "  len: " + entry.length);
            }

            double num = Double.valueOf(nums);

            switch (op) {
                case '+':
                    System.out.println("result: " + result + "  num: " + num);
                    result = result + num;
                    System.out.println(result);
                    break;
                case '-':
                    result = result - num;
                    break;
                case 'x':
                    result = result * num;
                    break;
                case '÷':
                    if (num != 0) {
                        result = result / num;
                    } else {
                        Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
        return result;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("memory", memory);
        outState.putString("calc_entry", calc_entry.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        calc_entry.setText(savedInstanceState.getString("calc_entry"));
        mem.setText(getResources().getString(R.string.mem));
        mem.append(savedInstanceState.getString("memory"));

    }
}
