package com.example.demoandroidbooknote;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// alt + enter
public class AdapterNote extends RecyclerView.Adapter<AdapterNote.ViewHolder> {
// cố định
    Context context;
    int resource;
    ArrayList<Note> nodeArrayList;
    public AdapterNote(Context context,int resource, ArrayList<Note> nodeArrayList){
        this.context=context;
        this.resource=resource;
        this.nodeArrayList=nodeArrayList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttieude1,txtNoiDung,txtngay1;
        LinearLayout layoutNode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttieude1=itemView.findViewById(R.id.txtTieuDe1);
            txtNoiDung=itemView.findViewById(R.id.txtnoidung1);
            txtngay1=itemView.findViewById(R.id.txtngay1);
            layoutNode=itemView.findViewById(R.id.layoutNode);
        }
    }
    @NonNull
    @Override
    //cos định
    public AdapterNote.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterNote.ViewHolder holder, int position) {
        // thong qua thằng ni lấy dữ liệu từ Array list
        final Note notes=nodeArrayList.get(position);
        holder.txttieude1.setText(notes.getTieude());
        holder.txtngay1.setText(notes.getNgay());
        holder.txtNoiDung.setText(notes.getNoidung());
        holder.layoutNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tham số 1: màn hình hiện tại
                // tham số 2: man hinh muốn chuyển tới
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("tieude", holder.txttieude1.getText());
                intent.putExtra("noidung", holder.txtNoiDung.getText());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return nodeArrayList.size();
    }


}
