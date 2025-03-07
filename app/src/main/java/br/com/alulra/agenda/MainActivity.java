package br.com.alulra.agenda;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "First test example", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
        List<String> users = new ArrayList<>(Arrays.asList("Alex", "Fran", "Jose"));

        ListView users_list = findViewById(R.id.activity_main_users_list);

        users_list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, users));
    }
}
