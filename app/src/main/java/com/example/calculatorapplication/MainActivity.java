package com.example.calculatorapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isNewOpr;
EditText ed1;
String oldNumber="";
String op="+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1= findViewById(R.id.editTextTextPersonName);
    }

    public void nuberEvent(View view) {
        if(isNewOpr)
            ed1.setText("");
        isNewOpr=false;
        String number = ed1.getText().toString();
        switch(view.getId()){
            case R.id.sept:
                number+="7";
                break;
            case R.id.six:
                number+="6";
                break;
            case R.id.cinq:
                number+="5";
                break;
            case R.id.quatre:
                number+="4";
                break;
            case R.id.trois:
                number+="3";
                break;
            case R.id.un:
                number+="1";
                break;
            case R.id.deux:
                number+="2";
                break;
            case R.id.huit:
                number+="8";
                break;
            case R.id.neuf:
                number+="9";
                break;
            case R.id.dot:
                number+=".";
                break;
            case R.id.devide:
                number+="/";
                break;
            case R.id.plusMoins:
                number="-"+number;
                break;
        }
        ed1.setText(number);
    }

    public void operationEvent(View view) {
        isNewOpr=true;
        oldNumber=ed1.getText().toString();
        switch(view.getId()){
            case R.id.devide:
                op="/";
                break;
            case R.id.multiply:
                op="*";
                break;
            case R.id.plus:
                op="+";
                break;
            case R.id.moins:
                op="-";
                break;
    }
}

    public void equalActivity(View view) {
        String newNumber= ed1.getText().toString();
        double result=0.0;
        switch(op){
            case "+":
              result=  Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result=  Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "/":
                  result=  Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
            case "%":
                result=  Double.parseDouble(oldNumber)%Double.parseDouble(newNumber);
                break;

            case "*":
                result=  Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
        }
ed1.setText(result+ " ");

    }

    public void acEvent(View view) {
        ed1.setText("0");
        isNewOpr=true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"item 1 is selected",Toast.LENGTH_SHORT).show();
                return true;
                case R.id.item2:
                Toast.makeText(this,"item 2 is selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this,"subitem 1 is selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem2:
                Toast.makeText(this,"subitem 2 is selected",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}