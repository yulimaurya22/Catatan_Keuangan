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
    private Dialog dialog;

    public interface Dialog {
        void onClick(int position);
    }
    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

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
        holder.tanggal.setText(list.get(position).tanggal);
        holder.pengeluaran.setText(list.get(position).pengeluaran);
        holder.total.setText(list.get(position).total);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView tanggal, pengeluaran,total;

        private ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.tgl);
            pengeluaran = itemView.findViewById(R.id.pengeluarn);
            total = itemView.findViewById(R.id.ttl);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
