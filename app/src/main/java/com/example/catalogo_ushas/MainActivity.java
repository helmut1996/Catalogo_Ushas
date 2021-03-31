package com.example.catalogo_ushas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText passw;
    private Spinner user;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.textUser);
        passw = findViewById(R.id.textpass);
        login = findViewById(R.id.btn_Login);
        login.setOnClickListener(this);

        //esta funcion se utiliza para la lista de usuarios
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.User, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user.setAdapter(adapter1);

///////////////////////////////////////////////////////////////////////////////////////////
    }


/*
para insertar Datos
    private void insertRecords(){
        Usuarios usu = new Usuarios();
        String Users=user.getSelectedItem().toString();
        String Pass=passw.getText().toString();

        usu.setNombreUsuario(Users);
        usu.setPassUsuario(Pass);

        usu.save();
        Toast.makeText(this,"Guardado Usuario",Toast.LENGTH_LONG).show();
        passw.setText("");
    }


 */

/*public void  login(){
    Usuarios.find(Usuarios.class, "nombre_usuario = ? and password = ?", user.getSelectedItem().toString(), passw.getText().toString());

} */



    @Override
    public void onClick(View view) {

        String username=user.getSelectedItem().toString();
        String password=passw.getText().toString();
        switch (view.getId()) {

            case R.id.btn_Login:
                if (user.getSelectedItemPosition()==0){
                    Toast.makeText(this,R.string.value_user,Toast.LENGTH_SHORT).show();
                }else if (passw.getText().toString().isEmpty()){
                    Toast.makeText(this,R.string.value_pass_isemty,Toast.LENGTH_SHORT).show();
                }else if(username.equals("Facturacion") && password.equals("facturacion")){
                    saveLoginSharedPrefences(username);
                    finish();
                    Intent intent = new Intent(getApplicationContext(), MainProductos.class);

                    startActivity(intent);
                }else if(username.equals("Vendedor") && password.equals("vendedor")){
                    saveLoginSharedPrefences(username);
                    Intent intent = new Intent(getApplicationContext(), MainProductos.class);

                    startActivity(intent);
                    finish();
                }else if(username.equals("Marlon") && password.equals("cosmeticos")){
                    saveLoginSharedPrefences(username);
                    Intent intent = new Intent(getApplicationContext(), MainProductos.class);
                    startActivity(intent);
                    finish();
                }else if(username.equals("Tania Lira") && password.equals("lira")){
                    saveLoginSharedPrefences(username);
                    Intent intent = new Intent(getApplicationContext(), MainProductos.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(this,R.string.mensaje,Toast.LENGTH_SHORT).show();

                }
                break;

        }

    }

    private void saveLoginSharedPrefences(String username) {
        SharedPreferences sharedPref=getSharedPreferences("login_preferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("username",username);
        editor.commit();
    }

}

