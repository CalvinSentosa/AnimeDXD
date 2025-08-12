package com.example.animedxd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class HunterReviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.hunter_fragment_review, container, false);

        Button addButton = root.findViewById(R.id.addButton); // set id for Add button in XML
        addButton.setOnClickListener(v -> showAddReviewDialog());

        return root;
    }
    private void showAddReviewDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.dialog_add_review, null);

        RatingBar ratingBar = dialogView.findViewById(R.id.ratingBar);
        EditText etComment = dialogView.findViewById(R.id.etComment);
        TextView tvError = dialogView.findViewById(R.id.tvError);

        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(dialogView)
                .create();

        Button btnCancel = dialogView.findViewById(R.id.btnCancel);
        Button btnUpload = dialogView.findViewById(R.id.btnUpload);

        btnCancel.setOnClickListener(v -> dialog.dismiss());

        btnUpload.setOnClickListener(v -> {
            String comment = etComment.getText().toString().trim();
            if (comment.isEmpty()) {
                tvError.setVisibility(View.VISIBLE);
            } else {
                tvError.setVisibility(View.GONE);
                // TODO: Save review to database or list
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

