package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.String;

public class MainActivity extends AppCompatActivity {

    String[] arrayResult;
    Double resultado;
    String operacion ="";
    boolean auxBoolean =false;
    TextView textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textField = (TextView) findViewById(R.id.textField);
    }


    public void pulsarCero(View view) {
        textField.setText(textField.getText()+ "0");
    }
    public void pulsarUno(View view) {
        textField.setText(textField.getText()+ "1");
    }
    public void pulsarDos(View view) {
        textField.setText(textField.getText()+ "2");
    }
    public void pulsarTres(View view) {
        textField.setText(textField.getText()+ "3");
    }
    public void pulsarCuatro(View view) {
        textField.setText(textField.getText()+ "4");
    }
    public void pulsarCinco(View view) {
        textField.setText(textField.getText()+ "5");
    }
    public void pulsarSeis(View view) {
        textField.setText(textField.getText()+ "6");
    }
    public void pulsarSiete(View view) {
        textField.setText(textField.getText()+ "7");
    }
    public void pulsarOcho(View view) {
        textField.setText(textField.getText()+ "8");
    }
    public void pulsarNueve(View view) {
        textField.setText(textField.getText()+ "9");
    }

    public void pulsarSuma(View view) {
        if(textField.getText().equals("")){}
        else{
            if(((textField.getText()).charAt(0)=='-')&& operacion.equals("-")){
                textField.setText(textField.getText()+ "+");
                operacion ="\\+";
            }else if(operacion.equals("")){
                textField.setText(textField.getText()+ "+");
                operacion ="\\+";
            }
        }

    }

    public void pulsarRestar(View view) {
        if(operacion.equals("")){
            textField.setText(textField.getText()+ "-");
            operacion ="-";
        }else if(((textField.getText()).charAt(0)== '-')&& operacion.equals("-") && auxBoolean ==false){
            textField.setText(textField.getText()+ "-");
            operacion ="-";
            auxBoolean =true;
        }
    }

    public void pulsarMultiplicacion(View view) {
        if(textField.getText().equals("")){}
        else{
            if(((textField.getText()).charAt(0)== '-')&& operacion.equals("-")){
                textField.setText(textField.getText()+ "x");
                operacion ="x";
            }else if(operacion.equals("")){
                textField.setText(textField.getText()+ "x");
                operacion ="x";
            }
        }
    }

    public void pulsarDivision(View view) {
        if(textField.getText().equals("")){

        }
        else{
            if(((textField.getText()).charAt(0)== '-')&& operacion.equals("-")){
                textField.setText(textField.getText()+ "÷");
                operacion ="÷";
            }else if(operacion.equals("")){
                textField.setText(textField.getText()+ "÷");
                operacion ="÷";
            }
        }
    }

    public void pulsarResultado(View view) {
        arrayResult = textField.getText().toString().split(operacion);
        if(auxBoolean ==true){
            resultado = (Double.parseDouble(arrayResult[1])*-1)-Double.parseDouble(arrayResult[2]);
        }else{
            switch(operacion){
                case "\\+": resultado = Double.parseDouble(arrayResult[0])+Double.parseDouble(arrayResult[1]);break;
                case "-": resultado = Double.parseDouble(arrayResult[0])-Double.parseDouble(arrayResult[1]);break;
                case "x": resultado = Double.parseDouble(arrayResult[0])*Double.parseDouble(arrayResult[1]);break;
                case "÷": resultado = Double.parseDouble(arrayResult[0])/Double.parseDouble(arrayResult[1]);break;
            }
        }

        String numAux="";
        int resultadoAux=0;
        numAux = resultado+"";
        String[] arrayAux;
        arrayAux=numAux.split("\\.");
        if(arrayAux[1].equals("0")){
            resultadoAux = Integer.parseInt(arrayAux[0]);
            textField.setText(resultadoAux+"");
        }else{
            textField.setText(resultado+"");
        }
        if(textField.getText().charAt(0)=='-'){
            operacion ="-";
        }else{
            operacion ="";
        }
        auxBoolean =false;
    }

    public void pulsarComa(View view) {
        textField.setText(textField.getText()+ ".");
    }

    public void pulsarBorrar(View view) {
        if(textField.getText().equals("")){
            System.out.println("nada");
        }
        else{
            textField.setText(textField.getText().toString().substring(0,textField.getText().length()-1));
        }
    }

    public void pulsarVaciar(View view) {
        textField.setText("");
        operacion ="";
        resultado=0.0;
        auxBoolean =false;
    }
}
