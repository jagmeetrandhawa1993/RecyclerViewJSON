package com.example.recyclerviewjson.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewjson.Model.Student;
import com.example.recyclerviewjson.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private static final int MENU_ITEM_VIEW_TYPE = 0;
    private final Context mContext;




    // The list of Native Express ads and menu items.
    private final List<Object> mRecyclerViewItems;

    public StudentAdapter(Context mContext, List<Object> mRecyclerViewItems) {
        this.mContext = mContext;
        this.mRecyclerViewItems = mRecyclerViewItems;
    }



    public class StudentHolder extends RecyclerView.ViewHolder {


        TextView sid;
        TextView sname;
        TextView gender;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            sid = (TextView) itemView.findViewById(R.id.textViewId);
            sname = (TextView) itemView.findViewById(R.id.textViewName);
            gender = (TextView) itemView.findViewById(R.id.textViewGender);

        }

    }

    @NonNull
    @Override
    public StudentAdapter.StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            case MENU_ITEM_VIEW_TYPE:

            default:
                View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.menu_item_container, viewGroup, false);

                return new StudentHolder(menuItemLayoutView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentHolder holder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType) {
            case MENU_ITEM_VIEW_TYPE:
            default:
                StudentHolder menuItemHolder = (StudentHolder) holder;
                Student menuItem = (Student) mRecyclerViewItems.get(position);



                menuItemHolder.sid.setText(menuItem.getSid());
                menuItemHolder.sname.setText(menuItem.getSname());
                menuItemHolder.gender.setText(menuItem.getGender());

        }
    }

    @Override
    public int getItemCount() {
        return mRecyclerViewItems.size();
    }
}
