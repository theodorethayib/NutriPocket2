package com.example.theo1.nutripocket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Preferences extends AppCompatActivity {

    Button cancelButton;
    Button saveButton;

    EditText fNameP;
    EditText lNameP;
    EditText ageP;
    EditText heightP;
    EditText weightP;
    Spinner genderSpinP;
    Spinner activityLevelP;
    Spinner bodyTypeP;
    Spinner goalP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        getSupportActionBar().hide();

        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton = (Button) findViewById(R.id.saveButton);


        fNameP = (EditText) findViewById(R.id.nameFirstP);
        lNameP = (EditText) findViewById(R.id.nameLastP);
        ageP = (EditText) findViewById(R.id.ageP);
        heightP = (EditText) findViewById(R.id.heightP);
        weightP = (EditText) findViewById(R.id.weightP);
        genderSpinP = (Spinner) findViewById(R.id.genderP);
        activityLevelP = (Spinner) findViewById(R.id.activityLevelP);
        bodyTypeP = (Spinner) findViewById(R.id.bodyTypeP);
        goalP = (Spinner) findViewById(R.id.goalP);

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



        fNameP.setText(fName);
        lNameP.setText(lName);
        ageP.setText(age);
        heightP.setText(height);
        weightP.setText(weight);

        final String aLevel = "Female";
        switch (gender) {
            case aLevel:
                genderSpinP.setSelection(1);
                break;
            default:
                genderSpinP.setSelection(0);
                break;
        }

        final String firstLevel = "Sedentary";
        final String secondLevel = "Light Activity";
        final String thirdLevel = "Moderate Activity";
        final String fourthLevel = "Heavy Activity";
        final String fifthLevel = "Extreme Activity";
        switch (activityLevel) {
            case firstLevel:
                activityLevelP.setSelection(0);
                break;
            case secondLevel:
                activityLevelP.setSelection(1);
                break;
            case thirdLevel:
                activityLevelP.setSelection(2);
                break;
            case fourthLevel:
                activityLevelP.setSelection(3);
                break;
            case fifthLevel:
                activityLevelP.setSelection(4);
                break;
        }

        final String onLevel = "Ectomorph";
        final String twLevel = "Mesomorph";
        final String thLevel = "Endomorph";
        switch (bodyType) {
            case onLevel:
                bodyTypeP.setSelection(0);
                break;
            case twLevel:
                bodyTypeP.setSelection(1);
                break;
            case thLevel:
                bodyTypeP.setSelection(2);
                break;
        }

        final String oneLevel = "Lose Weight";
        final String twoLevel = "Maintain Weight";
        final String threeLevel = "Gain Weight";
        switch (goal) {
            case oneLevel:
                goalP.setSelection(0);
                break;
            case twoLevel:
                goalP.setSelection(1);
                break;
            case threeLevel:
                goalP.setSelection(2);
                break;
        }


        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });




        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveUserInfo();
                finish();

            }
        });

        genderSpinP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });

        activityLevelP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });

        bodyTypeP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });

        goalP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });
    }




    public void saveUserInfo() {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("firstName", fNameP.getText().toString());
        editor.putString("lastName", lNameP.getText().toString());
        editor.putString("age", ageP.getText().toString());
        editor.putString("height", heightP.getText().toString());
        editor.putString("weight", weightP.getText().toString());
        editor.putString("gender", genderSpinP.getSelectedItem().toString());
        editor.putString("activityLevel", activityLevelP.getSelectedItem().toString());
        editor.putString("bodyType", bodyTypeP.getSelectedItem().toString());
        editor.putString("goal", goalP.getSelectedItem().toString());
        editor.apply();
    }
}
