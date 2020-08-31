package com.abhi.imagesearch.ui.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.abhi.imagesearch.ui.Model.ImageModel;
import com.abhi.imagesearch.ui.R;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> implements Filterable {

    //    private ArrayList<ModelQRSlider> sliderItem;
    static private Context mContext;
    private ArrayList<ImageModel> sliderItem;
    private ArrayList<ImageModel> sliderItemFull;
    private ViewPager2 viewPager2;

    //creating member variable of interface
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
//        void onSaveClick(int position);
        void onSaveIVClick(int position, ImageView imageView);
        void onShareIVClick(int position, ImageView imageView);
//        void onShareClick(int position);
//        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener; //here mListener is main Activity and we pass clicks to the main activity via this
    }

    public SliderAdapter(Context context,ArrayList<ImageModel> sliderItem, ViewPager2 viewPager2) {
        mContext = context;
        this.sliderItem = sliderItem;
        this.viewPager2 = viewPager2;
        sliderItemFull = new ArrayList<>(sliderItem);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private ImageButton btnSave;
        private ImageButton btnShare;
        private TextView imageTitle;
        private CardView cardView;


        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
            btnSave = itemView.findViewById(R.id.save);
            btnShare = itemView.findViewById(R.id.share);
            imageTitle = itemView.findViewById(R.id.imageTitle);
            cardView = itemView.findViewById(R.id.card_main);

//            btnSave.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(listener != null){
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION){
//                            listener.onSaveClick(position);
//
//                        }
//                    }
//                }
//            });

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onSaveIVClick(position, imageView);

                        }
                    }
                }
            });

            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onShareIVClick(position, imageView);

                        }
                    }
                }
            });

        }

        void setImageView(String cardCh){
            int resID = mContext.getResources().getIdentifier(cardCh , "drawable", mContext.getPackageName());
            if(resID != 0){
                imageView.setImageResource(resID);
            }
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_pager_slider,
                parent,
                false
        );

        ViewHolder viewHolder = new ViewHolder(view,mListener); //passing mListener to use it in onBindViewHolder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        ImageModel items = sliderItem.get(position);
        //holder.setImage(items);
//        holder.imageView.setImageResource(items.getImageResourse());
        holder.setImageView(items.getImageResourse());
       // holder.imageTitle.setText(items.getTitle());
//
        String[] chArray = items.getTitle().split("\\s+");
        StringBuffer sb = new StringBuffer();

        for(int i = 1; i<chArray.length; i++) {
            sb.append(chArray[i]);
            sb.append(" ");
        }

        holder.imageTitle.setText(sb.toString());
        //holder.cardView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

    }

    @Override
    public int getItemCount() {
        return sliderItem.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<ImageModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                /*******************************
                 filteredList.addAll(imageList);
                 ******************************/
                filteredList.addAll(sliderItemFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ImageModel item : sliderItemFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
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
            sliderItem.clear();
            sliderItem.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };



}


