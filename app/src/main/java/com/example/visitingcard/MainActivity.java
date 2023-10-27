package com.example.visitingcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static int PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dialNum = findViewById(R.id.phoneField);
        Button sendEmail = findViewById(R.id.emailField);

        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, PERMISSION_CODE);
        }
        dialNum.setOnClickListener(v -> {
            String phnNo = "+8801735867676";
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:"+phnNo));
            startActivity(i);
        });

        sendEmail.setOnClickListener(v -> {
            String emailAdd = "sowmikshovon@gmail.com";
            Intent j = new Intent(Intent.ACTION_SENDTO);
            j.setData(Uri.parse("mailto:"+emailAdd));
            startActivity(j);
        });
    }

}