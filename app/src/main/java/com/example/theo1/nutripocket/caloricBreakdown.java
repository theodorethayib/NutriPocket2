package com.example.theo1.nutripocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.theo1.nutripocket.R;

import static com.example.theo1.nutripocket.R.id.info;

public class caloricBreakdown extends AppCompatActivity {
    TextView calories;
    TextView fat;
    TextView carbs;
    TextView sodium;
    TextView sugar;
    TextView protein;



    Button returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloric_breakdown);
        getSupportActionBar().hide();

        calories = (TextView) findViewById(R.id.cbamountOfCalories);
        fat = (TextView) findViewById(R.id.cbamountOfFat);
        carbs = (TextView) findViewById(R.id.cbamountOfCarbs);
        sodium = (TextView) findViewById(R.id.cbamountOfSodium);
        sugar = (TextView) findViewById(R.id.cbamountOfSugar);
        protein = (TextView) findViewById(R.id.cbamountOfProtein);

        returnButton = (Button) findViewById(R.id.back_button);


        Bundle bundle = getIntent().getExtras();
        int calValue = bundle.getInt("caloriesCurrentValue");
        int currentFats = bundle.getInt("currentFats");
        int fatGoal = bundle.getInt("fatGoal");
        int currentCarbs = bundle.getInt("currentCarbs");
        int carbGoal = bundle.getInt("carbGoal");
        int currentSodium = bundle.getInt("currentSodium");
        int currentSugar = bundle.getInt("currentSugar");
        int currentProts = bundle.getInt("currentProts");
        int protGoal = bundle.getInt("protGoal");




//        calories.setText(String.valueOf(calValue));
        calories.setText(String.valueOf(currentCarbs) + " / " + String.valueOf(carbGoal));
        fat.setText(String.valueOf(currentFats) + " / " + String.valueOf(fatGoal));
        carbs.setText(String.valueOf(currentCarbs) + " / " + String.valueOf(carbGoal));
        sodium.setText(String.valueOf(currentSodium));
        sugar.setText(String.valueOf(currentSugar));
        protein.setText(String.valueOf(currentProts) + " / " + String.valueOf(protGoal));



        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });

    }
}
