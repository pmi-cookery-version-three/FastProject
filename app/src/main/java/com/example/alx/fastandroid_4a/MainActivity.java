package com.example.alx.fastandroid_4a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


// Ctrl + B -> Перейти к определению
public class MainActivity extends AppCompatActivity {

    ListView lv;
    Button btAdd;

    EditText et_n;  // имя
    EditText et_fn; // фамилия

    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.LV_data);
        btAdd = (Button) findViewById(R.id.BT_add);

        et_n = (EditText)findViewById(R.id.IN_name);
        et_fn = (EditText)findViewById(R.id.IN_fname);

        list = new ArrayList<>();

        list.add(new User("Иван", "Иваныч"));
        list.add(new User("Борис", "Бритва"));
        list.add(new User("Борис1", "Борисыч"));

        UserAdapter usr  = new UserAdapter(this, list);

        //ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, R.layout.simple_list_item1, list);

        lv.setAdapter(usr);
    }


    // Обработчик нажатия клавиши
    public void onMyButtonClick(View view)
    {
        // Какой то запрос на деградацию (с) alx
        if(et_n.getText().length() != 0 && et_fn.getText().length() != 0 ){
            list.add(new User(et_n.getText().toString(), et_fn.getText().toString()));

            UserAdapter usr  = new UserAdapter(this, list);
            lv.setAdapter(usr);
            // выводим сообщение
            Toast.makeText(this, "Данные добавленны!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Введите данные!", Toast.LENGTH_SHORT).show();
        }


    }
}
