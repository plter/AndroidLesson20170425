package top.yunp.notes;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import top.yunp.notes.databinding.FragmentMainBinding;

/**
 * Created by plter on 6/13/17.
 */

public class MainFragmentController {
    private final FragmentMainBinding binding;
    private final MainFragment fragment;
    private DbConnector dbConnector;

    public MainFragmentController(FragmentMainBinding binding, MainFragment fragment) {
        this.binding = binding;
        this.fragment = fragment;

        dbConnector = new DbConnector(fragment.getActivity());
        readNotes();

        addListeners();
    }

    private void addListeners() {
        binding.notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = (Note) parent.getAdapter().getItem(position);

                fragment.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.rootContainer, EditNoteFragment.newInstance(note.getId(), note.getTitle(), note.getContent()))
                        .addToBackStack(EditNoteFragment.NAME)
                        .commit();
            }
        });
    }

    private void readNotes() {
        NotesCursor cursor = dbConnector.queryNotes();
        List<Note> notes = new ArrayList<>();
        while (cursor.moveToNext()) {
            notes.add(new Note(cursor.getId(), cursor.getTitle(), cursor.getContent()));
        }
        cursor.close();

        binding.notesListView.setAdapter(new ArrayAdapter<Note>(fragment.getActivity(), android.R.layout.simple_list_item_1, notes));
    }

    public void btnAddClicked(View v) {
        fragment.getFragmentManager()
                .beginTransaction()
                .replace(R.id.rootContainer, EditNoteFragment.newInstance(0, "", ""))
                .addToBackStack(EditNoteFragment.NAME)
                .commit();
    }

    public void onDestroy() {
        dbConnector.close();
    }
}
