package com.bmt.lab3.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bmt.lab3.R;
import com.bmt.lab3.dto.Category;
import com.bmt.lab3.dto.OnSale;
import com.bmt.lab3.dto.TopBar;
import com.bmt.lab3.dto.TopPick;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

public class RecyclerAdapter<T extends TopBar & Serializable>  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public interface IClicked<T>{
        void isClicked(T data);
    }
    private List<T> datas;
    private IClicked<T> clicked;
    public void setData(List<T> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }
    public RecyclerAdapter(IClicked<T> clicked){
        this.clicked = clicked;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        String name = "";
        if(datas.get(position) instanceof Category){
            Category category = (Category) datas.get(position);
            name = category.getName();
            viewHolder.getTxt().setOnClickListener(view -> clicked.isClicked((T) category));
        }else if(datas.get(position) instanceof TopPick){
            TopPick topPick = (TopPick) datas.get(position);
            name = topPick.getName();
            viewHolder.getTxt().setOnClickListener(view -> clicked.isClicked((T) topPick));
        }else if(datas.get(position) instanceof OnSale){
            OnSale onSale = (OnSale) datas.get(position);
            name = onSale.getName();
            viewHolder.getTxt().setOnClickListener(view -> clicked.isClicked((T) onSale));
        }
        viewHolder.getTxt().setText(name);
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txt;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
        }

        public TextView getTxt() {
            return txt;
        }

        public void setTxt(TextView txt) {
            this.txt = txt;
        }
    }
}
