package com.example.a26052022_login;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class Giris_Fragment extends Fragment {


    private Button saveOld;
    private EditText editTextUserOld, editTextPasswordOld;
    private Toast toastOne, toastTwo, toastTheree;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_giris, container, false);


        saveOld = V.findViewById(R.id.saveOldKm);
        editTextUserOld = V.findViewById(R.id.editTextUserOldK);
        editTextPasswordOld = V.findViewById(R.id.editTextPasswordOldK);


        Data data=new Data();

        saveOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (editTextPasswordOld.getText().toString().equals(data.getPassWord()) && editTextUserOld.getText().toString().equals(data.getUserName())) {
                    Toast.makeText(getContext(), R.string.toastOne, Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.gecisss);

                    editTextPasswordOld.setText("");
                    editTextUserOld.setText("");

                } else if (editTextPasswordOld.getText().toString().equals("") && editTextUserOld.getText().toString().equals("")) {

                    Toast.makeText(getContext(), R.string.toastTwo, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), R.string.toastTheree, Toast.LENGTH_SHORT).show();
                }


            }
        });
        return V;
    }
}