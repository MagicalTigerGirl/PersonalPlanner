package com.example.personalplanner.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.personalplanner.data.model.People;
import com.example.personalplanner.data.repository.PeopleRepository;
import com.example.personalplanner.databinding.FragmentCreatePeopleBinding;

public class CreatePeopleFragment extends Fragment {

    FragmentCreatePeopleBinding binding;
    PeopleRepository repository;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreatePeopleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setPeople(new People());
        repository = PeopleRepository.getInstance();

        binding.btnCreatePeople.setOnClickListener(view1 -> {
            if (!TextUtils.isEmpty(binding.tilCreatePeopleName.getEditText().getText()) && !TextUtils.isEmpty(binding.tilCreatePeopleSurname.getEditText().getText()))
                repository.AddPeople(binding.tilCreatePeopleName.getEditText().getText().toString(), binding.tilCreatePeopleSurname.getEditText().getText().toString(), binding.tilCreatePeopleRol.getEditText().getText().toString());
            NavHostFragment.findNavController(this).popBackStack();
        });
    }
}