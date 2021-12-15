package com.calorilin.calorilin_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorilin.calorilin_mobile.adapter.Controlkaloriadapter;

import java.util.ArrayList;

public class FragmentKontrolKalori extends Fragment{

    ConstraintLayout expandableViewBreakfast, expandableViewLunch, expandableViewDinner;
    Button arrowBtnBreakfast, arrowBtnLunch, arrowBtnDinner;
    CardView cardViewBreakfast, cardViewLunch, cardViewDinner;
    RecyclerView dinner;
    ArrayList<ObjekKontrol> listkontrol;
    Button tambahmenusarapan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_control_calories, container, false);

        dinner = view.findViewById(R.id.viewKontrol);
        tambahmaknanankalori();
        Controlkaloriadapter adapter = new Controlkaloriadapter(getActivity().getApplicationContext(), listkontrol);
        dinner.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        dinner.setAdapter(adapter);

        expandableViewBreakfast = view.findViewById(R.id.expandableViewBreakfast);
        arrowBtnBreakfast = view.findViewById(R.id.buttonBreakfast);
        cardViewBreakfast = view.findViewById(R.id.jadwalMakanPagi);

        expandableViewLunch = view.findViewById(R.id.expandableViewLunch);
        arrowBtnLunch = view.findViewById(R.id.buttonlunch);
        cardViewLunch = view.findViewById(R.id.jadwalMakanSiang);

        expandableViewDinner = view.findViewById(R.id.expandableViewDinner);
        arrowBtnDinner = view.findViewById(R.id.buttonDinner);
        cardViewDinner = view.findViewById(R.id.jadwalMakanMalam);

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
            }
        });
        arrowBtnLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableViewLunch.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewLunch, new AutoTransition());
                    expandableViewLunch.setVisibility(View.VISIBLE);
                    arrowBtnLunch.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewLunch, new AutoTransition());
                    expandableViewLunch.setVisibility(View.GONE);
                    arrowBtnLunch.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });
        arrowBtnDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        tambahmenusarapan = view.findViewById(R.id.addMenuBreakfast);
        tambahmenusarapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlagTimeShow flagTimeShow = new FlagTimeShow();
                flagTimeShow.setTimeshownow("Pagi");
                Intent intent = new Intent(getActivity(), TambahMenu.class);
                startActivity(intent);
            }
        });

        return view;
    }
    private void tambahmaknanankalori() {
        listkontrol = new ArrayList<>();
        listkontrol.add(new ObjekKontrol("Telor Ceplok","780 Kcal","45 g","45 g", "45 g"));
        listkontrol.add(new ObjekKontrol("Telor Dadar","780 Kcal","45 g","45 g", "45 g"));
    }
    public  void openDialog(){
        TambahmenusarapanDialog tambahmenusarapanDialog = new TambahmenusarapanDialog();
        tambahmenusarapanDialog.show(getActivity().getSupportFragmentManager(), "menu sarapan");
    }
}
