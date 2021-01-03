package com.codingburg.math.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.codingburg.math.R;
import com.codingburg.math.ui.ApiActivity;

public class InputYear extends AppCompatDialogFragment {
    private EditText editTextUsername;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.yearbox, null);
        builder.setView(view)
                .setTitle("Write any year : ")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = editTextUsername.getText().toString();
                        Intent intent = new Intent(getContext(), ApiActivity.class);
                        intent.putExtra("key", username);
                        intent.putExtra("type", "year");

                        startActivity(intent);
                    }
                });
        editTextUsername = view.findViewById(R.id.edit_username);
        return builder.create();
    }



}