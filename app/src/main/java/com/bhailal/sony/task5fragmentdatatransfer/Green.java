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
import android.widget.TextView;

/**
 * Created by Sony on 07-02-2017.
 */

public class Green extends Fragment {

    Button gnext,gpre;
    EditText myedtGreen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.green,container,false);

        myedtGreen = (EditText)view.findViewById(R.id.edtGreen);

        TextView txtuser = (TextView)view.findViewById(R.id.txtUser);

        final String  value1 = getArguments().getString("MyKey");

        txtuser.setText(value1);

                gnext = (Button) view.findViewById(R.id.btngreennext);
                gpre = (Button)view.findViewById(R.id.btngreenpre);

        gnext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Blue newblue = new Blue();
            String value2  = myedtGreen.getText().toString();

            FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                Bundle ar = new Bundle();
                ar.putString("myuser",value1);
                ar.putString("mypass",value2);
                newblue.setArguments(ar);

                transaction.replace(R.id.lldisp,newblue);
                myedtGreen.setText("");
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        gpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });




        return view;
    }
}
