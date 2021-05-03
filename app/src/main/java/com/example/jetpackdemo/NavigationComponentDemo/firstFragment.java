package com.example.jetpackdemo.NavigationComponentDemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jetpackdemo.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class firstFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);;


        Button nextBtn =  view.findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstFragmentDirections.ActionFirstFragmentToSecondFragment firstFragmentToSecondFragment =
                        firstFragmentDirections.actionFirstFragmentToSecondFragment();
                firstFragmentToSecondFragment.setMessage("Messgae from first frgament RECEIVED");

                Navigation.findNavController(view).navigate(firstFragmentToSecondFragment);
                //Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments()!=null){
            firstFragmentArgs args = firstFragmentArgs.fromBundle(getArguments());
            Log.e("**Msg from second frag", "onViewCreated: "+args.getMessage() );
        }
    }
}