package com.example.team14;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.team14.contacts.ContactActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    static boolean service_activity_started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonService;
        Switch buttonServiceToggle;

//        buttonService = findViewById(R.id.button2);
//        buttonServiceToggle = findViewById(R.id.switch1);


//        buttonServiceToggle.setOnClickListener(view -> {
//            Thread myThread = null;
//            Runnable myRunnableThread = new CountDownRunner();
//            myThread= new Thread(myRunnableThread);
//            if (buttonServiceToggle.isChecked()) {
//                myThread.start();
//                Logger.getAnonymousLogger().info("Service started");
//            } else {
//                myThread.interrupt();
//                Logger.getAnonymousLogger().info("Service stopped");
//            }
//        });

//        buttonService.setOnClickListener(view -> {
//            Thread myThread = null;
//            if (this.service_activity_started) {
//                Logger.getAnonymousLogger().info("Stopping countdown runner");
//                this.service_activity_started = false;
//            } else {
//                Logger.getAnonymousLogger().info("Starting countdown runner");
//                Runnable myRunnableThread = new CountDownRunner();
//                myThread= new Thread(myRunnableThread);
//                myThread.start();
//                this.service_activity_started = true;
//            }
//        });
        textView = findViewById(R.id.textView5);
        Date currentTime = Calendar.getInstance().getTime();

        textView.setText(currentTime.toString());
    }


    public void broadcastListener(View view) {
        Logger.getAnonymousLogger().info("inside logger");
    }

    public void gotoContacts(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }

    public void toService(View view) {
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);
    }

    class CountDownRunner implements Runnable{
        // @Override
        public void run() {
            while(MainActivity.service_activity_started){
                try {
                    onClickServiceActivity();
                    Thread.sleep(1000); // Pause of 1 Second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }catch(Exception e){
                }
            }
        }
    }
    public void onClickServiceActivity() {
        runOnUiThread(() -> {
            try{
                textView = findViewById(R.id.textView5);
                Date dt = new Date();
                int hours = dt.getHours();
                int minutes = dt.getMinutes();
                int seconds = dt.getSeconds();
                String curTime = hours + ":" + minutes + ":" + seconds;
                textView.setText(curTime);
            }catch (Exception e) {}
        });
    }
}