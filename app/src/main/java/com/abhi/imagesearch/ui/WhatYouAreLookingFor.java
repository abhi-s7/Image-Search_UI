package com.abhi.imagesearch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.abhi.imagesearch.ui.Adapter.BrandNamesAdapter;
import com.abhi.imagesearch.ui.Constants.BrandData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhatYouAreLookingFor extends AppCompatActivity {

    EditText searchInput;
    private RecyclerView recyclerView;
    private List<String> items;
    private BrandNamesAdapter adapter;
    private TextView lookingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_you_are_looking_for);

        init();
        setAnimations();
        fillExampleList();
        setUpRecyclerView();

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(recyclerView.getVisibility() == View.INVISIBLE)
                    recyclerView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(s);
                // search = s
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setAnimations() {
        searchInput.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_scale_animation));
        lookingText.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_scale_animation));
    }

    private void fillExampleList() {
//        items.add("Suzuki Accord 800");
//        items.add("Suzuki Alto 800");
//        items.add("Eco Sports 1");
//        items.add("Eco Sports 2");
        /*
        List list = Arrays.asList(BrandData.brandNames);
        items = new ArrayList<>(list);
        Log.d("Before", "fillExampleList: " + items);
        */
//        for (String item : BrandData.brandNames){
//            items.add("#" + item);
//        }

        items.addAll(Arrays.asList(BrandData.brandNames));
//        ArrayList<String[]> al = BrandData.add();


    }

    private void init(){
        items = new ArrayList<>();
        searchInput = findViewById(R.id.lookingforwhat);
        recyclerView = findViewById(R.id.searchBrandRecycler);
        lookingText = findViewById(R.id.lookingForText);

    }

    private void setUpRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new BrandNamesAdapter(this,items);
        //adapter = new ExampleAdapter(items);

        adapter.setOnItemClickListener(new BrandNamesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent navigate = new Intent(WhatYouAreLookingFor.this, ImageActivity.class);
                navigate.putExtra("query", items.get(position));
                startActivity(navigate);
            }
        });


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
