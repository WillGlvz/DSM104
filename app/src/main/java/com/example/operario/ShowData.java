package com.example.operario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ShowData extends AppCompatActivity {
    private TextView tv1, tv2, tv3;
    DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    DecimalFormat df = new DecimalFormat("0.00", simbolos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        tv1 = (TextView)findViewById(R.id.tvsueldoactual);
        tv2 = (TextView)findViewById(R.id.tvanios);
        tv3 = (TextView)findViewById(R.id.tvnuevosueldo);

        Bundle data = this.getIntent().getExtras();
        Double salary = data.getDouble("salary");
        tv1.setText("Salario actual: $" + String.valueOf(df.format(salary)));
        int years = data.getInt("years");
        tv2.setText("Años de antiguedad: " + String.valueOf(years));
        Double NewSalary = data.getDouble("Newsalary");
        tv3.setText("Nuevo salario: $" + String.valueOf(df.format(NewSalary)));
    }

    public void Back(View view){
        finish();
    }
}