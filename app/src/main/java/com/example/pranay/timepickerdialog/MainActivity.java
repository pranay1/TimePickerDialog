package com.example.pranay.timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button button;
   static int DIALOG_ID = 1;
int hour_x;
    int min_x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // On button click we want to open a dialog(Timepickern  dialog). We can directly  open timepicker dialog
                // instead we call showdialog() function which will call onCreateDialog;
                showDialog(DIALOG_ID);
                //onCreateDialog()  is called

            }
        });


    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == DIALOG_ID) {

            return new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                hour_x = hourOfDay;
                    min_x = minute;
                    Toast.makeText(MainActivity.this, hour_x+" : "+min_x, Toast.LENGTH_SHORT).show();



                }
            }, hour_x, min_x, false);

        }
        else {
            return null;
        }


    }
}
