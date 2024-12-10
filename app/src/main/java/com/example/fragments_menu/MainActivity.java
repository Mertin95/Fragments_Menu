package com.example.fragments_menu;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView menus = findViewById(R.id.menu);
        menus.inflateMenu(R.menu.menubase);

        menus.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.rojo){
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainerView, Fragment1.class, null).commit();
                }else if (item.getItemId()==R.id.azul){
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainerView,Fragment2.class,null).commit();
                }else if (item.getItemId()==R.id.verde){
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainerView,Fragment3.class,null).commit();
                }

                return false;
            }
        });
    }
}