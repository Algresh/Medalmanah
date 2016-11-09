package ru.tulupov.alex.medalmanah.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import ru.tulupov.alex.medalmanah.R;


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
