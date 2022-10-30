package com.barisdundar.randomlandmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.barisdundar.randomlandmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
private Toolbar actionbardetails;

public void init(){
    actionbardetails=(Toolbar)findViewById(R.id.pnlActionbar) ;
    //setSupportActionBar(actionbardetails);
    getSupportActionBar().setTitle("Back To Home Page");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent=getIntent();
        //casting -> bir şeyi bir şeye dönüştürmek
        Landmark landmark=(Landmark) intent.getSerializableExtra("landmark");
        binding.nameText.setText(landmark.name);
        binding.countryText.setText(landmark.country);
        binding.infoText.setText(landmark.info);
        binding.imageView.setImageResource(landmark.image);
        init();

    }
}