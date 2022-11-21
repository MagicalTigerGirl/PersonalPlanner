package com.example.personalplanner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.personalplanner.R;
import com.example.personalplanner.data.repository.PeopleRepository;
import com.example.personalplanner.data.model.People;
import com.example.personalplanner.databinding.FragmentDashBoardBinding;

public class PeopleAdapter extends ArrayAdapter<People> {

    private FragmentDashBoardBinding binding;
    private PeopleRepository repository;

    public PeopleAdapter(@NonNull Context context, int resource) {
        super(context, resource, PeopleRepository.getInstance().getList());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tVName = view.findViewById(R.id.tvName);
            viewHolder.tvSurname = view.findViewById(R.id.tvSurname);
            viewHolder.tvRol = view.findViewById(R.id.tvRol);
            viewHolder.imgImage = view.findViewById(R.id.imgImage);

            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) view.getTag();

        viewHolder.tVName.setText(getItem(position).getName());
        viewHolder.tvSurname.setText(getItem(position).getSurname());
        viewHolder.tvRol.setText(getItem(position).getRol());
        viewHolder.imgImage.setImageResource(getItem(position).getImage());

        return view;
    }

    private static class ViewHolder {
        private TextView tVName;
        private TextView tvSurname;
        private TextView tvRol;
        private ImageView imgImage;
    }
}
