package com.example.azaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtCityFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        txtCityFirst = findViewById(R.id.txt_city_first);
    }

    public void onClickSearchCity(View view) {
        Intent intent = new Intent(this, SearchCityActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String text = data.getStringExtra(SearchCityActivity.TEXT_KEY);
            txtCityFirst.setText(text);
        }
    }

    public void onClockPhoto(View view) {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }

    public void onClickCallIcon(View view) {
        Intent intent = new Intent(this, CallActivity.class);
        startActivity(intent);
    }

    public void onClickGoogleIcon(View view) {
        Intent intent = new Intent(this, GoogleActivity.class);
        startActivity(intent);
    }
}