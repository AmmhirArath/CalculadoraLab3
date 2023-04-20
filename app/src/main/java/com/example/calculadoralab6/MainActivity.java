package com.example.calculadoralab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtNum1;
    EditText txtNum2;
    Spinner spnOperaciones;
    Button btnCalcular;
    TextView lblResultado;

    CheckBox chkSi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InicializarControles();
    }
    private void InicializarControles() {
        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);
        btnCalcular = (Button)findViewById(R.id.button);
        lblResultado = (TextView)findViewById(R.id.lblRes);
        spnOperaciones = (Spinner)findViewById(R.id.spnOperacion);
        chkSi = (CheckBox)findViewById(R.id.chkSi);


    }
    public void SumarNumeros(View view)
    {
        try{
            String resultado="";
            String seleccionado = spnOperaciones.getSelectedItem().toString();
            if (seleccionado.equals("Seleccionar operación")){
                new mensajito("Error D:", "Por favor seleccione una operación", "" +
                        "Aceptar ;)").show(getSupportFragmentManager(), "xd");
                lblResultado.setText("");
            }else if(seleccionado.equals("Dividir")){
                double n1 = Integer.parseInt(txtNum1.getText().toString());
                double n2 = Integer.parseInt(txtNum2.getText().toString());
                double division = n1 / n2;
                resultado = String.valueOf(division);
                if(chkSi.isChecked()) {
                    new mensajito("Resultado", "El resultado es = " + resultado, "" +
                            "Aceptar ;)").show(getSupportFragmentManager(), "xd");
                    lblResultado.setText("");
                }else{
                    lblResultado.setText("El resultado es = "+resultado);
                }
            }else{
                int n1 = Integer.parseInt(txtNum1.getText().toString());
                int n2 = Integer.parseInt(txtNum2.getText().toString());
                if(seleccionado.equals("Sumar")){
                    int suma = n1+n2;
                    resultado = String.valueOf(suma);

                } else if(seleccionado.equals("Restar")){
                    int resta = n1 - n2;
                    resultado = String.valueOf(resta);

                } else if(seleccionado.equals("Multiplicar")) {
                    int multiplicacion = n1 * n2;
                    resultado = String.valueOf(multiplicacion);
                }
                if(chkSi.isChecked()) {
                    new mensajito("Resultado", "El resultado es = " + resultado, "" +
                            "Aceptar ;)").show(getSupportFragmentManager(), "xd");
                    lblResultado.setText("");
                }else{
                    lblResultado.setText("El resultado es = "+resultado);
                }
            }
        }
        catch (Exception e)
        {
            new mensajito("Error en los digitos D:", "Verifique o coloque los digitos", "" +
                    "Aceptar :(").show(getSupportFragmentManager(), "xd");
        }

    }
}