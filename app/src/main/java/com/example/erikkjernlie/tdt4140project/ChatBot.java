package com.example.erikkjernlie.tdt4140project;


import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class ChatBot extends Activity {
    private static final String TAG = "ChatActivity";

    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private Button buttonSend;
    private boolean side = false;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chatbot);


        buttonSend = (Button) findViewById(R.id.send);

        listView = (ListView) findViewById(R.id.msgview);

        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.right_chat);
        listView.setAdapter(chatArrayAdapter);

        chatText = (EditText) findViewById(R.id.msg);
        chatText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    return sendChatMessage();
                }
                return false;
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendChatMessage();
            }
        });

        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatArrayAdapter);

        //to scroll the list view to bottom on data change
        chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatArrayAdapter.getCount() - 1);
            }
        });
    }

    //her er alt som skrives inn, og her er det vi svarer
    private boolean sendChatMessage() {

        String a = chatText.getText().toString();
        chatArrayAdapter.add(new ChatMessage(side, a));
        chatText.setText(""); //nullstiller chatboksen
        //her kommer responsen
        if (a.toLowerCase().equals("hi") || a.toLowerCase().equals("hello") || a.toLowerCase().equals("mårn")){
            chatArrayAdapter.add(new ChatMessage(true, "This is UniBOT. Hello"));
        } else if (a.toLowerCase().equals("who would jonas like to fuck?")){
            chatArrayAdapter.add(new ChatMessage(true, "Herman"));
        } else{
            chatArrayAdapter.add(new ChatMessage(true, "This is UniBOT. I don't understand"));
        }
        return true;
    }
}