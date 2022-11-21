package com.example.personalplanner.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.personalplanner.R;
import com.example.personalplanner.adapter.FoodAdapter;
import com.example.personalplanner.data.model.Food;
import com.example.personalplanner.data.repository.FoodRepository;
import com.example.personalplanner.databinding.FragmentFoodBinding;
import com.example.personalplanner.view_model.FoodViewModel;

public class FoodFragment extends Fragment implements FoodAdapter.OnManageFoodListener{

    private FragmentFoodBinding binding;
    private FoodAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFoodBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerDependency();

        binding.fabAddFood.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_FoodFragment_to_createFoodFragment);
        });
    }

    // Inicializar el recyclerView
    private void initRecyclerDependency() {
        adapter = new FoodAdapter(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        binding.rvFood.setLayoutManager(layoutManager);

        binding.rvFood.setAdapter(adapter);

    }

    @Override
    public void onEditFood(Food food) {
    }

    @Override
    public void onDeleteFood(Food food) {
    }
}