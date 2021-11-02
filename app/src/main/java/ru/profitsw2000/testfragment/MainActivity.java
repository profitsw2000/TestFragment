package ru.profitsw2000.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CallBackInterface{

    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager()   ;
        addFootballClubsFragment();
    }

    private void addFootballClubsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        FootballClubsFragment footballClubsFragment = new FootballClubsFragment()   ;
        footballClubsFragment.setCallBackInterface(this);
        fragmentTransaction.add(R.id.fragment_container, footballClubsFragment) ;
        fragmentTransaction.commit()    ;
    }

    private void addFCDescriptionFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        FCDescriptionFragment footballClubsFragment = new FCDescriptionFragment()   ;
        fragmentTransaction.replace(R.id.fragment_container, footballClubsFragment) ;
        fragmentTransaction.addToBackStack(null)   ;
        fragmentTransaction.commit()    ;
    }

    @Override
    public void callBackMethod() {
        addFCDescriptionFragment();
    }
}