package dev.skyit.elearning.student.ui.courses.details;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import dev.skyit.elearning.R;

public class TeacherInfoDialog extends DialogFragment {

    private ConstraintLayout zoomLink;
    private Button okButton;

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_teacher_info, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewByIdBiding(view);

        okButton.setOnClickListener(v -> {
            dismiss();
        });

        zoomLink.setOnClickListener(l -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://us04web.zoom.us/j/2160563556?pwd=MUxqaXVqYTNtMjdMYjd5TUJrZVBndz09"));
            startActivity(browserIntent);
        });
    }

    public void findViewByIdBiding(View view) {
        okButton = view.findViewById(R.id.rci_ok_button);
        zoomLink = view.findViewById(R.id.zoomLink);

    }

}

