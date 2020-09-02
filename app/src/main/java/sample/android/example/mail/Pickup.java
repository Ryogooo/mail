package sample.android.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pickup extends AppCompatActivity {

    private Button send;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);

        send = (Button)findViewById(R.id.send);

        //送信ボタンを押したときの処理
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RadioGroupの定義
                RadioGroup rgplace = (RadioGroup)findViewById(R.id.radioGroup);

                //RadioGroupでチェックされた項目をcheckedIdに代入
                int checkedId = rgplace.getCheckedRadioButtonId();

                //チェックした項目を文字列に変換
                String strplace = ((RadioButton)findViewById(checkedId)).getText().toString();

                //タイトルのEditTextを定義
                editText = (EditText)findViewById(R.id.editText);
                //EditTextに入力されている文字を文字列に変換
                String title = editText.getText().toString();

                //アプリケーションのリソースにアクセスするための定義
                Resources res = getResources();
                //URI 参照
                //string.xmlに記述されたメールアドレスを取得してmailto:と連携
                Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());

                //アクティビティアクション　指定した人にメッセージを送信ACTION_SENDTO
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);

                intent.putExtra(Intent.EXTRA_SUBJECT,title);
                intent.putExtra(Intent.EXTRA_TEXT,strplace +"に迎えに来て");
                startActivity(intent);
            }
        });
    }
}
