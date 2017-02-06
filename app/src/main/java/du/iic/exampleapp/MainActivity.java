package du.iic.exampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et, et2;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.valueOf(et.getText().toString());
                int b = Integer.valueOf(et2.getText().toString());

                int c = a + b;
                tv.setText(String.valueOf(c));
            }
        });
    }
}
