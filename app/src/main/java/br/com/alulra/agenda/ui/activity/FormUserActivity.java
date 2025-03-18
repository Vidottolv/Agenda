package br.com.alulra.agenda.ui.activity;

import br.com.alulra.agenda.R;
import br.com.alulra.agenda.dao.UserDAO;
import br.com.alulra.agenda.model.User;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FormUserActivity extends AppCompatActivity {
    public static final String APPBAR_TITLE = "Add User";
    private EditText fieldName;
    private EditText fieldPhone;
    private EditText fieldEmail;
    final UserDAO dao = new UserDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);
        setTitle(APPBAR_TITLE);
        startingFields();
        saveButton();
    }

    private void saveButton() {
        Button saveButton = findViewById(R.id.activity_form_user_save_button);
        saveButton.setOnClickListener((view) -> {
            User createdUser = createUser();
            saveUser(createdUser);
        });
    }
    private void startingFields() {
        fieldName = findViewById(R.id.activity_form_user_name);
        fieldPhone = findViewById(R.id.activity_form_user_phone);
        fieldEmail = findViewById(R.id.activity_form_user_email);
    }
    private void saveUser(User createdUser) {
        dao.save(createdUser);
        finish();
    }
    @NonNull
    private User createUser() {
        String name = fieldName.getText().toString();
        String phone = fieldPhone.getText().toString();
        String email = fieldEmail.getText().toString();

        return new User(name, phone, email);

    }
}