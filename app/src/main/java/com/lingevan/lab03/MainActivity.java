package com.lingevan.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mPreferences;
    SeekBar seekBar;
    Listener Lis;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    int i1;
    int i2;
    int i3;
    int i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences("com.lingevan.lab03.sharedprefs",MODE_PRIVATE);

        i1 = mPreferences.getInt("i1",0);
        i2 = mPreferences.getInt("i2",0);
        i3 = mPreferences.getInt("i3",0);
        i4 = mPreferences.getInt("i4",0);

        tv1=findViewById(R.id.textLabel);
        tv2=findViewById(R.id.textLabel2);
        tv3=findViewById(R.id.textLabel3);
        tv4=findViewById(R.id.textLabel4);

        Lis = new Listener();
        seekBar = findViewById(R.id.seekBar);

        tv1.setOnClickListener(Lis);
        tv2.setOnClickListener(Lis);
        tv3.setOnClickListener(Lis);
        tv4.setOnClickListener(Lis);

        tv1.setText(""+i1);
        tv2.setText(""+i2);
        tv3.setText(""+i3);
        tv4.setText(""+i4);


        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                        tv1.setTextSize((float)(progressValue) + 15);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

    }

    private class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor preferencesEditor = mPreferences.edit();
            if(tv1.isPressed()){
                i1++;
                tv1.setText(""+i1);
                preferencesEditor.putInt("i1", i1);
                Toast.makeText(getApplicationContext(),"Pressed: TextView 1, Count: " + i1,Toast.LENGTH_SHORT).show();
            }
            if(tv2.isPressed()){
                i2++;
                tv2.setText(""+i2);
                preferencesEditor.putInt("i2", i2);
                Toast.makeText(getApplicationContext(),"Pressed: TextView 2, Count: " + i2,Toast.LENGTH_SHORT).show();
            }
            if(tv3.isPressed()){
                i3++;
                tv3.setText(""+i3);
                preferencesEditor.putInt("i3", i3);
                Toast.makeText(getApplicationContext(),"Pressed: TextView 3, Count: " + i3,Toast.LENGTH_SHORT).show();
            }
            if(tv4.isPressed()){
                i4++;
                tv4.setText(""+i4);
                preferencesEditor.putInt("i4", i4);
                Toast.makeText(getApplicationContext(),"Pressed: TextView 4, Count: " + i4,Toast.LENGTH_SHORT).show();
            }
            preferencesEditor.apply();
        }

    }

}
