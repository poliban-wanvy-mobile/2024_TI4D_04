package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText pelanggan, harga, kuantitas, uang, diskon;
    Button proses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //input
        pelanggan = findViewById(R.id.pelanggan);
        harga = findViewById(R.id.harga);
        kuantitas = findViewById(R.id.kuantitas);
        uang = findViewById(R.id.uang);
        diskon = findViewById(R.id.diskon);

        proses = findViewById(R.id.proses);

        //output
       TextView total = findViewById(R.id.total);
       TextView kembalian = findViewById(R.id.kembalian);



        proses.setOnClickListener(v ->{

            //ambil nilai dari variable
            // Var pelanggan1 never use
            //String pelanggan1 = pelanggan.getText().toString();
            Integer harga1 = Integer.parseInt(harga.getText().toString());
            Integer kuantitas1 = Integer.parseInt(kuantitas.getText().toString());
            Integer uang1 = Integer.parseInt(uang.getText().toString());
            Integer diskon1 = Integer.parseInt(diskon.getText().toString());

            //hitung
            Integer total2 = harga1 * kuantitas1;
            Integer diskon2 = total2 * diskon1 / 100;
            Integer total3 = total2 - diskon2;
            Integer kembalian2 = uang1 - total3;

            //ubah var integer ke string agar dpt ditampilkan
            String total4 = String.valueOf(total3);
            String kembalian3 = String.valueOf(kembalian2);

            //output
            total.setText("Total harga :" + total4);
            kembalian.setText("kembalian : " + kembalian3);

        });
    }
}
