package ru.profitsw2000.testfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FCDescriptionFragment extends Fragment {

    TextView description    ;
    View rootView   ;
    String fc_name  ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_f_c_description, container, false);
        initUI()    ;
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        fc_name = "Barcelona"   ;
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(fc_name);
        description.setText(R.string.Barcelona);
    }

    private void initUI() {
        description = (TextView) rootView.findViewById(R.id.description_text)   ;
    }
}