package ru.profitsw2000.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{

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
        footballClubsFragment.setFragmentActionListener(this);
        fragmentTransaction.add(R.id.fragment_container, footballClubsFragment) ;
        fragmentTransaction.commit()    ;
    }

    /**
     * Start fragment with description of chosen football club.
     * @param bundle - parameters from main fragment
     */
    private void addFCDescriptionFragment(Bundle bundle) {

        FCDescriptionFragment footballClubsFragment = new FCDescriptionFragment()   ;
        fragmentTransaction = fragmentManager.beginTransaction();

        footballClubsFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragment_container, footballClubsFragment) ;
        fragmentTransaction.addToBackStack(null)   ;
        fragmentTransaction.commit()    ;
    }

    /**
     * Method to start fragment with description of selected football club
     * @param bundle - parameters from main fragment
     */
    @Override
    public void onActionPerformed(Bundle bundle) {
        int actionPerformed = bundle.getInt(ACTION_KEY) ;
        switch (actionPerformed) {
            case FragmentActionListener.ACTION_VALUE_CLUB_SELECTED: addFCDescriptionFragment(bundle);
        }
    }
}