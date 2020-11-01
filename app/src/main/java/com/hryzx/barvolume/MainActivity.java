package com.hryzx.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String STATE_RESULT = "state_result";
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inpLength = edtLength.getText().toString().trim();
            String inpWidth = edtWidth.getText().toString().trim();
            String inpHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inpLength)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(inpWidth)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(inpHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong!");
            }

            if (!isEmptyFields) {
                double volum = Double.valueOf(inpLength) * Double.valueOf(inpWidth) * Double.valueOf(inpHeight);
                tvResult.setText(String.valueOf(volum));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}