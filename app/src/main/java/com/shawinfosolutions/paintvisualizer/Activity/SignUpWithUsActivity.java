package com.shawinfosolutions.paintvisualizer.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shawinfosolutions.paintvisualizer.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.annotation.Nullable;

public class SignUpWithUsActivity extends Activity {
private LinearLayout ProfessionalLay,HomeMakerLay,DateOfBirthLayout;
private TextView ProfessionalBtn,HomeMakerBtn;
private ImageView radioProfessionalBtnGroup,radioHomeMakerBtnGroup;
private LinearLayout companyNameLayout;
public  String Home="000",Prop="000";
private EditText editTextDateOfBirth;
private Button SignUpBtn;
private ImageView backbtn;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_with_us);
        backbtn=findViewById(R.id.backbtn);
        companyNameLayout=findViewById(R.id.companyNameLayout);
        ProfessionalLay=findViewById(R.id.ProfessionalLay);
        HomeMakerLay=findViewById(R.id.HomeMakerLay);
        SignUpBtn=findViewById(R.id.SignUpBtn);
        editTextDateOfBirth=findViewById(R.id.editTextDateOfBirth);
        ProfessionalBtn=findViewById(R.id.ProfessionalBtn);
        HomeMakerBtn=findViewById(R.id.HomeMakerBtn);
        Prop="111";
        Home="000";
        DateOfBirthLayout=findViewById(R.id.DateOfBirthLayout);
        radioProfessionalBtnGroup=findViewById(R.id.radioProfessionalBtnGroup);
        radioHomeMakerBtnGroup=findViewById(R.id.radioHomeMakerBtnGroup);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpWithUsActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ProfessionalLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Prop="111";

                if(Prop.equalsIgnoreCase("111")) {
                    //Log.e("ProfessionalLay", "ProfessionalLay");

                     Home="111";
                    Prop="000";
                    Log.e("ProfessionalLay", "ProfessionalLay");

                    companyNameLayout.setVisibility(View.VISIBLE);


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        radioProfessionalBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.filled_radio, getApplicationContext().getTheme()));

                        radioHomeMakerBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.white_radio, getApplicationContext().getTheme()));
                    } else {
                        radioProfessionalBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.filled_radio));
                        radioHomeMakerBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.white_radio));
                    }
                }
            }
        });
        HomeMakerLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home="111";
                if(Home.equalsIgnoreCase("111")) {
                    // Prop="false";
                    Log.e("HomeMakerLay", "HomeMakerLay");

                    Home="000";
                    Prop="111";

                    companyNameLayout.setVisibility(View.GONE);


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        radioProfessionalBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.white_radio, getApplicationContext().getTheme()));

                        radioHomeMakerBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.filled_radio, getApplicationContext().getTheme()));
                    } else {
                        radioProfessionalBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.white_radio));
                        radioHomeMakerBtnGroup.setImageDrawable(getResources().getDrawable(R.drawable.filled_radio));
                    }
                }
            }
        });

        DateOfBirthLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog  dpDialog=   new DatePickerDialog(SignUpWithUsActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dpDialog.show();
                dpDialog.getDatePicker().setMaxDate(myCalendar.getTimeInMillis());
            }
        });

        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpWithUsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }


    };
    private void updateLabel() {
        String myFormat = "dd/MM/YYYY"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTextDateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will

        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intent = new Intent(SignUpWithUsActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();

                //  finish();
                break;

        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUpWithUsActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
}
