package ru.profitsw2000.testfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FootballClubsFragment extends Fragment {

    View rootView   ;
    ListView fcListView ;
    ArrayAdapter<String> fcNamesAdapter ;
    Context context ;
    String[] clubs  ;

    CallBackInterface callBackInterface ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_football_clubs, container, false);
        initUI();
        // Inflate the layout for this fragment
        return rootView ;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setCallBackInterface(CallBackInterface callBackInterface) {
        this.callBackInterface = callBackInterface  ;
    }

    private void initUI() {
        context = getContext()  ;
        clubs = getResources().getStringArray(R.array.footbal_clubs)    ;
        fcListView = (ListView)rootView.findViewById(R.id.fc_list)  ;

        fcNamesAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, clubs)    ;
        fcListView.setAdapter(fcNamesAdapter);

        fcListView.setOnItemClickListener((parent, view, position, id) -> {
            if (callBackInterface != null) {
                callBackInterface.callBackMethod();
            }
        });
    }
}