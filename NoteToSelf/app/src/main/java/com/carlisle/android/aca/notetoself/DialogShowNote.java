package com.carlisle.android.aca.notetoself;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chriscarlisle on 9/15/16.
 */
public class DialogShowNote extends DialogFragment {

    private Note mNote;
    ImageView imageView2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // All the other code goes here
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_note, null);

        TextView txtTitle = (TextView) dialogView.findViewById(R.id.txtTitle);

        TextView txtDescription = (TextView) dialogView.findViewById(R.id.txtDescription);

        ImageView imageView2 = (ImageView) dialogView.findViewById(R.id.imageView2);

        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());
        imageView2.setImageURI(mNote.getPhoto());

        ImageView ivImportant = (ImageView) dialogView.findViewById(R.id.imageViewImportant);
        ImageView ivTodo = (ImageView) dialogView.findViewById(R.id.imageViewTodo);
        ImageView ivIdea = (ImageView) dialogView.findViewById(R.id.imageViewIdea);

        if (!mNote.isImportant()){
            ivImportant.setVisibility(View.GONE);
        }

        if (!mNote.isTodo()){
            ivTodo.setVisibility(View.GONE);
        }

        if (!mNote.isIdea()){
            ivIdea.setVisibility(View.GONE);
        }

        Button btnOK = (Button) dialogView.findViewById(R.id.btnOk);

        builder.setView(dialogView).setMessage("Your Note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();

    }


    // Receive a note from the MainActivity
    public void sendNoteSelected(Note noteSelected) {
        mNote = noteSelected;
    }


}


