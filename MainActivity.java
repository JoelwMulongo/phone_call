package com.apk_devops_testproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { 
EditText edtphncall;

String telNum;

Button btnphncall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
edtphncall=(EditText)findViewById(R.id.edtphncall);

        btnphncall=(Button)findViewById(R.id.btnphncall);

        btnphncall.setOnClickListener(new View.OnClickListener() {
          @Override

    public void do_call(View view) {
        EditText edt = findViewById(R.id.number_text);
        String text = edt.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_CALL);
         telNum=edtphncall.getText().toString();
                 if(telNum.trim().isEmpty()){
        callIntent.setData(Uri.parse("tel:567788"));
        //Toast.makeText(getApplicationContext(),"Please Enter Num",Toast.LENGTH_SHORT).show();

                }

				else{
                    intentCall.setData(Uri.parse("tel:"+telNum)); }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
          
        }
       else { startActivity(callIntent);
    }
});
    public void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
