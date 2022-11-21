package com.example.personalplanner.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.personalplanner.R;
import com.example.personalplanner.data.model.Food;
import com.example.personalplanner.data.repository.FoodRepository;
import com.example.personalplanner.data.repository.PeopleRepository;
import com.example.personalplanner.databinding.FragmentCreateFoodBinding;
import com.example.personalplanner.databinding.FragmentCreatePeopleBinding;
import com.example.personalplanner.view_model.FoodResult;
import com.example.personalplanner.view_model.FoodViewModel;
import com.example.personalplanner.view_model.UserResult;
import com.example.personalplanner.view_model.UserViewModel;


public class CreateFoodFragment extends Fragment {

    FragmentCreateFoodBinding binding;
    //FoodRepository repository;
    private FoodViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateFoodBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*binding.setFood(new Food());
        repository = FoodRepository.getInstance();*/

        viewModel = new ViewModelProvider(this).get(FoodViewModel.class);

        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        viewModel.getResult().observe(getViewLifecycleOwner(), new Observer<FoodResult>() {
            @Override
            public void onChanged(FoodResult foodResult) {
                switch (foodResult) {
                    case NAMEEMPTY:
                        setNameErrorEmpty();
                        break;
                    case DESCRIPTIONEMPTY:
                        setDescriptionErrorEmpty();
                        break;
                }
                Toast.makeText(getContext(), "Error "+ foodResult, Toast.LENGTH_SHORT).show();
            }
        });

        binding.tilCreateFoodName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.tilCreateFoodName.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });

        binding.tilCreateFoodDescription.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.tilCreateFoodDescription.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });

        /*binding.btnCreateFood.setOnClickListener(view1 -> {
            if (!TextUtils.isEmpty(binding.tilCreateFoodName.getEditText().getText()) && !TextUtils.isEmpty(binding.tilCreateFoodDescription.getEditText().getText()))
                repository.AddFood(binding.tilCreateFoodName.getEditText().getText().toString(), binding.tilCreateFoodDescription.getEditText().getText().toString());
            NavHostFragment.findNavController(this).popBackStack();
        });*/
    }

    private void setNameErrorEmpty() {
        binding.tilCreateFoodName.setError(getString(R.string.errorNameEmpty));
        binding.tilCreateFoodName.requestFocus();
    }

    private void setDescriptionErrorEmpty() {
        binding.tilCreateFoodDescription.setError(getString(R.string.errorDescriptionEmpty));
        binding.tilCreateFoodDescription.requestFocus();
    }


}