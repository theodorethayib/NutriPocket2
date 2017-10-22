package com.example.theo1.nutripocket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;
import android.widget.Button;
import android.widget.Toast;

import static android.util.Log.d;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    TextView calorieGoal;
    TextView calorieGoalValue;
    ProgressBar calorieProgressBar;
    int calorieCount = 0;
    Button breakdownButton;
    TextView currentCalories;
    Button nutritionButton;
    Button prefButton;

    String tester;

    int currentCarbs = 0;
    int currentProts = 0;
    int currentFats = 0;
    int currentSugar = 0;
    int currentSodium = 0;
    int caloriesCurrentValue = 0;

    int carbGoal;
    int protGoal;
    int fatGoal;

    TextView carbString;
    TextView protString;
    TextView fatString;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();





        calorieGoal = (TextView) findViewById(R.id.calorieGoal);
        calorieProgressBar = (ProgressBar) findViewById(R.id.calorieProgressBar);
        breakdownButton = (Button) findViewById(R.id.caloricBreakdownButton);
        currentCalories = (TextView) findViewById(R.id.currentCalories);
        currentCalories.setText("You are currently at " + calorieCount + " Calories!");
        calorieProgressBar.setProgress(calorieCount);

        carbString = (TextView) findViewById(R.id.carbValueGoal);
        protString = (TextView) findViewById(R.id.proteinValueGoal);
        fatString = (TextView) findViewById(R.id.fatValueGoal);

        nutritionButton = (Button) findViewById(R.id.nutrition_button);
        nutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DailyNutritionActivity.class);
                startActivityForResult(intent, 5);
            }
        });


        prefButton = (Button) findViewById(R.id.pref_button);
        prefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Preferences.class);
                startActivity(intent);
            }
        });



        breakdownButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, caloricBreakdown.class);
                intent.putExtra("caloriesCurrentValue", caloriesCurrentValue);
                intent.putExtra("carbGoal", carbGoal);
                intent.putExtra("currentFats", currentFats);
                intent.putExtra("fatGoal", fatGoal);
                intent.putExtra("currentCarbs", currentCarbs);
                intent.putExtra("carbGoal", carbGoal);
                intent.putExtra("currentSodium", currentSodium);
                intent.putExtra("currentSugar", currentSugar);
                intent.putExtra("currentProts", currentProts);
                intent.putExtra("protGoal", protGoal);
                startActivity(intent);
            }
        });




        SharedPreferences sharedPrefs = getSharedPreferences("userInfo", MODE_PRIVATE);

        String age = sharedPrefs.getString("age", "");
        String height = sharedPrefs.getString("height", "");
        String weight = sharedPrefs.getString("weight", "");
        String gender = sharedPrefs.getString("gender", "");
        String activityLevel = sharedPrefs.getString("activityLevel", "");
        String bodyType = sharedPrefs.getString("bodyType", "");
        String goal = sharedPrefs.getString("goal", "");


        String fName = sharedPrefs.getString("firstName", "");
        String lName = sharedPrefs.getString("lastName", "");


        String[] userInfo = new String[] {age, height, weight, gender, activityLevel, goal};




        calculateCaloricGoal calGoal = new calculateCaloricGoal(userInfo);
        int goalAmount = calGoal.calculate();
        calorieGoal.setText("Daily Calorie Goal: " + String.valueOf(goalAmount));
        calorieProgressBar.setMax(goalAmount);

        String[] nutriInfo = new String[] {"" + goalAmount, bodyType};

        calculateMacronutrientsGoal macnutriGoal = new calculateMacronutrientsGoal(nutriInfo);
        int[] macronutriGoal = macnutriGoal.calculate();
        carbGoal = macronutriGoal[0];
        Log.d("HELP", valueOf(carbGoal));
        protGoal = macronutriGoal[1];
        fatGoal = macronutriGoal[2];

        carbString.setText(currentCarbs + " / " + carbGoal);
        protString.setText(currentProts + " / " + protGoal);
        fatString.setText(currentFats + " / " + fatGoal);







        Toast.makeText(getApplicationContext(),"Welcome, " + fName + " " + lName + "!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        Log.d("HELP", "RequestCode: " + requestCode + " ResultCode: " + resultCode);
        if (resultCode == 5)
        {
            double[] nutrients = intent.getDoubleArrayExtra("nutrients");
            calorieCount += (int) nutrients[0];
            currentProts += (int) nutrients[3];
            currentFats += (int) nutrients[4];
            currentCarbs += (int) nutrients[5];
            currentSugar += (int) nutrients[2];
            currentSodium += (int) nutrients[1];
            caloriesCurrentValue += (int) nutrients[6];
            currentCalories.setText("You are currently at " + calorieCount + " Calories!");
            calorieProgressBar.setProgress(calorieCount);
            carbString.setText(currentCarbs + " / " + carbGoal);
            protString.setText(currentProts + " / " + protGoal);
            fatString.setText(currentFats + " / " + fatGoal);
        }
    }




}
