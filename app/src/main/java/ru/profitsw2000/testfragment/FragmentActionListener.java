package ru.profitsw2000.testfragment;

import android.os.Bundle;

public interface FragmentActionListener {

    String ACTION_KEY = "action_key"    ;
    int ACTION_VALUE_CLUB_SELECTED = 1  ;
    String KEY_SELECTED_CLUB = "KEY_SELECTED_CLUB"    ;

    void onActionPerformed(Bundle bundle)    ;
}
