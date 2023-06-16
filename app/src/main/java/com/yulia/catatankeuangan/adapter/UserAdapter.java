package com.yulia.catatankeuangan.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yulia.catatankeuangan.R;

public class UserAdapter {

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView pengeluarn, tgl, ttl;

        private ViewAdapter(@NonNull View itemView) {
            super(itemView);
            pengeluarn = itemView.findViewById(R.id.pengeluarn);
            tgl = itemView.findViewById(R.id.tgl);
            ttl = itemView.findViewById(R.id.ttl);
        }
    }
}
