package com.example.azaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        editText = findViewById(R.id.edit_txt_call);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClickCallIc(View view) {
        String phoneNo = editText.getText().toString().trim();
        if(!TextUtils.isEmpty(phoneNo)) {
            String dial = "tel:" + phoneNo;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
        }else {
            Toast.makeText(CallActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

/*При нажатии на позвонить переходит на новое активити для ввода номера телефона,
там нужно чтоб выходили цифры при вводе, и открывались контакты при нажатии на конпку
позвонить с номером который ввели сверху в editText.
Так же при нажатии кнопки Назад -> закрывалось активити и переходило на главный экран.


4) При нажатии на позвонить переходит на новое активити для ввода номера телефона,
 там нужно чтоб выходили цифры при вводе, и открывались контакты при нажатии на конпку позвонит
 ь с номером который ввели сверху в editText. Так же при нажатии кнопки Назад -> закрывалось активити и переходило на главный экран.
5)При нажати на иконку гугл -> переходит на новое активити, там вводите слово и при нажатии
на кнопку Поиск -> открывается браузер и происходит поиск вашего введенного слова.
6) Кнопка Перейти не кликабельная.*/