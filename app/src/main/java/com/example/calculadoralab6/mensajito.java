package com.example.calculadoralab6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class mensajito extends DialogFragment {


    String titulo;

    public mensajito(String titulo, String resultado, String boton) {
        this.titulo = titulo;
        this.resultado = resultado;
        this.boton = boton;
    }

    String resultado;
    String boton;

    public Dialog onCreateDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(resultado)
                .setTitle(titulo)
                .setPositiveButton(boton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}