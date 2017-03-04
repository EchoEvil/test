package com.example.administrator.godutch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String st_amount;
    private String st_people;
    private double db_amount;
    private double db_people;
    private double db_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calculate(View v){

        EditText editText1 = (EditText)findViewById(R.id.ed_amount);
        st_amount = editText1.getText().toString();

        EditText editText2 = (EditText)findViewById(R.id.ed_people);
        st_people = editText2.getText().toString();

        if(st_amount == null||st_amount=="")
        {
            Toast.makeText(MainActivity.this, "Please input an amount", Toast.LENGTH_SHORT).show();
            return;
        }

        if(st_people == null|| st_people=="")
        {
            Toast.makeText(MainActivity.this, "Please input a number", Toast.LENGTH_SHORT).show();
            return;
        }

        try{

            db_amount = Double.parseDouble(st_amount);
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Please input a right amount", Toast.LENGTH_LONG).show();
            return;
        }

        try{
            db_people = Double.parseDouble(st_people);
            if(db_people == 0)
            {
                Toast.makeText(MainActivity.this, "Please input a right number", Toast.LENGTH_LONG).show();
                return;
            }
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Please input a right number", Toast.LENGTH_LONG).show();
            return;
        }

        db_result = db_amount/db_people;
        db_result = Double.valueOf(Math.round(db_result*100));
        db_result = db_result/100;

        TextView textview = (TextView)findViewById(R.id.tv_result);
        textview.setText(String.valueOf(db_result));
    }
}
