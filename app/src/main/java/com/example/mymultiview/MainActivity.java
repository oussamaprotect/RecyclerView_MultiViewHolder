package com.example.mymultiview;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button send,recieve;
    EditText editText;
    String m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittxt);
        send = findViewById(R.id.send);
        recieve = findViewById(R.id.reciv);
        ArrayList<MessageModel> messagesList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              m = editText.getText().toString();

              messagesList.add(new MessageModel(m, CustomAdapter.MESSAGE_TYPE_IN));

                CustomAdapter adapter = new CustomAdapter(MainActivity.this, messagesList);


                recyclerView.setAdapter(adapter);
                recyclerView.scrollToPosition(messagesList.size()-1);
                editText.setText("");
            }
        });

        recieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              m = editText.getText().toString();

              messagesList.add(new MessageModel(m,CustomAdapter.MESSAGE_TYPE_OUT));

                CustomAdapter adapter = new CustomAdapter(MainActivity.this, messagesList);


                recyclerView.setAdapter(adapter);
                recyclerView.scrollToPosition(messagesList.size()-1);
                editText.setText("");

            }
        });

        // Populate dummy messages in List, you can implement your code here

        for (int i=0;i<30;i++) {

        }



    }
}