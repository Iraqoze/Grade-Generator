package com.example.makeup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

EditText edtAPT3060, edtAPT1030, edtIST2045, edtAPT2055, edtBUS1010;
TextView txtAPT3060, txtAPT1030, txtIST2045, txtAPT2055, txtBUS1010;
Button generateBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtAPT1030=findViewById(R.id.edtAPT1030);
        edtAPT3060=findViewById(R.id.edtAPT3060);
        edtAPT2055=findViewById(R.id.edtAPT2055);
        edtIST2045=findViewById(R.id.edtIST2045);
        edtBUS1010=findViewById(R.id.edtBus1010);
        generateBtn=findViewById(R.id.generateBtn);

        txtAPT3060=findViewById(R.id.txtApt3060Grade);
        txtIST2045=findViewById(R.id.txtIST2045Grade);
        txtBUS1010=findViewById(R.id.txtBus1010Grade);
        txtAPT1030=findViewById(R.id.txtAPT1030Grade);
        txtAPT2055=findViewById(R.id.txtApt20555Grade);




        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Apt3060=edtAPT3060.getText().toString();
                String Apt2055=edtAPT2055.getText().toString();
                String Apt1030=edtAPT1030.getText().toString();
                String Ist2045=edtIST2045.getText().toString();
                String Bus1010=edtBUS1010.getText().toString();

                if(Apt1030.isEmpty() || Apt2055.isEmpty() || Apt3060.isEmpty() || Bus1010.isEmpty() || Ist2045.isEmpty()){
                    edtAPT1030.setError("Invalid Marks");
                    edtAPT2055.setError("Invalid Marks");
                    edtAPT3060.setError("Invalid Marks");
                    edtIST2045.setError("Invalid Marks");
                    edtBUS1010.setError("Invalid Marks");
                    return;
                }

            boolean isValid=isValid(Integer.parseInt(Apt1030),Integer.parseInt(Apt2055),Integer.parseInt(Apt3060),Integer.parseInt(Bus1010),Integer.parseInt(Ist2045));
            if(!isValid){
                edtAPT1030.setError("Valid Marks");
                edtAPT2055.setError("Valid Marks");
                edtAPT3060.setError("Valid Marks");
                edtIST2045.setError("Valid Marks");
                edtBUS1010.setError("Valid Marks");
                return;
            }

                String g1030=getGrade(Integer.parseInt(Apt1030));
                String g3060=getGrade(Integer.parseInt(Apt3060));
                String g2045=getGrade(Integer.parseInt(Ist2045));
                String g1010=getGrade(Integer.parseInt(Bus1010));
                String g2055=getGrade(Integer.parseInt(Apt2055));

                txtAPT1030.setText(g1030);
                txtAPT2055.setText(g2055);
                txtAPT3060.setText(g3060);
                txtBUS1010.setText(g1010);
                txtIST2045.setText(g2045);
                System.out.println("TUKO HAPA");
            }


        });
    }

    private String getGrade(int marks){

        if(marks>=70 && marks<=100)
            return "A";
        if(marks>=60 && marks<=69)
            return "B";
        if (marks>=50 && marks<=59)
            return "C";
        if(marks>=40 && marks<=49)
            return "D";
        else
            return "F";
    }
    private boolean isValid(int apt1030, int apt2055, int apt3060,int bus1010,int ist2045){
        if (apt1030 <0 || apt1030>100)
            return  false;
        if (apt2055 <0 || apt2055>100)
            return  false;
        if (apt3060 <0 || apt3060>100)
            return  false;
        if (bus1010 <0 || bus1010>100)
            return  false;
        if (ist2045 <0 || ist2045>100)
            return  false;
        return true;

    }


}