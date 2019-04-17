package com.example.kanishk.virtualtype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    //EditText nm=(EditText)findViewById(R.id.getNum);
    public void getData(View view) throws IOException {
        EditText nm=(EditText)findViewById(R.id.getNum);
        ListView listView=(ListView)findViewById(R.id.listId) ;
        String st=nm.getText().toString();
       // Toast.makeText(HomeActivity.this,"hi "+ st, Toast.LENGTH_SHORT).show();
        //ArrayList<String> alist=new ArrayList<>();
        InputStream is = getResources().openRawResource(R.raw.t9dictionary);
        ArrayList<String> alist= (ArrayList<String>) TypingAssist.mains(st,is);
        if(alist.size()==0)
        {
            Toast.makeText(this, "No Suggessions!!", Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alist);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
