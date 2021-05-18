package sg.edu.rp.c346.id20013783.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText n;
    EditText mn;
    EditText sg;
    RadioButton sm;
    RadioButton nsm;
    DatePicker dp;
    TimePicker tp;
    Button btnSubmit;
    Button btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n = findViewById(R.id.enterName);
        mn = findViewById(R.id.mobileNumber);
        sg = findViewById(R.id.sizeOfGroup);
        sm = findViewById(R.id.radioButton3);
        nsm = findViewById(R.id.radioButton4);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnSubmit = findViewById(R.id.submit);
        btnReset = findViewById(R.id.resetButton);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = " ";
                String error = " ";

                String name = n.getText().toString();
                String number = mn.getText().toString();
                String group = sg.getText().toString();

                int day = dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();
                String date = day + "/" + month + "/" + year;

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                String time = hour + ":" + minute;


                if (name.isEmpty() || number.isEmpty() || group.isEmpty()) {
                    error += "Please input the details";
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
                } else {
                    if (nsm.isChecked()) {
                        msg += "Hello , Mr/Mrs " + name + " Thank you for the reservation. To confirm your particulars, your mobile number is "
                                + number + " with " + group + " on " + date + " at " + time + " .The seat is a non-smoking area.See you!";
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    } else {
                        msg += "Hello , Mr/Mrs " + name + " Thank you for the reservation. To confirm your particulars, your mobile number is "
                                + mn + " with " + sg + " on " + date + " at " + time + " .The seat is a smoking area.See you!";
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                }
            }
});


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n.setText("");
                mn.setText("");
                sg.setText("");
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                sm.setChecked(false);
                nsm.setChecked(false);
                dp.updateDate(2020, 5, 1);
            }
        });
    }
}



