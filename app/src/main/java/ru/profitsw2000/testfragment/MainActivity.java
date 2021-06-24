package ru.profitsw2000.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment();
    }

    private void addFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager()   ;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()    ;
        FirstFragment firstFragment = new FirstFragment()   ;
        fragmentTransaction.add(R.id.first_fragment, firstFragment) ;
        fragmentTransaction.commit()    ;
    }
}