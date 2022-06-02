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

public class Kayit_Fragment extends Fragment   {
    protected Button saveOldKm;
    protected EditText editTextUserOldK, editTextPasswordOldK;
    private Toast toastFırst,toastSecond;
    public static  String receivedName,receivedPass;
    private boolean errorOne,errorSecond;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_kayit_, container, false);

        saveOldKm = V.findViewById(R.id.saveOldKm);
        editTextUserOldK = V.findViewById(R.id.editTextUserOldK);
        editTextPasswordOldK = V.findViewById(R.id.editTextPasswordOldK);

        saveOldKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 receivedName = editTextUserOldK.getText().toString();
                 receivedPass = editTextPasswordOldK.getText().toString();
                 Data data = new Data();
                data.setUserName(receivedName);
                data.setPassWord(receivedPass);

                editTextPasswordOldK.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                        if(i== EditorInfo.IME_NULL && keyEvent.getAction() == KeyEvent.ACTION_DOWN){

                        }
                        return false;
                    }
                });


                if (receivedPass.length()>= 10) {
                    Toast.makeText(getContext(), R.string.toastFırst, Toast.LENGTH_LONG).show();

                } else if (receivedName.length()== 0 ) {
                    editTextUserOldK.setError(getContext().getText(R.string.errorOne ));

                } else if (receivedPass.length()== 0) {
                    editTextPasswordOldK.setError(getContext().getText(R.string.errorSecond));

                }else{
                    Toast.makeText(getContext(), R.string.toastSecond, Toast.LENGTH_SHORT).show();

                Navigation.findNavController(view).navigate(R.id.yenii);

                }
            }

        });
        return V;
    }
}