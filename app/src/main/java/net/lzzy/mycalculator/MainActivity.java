package net.lzzy.mycalculator;

import java.lang.*;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String number = "";
    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_sub = (Button) findViewById(R.id.btn_sub);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Button btn_div = (Button) findViewById(R.id.btn_div);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);
        Button btn_0 = (Button) findViewById(R.id.btn_0);
        Button btn_c = (Button) findViewById(R.id.btn_c);
        Button btn_del = (Button) findViewById(R.id.btn_del);
        Button btn_poi = (Button) findViewById(R.id.poi);
        Button btn_equ = (Button) findViewById(R.id.btn_equ);
        btn_1.setOnClickListener(listener);
        btn_2.setOnClickListener(listener);
        btn_3.setOnClickListener(listener);
        btn_4.setOnClickListener(listener);
        btn_5.setOnClickListener(listener);
        btn_6.setOnClickListener(listener);
        btn_7.setOnClickListener(listener);
        btn_8.setOnClickListener(listener);
        btn_9.setOnClickListener(listener);
        btn_0.setOnClickListener(listener);
        btn_c.setOnClickListener(listener);
        btn_del.setOnClickListener(listener);
        btn_poi.setOnClickListener(listener);
        btn_add.setOnClickListener(sinal);
        btn_sub.setOnClickListener(sinal);
        btn_mul.setOnClickListener(sinal);
        btn_div.setOnClickListener(sinal);
        btn_equ.setOnClickListener(sinal);


    }

    View.OnClickListener sinal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            TextView text = (TextView) findViewById(R.id.text);
            if (GainStringProperty.sinal_state1 == true)
                switch (v.getId()) {
                    case R.id.btn_add:
                        if(GainStringProperty.sinal>=1&&number.length()!=0)
                            GainStringProperty.sinal_state2=true;
                        if (number.length() != 0) {
                            GainStringProperty.num1 = Float.parseFloat(number);
                            GainStringProperty.sinal = 1;
                            temp = number + "+";
                            text.setText(temp);
                            number = "";
                        }
                        break;



                    case R.id.btn_sub:
                        if (number.length() != 0) {
                            GainStringProperty.num1 = Float.parseFloat(number);
                            GainStringProperty.sinal = 2;
                            temp = number + "-";
                            text.setText(temp);
                            number = "";
                        }
                        break;
                    case R.id.btn_mul:
                        if (number.length() != 0) {
                            GainStringProperty.num1 = Float.parseFloat(number);
                            GainStringProperty.sinal = 3;
                            temp = number + "*";
                            text.setText(temp);
                            number = "";
                        }
                        break;

                    case R.id.btn_div:




                        if (number.length() != 0) {
                            GainStringProperty.num1 = Float.parseFloat(number);
                            GainStringProperty.sinal = 4;
                            temp = number + "/";
                            text.setText(temp);
                            number = "";
                        }



                        break;









                    case R.id.btn_equ:

                        if(GainStringProperty.sinal>=1&&number.length()!=0)
                            GainStringProperty.sinal_state2=true;
                        if (GainStringProperty.sinal_state1 == true&& GainStringProperty.sinal_state2==true) {
                            GainStringProperty.num2 = Float.parseFloat(number);
                            text.setText(String.valueOf(GainStringProperty.total()));
                            number = temp = "";
                            GainStringProperty.sinal_state1 = false;
                            GainStringProperty.sinal_state2=false;
                        }
                        break;

                }


        }
    };


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView text = (TextView) findViewById(R.id.text);
            switch (v.getId()) {
                case R.id.btn_c:
                    text.setText("0");
                    number = "";
                    GainStringProperty.sinal_state1 = false;
                    temp = "";
                    break;



                case R.id.btn_del:
                    if (number.length() <= 1) {
                        text.setText("0");
                        number = "";
                        GainStringProperty.sinal_state1 = false;
                    } else
                        number = number.substring(0, number.length() - 1);
                    break;
                case R.id.btn_1:
                    number = number + "1";
                    break;
                case R.id.btn_2:
                    number = number + "2";
                    break;
                case R.id.btn_3:
                    number = number + "3";
                    break;
                case R.id.btn_4:
                    number = number + "4";
                    break;
                case R.id.btn_5:
                    number = number + "5";
                    break;
                case R.id.btn_6:
                    number = number + "6";
                    break;
                case R.id.btn_7:
                    number = number + "7";
                    break;
                case R.id.btn_8:
                    number = number + "8";
                    break;
                case R.id.btn_9:
                    number = number + "9";
                    break;
                case R.id.btn_0:
                    if (!number.substring(0).equals("0") && number.length() != 0)
                        number = number + "0";
                    break;
                case R.id.poi:
                    if (number.length() == 0 || number.equals("0"))
                        number = "0.";
                    else if (number.indexOf(".") == -1)
                        number = number + ".";
            }
            if (number.length() != 0) {
                text.setText(temp + number);
                GainStringProperty.sinal_state1 = true;

            }
        }
    };

}
