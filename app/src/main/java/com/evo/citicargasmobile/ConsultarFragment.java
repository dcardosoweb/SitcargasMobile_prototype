package com.evo.citicargasmobile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsultarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsultarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarFragment extends Fragment {

    public ConsultarFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_consultar, container, false);

        return rootView;
    }

}
