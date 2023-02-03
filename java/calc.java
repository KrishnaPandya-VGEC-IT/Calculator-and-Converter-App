package com.example.mini_project_mcwc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class calc extends Fragment
{
    View v;
    EditText input;
    TextView result,show_op;
    DataBaseHelper mydb; //new
    public int Count_Iteration=1;   //new
    public float current=0;
    public String previous=null, before_previous=null;    //OPERATION
    public float previous_input = 0;    //Last value
    public boolean result_null = true;
    Button zero,one,two,three,four,five,six,seven,eight,nine,clr,dot,add,sub,div,mul,equals,history,undo,ac,delete; //delete is new
    public String s1;

    public void SaveInt(String key, int value){
    } //new function
    public int LoadInt(){
        return 0;
    } //new function

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.calculator,container,false);
        SaveInt("key",Count_Iteration); //new function
        Count_Iteration = LoadInt();    //new function
        zero = (Button)v. findViewById(R.id.zero);
        one = (Button)v. findViewById(R.id.one);
        two = (Button)v. findViewById(R.id.two);
        three = (Button)v. findViewById(R.id.three);
        four = (Button)v. findViewById(R.id.four);
        five = (Button)v. findViewById(R.id.five);
        six = (Button)v. findViewById(R.id.six);
        seven = (Button)v. findViewById(R.id.seven);
        eight = (Button)v. findViewById(R.id.eight);
        nine = (Button)v. findViewById(R.id.nine);
        clr = (Button)v. findViewById(R.id.clr);
        dot = (Button)v. findViewById(R.id.dot);
        add = (Button)v. findViewById(R.id.add);
        sub = (Button)v. findViewById(R.id.minus);
        div = (Button)v. findViewById(R.id.div);
        mul = (Button)v. findViewById(R.id.mul);
        delete = (Button)v. findViewById(R.id.Delete);
        equals = (Button)v. findViewById(R.id.equals);
        history = (Button)v. findViewById(R.id.history);
        input = (EditText)v. findViewById(R.id.text);
        result = (TextView)v. findViewById(R.id.result);
        undo = (Button)v. findViewById(R.id.undo);
        ac = (Button)v. findViewById(R.id.ac);
        show_op = (TextView)v.findViewById(R.id.operation_show);
        mydb = new DataBaseHelper(this.getContext());    //new
        zero.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "0";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        one.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "1";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        two.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "2";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        three.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "3";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        four.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "4";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        five.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "5";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        six.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "6";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        seven.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "7";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        eight.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "8";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        nine.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                s1 += "9";
                input.setText(s1);
                input.setSelection(input.getText().length());
            }
        });
        dot.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                if (s1.contains(".")) {
                    Toast.makeText(v.getContext(), "Already one decimal Point", Toast.LENGTH_SHORT).show();
                } else {
                    s1 += ".";
                    input.setText(s1);
                    input.setSelection(input.getText().length());
                }
            }
        });
        undo.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                s1 = input.getText().toString();
                if (s1.length() > 0) {
                    s1 = s1.substring(0, s1.length() - 1);
                    input.setText(s1);
                    input.setSelection(input.getText().length());
                } else {
                    Toast.makeText(v.getContext(), "Input field is already blank", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                SQLiteDatabase db = mydb.getWritableDatabase();
                db.execSQL("delete from "+"history_table");
                Toast.makeText(v.getContext(), "History deleted", Toast.LENGTH_SHORT).show();
                Count_Iteration = 0;
            }
        });
        clr.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                input.setTextSize(20);
                String s = "";
                input.setText(s);
                input.setSelection(input.getText().length());
            }
        });

        ac.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                current = 0;
                previous = null;
                result.setText(Float.toString(current));
                show_op.setText("");
                result_null = true;
            }
        });

        history.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent i=new Intent(v.getContext(),com.example.mini_project_mcwc.View.class);
                startActivity(i);
            }
        });

        add.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String temp, string;
                Float f1;
                temp = input.getText().toString();
                s1 = "";
                if (temp.length() != 0) {
                    if (temp.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))")) {
                        if (result_null == true) {
                            previous = "plus";
                            previous_input = Float.parseFloat(temp);
                            Count_Iteration++; //new
                            mydb.insertData("\n "+"---------------------------------------------------------"+"\n","");  //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            result.setText(temp);
                            current = Float.parseFloat(temp);
                            show_op.setText("(+) ("+previous_input+")");
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            result_null = false;
                        } else {
                            f1 = Float.parseFloat(temp);
                            if (previous == "plus") {
                                current += f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "plus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("+", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "minus") {
                                current -= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "plus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("-", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "mul") {
                                current *= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "plus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("*", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "div") {
                                current /= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "plus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("/", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            }
                            show_op.setText("(+) ("+previous_input+")");
                        }

                    } else {
                        Toast.makeText(v.getContext(), "Wrong input format", Toast.LENGTH_SHORT).show();
                        previous = "plus";
                        input.setText("");
                    }
                } else {
                    previous = "plus";
                }
            }
        });
        sub.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String temp, string;
                Float f1;
                temp = input.getText().toString();
                s1 = "";
                if (temp.length() != 0) {
                    if (temp.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))")) {
                        if (result_null == true) {
                            previous = "minus";
                            previous_input = Float.parseFloat(temp);
                            Count_Iteration++; //new
                            mydb.insertData("\n "+"---------------------------------------------------------"+"\n","");  //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            result.setText(temp);
                            current = Float.parseFloat(temp);
                            show_op.setText("(-) ("+previous_input+")");
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            result_null = false;
                        } else {
                            f1 = Float.parseFloat(temp);
                            if (previous == "plus") {
                                current += f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "minus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("+", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "minus") {
                                current -= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "minus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("-", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "mul") {
                                current *= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "minus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("*", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new

                            } else if (previous == "div") {
                                //add symbol of div to database
                                //add current input to database
                                current /= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "minus";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("/", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            }
                            show_op.setText("(-) ("+previous_input+")");
                        }

                    } else {
                        Toast.makeText(v.getContext(), "Wrong input format", Toast.LENGTH_SHORT).show();
                        previous = "minus";
                        input.setText("");
                    }
                } else {
                    previous = "minus";
                }
            }
        });

        mul.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String temp, string;
                Float f1;
                temp = input.getText().toString();
                s1 = "";
                if (temp.length() != 0) {
                    if (temp.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))")) {
                        if (result_null == true) {
                            previous = "mul";
                            previous_input = Float.parseFloat(temp);
                            Count_Iteration++; //new
                            mydb.insertData("\n "+"---------------------------------------------------------"+"\n","");  //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            result.setText(temp);
                            current = Float.parseFloat(temp);
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            show_op.setText("(*) ("+previous_input+")");
                            result_null = false;
                        } else {
                            f1 = Float.parseFloat(temp);
                            if (previous == "plus") {
                                current += f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "mul";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("+", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new

                            } else if (previous == "minus") {
                                current -= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "mul";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("-", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "mul") {
                                current *= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "mul";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("*", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "div") {
                                current /= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "mul";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("/", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            }
                            show_op.setText("(*) ("+previous_input+")");
                        }

                    } else {
                        Toast.makeText(v.getContext(), "Wrong input format", Toast.LENGTH_SHORT).show();
                        previous = "mul";
                        input.setText("");
                    }
                } else {
                    previous = "mul";
                }
            }
        });

        div.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String temp, string;
                Float f1;
                temp = input.getText().toString();
                s1 = "";
                if (temp.length() != 0) {
                    if (temp.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))")) {
                        if (result_null == true) {
                            previous = "div";
                            previous_input = Float.parseFloat(temp);
                            Count_Iteration++; //new
                            mydb.insertData("\n "+"---------------------------------------------------------"+"\n","");  //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            result.setText(temp);
                            current = Float.parseFloat(temp);
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            show_op.setText("(/) ("+previous_input+")");
                            result_null = false;
                        } else {
                            f1 = Float.parseFloat(temp);
                            if (previous == "plus") {
                                current += f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "div";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("+", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "minus") {
                                current -= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "div";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("-", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "mul") {
                                current *= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "div";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("*", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            } else if (previous == "div") {
                                current /= f1;
                                string = Float.toString(current);
                                result.setText(string);
                                previous = "div";
                                input.setText(s1);
                                input.setSelection(input.getText().length());
                                previous_input = f1;
                                mydb.insertData("/", "");   //new
                                mydb.insertData(Float.toString(previous_input), ""); //new
                                mydb.insertData("", string);    //new
                            }
                            show_op.setText("(/) ("+previous_input+")");
                        }

                    } else {
                        Toast.makeText(v.getContext(), "Wrong input format", Toast.LENGTH_SHORT).show();
                        previous = "div";
                        input.setText("");
                    }
                } else {
                    previous = "div";
                }
            }
        });

        equals.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp, string;
                temp = input.getText().toString();
                Float f1;
                s1="";
                if (temp.length() != 0) {
                    if (previous == null) {
                        previous_input = Float.parseFloat(temp);
                        result.setText(temp);
                        current = Float.parseFloat(temp);
                        mydb.insertData("\n "+"---------------------------------------------------------"+"\n","");  //new
                        mydb.insertData(Float.toString(previous_input), ""); //new
                        input.setText(s1);
                        input.setSelection(input.getText().length());
                        result_null = false;
                    } else {
                        f1 = Float.parseFloat(temp);
                        if (previous == "plus") {
                            current += f1;
                            string = Float.toString(current);
                            result.setText(string);
                            previous = "equals";
                            before_previous ="plus";
                            previous_input = f1;
                            mydb.insertData("+", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            show_op.setText("(+) ("+previous_input+")");
                        } else if (previous == "minus") {
                            current -= f1;
                            string = Float.toString(current);
                            result.setText(string);
                            previous = "equals";
                            before_previous = "minus";
                            previous_input = f1;
                            mydb.insertData("-", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            show_op.setText("(-) ("+previous_input+")");
                        } else if (previous == "mul") {
                            current *= f1;
                            string = Float.toString(current);
                            result.setText(string);
                            previous = "equals";
                            before_previous = "mul";
                            previous_input =f1;
                            mydb.insertData("*", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            show_op.setText("(*) ("+previous_input+")");
                        } else if (previous == "div") {
                            current /= f1;
                            string = Float.toString(current);
                            result.setText(string);
                            previous = "equals";
                            before_previous = "div";
                            previous_input = f1;
                            mydb.insertData("/", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                            show_op.setText("(/) ("+previous_input+")");
                        }
                    }
                } else {
                    if(previous == "equals")
                    {
                        if (before_previous == "plus") {
                            current += previous_input;
                            string = Float.toString(current);
                            result.setText(string);
                            mydb.insertData("+", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                        } else if (before_previous == "minus") {
                            current -= previous_input;
                            string = Float.toString(current);
                            result.setText(string);
                            mydb.insertData("-", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                        } else if (before_previous == "mul") {
                            current *= previous_input;
                            string = Float.toString(current);
                            result.setText(string);
                            mydb.insertData("*", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                        } else if (before_previous == "div") {
                            current /= previous_input;
                            string = Float.toString(current);
                            result.setText(string);
                            mydb.insertData("/", "");   //new
                            mydb.insertData(Float.toString(previous_input), ""); //new
                            mydb.insertData("", string);    //new
                            input.setText(s1);
                            input.setSelection(input.getText().length());
                        }
                    }
                    else
                    {
                        previous = null;
                    }
                }
            }
        });
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
