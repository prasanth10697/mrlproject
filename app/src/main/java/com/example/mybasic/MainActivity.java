package com.example.mybasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MultipleChoiceDialogFragment.onMultiChoiceListener {

    SearchableSpinner searchableSpinner;
    ArrayList<String>arrayList = new ArrayList<>();
    TextView tvSelectedChoices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelectedChoices = findViewById(R.id.test);

        Button btnSelectChoices = findViewById(R.id.btnSelectChoices);
        btnSelectChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment multiChoiceDialog = new MultipleChoiceDialogFragment();
                multiChoiceDialog.setCancelable(false);
                multiChoiceDialog.show(getSupportFragmentManager(), "Multichoice Dialog");
            }
        });
        /*searchableSpinner = findViewById(R.id.spiner);

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

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        searchableSpinner.setAdapter(adapter);*/
    }
    @Override
    public void onPositiveButtonClicked(String[] list, ArrayList<String> selectedItemList) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Selected Choices = ");
        for (String str : selectedItemList) {
            stringBuilder.append(str + ",");
        }
        tvSelectedChoices.setText(stringBuilder);

    }

    @Override
    public void onNegativeButtonClicked() {
        tvSelectedChoices.setText("Dialog Cancel");
    }
}