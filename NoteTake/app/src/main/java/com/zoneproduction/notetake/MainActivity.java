package com.zoneproduction.notetake;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {

                //update Recycler View
                adapter.setNotes(notes);

            }
        });

        //Dodavanje slide funkcije prilikom brisanja ili nekog kurca On move je kao nošenje a swipeanje je samo lijevo i desno
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                noteViewModel.delete(adapter.getNote(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Note note) {

                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("id", note.getId());
                intent.putExtra("title", note.getTitle());
                intent.putExtra("description", note.getDescription());
                startActivityForResult(intent, 2);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.new_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.top_menu:
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivityForResult(intent,1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){

            assert data != null;
            String title = data.getStringExtra("noteTitle");
            String description = data.getStringExtra("noteDescription");

            Note note = new Note(title, description);
            noteViewModel.insert(note);
        }else if(resultCode == 2 && resultCode == RESULT_OK){

            String title = data.getStringExtra("titleLast");
            String description = data.getStringExtra("descriptionLast");
            int id = data.getIntExtra("noteId", -1);

            Note note = new Note(title,description);
            note.setId(id);
            noteViewModel.update(note);
        }
    }
}