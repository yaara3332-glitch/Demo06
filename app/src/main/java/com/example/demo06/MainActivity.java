package com.example.demo06;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    int cnt;


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

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        cnt = 0;
    }
    public boolean isContainSeven(int num) {
        while (num != 0) {
            int d = num % 10;
            if (d == 7) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public String sevenBoom(int num) {
        String txt = "";

        if (num % 7 == 0) {
            txt = "BOOM!";
        }
        else if (isContainSeven(num) == true) {
            txt = "BOOM!";
        }
        else {
            txt = "This is a click number: " + num;
        }
        return txt;
    }



    public void clicked(View view){
        cnt = cnt + 1;
        textView.setText(sevenBoom(cnt));
        }
    }
