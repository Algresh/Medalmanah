package ru.tulupov.alex.medalmanah;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by tulup on 07.11.2016.
 */

public class FragmentSpecialitiesDialog extends DialogFragment implements DialogInterface.OnClickListener {

    Speciality[] specialitiesArray;
    String[] specialitiesTitle;

    SelectSpeciality listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources res = getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(res.getString(R.string.selectSpecialities))
                .setSingleChoiceItems(specialitiesTitle, 0, this)
                .setNegativeButton(res.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                });

        return builder.create();
    }

    public void setArraySpecialities (ListSpecialities specialities) {
        List<Speciality> list = specialities.getSpecialties();
        specialitiesArray = new Speciality[list.size()];
        specialitiesTitle = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            specialitiesArray[i] = list.get(i);
            specialitiesTitle[i] = list.get(i).getTitle();
        }
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        listener.selectSpeciality(specialitiesArray[i]);
        dismiss();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (SelectSpeciality) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement " + FragmentSpecialitiesDialog.SelectSpeciality.class.getName());
        }

    }

    public interface SelectSpeciality {
        void selectSpeciality(Speciality speciality);
    }
}
