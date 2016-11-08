package ru.tulupov.alex.medalmanah;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;
public class FragmentLocationDialog  extends DialogFragment implements DialogInterface.OnClickListener {

//    final static int LARGE_FONT_SIZE = 2;
//    final static int NORMAL_FONT_SIZE = 1;
//    final static int SMALL_FONT_SIZE = 0;

    SelectLocation listener;
    int selectedItem = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Resources res = getActivity().getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(res.getString(R.string.selectLocation))
                .setSingleChoiceItems(res.getStringArray(R.array.type_location), selectedItem, this)
                .setNegativeButton(res.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return builder.create();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        listener.selectLocation(which);
        dismiss();
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    public interface SelectLocation {
        void selectLocation(int location);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (SelectLocation) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement " + FragmentSpecialitiesDialog.SelectSpeciality.class.getName());
        }

    }
}
