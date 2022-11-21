package com.example.personalplanner.ui.fragment;

import android.graphics.drawable.Animatable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.personalplanner.R;
import com.example.personalplanner.databinding.FragmentSignUpBinding;
import com.example.personalplanner.view_model.UserResult;
import com.example.personalplanner.view_model.UserViewModel;

public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;
    private UserViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        viewModel.getResult().observe(getViewLifecycleOwner(), new Observer<UserResult>() {
            @Override
            public void onChanged(UserResult userResult) {
                switch (userResult) {
                    case NAMEEMPTY:
                        setNameErrorEmpty();
                        break;
                    case EMAILEMPTY:
                        setEmailErrorEmpty();
                        break;
                    case EMAILFORMAT:
                        setEmailErrorFormat();
                        break;
                    case PASSWORDEMPTY:
                        setPasswordErrorEmpty();
                        break;
                    case PASSWORDFORMAT:
                        setPasswordErrorFormat();
                        break;
                    case CONFIRMPASSWORDEMPTY:
                        setConfirmPasswordErrorEmpty();
                        break;
                    case CONFIRMPASSWORDNOTEQUALS:
                        setConfirmPasswordErrorNotEquals();
                        break;
                }
                Toast.makeText(getContext(), "Error "+ userResult, Toast.LENGTH_SHORT).show();
            }
        });

        //binding.imgbtnCreateUser.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigateUp());
    }

    private void setNameErrorEmpty() {
        binding.tilSignUpUserName.setError(getString(R.string.errorNameEmpty));
        binding.tilSignUpUserName.requestFocus();
    }

    private void setEmailErrorEmpty() {
        binding.tilSignUpEmail.setError(getString(R.string.errorEmailEmpty));
        binding.tilSignUpEmail.requestFocus();
    }

    private void setEmailErrorFormat() {
        binding.tilSignUpEmail.setError(getString(R.string.errorEmailFormat));
        binding.tilSignUpEmail.requestFocus();
    }

    private void setPasswordErrorEmpty() {
        binding.tilSignUpPassword.setError(getString(R.string.errorPasswordEmpty));
        binding.tilSignUpPassword.requestFocus();
    }

    private void setPasswordErrorFormat() {
        binding.tilSignUpPassword.setError(getString(R.string.errorPassworFormat));
        binding.tilSignUpPassword.requestFocus();
    }

    private void setConfirmPasswordErrorEmpty() {
        binding.tilSignUpConfirmPassword.setError(getString(R.string.errorConfirmPasswordEmpty));
        binding.tilSignUpConfirmPassword.requestFocus();
    }

    private void setConfirmPasswordErrorNotEquals() {
        binding.tilSignUpConfirmPassword.setError(getString(R.string.errorConfirmPasswordNotEquals));
        binding.tilSignUpConfirmPassword.requestFocus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}