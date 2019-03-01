package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnSin, btnCos, btnTan, btnFactorial, btnPow;
    private Button btnClear, btnBack, btnBracketsOpen, btnBracketsClose, btnSquareRoot;
    private Button btnSeven, btnEight, btnNine, btnDivide, btnMod;
    private Button btnFour, btnFive, btnSix, btnMultiply, btnInverse;
    private Button btnOne, btnTwo, btnThree, btnMinus, btnAdd;
    private Button btnZero, btnDecimal, btnPi, btnResult;

    private TextView screenAns, screenMath;

    private StringBuilder textMath = new StringBuilder("");
    private StringBuilder textAns = new StringBuilder("0");
    private StringBuilder screenTextMath = new StringBuilder("");

    int checkSubmit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting font
        Calligrapher calligraph = new Calligrapher(this);
        calligraph.setFont(this, "lato-regular.ttf", true);
        //Control

        screenAns = (TextView) findViewById(R.id.tvResult);
        screenMath = (TextView) findViewById(R.id.tvCal);

        btnZero = (Button) findViewById(R.id.btnZero);
        btnZero.setOnClickListener(this);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);

        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(this);

        btnThree = (Button) findViewById(R.id.btnThree);
        btnThree.setOnClickListener(this);

        btnFour = (Button) findViewById(R.id.btnFour);
        btnFour.setOnClickListener(this);

        btnFive = (Button) findViewById(R.id.btnFive);
        btnFive.setOnClickListener(this);

        btnSix = (Button) findViewById(R.id.btnSix);
        btnSix.setOnClickListener(this);

        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(this);

        btnEight = (Button) findViewById(R.id.btnEight);
        btnEight.setOnClickListener(this);

        btnNine = (Button) findViewById(R.id.btnNine);
        btnNine.setOnClickListener(this);

        btnSin = (Button) findViewById(R.id.btnSin);
        btnSin.setOnClickListener(this);

        btnCos = (Button) findViewById(R.id.btnCos);
        btnCos.setOnClickListener(this);

        btnTan = (Button) findViewById(R.id.btnTan);
        btnTan.setOnClickListener(this);

        btnFactorial = (Button) findViewById(R.id.btnFactorial);
        btnFactorial.setOnClickListener(this);

        btnPow = (Button) findViewById(R.id.btnPow);
        btnPow.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        btnBracketsClose = (Button) findViewById(R.id.btnBracketsClose);
        btnBracketsClose.setOnClickListener(this);

        btnBracketsOpen = (Button) findViewById(R.id.btnBracketsOpen);
        btnBracketsOpen.setOnClickListener(this);

        btnSquareRoot = (Button) findViewById(R.id.btnSquareRoot);
        btnSquareRoot.setOnClickListener(this);

        btnDecimal =(Button) findViewById(R.id.btnDecimal);
        btnDecimal.setOnClickListener(this);

        btnPi = (Button) findViewById(R.id.btnPi);
        btnPi.setOnClickListener(this);

        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);

        btnMod = (Button) findViewById(R.id.btnBracketsMod);
        btnMod.setOnClickListener(this);

        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(this);

        btnInverse = (Button) findViewById(R.id.btnInverse);
        btnInverse.setOnClickListener(this);

        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(this);

    }

    public void error (){
        screenAns.setText("Math Error");
        textAns = textMath = screenTextMath =new StringBuilder("");
    }

    public void submit(String[] elementMath){
        InfixToPostFix  ITP = new InfixToPostFix
    }
}
