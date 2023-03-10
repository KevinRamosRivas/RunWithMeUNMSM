package com.arge.correosm;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link activity_PerfilUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activity_PerfilUser extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public SharedPreferences mPref;
    public ImageButton mButtonCloseSession;

    public activity_PerfilUser() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment activity_PerfilUser.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_PerfilUser newInstance(String param1, String param2) {
        activity_PerfilUser fragment = new activity_PerfilUser();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mButtonCloseSession = (ImageButton) getView().findViewById(R.id.btnCloseSession);
        mButtonCloseSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "cerrar sesion", Toast.LENGTH_SHORT).show();
                Log.d("cerrar sesion", "cerrar sesion");
                mPref.edit().clear().apply();
            }
        });
        mPref = this.getActivity().getSharedPreferences("Preferences", MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity__perfil_user, container, false);
    }


}