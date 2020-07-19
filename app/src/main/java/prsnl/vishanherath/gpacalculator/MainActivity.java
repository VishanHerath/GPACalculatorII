package prsnl.vishanherath.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button;
    String text;
    //int no;
    Spinner spinner;
    TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (TextView) findViewById(R.id.text);

        button = findViewById(R.id.calcBtn);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.subjects,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calc = new Intent(getApplicationContext(), Calculate_GPA.class);
                startActivity(calc);
            }
        });
        //no = Integer.parseInt(text);
        //String[] inputs = new String[no];
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //int n = (int) parent.getItemAtPosition(position);
        text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        a.setText(text);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}
