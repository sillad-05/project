package com.example.attendance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnEnroll, btnAuthenticate, btnRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnroll = findViewById(R.id.btnEnroll);
        btnAuthenticate = findViewById(R.id.btnAuthenticate);
        btnRecord = findViewById(R.id.btnRecord);

        btnEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Enroll clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnAuthenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Authenticate clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnRecord.setOnClickListener(v -> {

            SupabaseClient.fetchAttendance(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    runOnUiThread(() ->
                            Toast.makeText(MainActivity.this,
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show()
                    );
                }

                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response)
                        throws IOException {

                    String json = response.body().string();

                    runOnUiThread(() ->
                            Toast.makeText(MainActivity.this,
                                    json,
                                    Toast.LENGTH_LONG).show()
                    );
                }
            });
        });

    }
}
