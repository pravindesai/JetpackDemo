package com.example.jetpackdemo.ViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jetpackdemo.R;

import java.util.List;

public class VMActivity extends AppCompatActivity {
    private VM vm;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_m);
        btn = findViewById(R.id.btn);

        vm = new ViewModelProvider(this).get(VM.class);

        vm.ival.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                //Log.e("**Val: ", "onChanged: "+integer );
                btn.setText(integer.toString());
            }
        });

        vm.intList.observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(List<Integer> integers) {
                Log.e("**intList : ", "onChanged: "+integers );
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.inc();
            }
        });


    }
}