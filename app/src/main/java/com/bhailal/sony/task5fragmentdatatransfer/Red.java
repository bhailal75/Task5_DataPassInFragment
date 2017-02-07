package com.bhailal.sony.task5fragmentdatatransfer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sony on 07-02-2017.
 */

public class Red extends Fragment {

    Button b1;
    EditText edtred;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.red,container,false);
        b1 = (Button)view.findViewById(R.id.btnrednext);

        edtred = (EditText)view.findViewById(R.id.edtred);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Green newGreen = new Green();
                String temp = edtred.getText().toString();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                Bundle args = new Bundle();
                args.putString("MyKey",temp);
                newGreen.setArguments(args);

                transaction.replace(R.id.lldisp,newGreen);
                edtred.setText("");
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return view;
    }
}
