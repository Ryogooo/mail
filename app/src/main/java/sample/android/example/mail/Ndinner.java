package sample.android.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ndinner extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndinner);

        button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        editText = (EditText)findViewById(R.id.editText2);
        String title = editText.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
        intent.putExtra(Intent.EXTRA_TEXT,"遅くなるので飯いらないです");
        intent.putExtra(Intent.EXTRA_SUBJECT,title);
        startActivity(intent);

    }

    @Override
    public boolean onLongClick(View v) {
        editText = (EditText)findViewById(R.id.editText2);
        String title = editText.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
        intent.putExtra(Intent.EXTRA_SUBJECT,title);
        intent.putExtra(Intent.EXTRA_TEXT,"遅くなるので飯いらないです。" + "いつもありがとう");
        startActivity(intent);
        return true;
    }
}
