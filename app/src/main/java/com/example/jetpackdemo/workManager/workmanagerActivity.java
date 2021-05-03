package com.example.jetpackdemo.workManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jetpackdemo.MainActivity;
import com.example.jetpackdemo.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class workmanagerActivity extends AppCompatActivity {
    TextView downloadTextView;
    Button downloadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workmanager);

        downloadTextView = findViewById(R.id.downloadTextView);
        downloadButton = findViewById(R.id.downloadButton);

        //Not Required if worker does not need any data
        Data data = new Data.Builder()
                .putInt("number", 10)
                .build();

        //Not required if no criteria
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setConstraints(constraints)
                .setInputData(data)
                .addTag("download")
                .build();


        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkManager.getInstance(getApplicationContext())
                        .enqueueUniqueWork("mywork",
                        ExistingWorkPolicy.KEEP,
                        oneTimeWorkRequest);
            }
        });



        WorkManager.getInstance(this).getWorkInfosByTagLiveData("download").observe(this
                , new Observer<List<WorkInfo>>() {
                    @Override
                    public void onChanged(List<WorkInfo> workInfos) {
                        if (workInfos.size()>0){
                            Log.e("**", "onChanged: "+workInfos.get(0).getState() );
                            downloadTextView.setText(workInfos.get(0).getState()+"");
                        }
                    }
                });
    }
}