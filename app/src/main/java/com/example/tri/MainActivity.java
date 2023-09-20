package com.example.tri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.function.ToDoubleFunction;

public class MainActivity extends AppCompatActivity {
    EditText edituser,editpassword;
    Button buttondangky,buttondangnhap;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControButton();
    }
    private void ControButton(){
        buttondangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dangky);
                EditText edittk = (EditText) dialog.findViewById(R.id.edittk);
                EditText editmk = (EditText) dialog.findViewById(R.id.editmk);
                Button buttonhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button buttondongy = (Button) dialog.findViewById(R.id.buttondongy);
                buttondongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten =edittk.getText().toString().trim();
                        mk =editmk.getText().toString().trim();

                        edituser.setText(ten);
                        editpassword.setText(mk);
                        dialog.cancel();
                    }
                });
                buttonhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        buttondangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edituser.getText().length() !=0 && editpassword.getText().length() !=0){
                    if (edituser.getText().toString().equals(ten) && editpassword.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    } else if (edituser.getText().toString().equals("tri") && editpassword.getText().toString().equals("123")) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thất bại ", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập đủ thông tin ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Anhxa(){
        edituser = (EditText) findViewById(R.id.edittextuer);
        editpassword = (EditText)  findViewById(R.id.edittextpassword);
        buttondangky = (Button) findViewById(R.id.buttondangky);
        buttondangnhap = (Button) findViewById(R.id.buttondangnhap);
    }
}