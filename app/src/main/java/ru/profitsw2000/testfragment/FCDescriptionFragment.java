package ru.profitsw2000.testfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FCDescriptionFragment extends Fragment {

    TextView description    ;
    View rootView   ;
    String fc_name  ;
    String fcDescription    ;
    String TAG_DESCR = "Description"    ;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Bundle bundle = getArguments()  ;
        fc_name = bundle.getString(FragmentActionListener.KEY_SELECTED_CLUB, "Barcelona")    ;
        fcDescription = getDescriptionString(fc_name) ;
        Log.d(TAG_DESCR, "savedInstanceState == null: " + fc_name)   ;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(fc_name);
        if (fcDescription != null) description.setText(fcDescription);
    }

    private void initUI() {
        description = (TextView) rootView.findViewById(R.id.description_text)   ;
    }

    private String getDescriptionString(String clubName) {
        String temp ;

        switch (clubName) {
            case "Barcelona":
                temp = getResources().getString(R.string.Barcelona)   ;
                break;

            case "Bayern Munich":
                temp = getResources().getString(R.string.Bayern)   ;
                break;

            case "Borussia Dortmund":
                temp = getResources().getString(R.string.Borussia)   ;
                break;

            case "Chelsea":
                temp = getResources().getString(R.string.Chelsea)   ;
                break;

            case "Inter":
                temp = getResources().getString(R.string.Inter)   ;
                break;

            case "Juventus":
                temp = getResources().getString(R.string.Juventus)   ;
                break;

            case "Liverpool":
                temp = getResources().getString(R.string.Liverpool)   ;
                break;

            case "Milan":
                temp = getResources().getString(R.string.Milan)   ;
                break;

            case "Real":
                temp = getResources().getString(R.string.Real)   ;
                break;

            default:
                temp = getResources().getString(R.string.Barcelona)   ;
                break;
        }

        return temp   ;
    }
}