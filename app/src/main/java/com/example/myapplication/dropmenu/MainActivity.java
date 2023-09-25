package com.example.myapplication.dropmenu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private PopupWindow submenuPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.manage) {
                    showSubmenu(v);
                    return true;
                } else if (item.getItemId() == R.id.view_ranking) {
                    showRankingSubmenu(v);
                    return true;
                }
                return false;
            }
        });

        popup.show();
    }

    private void showRankingSubmenu(View anchorView) {
        View rankingSubmenuView = LayoutInflater.from(this).inflate(R.layout.submennu_layout2, null);

        rankingSubmenuView.findViewById(R.id.ranking_personal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlankActivity();
            }
        });

        rankingSubmenuView.findViewById(R.id.ranking_team).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlankActivity();
            }
        });

        rankingSubmenuView.findViewById(R.id.ranking_elo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlankActivity();
            }
        });

        PopupWindow rankingSubmenuPopupWindow = new PopupWindow(rankingSubmenuView,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true);
        rankingSubmenuPopupWindow.setOutsideTouchable(true);
        rankingSubmenuPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        int xOff = anchorView.getWidth();  // x-offset
        rankingSubmenuPopupWindow.showAsDropDown(anchorView, xOff, 0);
    }



    private void showSubmenu(View anchorView) {
        View submenuView = LayoutInflater.from(this).inflate(R.layout.submenu_layout, null);

        submenuView.findViewById(R.id.them).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlankActivity();
            }
        });

        submenuView.findViewById(R.id.sua).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlankActivity();
            }
        });

        submenuView.findViewById(R.id.xoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlankActivity();
            }
        });

        submenuPopupWindow = new PopupWindow(submenuView,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true);
        submenuPopupWindow.setOutsideTouchable(true);
        submenuPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        int xOff = anchorView.getWidth();  // x-offset
        submenuPopupWindow.showAsDropDown(anchorView, xOff, 0);
    }


    private void openBlankActivity() {
        Intent intent = new Intent(MainActivity.this, BlankActivity.class);
        startActivity(intent);
    }
}




