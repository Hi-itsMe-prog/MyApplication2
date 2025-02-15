package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer count = 0;
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
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();


        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("Click", 0);
            TextView txt = findViewById(R.id.txtCounter);
            txt.setText(count.toString());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Instance", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Instance", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Instance", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Instance", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Instance", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Click", count);
        Log.d("Instance", "onSave");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("Click")) {
            count = savedInstanceState.getInt("Click");
            TextView txt = findViewById(R.id.txtCounter);
            txt.setText(count.toString());
        }
        Log.d("Instance", "get");
    }

    public void onClickButton(View view) {
        count++;
        TextView txt = findViewById(R.id.txtCounter);
        txt.setText(count.toString());
    }

    public void onClickButton1(View view) {
        count += 2;
        TextView txt = findViewById(R.id.txtCounter);
        txt.setText(count.toString());
    }
}
