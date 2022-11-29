package com.bmt.lab3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bmt.lab3.R;
import com.bmt.lab3.dto.Vitamin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SubRecyclerAdapter<T> extends RecyclerView.Adapter<SubRecyclerAdapter.SubViewHolder> {
    public interface IClicked<T>{
        void isClicked(T data);
    }
    private IClicked<T> clicked;
    private List<T> datas;
    public void setData(List<T> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }
    public SubRecyclerAdapter(IClicked<T> clicked){
        this.clicked = clicked;
    }
    @NonNull
    @NotNull
    @Override
    public SubRecyclerAdapter.SubViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_category_item, parent, false);
        return new SubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SubRecyclerAdapter.SubViewHolder holder, int position) {
        SubViewHolder viewHolder = (SubViewHolder) holder;
        if(datas.get(position) instanceof Vitamin){
            Vitamin vitamin = (Vitamin) datas.get(position);
            viewHolder.getTitle().setText(vitamin.getTitle()+"");
            viewHolder.getCreateTime().setText(vitamin.getPubDate()+"");
        }
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }
    public class SubViewHolder extends RecyclerView.ViewHolder{
        private ImageView represent;
        private TextView title;
        private TextView createTime;
        private ConstraintLayout wrapper;
        public SubViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            represent = itemView.findViewById(R.id.represent);
            title = itemView.findViewById(R.id.title);
            createTime = itemView.findViewById(R.id.createTime);
            wrapper = itemView.findViewById(R.id.wrapper);
        }

        public ImageView getRepresent() {
            return represent;
        }

        public void setRepresent(ImageView represent) {
            this.represent = represent;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getCreateTime() {
            return createTime;
        }

        public void setCreateTime(TextView createTime) {
            this.createTime = createTime;
        }

        public ConstraintLayout getWrapper() {
            return wrapper;
        }

        public void setWrapper(ConstraintLayout wrapper) {
            this.wrapper = wrapper;
        }
    }
}
