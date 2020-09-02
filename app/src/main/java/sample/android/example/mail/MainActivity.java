package sample.android.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private Button btm;
    private Button btm2;
    private Button line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btm = (Button)findViewById(R.id.button);
        btm2 = (Button)findViewById(R.id.button2);
        line = (Button)findViewById(R.id.button4);

        //迎えに来てボタンを押したときの処理
        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Pickup.class);
                startActivity(intent);
            }
        });

        //今日のご飯ボタンを押したときの処理
        btm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Ndinner.class);
                startActivity(intent);
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("line://msg/text/" + "送りたいテキストの内容"));
                // ブラウザ起動
                startActivity(intent);
            }
        });
    }
}
