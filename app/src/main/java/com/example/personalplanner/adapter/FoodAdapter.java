package com.example.personalplanner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalplanner.R;
import com.example.personalplanner.data.repository.FoodRepository;
import com.example.personalplanner.data.model.Food;
import com.example.personalplanner.databinding.FragmentFoodBinding;
import com.example.personalplanner.databinding.ItemFoodBinding;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private ArrayList<Food> list;
    private FragmentFoodBinding binding;
    private OnManageFoodListener listener;

    /**
     * Se declara una interfaz o contrato entre el Adapter-UI Controller
     */
    public interface OnManageFoodListener{
        // 1. Si se hace click se editará la dependencia (onClickListener)
        void onEditFood(Food food);


        // 2. Si se hace longClick entendemos que se quiere eliminar la dependencia (onLongClickListener)
        void onDeleteFood(Food food);
    }

    public FoodAdapter(OnManageFoodListener listener) {
        this.list = FoodRepository.getInstance().getList();
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // SOLUCION1: Tengo que conseguir el layoutInflater, e inflar la vista del XML item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);


        // SOLUCION1 :
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        // SOLUCION 1:
        holder.tvName.setText(list.get(position).getName());
        holder.imgIcon.setImageResource(list.get(position).getImageName());
        holder.bind(listener, list.get(position));

    }

    /**
     * Cuidado que este método no puede devoler el valor por defecto 0. Nunca llamaría a onCreateViewHolder () ni
     * onBindViewHolder()
     * */
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircularImageView imgIcon;
        TextView tvName;
        ItemFoodBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // SOLUCION1: Tengo que utilizar el findById
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvName = itemView.findViewById(R.id.tvName);




        }

        // Solución 1 y 2: en este método se inicializa el listener y su dependencia a cada elemento itemView
        public void bind(OnManageFoodListener listener, Food food){
            itemView.setOnClickListener(view -> list.remove(getAdapterPosition()));
            itemView.setOnLongClickListener(view -> {
                listener.onDeleteFood(food);
                return true;
            });
        }
    }
}
