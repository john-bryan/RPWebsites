package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinnerCat);
        spn2 = findViewById(R.id.spinnerSub);
        btnGo = findViewById(R.id.buttonGo);
        al = new ArrayList<>();



        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] list;

                switch (position){
                    case 0:
                        al.clear();
                        list = getResources().getStringArray(R.array.subA);
                        al.addAll(Arrays.asList(list));
                        spn2.setSelection(position);
                        break;

                    case 1:
                        al.clear();
                        list = getResources().getStringArray(R.array.subB);
                        al.addAll(Arrays.asList(list));
                        spn2.setSelection(position);
                        break;
                }
                aa.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spn1.getSelectedItem().equals("RP") && spn2.getSelectedItem().equals("Homepage")) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("url", "www.rp.edu.sg/");
                    startActivity(intent);
                }
                else if (spn1.getSelectedItem().equals("RP") && spn2.getSelectedItem().equals("Student Life")) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("url", "www.rp.edu.sg/student-life");
                    startActivity(intent);
                }
                else if (spn1.getSelectedItem().equals("SOI") && spn2.getSelectedItem().equals("DMSD")) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("url", "www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("url", "www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                    startActivity(intent);
                }
            }
        });

        aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, al);
        spn2.setAdapter(aa);
    }
}
