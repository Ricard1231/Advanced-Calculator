package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String DISPLAY_VIEW = "display";
    private static final String RESULT_VIEW = "result";
    private static final String CALCULATION_VIEW = "calculation";
    private static final String DISPLAY_NUM = "display_number";
    private static final String NON_DEC_RESULT = "nonDecResult";
    private static final String CHECK_VAR = "check";
    private static final String ISPI_VAR = "isPi";
    private static final String SPECIAL_TEXT_VAR = "special";
    private static final String SPECIAL_TEXT_TYPE_TWO_VAR = "special_two";
    private static final String ISEQUAL_VAR = "isEqual";
    private static final String ISPOSITIVE_VAR = "isPositive";

    DrawerLayout mDrawerLayout;
    EditText display;
    TextView result, calculation;
    Button button_plus, button_minus, button_multiply, button_all_clear, button_seven, button_eight, button_nine, button_divide, button_four, button_five, button_six,
            button_root, button_one, button_two, button_three, button_module, button_dot, button_zero, button_clear, button_equal, button_backspace, button_sin, button_cos,
            button_tan, button_posneg, button_power, button_percent, button_factorial, button_pi, button_log;
    ImageButton button_exp, button_10power, button_power2, button_arcsin, button_arccos, button_arctan;
    float display_number = 0;
    int nonDecResult = 0;
    String check = "";
    boolean isPi = false;
    String special_text = "";
    String special_text_type_two = "";
    boolean isEqual = false;
    boolean isPositive = true;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DISPLAY_VIEW, display.getText().toString());
        outState.putString(RESULT_VIEW, result.getText().toString());
        outState.putString(CALCULATION_VIEW, calculation.getText().toString());
        outState.putFloat(DISPLAY_NUM, display_number);
        outState.putInt(NON_DEC_RESULT, nonDecResult);
        outState.putString(CHECK_VAR, check);
        outState.putBoolean(ISPI_VAR, isPi);
        outState.putString(SPECIAL_TEXT_VAR, special_text);
        outState.putString(SPECIAL_TEXT_TYPE_TWO_VAR, special_text_type_two);
        outState.putBoolean(ISEQUAL_VAR, isEqual);
        outState.putBoolean(ISPOSITIVE_VAR, isPositive);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = this.findViewById(R.id.drawer_layout);
        display = this.findViewById(R.id.screen);
        result = this.findViewById(R.id.result);
        calculation = this.findViewById(R.id.calculation);
        button_plus = this.findViewById(R.id.button_plus);
        button_minus = this.findViewById(R.id.button_minus);
        button_multiply = this.findViewById(R.id.button_multiply);
        button_all_clear = this.findViewById(R.id.button_all_clear);
        button_seven = this.findViewById(R.id.button_seven);
        button_eight = this.findViewById(R.id.button_eight);
        button_nine = this.findViewById(R.id.button_nine);
        button_divide = this.findViewById(R.id.button_divide);
        button_four = this.findViewById(R.id.button_four);
        button_five = this.findViewById(R.id.button_five);
        button_six = this.findViewById(R.id.button_six);
        button_root = this.findViewById(R.id.button_root);
        button_one = this.findViewById(R.id.button_one);
        button_two = this.findViewById(R.id.button_two);
        button_three = this.findViewById(R.id.button_three);
        button_module = this.findViewById(R.id.button_module);
        button_dot = this.findViewById(R.id.button_dot);
        button_zero = this.findViewById(R.id.button_zero);
        button_clear = this.findViewById(R.id.button_clear);
        button_equal = this.findViewById(R.id.button_equal);
        button_backspace = this.findViewById(R.id.button_backspace);
        button_sin = this.findViewById(R.id.button_sin);
        button_cos = this.findViewById(R.id.button_cos);
        button_tan = this.findViewById(R.id.button_tan);
        button_posneg = this.findViewById(R.id.button_posneg);
        button_power = this.findViewById(R.id.button_power);
        button_percent = this.findViewById(R.id.button_percent);
        button_factorial = this.findViewById(R.id.button_factorial);
        button_pi = this.findViewById(R.id.button_pi);
        button_log = this.findViewById(R.id.button_log);
        button_exp = this.findViewById(R.id.button_exp);
        button_10power = this.findViewById(R.id.button_10power);
        button_power2 = this.findViewById(R.id.button_power2);
        button_arcsin = this.findViewById(R.id.button_arcsin);
        button_arccos = this.findViewById(R.id.button_arccos);
        button_arctan = this.findViewById(R.id.button_arctan);

        if (savedInstanceState != null) {
            display.setText(savedInstanceState.getString(DISPLAY_VIEW, ""));
            result.setText(savedInstanceState.getString(RESULT_VIEW, ""));
            calculation.setText(savedInstanceState.getString(CALCULATION_VIEW, ""));
            display_number = savedInstanceState.getFloat(DISPLAY_NUM, 0);
            nonDecResult = savedInstanceState.getInt(NON_DEC_RESULT, 0);
            check = savedInstanceState.getString(CHECK_VAR, "");
            isPi = savedInstanceState.getBoolean(ISPI_VAR, false);
            special_text = savedInstanceState.getString(SPECIAL_TEXT_VAR, "");
            special_text_type_two = savedInstanceState.getString(SPECIAL_TEXT_TYPE_TWO_VAR, "");
            isEqual = savedInstanceState.getBoolean(ISEQUAL_VAR, false);
            isPositive = savedInstanceState.getBoolean(ISPOSITIVE_VAR, true);
        }

        mDrawerLayout.setScrimColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));

        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("1");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("2");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("3");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("4");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("5");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("6");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("7");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("8");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("9");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().contains("."))
                    addText(".");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("0");
                if (!result.getText().toString().equals(""))
                    result.setText("");
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPi = false;
                special_text = "";
                special_text_type_two = "";
                display.setText("");
                result.setText("");
                isPositive = true;
            }
        });

        button_all_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                result.setText("");
                calculation.setText("");
                check = "";
                isPi = false;
                special_text = "";
                special_text_type_two = "";
                isEqual = false;
                isPositive = true;
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditions("add", "+");
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditions("min", "-");
            }
        });

        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditions("mul", "*");
                String text = calculation.getText().toString();
                calculation.setText("(" + text.substring(0, text.length() - 2) + " )" + text.substring(text.length() - 2));
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditions("div", "/");
                String text = calculation.getText().toString();
                calculation.setText("(" + text.substring(0, text.length() - 2) + " )" + text.substring(text.length() - 2));
            }
        });

        button_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditions("mod", "%");
                String text = calculation.getText().toString();
                calculation.setText("(" + text.substring(0, text.length() - 2) + " )" + text.substring(text.length() - 2));
            }
        });

        button_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("√", "");
                    root();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEqual = true;
                if (!check.equals("") && !display.getText().toString().equals("")) {
                    addTextCalc(display.getText().toString());
                    operation();
                    check = "";
                } else if (check.equals("") && !display.getText().toString().equals("")) {
                    display_number = Float.parseFloat(display.getText().toString());
                    display.setText("");
                    numberType();
                } else numberType();
            }
        });

        button_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("")) {
                    display.setText(display.getText().toString().substring(0, display.getText().toString().length() - 1));
                    isPi = false;
                }
            }
        });

        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("sin(", ")");
                    sin();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("cos(", ")");
                    cos();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("tan(", ")");
                    tan();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_posneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("")) {
                    if (display.getText().toString().contains("-"))
                        display.setText(display.getText().toString().substring(1));
                    else display.setText("-" + display.getText().toString());
                } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
                    if (display.getText().toString().contains("-"))
                        result.setText(result.getText().toString().substring(1));
                    else result.setText("-" + result.getText().toString());
                }
                isPositive = !isPositive;
            }
        });

        button_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditions("power", "^");
            }
        });

        button_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!display.getText().toString().equals("") && !display.getText().toString().contains(".")) ||
                        (!result.getText().toString().equals("") && !result.getText().toString().contains("."))) {
                    conditions2("%");
                    percent();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!display.getText().toString().equals("") && !display.getText().toString().contains(".")) ||
                        (!result.getText().toString().equals("") && !result.getText().toString().contains("."))) {
                    conditions2("!");
                    factorial();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().equals(""))
                    result.setText("");
                display.setText(String.valueOf(Math.PI));
                isPi = true;
            }
        });

        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("log(", ")");
                    log();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_power2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!display.getText().toString().equals("") && !display.getText().toString().contains(".")) ||
                        (!result.getText().toString().equals("") && !result.getText().toString().contains("."))) {
                    conditions2("^2");
                    power2();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("exp(",")");
                    exp();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_10power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("10^", "");
                    ten_power();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_arcsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("sin-1(",")");
                    asin();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_arccos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("cos-1(", ")");
                    acos();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });

        button_arctan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().equals("") || !result.getText().toString().equals("")) {
                    conditions1("tan-1(", ")");
                    atan();
                    numberType();
                    display.setText("");
                    calculation.setText("");
                }
            }
        });
    }

    private void addText(String mtext) {
        display.setText(display.getText().toString() + mtext);
        isPi = false;
    }

    private void addTextCalc(String mtext) {
        if (isPi && isEqual) {
            if (!isPositive)
            calculation.setText(calculation.getText().toString() + " (-π)");
            else calculation.setText(calculation.getText().toString() + " π");
            isPi = false;
        } else if (isPi){
            if (!isPositive)
            calculation.setText(calculation.getText().toString() + " (-π) " + mtext.substring(mtext.length() - 2) + " ");
            else calculation.setText(calculation.getText().toString() + " π " + mtext.substring(mtext.length() - 2) + " ");
            isPi = false;
        } else if (mtext.length() < 11) {
            calculation.setText(calculation.getText().toString() + " " + mtext);
        } else if (!special_text.equals("") && special_text_type_two.equals(""))
            calculation.setText(calculation.getText().toString() + mtext.substring(0, 9) + "... " + ") " + mtext.substring(mtext.length() - 2) + " ");
        else
            calculation.setText(calculation.getText().toString() + " " + mtext.substring(0, 6) + "... " + mtext.substring(mtext.length() - 2) + " ");
    }

    private void plus() {
        if(!display.getText().toString().equals("")) {
            display_number += Float.parseFloat(display.getText().toString());
            check = "";
        } else if(!result.getText().toString().equals("")){
            display_number += Float.parseFloat(result.getText().toString());
            check = "";
        }
    }

    private void minus() {
        display_number -= Float.parseFloat(display.getText().toString());
        check = "";
    }

    private void multiply() {
        display_number *= Float.parseFloat(display.getText().toString());
        check = "";
    }

    private void divide() {
        display_number /= Float.parseFloat(display.getText().toString());
        check = null;
    }

    private void module() {
        display_number %= Float.parseFloat(display.getText().toString());
        check = "";
    }

    private void root() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.sqrt(Float.parseFloat(display.getText().toString()));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.sqrt(Float.parseFloat(result.getText().toString()));
        }
    }

    private void power() {
        display_number = (float) Math.pow(display_number, Float.parseFloat(display.getText().toString()));
        check = "";
    }

    private void sin() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.sin(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.sin(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void cos() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.cos(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.cos(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void tan() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.tan(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.tan(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void asin() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.asin(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.asin(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void acos() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.acos(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.acos(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void atan() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.atan(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.atan(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void percent() {
        if (!display.getText().toString().equals("")) {
            display_number = Float.parseFloat(display.getText().toString()) / (float) 100;
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = Float.parseFloat(result.getText().toString()) / (float) 100;
        }
    }

    private void factorial() {
        if (!display.getText().toString().equals("")) {
            int number = Integer.parseInt(display.getText().toString());
            for (int i = number - 1; i > 0; i--) {
                number *= i;
            }
            display_number = number;
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            int number = Integer.parseInt(result.getText().toString());
            for (int i = number; i > 0; i--) {
                number *= i;
            }
            display_number = number;
        }
    }

    private void log() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.log(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.log(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void power2() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.pow(Float.parseFloat(display.getText().toString()), 2);
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.pow(Float.parseFloat(result.getText().toString()), 2);
        }
    }

    private void exp() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.exp(Math.toRadians(Double.parseDouble(display.getText().toString())));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.exp(Math.toRadians(Double.parseDouble(result.getText().toString())));
        }
    }

    private void ten_power() {
        if (!display.getText().toString().equals("")) {
            display_number = (float) Math.pow(10, Float.parseFloat(display.getText().toString()));
        } else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            display_number = (float) Math.pow(10, Float.parseFloat(result.getText().toString()));
        }
    }

    private void numberType() {
        String num = String.valueOf(display_number);
        if (num.substring(num.length() - 2).equals(".0")) {
            nonDecResult = (int) display_number;
            result.setText(String.valueOf(nonDecResult));
        } else result.setText(String.valueOf(display_number));
    }

    private void operation() {
        switch (check) {
            case "add":
                plus();
                numberType();
                display.setText("");
                break;
            case "min":
                minus();
                numberType();
                display.setText("");
                break;
            case "mul":
                multiply();
                numberType();
                display.setText("");
                break;
            case "div":
                divide();
                numberType();
                display.setText("");
                break;
            case "mod":
                module();
                numberType();
                display.setText("");
                break;
            case "power":
                power();
                numberType();
                display.setText("");
                break;
            default:
                numberType();
        }
    }

    private void conditions(String operator, String symbol){
        if(isEqual && display.getText().toString().equals("") && !result.getText().toString().equals("")){
            display_number = Float.parseFloat(result.getText().toString());
            check = operator;
            calculation.setText(result.getText().toString() + " " + symbol);
            isEqual = false;
        } else if (isEqual && result.getText().toString().equals("") && !display.getText().toString().equals("")){
            display_number = Float.parseFloat(display.getText().toString());
            check = operator;
            calculation.setText(display.getText().toString() + " " + symbol);
            display.setText("");
            isEqual = false;
        } else if (!check.equals("") && display.getText().toString().equals("")) {
            check = operator;
            addTextCalc(calculation.getText().toString().substring(0, calculation.getText().toString().length() - 1) + symbol);
        } else if (!check.equals("") && !display.getText().toString().equals("")) {
            if (!special_text.equals("") && special_text_type_two.equals("")) {
                addTextCalc(special_text + " " + symbol);
                special_text = "";
            } else if (special_text.equals("") && !special_text_type_two.equals("")) {
                addTextCalc(result.getText().toString());
                addTextCalc(special_text_type_two + " " + symbol);
                special_text_type_two = "";
            } else addTextCalc(display.getText().toString() + " " + symbol);
            operation();
            check = operator;
        } else if (!display.getText().toString().equals("")) {
            check = operator;
            if (!special_text.equals("") && special_text_type_two.equals("")) {
                addTextCalc(special_text + " " + symbol);
                special_text = "";
            } else if (special_text.equals("") && !special_text_type_two.equals("")) {
                addTextCalc(special_text_type_two + " " + symbol);
                special_text_type_two = "";
            } else addTextCalc(display.getText().toString() + " " + symbol);
            display_number = Float.parseFloat(display.getText().toString());
            display.setText("");
        } else if (!result.getText().toString().equals("") && display.getText().toString().equals("")) {
            check = operator;
            display_number = Float.parseFloat(result.getText().toString());
            if (!special_text.equals("") && special_text_type_two.equals("")) {
                addTextCalc(special_text + " " + symbol);
                special_text = "";
            } else if (special_text.equals("") && !special_text_type_two.equals("")) {
                addTextCalc(special_text_type_two + " " + symbol);
                special_text_type_two = "";
            } else addTextCalc(result.getText().toString() + " " + symbol);
        }
    }

    private void conditions1(String front, String back){
        if (!display.getText().toString().equals("") && result.getText().toString().equals("")) {
            special_text = front + display.getText().toString() + back;
        }
        else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            special_text = front + result.getText().toString() + back;
        }
    }

    private void conditions2(String back){
        if (!display.getText().toString().equals("") && result.getText().toString().equals("")) {
            special_text_type_two = display.getText().toString() + back;
        }
        else if (display.getText().toString().equals("") && !result.getText().toString().equals("")) {
            special_text_type_two = result.getText().toString() + back;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
