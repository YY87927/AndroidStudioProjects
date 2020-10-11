package com.example.a1011_qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText mail;
    Button btnGen;
    ImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCode = (ImageView) findViewById(R.id.ivCode);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        mail = (EditText) findViewById(R.id.mail);
        btnGen = (Button) findViewById(R.id.btnGen);
    }
    public void genCode(View view) {
        String name_text = name.getText().toString();
        String phone_text = phone.getText().toString();
        String mail_text = mail.getText().toString();
        String result = name_text + "\n" + phone_text + "\n" + mail_text;

        BarcodeEncoder encoder = new BarcodeEncoder();
        try {
            Bitmap bit = encoder.encodeBitmap(result, BarcodeFormat.QR_CODE,
                    250, 250);
            ivCode.setImageBitmap(bit);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }
}