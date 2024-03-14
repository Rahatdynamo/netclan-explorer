package com.example.netclanexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

public class Refine_Activity extends AppCompatActivity {
    ImageView return_btn;
Spinner spinner;
SeekBar seekbar;
TextView textView;
TextView coffee,bussiness,hobbies,friendship,movie,dinning,dating,matrimony;
   boolean isButtonClicked1 = false;
    boolean isButtonClicked2 = false;
    boolean isButtonClicked3 = false;
    boolean isButtonClicked4= false;
    boolean isButtonClicked5 = false;
    boolean isButtonClicked6 = false;
    boolean isButtonClicked7 = false;
    boolean isButtonClicked8 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);
        return_btn=findViewById(R.id.return_btn);
        return_btn.setClickable(true);
        textView=findViewById(R.id.text_view1);
        seekbar=findViewById(R.id.seekbar);
        spinner=findViewById(R.id .spinner_opn);
        coffee=findViewById(R.id.coffee);
        bussiness=findViewById(R.id.bussiness);
        hobbies=findViewById(R.id.hobbies);
        friendship=findViewById(R.id.friendship);
        movie=findViewById(R.id.movie);
        dinning=findViewById(R.id.dinning);
        dating=findViewById(R.id.dating);
        matrimony=findViewById(R.id.matrimony);

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getApplicationContext(),MainActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);
                overridePendingTransition(0,0);


            }
        });
        String [] option=getResources().getStringArray(R.array.availability);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,option);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(String.valueOf(i));
                int width=seekBar.getWidth()-seekBar.getPaddingLeft()-seekBar.getPaddingRight();
                int thumbPos=seekBar.getPaddingLeft()+width*seekBar.getProgress()/seekBar.getMax();
                textView.measure(0,0);
                int txt=textView.getMeasuredWidth();
                int delta=txt/2;
                textView.setX(seekBar.getX()+thumbPos-delta);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });



    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }


    public void onClickButton(View view) {
       Button clickButton=(Button) view;
       if(clickButton==findViewById(R.id.coffee)){
           isButtonClicked1=!isButtonClicked1;
           change(clickButton,isButtonClicked1);
       }
        if(clickButton==findViewById(R.id.bussiness)){
            isButtonClicked2=!isButtonClicked2;
            change(clickButton,isButtonClicked2);
        }
        if(clickButton==findViewById(R.id.hobbies)){
            isButtonClicked3=!isButtonClicked3;
            change(clickButton,isButtonClicked3);
        }
        if(clickButton==findViewById(R.id.friendship)){
            isButtonClicked4=!isButtonClicked4;
            change(clickButton,isButtonClicked4);
        }
        if(clickButton==findViewById(R.id.movie)){
            isButtonClicked5=!isButtonClicked5;
            change(clickButton,isButtonClicked5);
        }
        if(clickButton==findViewById(R.id.dating)){
            isButtonClicked6=!isButtonClicked6;
            change(clickButton,isButtonClicked6);
        }
        if(clickButton==findViewById(R.id.dinning)){
            isButtonClicked7=!isButtonClicked7;
            change(clickButton,isButtonClicked7);
        }
        if(clickButton==findViewById(R.id.matrimony)){
            isButtonClicked8=!isButtonClicked8;
            change(clickButton,isButtonClicked8);
        }

    }
    public void change(Button button,boolean isButtonClicked){
        if(isButtonClicked) {
                    button.setBackgroundColor(getResources().getColor(R.color.light_blue));
                    button.setTextColor(Color.WHITE);
                } else {
                    button.setBackgroundColor(Color.WHITE);
                    button.setTextColor(getResources().getColor(R.color.light_blue));
                }
    }
}