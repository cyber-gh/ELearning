package dev.skyit.elearning.student.ui.courses.details;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import dev.skyit.elearning.R;
import dev.skyit.elearning.student.StudentActivity;
import dev.skyit.model.Student;
import thinkit.redesign.ui.generic.ActivityDestination;

public class TestCourseDialog extends DialogFragment {

    TextView q1, q2, q3, ans1, ans2, ans3;
    Button btn;

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_test_course, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewByIdBiding(view);

        ans1.setOnClickListener(l -> {
            List<String> somethingList = new ArrayList<>();
            somethingList.add("Response 1");
            somethingList.add("Response 2");
            somethingList.add("Response 3");
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice, somethingList);


            new MaterialAlertDialogBuilder(getContext())
                    .setTitle("Choose your answer")
                    .setNeutralButton("Cancel", (dialog, which) -> {
                        dialog.dismiss();
                    }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
                    .setSingleChoiceItems(arrayAdapter, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String ans = (String) arrayAdapter.getItem(which);
                            ans1.setText(ans);
                        }
                    }).show();
        });


        ans2.setOnClickListener(l -> {
            List<String> somethingList = new ArrayList<>();
            somethingList.add("Response 1");
            somethingList.add("Response 2");
            somethingList.add("Response 3");
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice, somethingList);


            new MaterialAlertDialogBuilder(getContext())
                    .setTitle("Choose your answer")
                    .setNeutralButton("Cancel", (dialog, which) -> {
                        dialog.dismiss();
                    }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
                    .setSingleChoiceItems(arrayAdapter, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String ans = (String) arrayAdapter.getItem(which);
                            ans2.setText(ans);
                        }
                    }).show();
        });

        ans3.setOnClickListener(l -> {
            List<String> somethingList = new ArrayList<>();
            somethingList.add("Response 1");
            somethingList.add("Response 2");
            somethingList.add("Response 3");
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice, somethingList);


            new MaterialAlertDialogBuilder(getContext())
                    .setTitle("Choose your answer")
                    .setNeutralButton("Cancel", (dialog, which) -> {
                        dialog.dismiss();
                    }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
                    .setSingleChoiceItems(arrayAdapter, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String ans = (String) arrayAdapter.getItem(which);
                            ans3.setText(ans);
                        }
                    }).show();
        });

        btn.setOnClickListener(l -> {
            Intent intent = new Intent(getContext(), StudentActivity.class);
            startActivity(intent);
            getActivity().finish();
            getActivity().finishAffinity();
        });

//        okButton.setOnClickListener(v -> {
//            dismiss();
//        });
//
//        zoomLink.setOnClickListener(l -> {
//            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://us04web.zoom.us/j/2160563556?pwd=MUxqaXVqYTNtMjdMYjd5TUJrZVBndz09"));
//            startActivity(browserIntent);
//        });
    }

    public void findViewByIdBiding(View view) {
        q1 = view.findViewById(R.id.qustion1);
        q2 = view.findViewById(R.id.question2);
        q3 = view.findViewById(R.id.question3);
        ans1 = view.findViewById(R.id.response1);
        ans2 = view.findViewById(R.id.response2);
        ans3 = view.findViewById(R.id.response3);
        btn = view.findViewById(R.id.button);
//        okButton = view.findViewById(R.id.rci_ok_button);
//        zoomLink = view.findViewById(R.id.zoomLink);

    }

}
