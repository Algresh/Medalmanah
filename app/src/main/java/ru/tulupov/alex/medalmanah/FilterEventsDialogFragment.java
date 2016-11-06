package ru.tulupov.alex.medalmanah;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


/**
 * DELETE!!!
 */
public class FilterEventsDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Resources resources = getActivity().getResources();
        View view = getActivity().getLayoutInflater().inflate(R.layout.filter_events_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(resources.getString(R.string.searchEvents));
        builder.setView(view);

        return builder.create();
    }


}
