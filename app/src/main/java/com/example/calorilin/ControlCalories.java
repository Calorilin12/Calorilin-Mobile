package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class ControlCalories extends AppCompatActivity{
    ConstraintLayout expandableViewBreakfast, expandableViewLunch, expandableViewDinner;
    Button arrowBtnBreakfast, arrowBtnLunch, arrowBtnDinner;
    CardView cardViewBreakfast, cardViewLunch, cardViewDinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableViewBreakfast = findViewById(R.id.expandableViewBreakfast);
        arrowBtnBreakfast = findViewById(R.id.buttonBreakfast);
        cardViewBreakfast = findViewById(R.id.jadwalMakanPagi);

        expandableViewLunch = findViewById(R.id.expandableViewLunch);
        arrowBtnLunch = findViewById(R.id.buttonlunch);
        cardViewLunch = findViewById(R.id.jadwalMakanSiang);

        expandableViewDinner = findViewById(R.id.expandableViewDinner);
        arrowBtnDinner = findViewById(R.id.buttonDinner);
        cardViewDinner = findViewById(R.id.jadwalMakanMalam);

        arrowBtnBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableViewBreakfast.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewBreakfast, new AutoTransition());
                    expandableViewBreakfast.setVisibility(View.VISIBLE);
                    arrowBtnBreakfast.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewBreakfast, new AutoTransition());
                    expandableViewBreakfast.setVisibility(View.GONE);
                    arrowBtnBreakfast.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }

                if (expandableViewLunch.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewLunch, new AutoTransition());
                    expandableViewLunch.setVisibility(View.VISIBLE);
                    arrowBtnLunch.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewLunch, new AutoTransition());
                    expandableViewLunch.setVisibility(View.GONE);
                    arrowBtnLunch.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }

                if (expandableViewDinner.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewDinner, new AutoTransition());
                    expandableViewDinner.setVisibility(View.VISIBLE);
                    arrowBtnDinner.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewDinner, new AutoTransition());
                    expandableViewDinner.setVisibility(View.GONE);
                    arrowBtnDinner.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });
    }
}
