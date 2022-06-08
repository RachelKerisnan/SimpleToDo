package sg.edu.rp.c346.id21013643.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etToDo;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    ListView lvToDo;
    Spinner spnAnR;

    ArrayList<String> ToDoList;
    ArrayAdapter<String> ToDoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etToDo = findViewById(R.id.editText1);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDelete = findViewById(R.id.buttonDelete);
        btnClear = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.lvToDo);
        spnAnR = findViewById(R.id.spinner);


        ToDoList =  new ArrayList<> ();
        ToDoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ToDoList);

        lvToDo.setAdapter(ToDoAdapter);




        spnAnR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        etToDo.setHint("Type in a new task here");
                        spnAnR.getSelectedItemPosition();
                        spnAnR.getSelectedItem();


                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String newTask = etToDo.getText().toString();
                                ToDoList.add(newTask);
                                etToDo.clearComposingText();

                            }

                        });
                        btnClear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                lvToDo.setAdapter(null);
                                ToDoAdapter.notifyDataSetChanged();
                                etToDo.clearFocus();


                            }
                        });

                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);
                        etToDo.clearFocus();
                        break;

                    case 1:
                        spnAnR.getSelectedItemPosition();
                        spnAnR.getSelectedItem();
                        etToDo.setHint("Type in the index of the task to be removed here");
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);

                        btnClear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                lvToDo.setAdapter(null);
                                ToDoAdapter.notifyDataSetChanged();
                                etToDo.clearFocus();


                            }
                        });


                        btnDelete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // String element = etToDo.getText().toString();
                                int position = Integer.parseInt(etToDo.getText().toString());

                                ToDoList.remove(position);
                                etToDo.clearComposingText();
                                ToDoAdapter.notifyDataSetChanged();

                               int A =  lvToDo.getCount();
                                if(position > A){
                                    Toast.makeText(MainActivity.this,"Wrong Index Number",Toast.LENGTH_LONG).show();

                                }

                            }

                        });




                        etToDo.clearComposingText();


                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        lvToDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (lvToDo == null){
                    Toast.makeText(MainActivity.this,"You don't have any task to remove",Toast.LENGTH_LONG).show();

                }




                }
        });
    }
}
