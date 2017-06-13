package top.yunp.notes;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        readAndShowNotes();

        addListeners();
    }

    private void addListeners() {
        binding.notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = (Note) parent.getAdapter().getItem(position);

                showEditNoteFragment(note);
            }
        });

        binding.notesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Note note = (Note) parent.getAdapter().getItem(position);

                new AlertDialog.Builder(fragment.getActivity())
                        .setAdapter(new ArrayAdapter<String>(fragment.getActivity(), android.R.layout.simple_list_item_1, new String[]{"编辑", "删除"}), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        showEditNoteFragment(note);
                                        break;
                                    case 1:
                                        dbConnector.deleteNode(note.getId());
                                        readAndShowNotes();
                                        break;
                                }
                            }
                        })
                        .show();
                return true;
            }
        });
    }

    private void showEditNoteFragment(Note note) {
        fragment.getFragmentManager()
                .beginTransaction()
                .replace(R.id.rootContainer, EditNoteFragment.newInstance(note.getId(), note.getTitle(), note.getContent()))
                .addToBackStack(EditNoteFragment.NAME)
                .commit();
    }

    private void readAndShowNotes() {
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
