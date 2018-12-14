package com.a247software.javatraining;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TopicViewHolder> {
    private static final String TAG = ListAdapter.class.getSimpleName();

    final private ListItemClickListner mOnClickListner;
    private ArrayList<String> mTopicNames;


    public ListAdapter(ListItemClickListner mOnClickListner, ArrayList<String> mTopicNames) {
        this.mOnClickListner = mOnClickListner;
        this.mTopicNames = mTopicNames;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder topicViewHolder, int i) {
        topicViewHolder.listItemNumber.setText(i);
        topicViewHolder.listItemTopicName.setText(mTopicNames.get(i));
        Log.i(TAG, i + "\t" + "Topic : " + mTopicNames.get(i));
    }

    @Override
    public int getItemCount() {
        return mTopicNames.size();
    }


    public interface ListItemClickListner {
        void onListItemClick(int clickedIndex);
    }

    class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView listItemTopicName;
        TextView listItemNumber;

        TopicViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemTopicName = itemView.findViewById(R.id.tv_topic_name);
            listItemNumber = itemView.findViewById(R.id.tv_item_number);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            int clickedPosition = getAdapterPosition();
            mOnClickListner.onListItemClick(clickedPosition);
        }
    }


    // END
}
