package com.example.androidui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SearchResultsActivity extends MainActivity {
    private EditText edtSearch;
    private ImageView imgMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results_activity);

        edtSearch = findViewById(R.id.edtSearch);
        imgMenu = findViewById(R.id.imgMenu);

        // 검색 버튼 클릭 이벤트 처리
        edtSearch.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                performSearch(edtSearch.getText().toString());
                return true;
            }
            return false;
        });

        // 메뉴 창 클릭 이벤트 처리
        imgMenu.setOnClickListener(v -> showPopupMenu(v));
    }

    // 검색 수행
    private void performSearch(String query) {
        // 검색 결과 처리 로직 작성
        Toast.makeText(this, "검색어: " + query, Toast.LENGTH_SHORT).show();
    }

    // 메뉴 창 표시
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.search_results_menu);

        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_search_in_document:
                    // 문서 내 검색 기능 처리
                    Toast.makeText(this, "문서 내 검색", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_settings:
                    // 환경 설정 기능 처리
                    Toast.makeText(this, "환경 설정", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });

        popupMenu.show();
    }
}

