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

public class secondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);;

        Button nextBtn =  view.findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondFragmentDirections.ActionSecondFragmentToFirstFragment secondFragmentToFirstFragment =
                        secondFragmentDirections.actionSecondFragmentToFirstFragment();

                secondFragmentToFirstFragment.setMessage("Message from Second fragment RECEIVED");

                Navigation.findNavController(view).navigate(secondFragmentToFirstFragment);
                //Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments()!=null){
            secondFragmentArgs args = secondFragmentArgs.fromBundle(getArguments());
            Log.e("**Msg from first frag", "onViewCreated: "+args.getMessage() );
        }

    }
}