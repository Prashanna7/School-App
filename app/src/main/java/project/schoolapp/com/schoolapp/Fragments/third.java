package project.schoolapp.com.schoolapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.schoolapp.com.schoolapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link third.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link third#newInstance} factory method to
 * create an instance of this fragment.
 */

public class third extends Fragment {

    private RecyclerView mRecyclerview;

    public third() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);


        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
