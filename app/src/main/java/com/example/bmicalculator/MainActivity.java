package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static String TAG = MainActivity.class.getSimpleName();
    private EditText height, weight;
    private Button btn;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (height.getText().toString().isEmpty())
                {
                    height.setError("Please enter your height");
                }

                else if (weight.getText().toString().isEmpty())
                {
                    weight.setError("Please enter your weight");
                }

                else
                {

                    float h = Float.parseFloat(height.getText().toString());
                    float w = Float.parseFloat(weight.getText().toString());

                    //converting geight in centimeter in meter
                    double meter = h/100;
                    double bmi = w/(meter*meter);
                    String category;
                    if (bmi<18.5)
                    {
                        category = "Underweight";
                    }

                    else if(bmi>=18.5 && bmi<=24.9)
                    {
                        category = "Normal Weight";
                    }

                    else if(bmi>=25 && bmi<=29.9)
                    {
                        category = "Overweight";
                    }

                    else
                    {
                        category = "Obesity";
                    }

                    Toast.makeText(getApplicationContext(), "Your Body Mass Index is: "+category, Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}
