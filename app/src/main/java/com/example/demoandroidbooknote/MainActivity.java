package com.example.demoandroidbooknote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtnoidung,txtTieuDe;
    EditText noidung1,noidung2,noidung3;
    Button btnThem;
    RecyclerView recyclerviewNote;
    AdapterNote adapterNote;
    ArrayList<Note> dsnote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noidung1=findViewById(R.id.nhapnoidung1);
        noidung2=findViewById(R.id.nhapnoidung2);
        noidung3=findViewById(R.id.nhapnoidung3);
        btnThem=findViewById(R.id.them);
        dsnote=new ArrayList<>();
        // xu ly them
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsnote.add(new Note(noidung1.getText()+"",noidung2.getText()+"",noidung3.getText()+""));
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerviewNote.setLayoutManager(layoutManager);
                adapterNote = new AdapterNote(MainActivity.this, R.layout.custom_layout_recylerviewnote, dsnote);
                recyclerviewNote.setAdapter(adapterNote);

                adapterNote.notifyDataSetChanged(); // cập nhật lại dữ liệu

            }
        });


        txtTieuDe=findViewById(R.id.txtTieuDe);
        txtnoidung=findViewById(R.id.txtNoiDung);
        recyclerviewNote=findViewById(R.id.recyclerviewNote);
        // nhận dữ liệu từ recyclerview
        Intent intent = getIntent();
        String tieude = intent.getStringExtra("tieude");
        String noidung = intent.getStringExtra("noidung");

        txtnoidung.setText(noidung);
        txtTieuDe.setText(tieude);


       /* dsnote.add(new Note("abc1","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));
        dsnote.add(new Note("abc2","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));
        dsnote.add(new Note("abc3","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));
        dsnote.add(new Note("abc4","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));
        dsnote.add(new Note("abc5","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));
        dsnote.add(new Note("abc6","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));
        dsnote.add(new Note("abc7","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));
        dsnote.add(new Note("abc8","20-12-1999","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa/n bbbbbbb"));*/

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerviewNote.setLayoutManager(layoutManager);
        adapterNote = new AdapterNote(MainActivity.this, R.layout.custom_layout_recylerviewnote, dsnote);
        recyclerviewNote.setAdapter(adapterNote);


        adapterNote.notifyDataSetChanged(); // cập nhật lại dữ liệu

    }
}
