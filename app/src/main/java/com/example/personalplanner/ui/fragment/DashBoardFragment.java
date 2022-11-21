package com.example.personalplanner.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.personalplanner.R;
import com.example.personalplanner.adapter.PeopleAdapter;
import com.example.personalplanner.data.model.People;
import com.example.personalplanner.databinding.FragmentDashBoardBinding;

public class DashBoardFragment extends Fragment {

    private FragmentDashBoardBinding binding;
    private ArrayAdapter<People> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new PeopleAdapter(getActivity(), R.layout.item_people);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerPeopleList.setAdapter(adapter);
        binding.spinnerPeopleList.setSelection(0, false);
        binding.spinnerPeopleList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                People item = (People) adapterView.getSelectedItem();
                Toast.makeText(getActivity(), getString(R.string.ToastChosenPeople) +" "+item.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btnEditPeople.setOnClickListener( view1 -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_EditPeopleFragment);
        });
        binding.btnAddPeople.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_createUserFragment));

        // Navegación a las distintas opciones del menú
        binding.cardViewToDoList.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_ToDoListFragment));
        binding.cardViewCalendar.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_CalendarFragment));
        binding.cardViewWhislist.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_WhislistFragment));
        binding.cardViewShoppingList.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_ShoppingListFragment));
        binding.cardViewBills.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_BillsFragment));
        binding.cardViewFood.setOnClickListener(view1 -> NavHostFragment.findNavController(this).navigate(R.id.action_DashBoardFragment_to_FoodFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}