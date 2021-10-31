package ru.profitsw2000.testfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {

    private static final String COMMON_TAG = "LifeCycleFragment"    ;
    private static final String FRAGMENT_NAME = FirstFragment.class.getSimpleName()    ;
    private static final String TAG = COMMON_TAG    ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, FRAGMENT_NAME + " onAttach") ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, FRAGMENT_NAME + " onCreate") ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, FRAGMENT_NAME + " onCreateView") ;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, FRAGMENT_NAME + " onViewCreated") ;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, FRAGMENT_NAME + " onViewStateRestored") ;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, FRAGMENT_NAME + " onStart") ;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, FRAGMENT_NAME + " onResume") ;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, FRAGMENT_NAME + " onPause") ;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, FRAGMENT_NAME + " onStop") ;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, FRAGMENT_NAME + " onSaveInstanceState") ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, FRAGMENT_NAME + " onDestroyView") ;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, FRAGMENT_NAME + " onDestroy") ;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, FRAGMENT_NAME + " onDetach") ;
    }

    @Override
    public String toString() {
        return FirstFragment.class.getSimpleName();
    }
}