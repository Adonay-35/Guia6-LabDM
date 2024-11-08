package UI.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guia6.R;

import java.util.List;

import Models.Presupuesto;
import UI.viewHolders.ChildViewHolder;

public class ChildRecyclerAdapter  extends RecyclerView.Adapter<ChildViewHolder>{

    List<Presupuesto> items;
    private final OnItemChildClickListener onItemChildClickListener;

    public ChildRecyclerAdapter(List<Presupuesto> items, OnItemChildClickListener onItemChildClickListener) {
        this.items = items;
        this.onItemChildClickListener = onItemChildClickListener;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ChildViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        holder.txvItemRow.setText(items.get(position).getNombre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemChildClickListener != null){
                    Presupuesto mainObject = items.get(holder.getAdapterPosition());
                    onItemChildClickListener.onItemChildClick(mainObject);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemChildClickListener{
        void onItemChildClick(Presupuesto mainObject);
    }
}

