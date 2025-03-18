package br.com.alulra.agenda.ui.activity;

import br.com.alulra.agenda.R;
import br.com.alulra.agenda.dao.UserDAO;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class UsersListActivity extends AppCompatActivity {
    public static final String USERS_LIST = "Users list";
    private final UserDAO dao = new UserDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "First test example", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_users_list);
        setTitle(USERS_LIST);
        FABNewUser();
    }
    private void FABNewUser() {
        FloatingActionButton NewUserButton = findViewById(R.id.activity_users_list_fab_new_user);
        NewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenFormUserActivity();
            }
        });
    }
    private void OpenFormUserActivity() {
        startActivity(new Intent(this, FormUserActivity.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
        usersList();
    }
    private void usersList() {
        ListView users_list = findViewById(R.id.activity_users_listview);
        users_list.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
