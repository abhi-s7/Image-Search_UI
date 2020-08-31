package com.abhi.imagesearch.ui.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi.imagesearch.ui.Constants.BrandData;
import com.abhi.imagesearch.ui.R;

import java.util.ArrayList;
import java.util.List;

public class BrandNamesAdapter extends RecyclerView.Adapter<BrandNamesAdapter.ViewHolder> implements Filterable {

    static private Context mContext;


    private List<String> exampleList;
    private List<String> exampleListFull;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
//        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener; //here mListener is main Activity and we pass clicks to the main activity via this
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.brand_recycler_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public BrandNamesAdapter(Context context,List<String> exampleList){
        mContext = context;
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_items,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String current = "#" + exampleList.get(position);
        holder.textView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));

        if(BrandData.brandSet.contains(exampleList.get(position)))
            holder.textView.setTextColor(Color.parseColor("#eca0b6"));
        else
            holder.textView.setTextColor(Color.parseColor("#757575"));

        holder.textView.setText(current);

    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (String item : exampleListFull) {
                    if (item.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //Log.d("After", "publishResults: " + exampleList);
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

}
