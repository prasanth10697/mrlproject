package com.example.mybasic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class MultipleChoiceDialogFragment extends DialogFragment {

    ArrayList<String>arrayList = new ArrayList<>();

    public interface onMultiChoiceListener {
        void onPositiveButtonClicked(String[] list, ArrayList<String> selectedItemList);

        void onNegativeButtonClicked();
    }

    onMultiChoiceListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (onMultiChoiceListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " onMultiChoiceListener must implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final ArrayList<String> selectedItemList = new ArrayList<>();

        arrayList.add("thala");
        arrayList.add("thalapathy");
        arrayList.add("vijay");
        arrayList.add("prasanth");
        arrayList.add("aijth");
        arrayList.add("mari");
        arrayList.add("muthu");
        arrayList.add("thala");
        arrayList.add("thalapathy");
        arrayList.add("vijay");
        arrayList.add("prasanth");
        arrayList.add("aijth");
        arrayList.add("mari");
        arrayList.add("muthu");
        arrayList.add("thala");
        arrayList.add("thalapathy");
        arrayList.add("vijay");
        arrayList.add("prasanth");
        arrayList.add("aijth");
        arrayList.add("mari");
        arrayList.add("muthu");


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

       final String[] items = new String[arrayList.size()];

        for(int i=0; i<arrayList.size(); i++){
            //Storing names to string array
            items[i] = String.valueOf(arrayList.get(i).equals(arrayList));
        }

       // final String[] list = getActivity().getResources().getStringArray(R.array.choice_items);

        builder.setTitle("Select Your Choice")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b) {
                            selectedItemList.add(items[i]);
                        } else {
                            selectedItemList.remove(items[i]);
                        }
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onPositiveButtonClicked(items, selectedItemList);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onNegativeButtonClicked();
                    }
                });

        return builder.create();

    }}
