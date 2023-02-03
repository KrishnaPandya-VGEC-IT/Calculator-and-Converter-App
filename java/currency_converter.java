package com.example.mini_project_mcwc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class currency_converter extends Fragment implements AdapterView.OnItemSelectedListener
{

    View v;
    Spinner first,second;
    Button b;
    EditText input;
    String take;
    TextView output;
    Float number,give;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.currency_converter,container,false);
        first = v.findViewById(R.id.currency_left_side_uc);
        second = v.findViewById(R.id.currency_right_side_uc);
        input = v.findViewById(R.id.ip_in_currency);
        output = v.findViewById(R.id.curr_output);
        b = v.findViewById(R.id.curr_convert);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.currencies,R.layout.spinner_item_main);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        first.setAdapter(adapter);
        first.setOnItemSelectedListener(this);
        final ArrayAdapter<CharSequence> sec_adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.currencies,R.layout.spinner_item_main);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        first.setAdapter(adapter);
        first.setOnItemSelectedListener(this);
        second.setAdapter(adapter);
        second.setOnItemSelectedListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take = input.getText().toString();
                if(take.isEmpty() == false)
                {
                    number = Float.parseFloat(take);
                    if(first.getSelectedItemPosition() == 0) //USD
                    {
                        if(second.getSelectedItemPosition() == 0)//USD
                        {
                            give = number;
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 1) //INR
                        {
                            give =(float) (number * 73.16);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 2) //Pound
                        {
                            give =(float) (number * 0.77);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 3) //CAD
                        {
                            give = (float)(number*1.32);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 4) //Euro
                        {
                            give = (float)(number*0.85);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 5) //Yuan
                        {
                            give = (float)(number * 6.71);
                            output.setText(Float.toString(give));
                        }
                    }
                    else if(first.getSelectedItemPosition() == 1) //INR
                    {
                        if(second.getSelectedItemPosition() == 0)//USD
                        {
                            give = (float) (number * 0.014);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 1) //INR
                        {
                            give =number;
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 2) //Pound
                        {
                            give =(float) (number * 0.011);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 3) //CAD
                        {
                            give = (float)(number * 0.018);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 4) //Euro
                        {
                            give = (float)(number*0.012);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 5) //Yuan
                        {
                            give = (float)(number * 0.092);
                            output.setText(Float.toString(give));
                        }
                    }
                    else if(first.getSelectedItemPosition() == 2) //Pound
                    {
                        if(second.getSelectedItemPosition() == 0)//USD
                        {
                            give = (float) (number * 1.29);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 1) //INR
                        {
                            give =(float) (number * 94.55);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 2) //Pound
                        {
                            give =number;
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 3) //CAD
                        {
                            give = (float)(number*1.70);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 4) //Euro
                        {
                            give = (float)(number*1.10);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 5) //Yuan
                        {
                            give = (float)(number * 8.67);
                            output.setText(Float.toString(give));
                        }
                    }
                    else if(first.getSelectedItemPosition() == 3) //CAD
                    {
                        if(second.getSelectedItemPosition() == 0)//USD
                        {
                            give = (float) (number * 0.76);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 1) //INR
                        {
                            give =(float) (number * 55.53);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 2) //Pound
                        {
                            give =(float) (number * 0.59);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 3) //CAD
                        {
                            give = number;
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 4) //Euro
                        {
                            give = (float)(number*0.64);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 5) //Yuan
                        {
                            give = (float)(number * 5.09);
                            output.setText(Float.toString(give));
                        }
                    }
                    else if(first.getSelectedItemPosition() == 4) //Euro
                    {
                        if(second.getSelectedItemPosition() == 0)//USD
                        {
                            give = (float) (number * 1.18);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 1) //INR
                        {
                            give =(float) (number * 86.28);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 2) //Pound
                        {
                            give =(float) (number * 0.91);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 3) //CAD
                        {
                            give = (float)(number*1.55);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 4) //Euro
                        {
                            give = number;
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 5) //Yuan
                        {
                            give = (float)(number * 7.92);
                            output.setText(Float.toString(give));
                        }
                    }
                    else if(first.getSelectedItemPosition() == 5) //Yuan
                    {
                        if(second.getSelectedItemPosition() == 0)//USD
                        {
                            give = (float) (number * 0.15);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 1) //INR
                        {
                            give =(float) (number * 10.91);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 2) //Pound
                        {
                            give =(float) (number * 0.12);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 3) //CAD
                        {
                            give = (float)(number*0.20);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 4) //Euro
                        {
                            give = (float)(number*0.13);
                            output.setText(Float.toString(give));
                        }
                        else if(second.getSelectedItemPosition() == 5) //Yuan
                        {
                            give = number;
                            output.setText(Float.toString(give));
                        }
                    }
                }
                else
                {
                    output.setText("");
                    Toast.makeText(v.getContext(),"Please enter input",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
