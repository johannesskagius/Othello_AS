package com.example.othello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);         //Hittar meny i appen
        bottomNav.setOnNavigationItemSelectedListener(navListener);             //Sätter en lyssnare på menyn
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new PlayFragment(), null).commit();  //Öppnar fragment "hem-fragment" onCreate.
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = (item) -> {     //Lyssnaren till menyn som styr vilket fragment som ska visas.
        Fragment selectedFragment = null; //Skapar en instans av fragment som är null. Denna fylls i switchsatsen senare.
        switch (item.getItemId()){          //Switch satsen som hämtar vilken knapp som var tryckt och kör korrekt case under.
            case R.id.play:
                selectedFragment = new PlayFragment();
                break;
            case R.id.settings:
                selectedFragment = new SettingsFragment();
                break;
        }
        assert selectedFragment != null;//Kollar att selectedFragment inte är null.
        changeFragment(selectedFragment);
        return true;
    };
}