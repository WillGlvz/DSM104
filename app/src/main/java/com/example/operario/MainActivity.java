package com.example.operario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2;
    DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    DecimalFormat df = new DecimalFormat("0.00", simbolos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.txtsueldo);
        edt2 = (EditText)findViewById(R.id.txtanhos);
    }

    public void Send(View view){
        String valor1 = edt1.getText().toString();
        String valor2 = edt2.getText().toString();

        if (valor1.length() == 0 || valor2.length() == 0) {
            edt1.setError("Campo en blanco.");
            edt2.setError("Campo en blanco.");
        }else{
            Double sueldo = Double.parseDouble(valor1);
            int anios = Integer.parseInt(valor2);

            if (sueldo < 500.00 && anios >= 10 && sueldo >= 100){
                Double aumento = sueldo*0.2;
                Double nuevoSueldo = sueldo + aumento;
                Bundle data = new Bundle();
                data.putDouble("salary", sueldo);
                data.putInt("years", anios);
                data.putDouble("Newsalary", nuevoSueldo);
                Intent i = new Intent(this,ShowData.class);
                i.putExtras(data);
                startActivity(i);
            }else if (sueldo < 500.00 && anios < 10 && sueldo >= 100){
                Double aumento = sueldo*0.05;
                Double nuevoSueldo = sueldo + aumento;
                Bundle data = new Bundle();
                data.putDouble("salary", sueldo);
                data.putInt("years", anios);
                data.putDouble("Newsalary", nuevoSueldo);
                Intent i = new Intent(this,ShowData.class);
                i.putExtras(data);
                startActivity(i);
            }else if (sueldo > 500){
                Bundle data = new Bundle();
                data.putDouble("salary", sueldo);
                data.putInt("years", anios);
                data.putDouble("Newsalary", sueldo);
                Intent i = new Intent(this,ShowData.class);
                i.putExtras(data);
                startActivity(i);
            }else if (sueldo < 100.00) {
                Toast.makeText(this, "No se permiten sueldos menores a $100.", Toast.LENGTH_SHORT).show();
            }else if (anios < 0) {
                Toast.makeText(this, "No se permiten valores negativos.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}