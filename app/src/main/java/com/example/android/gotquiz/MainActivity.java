package com.example.android.gotquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int mScoreRecord = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find and set text to view
        TextView textViewQue1 = findViewById(R.id.text_view_que1);
        textViewQue1.setText("Who is pictured below?");

        // Radio group 1
        RadioButton radioButton1 = findViewById(R.id.rg1_option_1);
        RadioButton radioButton2 = findViewById(R.id.rg1_option_2);
        RadioButton radioButton3 = findViewById(R.id.rg1_option_3);
        RadioButton radioButton4 = findViewById(R.id.rg1_option_4);

        // Set text to each radio button
        radioButton1.setText("Tyrion Lannister");
        radioButton2.setText("Jaime Lannister");
        radioButton3.setText("Jon Snow");
        radioButton4.setText("Tywin Lannister");

        // Find and set text to view
        TextView textViewQue2 = findViewById(R.id.text_view_que2);
        textViewQue2.setText("Select those which are the Starks' dire wolves (Select only two)");

        // Checkboxes
        CheckBox checkBox1 = findViewById(R.id.checkbox_ghost);
        CheckBox checkBox2 = findViewById(R.id.checkbox_simba);
        CheckBox checkBox3 = findViewById(R.id.checkbox_nymeria);
        CheckBox checkBox4 = findViewById(R.id.checkbox_narnia);

        // Set text to checkboxes
        checkBox1.setText("Ghost");
        checkBox2.setText("Simba");
        checkBox3.setText("Nymeria");
        checkBox4.setText("Narnia");

        // Radio group 2
        RadioButton radioButton5 = findViewById(R.id.rg2_option_1);
        RadioButton radioButton6 = findViewById(R.id.rg2_option_2);
        RadioButton radioButton7 = findViewById(R.id.rg2_option_3);
        RadioButton radioButton8 = findViewById(R.id.rg2_option_4);

        // Set text to each radio button
        radioButton5.setText("6");
        radioButton6.setText("4");
        radioButton7.setText("2");
        radioButton8.setText("3");

        // Radio group 3
        RadioButton radioButton9 = findViewById(R.id.rg3_option_1);
        RadioButton radioButton10 = findViewById(R.id.rg3_option_2);
        RadioButton radioButton11 = findViewById(R.id.rg3_option_3);
        RadioButton radioButton12 = findViewById(R.id.rg3_option_4);

        // Find and set text to view
        TextView textViewQue3 = findViewById(R.id.text_view_que3);
        textViewQue3.setText("Brian pledged her allegiance to which of these pairs?");

        // Set text to each radio button
        radioButton9.setText("Renly Baratheon and Melisandre");
        radioButton10.setText("Sansa Stark and Selwyn Tarth");
        radioButton11.setText("Stannis Baratheon and Catelyn Stark");
        radioButton12.setText("Catelyn Stark and Renly Baratheon");

        TextView textViewQue4 = findViewById(R.id.text_view_que4);
        textViewQue4.setText("The below is known as the...");

    }

    public void onRadioButtonClicked(View view) {
        // checked state of radio button
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rg1_option_2:
                if (checked) {
                    // in radio group 1 the correct option is option 2, add 1 point
                    mScoreRecord += 1;
                }
                break;
            case R.id.rg2_option_4:
                if (checked) {
                    // in radio group 2 the correct option is 4, add 1 point
                    mScoreRecord += 1;
                }
            case R.id.rg3_option_4:
                if (checked) {
                    // in radio group 3 correct option is 4, add 1 point
                    mScoreRecord += 1;
                }
            default:
                // otherwise, do not add any points if other options were chosen
                mScoreRecord += 0;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkbox_ghost:
                if (checked) {
                    // the correct answer is ghost, add 1 point
                    mScoreRecord += 1;
                }
                break;
            case R.id.checkbox_nymeria:
                if (checked) {
                    // the correct answer is nymeria, add 1 point
                    mScoreRecord += 1;
                }
            default:
                // if other options are selected, don't add anything
                mScoreRecord += 0;
                break;
        }
    }

    // This method ensures the data within is sent after its pressed
    public void onSubmitButtonClicked(View view) {
        // find edit text view
        EditText userName = findViewById(R.id.username_edit_text);
        // store in name variable
        String name = userName.getText().toString();

        // find view and store
        EditText editText2 = findViewById(R.id.edit_text_iron_throne);
        String ironThrone = editText2.getText().toString();
        StringBuffer correctAns = new StringBuffer("iron throne");

        if (ironThrone.contains(correctAns)) {
            // edit text matches string, add 1 point
            mScoreRecord += 1;
        } else mScoreRecord += 0;
        Toast.makeText(this, name + " your score is " + mScoreRecord, Toast.LENGTH_LONG).show();
        mScoreRecord = 0;
        Intent restartGame = getIntent();
        // terminate activity
        finish();
        //start new activity
        startActivity(restartGame);
    }
}
