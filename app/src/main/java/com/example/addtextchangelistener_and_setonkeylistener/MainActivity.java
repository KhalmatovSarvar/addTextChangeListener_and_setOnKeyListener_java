package com.example.addtextchangelistener_and_setonkeylistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_validUserName,edt_uzs, edt_usd;
    Button btn_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    initViews();
    }

    private void initViews() {
        edt_validUserName = findViewById(R.id.edt_validName);
      btn_confirm = findViewById(R.id.btn_confirm);
      edt_usd = findViewById(R.id.edt_usd);
      edt_uzs = findViewById(R.id.edt_uzs);
        btn_confirm.setEnabled(false);


        convert();
       textChangedListener();
    }

    private void convert() {
        edt_usd.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String USD = edt_usd.getText().toString();
                if(USD.isEmpty()){
                    edt_uzs.setText("");
                }else{
                    double num = Double.valueOf(USD)*10825.00;
                    edt_uzs.setText(num+"");
                }
                return false;
            }
        });

        edt_uzs.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String UZS = edt_uzs.getText().toString();
                if(UZS.isEmpty()){
                    edt_usd.setText("");
                }else{
                    double num = Double.valueOf(UZS)/10825.00;
                    edt_usd.setText(num+"");
                }
                return false;
            }
        });
    }

    private void textChangedListener() {

        edt_validUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                     String onTimePassword = edt_validUserName.getText().toString();
                     if(onTimePassword.length()>3 && onTimePassword.length()<10){
                         btn_confirm.setEnabled(true);
                     }else{
                         Toast.makeText(MainActivity.this,"Invalid name",Toast.LENGTH_SHORT).show();
                         btn_confirm.setEnabled(false);
                     }


            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}