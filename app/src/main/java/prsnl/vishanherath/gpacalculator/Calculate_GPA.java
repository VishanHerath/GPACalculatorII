package prsnl.vishanherath.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.widget.TextView;

public class Calculate_GPA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate__g_p);

        LinearLayout linLayout;
        String NoFS;
        int NoFI;

        linLayout = findViewById(R.id.linearLayout);
        EditText nof = (EditText) findViewById(R.id.NoFeditText);

        NoFS = nof.getText().toString();
        NoFI = Integer.parseInt(NoFS);


        for(int i=0; i<NoFI; i++){
            addTextView();
        }

    }

    private void addTextView() {
        //Adding a LinearLayout with HORIZONTAL orientation
        LinearLayout textLinearLayout = new LinearLayout(this);
        textLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        textLinearLayout.addView(textLinearLayout);

        for (int i = 1; i <= 3; i++) {
            TextView textView = new TextView(this);
            textView.setText("TextView " + String.valueOf(i));
            setTextViewAttributes(textView);
            textLinearLayout.addView(textView);
        }
        addLineSeperator();
    }

    private void setTextViewAttributes(TextView textView) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                0, 0
        );

        textView.setTextColor(Color.BLACK);
        textView.setLayoutParams(params);
    }

    private int convertDpToPixel (float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    private void addLineSeperator() {
        LinearLayout lineLayout = new LinearLayout(this);
        lineLayout.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2);
        params.setMargins(0, convertDpToPixel(10), 0, convertDpToPixel(10));
        lineLayout.setLayoutParams(params);
        lineLayout.addView(lineLayout);
    }

}