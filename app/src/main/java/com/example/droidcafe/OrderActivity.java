package com.example.fundamentals_unit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent i = getIntent ();
        String mess = "Order: " + i.getStringExtra (MainActivity.EXTRA_MESSAGE);
        TextView intro = findViewById (R.id.intro);
        intro.setText(mess);

        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null)
        {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById (R.id.spinner);
        if (spinner != null)
        {
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked (View v)
    {
        boolean clicked = ( (RadioButton) v).isChecked();

        switch (v.getId ())
        {
            case R.id.sameDay:
                if (clicked)
                    // Same day service
                    displayToast ("You selected Same Day Delivery");
                break;
            case R.id.nextDay:
                if (clicked)
                    // Same day service
                    displayToast ("You selected Next Day Delivery");
                break;
            case R.id.pickUp:
                if (clicked)
                    // Same day service
                    displayToast ("You selected Pick Up");
                break;
        }
    }

    public void displayToast (String m)
    {
        Toast.makeText (getApplicationContext(), m, Toast.LENGTH_SHORT).show ();
    }

    public void showDatePicker (View v)
    {
        DatePickerFrag dateFragment = new DatePickerFrag ();
        dateFragment.show (getSupportFragmentManager (), "datePicker");
    }

    public void processDatePickerResult (int year, int month, int day)
    {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (day_string + "/" + month_string + "/" + year_string);

        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        String spinner = adapterView.getItemAtPosition(i).toString ();
        displayToast (spinner);
    }
//
    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
} 
