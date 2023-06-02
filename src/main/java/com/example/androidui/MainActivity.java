package com.example.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSearch = findViewById(R.id.btnSearch);  // 검색 버튼을 찾아옵니다.

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtSearch = findViewById(R.id.edtSearch);  // 검색어를 입력하는 EditText를 찾아옵니다.
                String searchQuery = edtSearch.getText().toString();  // 검색어를 가져옵니다.

                // 검색어를 전달하여 새로운 화면으로 이동하는 로직을 작성합니다.
                Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
                intent.putExtra("searchQuery", searchQuery);
                startActivity(intent);
            }
        });

    }
}