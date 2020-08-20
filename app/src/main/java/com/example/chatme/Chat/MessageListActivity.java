package com.example.chatme.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatme.R;
import com.example.chatme.User.User;

import java.util.ArrayList;
import java.util.List;

public class MessageListActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText chatMessage;
    private Button sendButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);

        chatMessage = (EditText) findViewById(R.id.chatMessage);
        sendButton = (Button) findViewById(R.id.sendButton);
        recyclerView = (RecyclerView) findViewById(R.id.chatList);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Message> list = getMessageList();

        mAdapter = new MessageController(list);
        recyclerView.setAdapter(mAdapter);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_chat));
        //Активация кнопка Назад на панели приложения
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



//        LayoutInflater inflater = getLayoutInflater();
//        MessageController cotroller = new MessageController(list, inflater);

        //chatWindow.setAdapter(cotroller);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.share_action);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Join to my room in Chat!");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, s);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.exit_action:
               this.finish();
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }
    }

    private List<Message> getMessageList() {
        List<Message> list = new ArrayList<>();

        list.add(new Message("Привет всем в этом чате!", User.users.get(0), true));
        list.add(new Message("Как дела?", User.users.get(0), true));

        return list;
    }
}
