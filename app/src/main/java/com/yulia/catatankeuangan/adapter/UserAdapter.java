package com.yulia.catatankeuangan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yulia.catatankeuangan.R;
import com.yulia.catatankeuangan.database.entitas.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewAdapter> {
    private List<User> list;
    private Context context;

    public UserAdapter(Context context, List<User> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.pengeluaran.setText(list.get(position).pengeluaran);
        holder.tanggal.setText(list.get(position).tanggal);
        holder.total.setText(list.get(position).total);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView pengeluaran, tanggal, total;

        private ViewAdapter(@NonNull View itemView) {
            super(itemView);
            pengeluaran = itemView.findViewById(R.id.pengeluaran);
            tanggal = itemView.findViewById(R.id.tanggal);
            total = itemView.findViewById(R.id.total);
        }
    }
}
