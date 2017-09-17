package com.programacion.movil.estemanp.androidmvcapplication.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import com.programacion.movil.estemanp.androidmvcapplication.Controller.ApplicationController;
import com.programacion.movil.estemanp.androidmvcapplication.R;

public class LoginActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    public Button but;
    public Spinner spinner1;
    String usuario, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName=(android.widget.EditText) this.findViewById(R.id.editUsername);
        password=(android.widget.EditText) this.findViewById(R.id.editPassword);
        but=(Button)findViewById(R.id.btnLogin );
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        admin = "Admin";
        usuario = "User";
    }

    public void login(View view) {
        if (ApplicationController.getInstance().isValidUser(userName.getText().toString(), password.getText().toString(), spinner1.getSelectedItem().toString()) && admin.equals(spinner1.getSelectedItem().toString())) {
            Intent intent = new Intent(this, Admin.class);
            startActivity(intent);
        } else if (ApplicationController.getInstance().isValidUser(userName.getText().toString(), password.getText().toString(), spinner1.getSelectedItem().toString()) && usuario.equals(spinner1.getSelectedItem().toString())){
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), Evento_activity.class);
            intent.setAction(Evento_activity.class.getName());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            getApplicationContext().startActivity(intent);
        }else{
            Toast.makeText(this, "El usuario, contraseña o rol no coinciden", Toast.LENGTH_SHORT).show();
        }
    }

}
