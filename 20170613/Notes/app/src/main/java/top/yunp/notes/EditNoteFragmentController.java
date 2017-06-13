package top.yunp.notes;

import android.view.View;

import top.yunp.notes.databinding.FragmentEditNoteBinding;

/**
 * Created by plter on 6/13/17.
 */

public class EditNoteFragmentController {

    private EditNoteFragment fragment;
    private FragmentEditNoteBinding binding;
    private DbConnector dbConnector;

    public EditNoteFragmentController(FragmentEditNoteBinding binding, EditNoteFragment fragment) {
        this.binding = binding;
        this.fragment = fragment;

        dbConnector = new DbConnector(fragment.getActivity());

        binding.titleInput.setText(fragment.getTitle());
        binding.contentInput.setText(fragment.getContent());
    }

    public void btnCancelClicked(View v) {
        fragment.getFragmentManager().popBackStack();
    }

    public void btnSaveClicked(View v) {
        String title = binding.titleInput.getText().toString();
        String content = binding.contentInput.getText().toString();

        if (fragment.getNoteId() > 0) {
            dbConnector.updateNote(fragment.getNoteId(), title, content);
        } else {
            dbConnector.insertNote(title, content);
        }

        fragment.getFragmentManager().popBackStack();
    }

    public void onDestroy() {
        dbConnector.close();
    }
}
