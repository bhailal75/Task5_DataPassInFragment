package com.bhailal.sony.task5fragmentdatatransfer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sony on 07-02-2017.
 */

public class Blue extends Fragment {
    Button b;
    TextView txtblue1,txtblue2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.blue,container,false);

        txtblue1 = (TextView)view.findViewById(R.id.txt1);
        txtblue2 = (TextView)view.findViewById(R.id.txt2);


        String t1 = getArguments().getString("myuser");
        String t2 = getArguments().getString("mypass");

        txtblue1.setText(t1);
        txtblue2.setText(t2);
        b = (Button)view.findViewById(R.id.btnbluepre);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
