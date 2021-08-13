package br.com.uninterwork.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Criando os botões
    private Button numberZero, numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix,
            numberSeven, numberEight, numberNine, dot, sum, subtraction, multiplication, division, equals, button_clear;

    // Expressão e resultado
    private TextView txtExpression, txtResult;
    // Imagem para apagar
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // iniciando os componentes para organizar o código
        componentInit();

        // Recuperar o click a partir do contexto atual
        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        dot.setOnClickListener(this);
        sum.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);

        // Botão de limpar para zerar a expressão
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpression.setText("");
                txtResult.setText("");
            }
        });


        // Apagar
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expression = findViewById(R.id.txt_expression);
                String string = expression.getText().toString();

                // depois de converter para string a expressao, diminuir -1 da expressão
                if (!string.isEmpty()) {
                    byte varZero = 0;
                    int varOne = string.length()-1;
                    String txtExpression = string.substring(varZero, varOne);
                    expression.setText(txtExpression);
                }
                txtResult.setText("");
            }
        });

        // Botão igual
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Expression expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                double result = expression.evaluate();
                long longResult = (long) result;

                // ExpressionBuilder para fazer a expressão
                if (result == (double)longResult) {
                    txtResult.setText((CharSequence) String.valueOf(longResult));
                }
                else {
                    txtResult.setText((CharSequence) String.valueOf(result));
                }
            }
        });
    }

    // Pegar todos os ids utilizando o findViewById para recuperar do MainActivity
    private void componentInit() {
        numberZero = findViewById(R.id.number_zero);
        numberOne = findViewById(R.id.number_one);
        numberTwo = findViewById(R.id.number_two);
        numberThree = findViewById(R.id.number_three);
        numberFour = findViewById(R.id.number_four);
        numberFive = findViewById(R.id.number_five);
        numberSix = findViewById(R.id.number_six);
        numberSeven = findViewById(R.id.number_seven);
        numberEight = findViewById(R.id.number_eight);
        numberNine = findViewById(R.id.number_nine);
        dot = findViewById(R.id.dot);
        sum = findViewById(R.id.sum);
        subtraction = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);
        equals = findViewById(R.id.equals);
        button_clear = findViewById(R.id.bt_clear);
        txtExpression = findViewById(R.id.txt_expression);
        txtResult = findViewById(R.id.txt_result);
        backspace = findViewById(R.id.backspace);
    }

    // método para acrescentar uma expressão
    public void addExpression(String string, boolean clear_data) {
        if (txtResult.getText().equals("")) {
            txtExpression.setText(" ");
        }

        if (clear_data) {
            txtResult.setText(" ");
            txtExpression.append(string);
        }
        else {
            txtExpression.append(txtResult.getText());
            txtExpression.append(string);
            txtResult.setText(" ");
        }
    }

    // Método responsável pelos clicks
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.number_zero:
                addExpression("0", true);
                break;

            case R.id.number_one:
                addExpression("1", true);
                break;

            case R.id.number_two:
                addExpression("2", true);
                break;

            case R.id.number_three:
                addExpression("3", true);
                break;

            case R.id.number_four:
                addExpression("4", true);
                break;

            case R.id.number_five:
                addExpression("5", true);
                break;

            case R.id.number_six:
                addExpression("6", true);
                break;

            case R.id.number_seven:
                addExpression("7", true);
                break;

            case R.id.number_eight:
                addExpression("8", true);
                break;

            case R.id.number_nine:
                addExpression("9", true);
                break;

            case R.id.dot:
                addExpression(".", true);
                break;

            case R.id.sum:
                addExpression("+ ", false);
                break;

            case R.id.subtraction:
                addExpression("- ", false);
                break;

            case R.id.multiplication:
                addExpression("* ", false);
                break;

            case R.id.division:
                addExpression("/ ", false);
                break;
        }
    }
}