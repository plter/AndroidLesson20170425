package top.yunp.notes;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.yunp.notes.databinding.FragmentEditNoteBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditNoteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ID = "noteId";
    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";
    public static final String NAME = "EditNoteFragment";

    // TODO: Rename and change types of parameters
    private String title;
    private String content;
    private int noteId;
    private EditNoteFragmentController controller;


    public EditNoteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title   Parameter 1.
     * @param content Parameter 2.
     * @return A new instance of fragment EditNoteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditNoteFragment newInstance(int id, String title, String content) {
        EditNoteFragment fragment = new EditNoteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
            noteId = getArguments().getInt(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentEditNoteBinding binding = FragmentEditNoteBinding.inflate(inflater);
        controller = new EditNoteFragmentController(binding, this);
        binding.setController(controller);
        return binding.getRoot();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getNoteId() {
        return noteId;
    }

    @Override
    public void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }
}
