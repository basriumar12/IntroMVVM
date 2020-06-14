package com.example.intromvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //buat global variabel
    EditText edtnilaiSatu, edtnilaiDua;
    Button btnHitung;
    private HitungViewModel hitungViewModel;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtnilaiDua = findViewById(R.id.edt_nilai_dua);
        edtnilaiSatu = findViewById(R.id.edt_nilai_satu);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);

        //inisialisasi viewmodel pada activity
        hitungViewModel = new ViewModelProvider(this).get(HitungViewModel.class);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtnilaiSatu.getText().toString().isEmpty() ||
                        edtnilaiDua.getText().toString().isEmpty()

                ) {
                    Toast.makeText(MainActivity.this, "Nilai tidak bisa kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String nilaiSatu = edtnilaiSatu.getText().toString();
                    String nilaiDua = edtnilaiDua.getText().toString();
                    //memasukan nilai dalam method yang ada dalam HitungViewModel
                    hitungViewModel.calculate(nilaiSatu, nilaiDua);
                    hasilHitung();
                }


            }
        });


    }

    private void hasilHitung() {
        tvHasil.setText("Hasil :"+String.valueOf(hitungViewModel.resultData));
    }
}
