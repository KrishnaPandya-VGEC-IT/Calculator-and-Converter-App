package com.example.mini_project_mcwc;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
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


public class unit_converter extends Fragment implements AdapterView.OnItemSelectedListener
{
    View v;
    Spinner s,second,third;
    Button b;
    EditText input;
    String take;
    TextView output;
    float number,give;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.unit_converter,container,false);
        s = v.findViewById(R.id.spinner_unit_converter);
        second = v.findViewById(R.id.left_side_uc);
        output = v.findViewById(R.id.output);
        input = v.findViewById(R.id.input);
        b = v.findViewById(R.id.convert);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.all_types,R.layout.spinner_item_main);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take = input.getText().toString();
                if(take.isEmpty() == false)
                {
                    number = Float.parseFloat(take);
                    if(s.getSelectedItemPosition()==0)  //weight
                    {
                        if(second.getSelectedItemPosition() == 0) //kgs
                        {
                            if(third.getSelectedItemPosition() == 0) //kgs
                            {
                                give = number * 1;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //grams
                            {
                                give = number * 1000;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2)//pounds
                            {
                                give = (float) (number* 2.20462);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3) //ounce
                            {
                                give = (float)(number * 35.274);
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 1) //grams
                        {
                            if(third.getSelectedItemPosition() == 0) //kgs
                            {
                                give = number/1000;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //grams
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //pounds
                            {
                                give = (float) (number * 0.00220462);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3) //ounce
                            {
                                give = (float) (number * 0.035274);
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 2) //pounds
                        {
                            if(third.getSelectedItemPosition() == 0) //kgs
                            {
                                give = (float) (number * 0.453592);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //grams
                            {
                                give = (float) (number * 453.592);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //pounds
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3) //ounces
                            {
                                give = number * 16;
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 3) //ounces
                        {
                            if(third.getSelectedItemPosition() == 0)//kgs
                            {
                                give = (float) (number * 0.0283495);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //grams
                            {
                                give = (float) (number * 28.3495);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //pounds
                            {
                                give = (float) (number * 0.0625);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3 )//ounces
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                        }
                    }
                    else if(s.getSelectedItemPosition() == 1) //time
                    {
                        if(second.getSelectedItemPosition() == 0) //minute
                        {
                            if(third.getSelectedItemPosition() == 0) //minute
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1)//second
                            {
                                give = number * 60;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //hr
                            {
                                give = number/60;
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 1) //seconds
                        {
                            if(third.getSelectedItemPosition() == 0) //minutes
                            {
                                give = number / 60;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //seconds
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //hrs
                            {
                                give = number/3600;
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 2) //hrs
                        {
                            if(third.getSelectedItemPosition() == 0) //minutes
                            {
                                give = number *60;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //seconds
                            {
                                give = number * 3600;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //hrs
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                        }
                    }
                    else if(s.getSelectedItemPosition() == 2)   //distance
                    {
                        if(second.getSelectedItemPosition() == 0) //meters
                        {
                            if(third.getSelectedItemPosition() == 0) //meters
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //kilometers
                            {
                                give = number/1000;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //mile
                            {
                                give = number / 1609;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3) //yard
                            {
                                give = (float) (number * 1.094);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 4) //foot
                            {
                                give = (float) (number * 3.281);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 5) //inch
                            {
                                give = (float) (number * 39.37);
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 1) //kilometers
                        {
                            if (third.getSelectedItemPosition() == 0)//meters
                            {
                                give = number * 1000;
                                output.setText(Float.toString(give));
                            } else if (third.getSelectedItemPosition() == 1) //kms
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            } else if (third.getSelectedItemPosition() == 2) //miles
                            {
                                give = (float) (number / 1.609);
                                output.setText(Float.toString(give));
                            }
                            else if (third.getSelectedItemPosition() == 3) //yard
                            {
                                give = (float) (number * 1093.61);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 4) //foot
                            {
                                give = (float) (number* 3280.84);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 5) //inch
                            {
                                give = (float) (number * 39370.1);
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 2) //mile
                        {
                            if(third.getSelectedItemPosition() == 0) //meters
                            {
                                give = (float) (number * 1609.34);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //kilometers
                            {
                                give = (float) (number * 1.60934);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //mile
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3)//yard
                            {
                                give = number * 1760;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 4) //foot
                            {
                                give = number * 5280;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 5) //inch
                            {
                                give = number * 63360;
                                output.setText(Float.toString(give));
                            }
                        }

                        else if(second.getSelectedItemPosition() == 3) //yard
                        {
                            if(third.getSelectedItemPosition() == 0) //meters
                            {
                                give = (float) (number / 1.094);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //kilometers
                            {
                                give = (float) (number / 1094);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //mile
                            {
                                give = number/1760;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3)//yard
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 4) //foot
                            {
                                give = number * 3;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 5) //inch
                            {
                                give = number * 36;
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 4 )//foot
                        {
                            if(third.getSelectedItemPosition() == 0) //meters
                            {
                                give = (float) (number / 3.281);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //kilometers
                            {
                                give = (float) (number / 3281);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //mile
                            {
                                give = number / 5280;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3)//yard
                            {
                                give = number / 3;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 4) //foot
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 5) //inch
                            {
                                give = number * 12;
                                output.setText(Float.toString(give));
                            }
                        }
                        else if(second.getSelectedItemPosition() == 5) //inch
                        {
                            if(third.getSelectedItemPosition() == 0) //meters
                            {
                                give = (float) (number / 39.37);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 1) //kilometers
                            {
                                give = (float) (number / 39370);
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 2) //mile
                            {
                                give = number/63360;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 3)//yard
                            {
                                give = number / 36;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 4) //foot
                            {
                                give = number / 12;
                                output.setText(Float.toString(give));
                            }
                            else if(third.getSelectedItemPosition() == 5) //inch
                            {
                                give = number;
                                output.setText(Float.toString(give));
                            }
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
        String text = parent.getItemAtPosition(position).toString();
        if(parent.getSelectedItemPosition() == 0)
        {
            input.setText("");
            output.setText("");
            //Toast.makeText(this.getContext(),"In weight",Toast.LENGTH_SHORT).show();
            second= v.findViewById(R.id.left_side_uc);
            ArrayAdapter<CharSequence>adapter_left_uc = ArrayAdapter.createFromResource(this.getContext(),R.array.unit_converter_menu_weight,R.layout.spinner_item_main);
            adapter_left_uc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            second.setAdapter(adapter_left_uc);
            second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            third= v.findViewById(R.id.right_side_uc);
            ArrayAdapter<CharSequence>adapter_right_uc = ArrayAdapter.createFromResource(this.getContext(),R.array.unit_converter_menu_weight,R.layout.spinner_item_main);
            adapter_right_uc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            third.setAdapter(adapter_right_uc);
            third.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if(parent.getSelectedItemPosition() == 2)
        {
            input.setText("");
            output.setText("");
            //Toast.makeText(this.getContext(),"In Distance",Toast.LENGTH_SHORT).show();
            second= v.findViewById(R.id.left_side_uc);
            ArrayAdapter<CharSequence>adapter_left_uc = ArrayAdapter.createFromResource(this.getContext(),R.array.unit_converter_menu_distance,R.layout.spinner_item_main);
            adapter_left_uc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            second.setAdapter(adapter_left_uc);
            second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            third= v.findViewById(R.id.right_side_uc);
            ArrayAdapter<CharSequence>adapter_right_uc = ArrayAdapter.createFromResource(this.getContext(),R.array.unit_converter_menu_distance,R.layout.spinner_item_main);
            adapter_right_uc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            third.setAdapter(adapter_right_uc);
            third.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if(parent.getSelectedItemPosition() == 1)
        {
            input.setText("");
            output.setText("");
            //Toast.makeText(this.getContext(),"In time",Toast.LENGTH_SHORT).show();
            second= v.findViewById(R.id.left_side_uc);
            ArrayAdapter<CharSequence>adapter_left_uc = ArrayAdapter.createFromResource(this.getContext(),R.array.unit_converter_menu_time,R.layout.spinner_item_main);
            adapter_left_uc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            second.setAdapter(adapter_left_uc);
            second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            third= v.findViewById(R.id.right_side_uc);
            ArrayAdapter<CharSequence>adapter_right_uc = ArrayAdapter.createFromResource(this.getContext(),R.array.unit_converter_menu_time,R.layout.spinner_item_main);
            adapter_right_uc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            third.setAdapter(adapter_right_uc);
            third.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this.getContext(),"hello hello hello",Toast.LENGTH_LONG).show();
    }
}
