package du.iic.exampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et, et2;
    Button btn, btnBlue, btnRed;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);

        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnRed = (Button) findViewById(R.id.btnRed);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.valueOf(et.getText().toString());
                int b = Integer.valueOf(et2.getText().toString());

                int c = a + b;
                tv.setText(String.valueOf(c));
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RedActivity.class);
                startActivity(i);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(i);
            }
        });
    }
}
