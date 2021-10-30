package ru.profitsw2000.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String COMMON_TAG = "LifeCycle"    ;
    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName()    ;
    private static final String TAG = COMMON_TAG    ;
    Button buttonAddFragment    ;
    TextView textView   ;
    FragmentManager fragmentManager ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ACTIVITY_NAME + " onCreate") ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAddFragment = findViewById(R.id.button)  ;
        textView = findViewById(R.id.textView)  ;
        fragmentManager = getSupportFragmentManager()   ;

        textView.setText("Count in backstack: " + fragmentManager.getBackStackEntryCount());

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textView.setText("Count in backstack: " + fragmentManager.getBackStackEntryCount());
            }
        });

        buttonAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, ACTIVITY_NAME + " onStart")  ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, ACTIVITY_NAME + " onStop")  ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, ACTIVITY_NAME + " onDestroy")  ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, ACTIVITY_NAME + " onPause")  ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, ACTIVITY_NAME + " onResume")  ;
    }

    private void addFragment(){
        Fragment fragment   ;

        switch (fragmentManager.getBackStackEntryCount()) {
            case 0: fragment = new FirstFragment()    ;
                break;
            case 1: fragment = new SecondFragment()    ;
                break;
            case 2: fragment = new ThirdFragment()    ;
                break;
            default: fragment = new FirstFragment()    ;
                break;
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()    ;
        fragmentTransaction.add(R.id.first_fragment, fragment) ;
        fragmentTransaction.addToBackStack("MyStack")   ;
        fragmentTransaction.commit()    ;
    }
}