package com.sargent.mark.todolist;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sargent.mark.todolist.data.Contract;
import com.sargent.mark.todolist.data.ToDoItem;

import java.util.ArrayList;

/**
 * Created by mark on 7/4/17.
 */

public class  ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ItemHolder> {

    private Cursor cursor;
    private ItemClickListener listener;
    private String TAG = "todolistadapter";

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item, parent, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
//add checkbox listenner interface
    public interface ItemClickListener {
        void onItemClick(int pos, String description, String duedate,int done, String category,long id);
        void checkBoxClicked(String description, String dueDate,int done,String category, long id);
    }

    public ToDoListAdapter(Cursor cursor, ItemClickListener listener) {
        this.cursor = cursor;
        this.listener = listener;
    }

    public void swapCursor(Cursor newCursor){
        if (cursor != null) cursor.close();
        cursor = newCursor;
        if (newCursor != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView descr;
        TextView due;
        String duedate;
        TextView categoryT;
        String description;
        CheckBox checkBox;
        int done = 0;
        String category;
        long id;


        ItemHolder(View view) {
            super(view);
            descr = (TextView) view.findViewById(R.id.description);
            due = (TextView) view.findViewById(R.id.dueDate);
            checkBox=(CheckBox) view.findViewById(R.id.checkbox);
            categoryT = (TextView) view.findViewById(R.id.category1);
            //make it buautiful
            categoryT.setTextColor(0xff0000ff);
            due.setTextColor(0xffff0000);
            descr.setTextColor(0xff000000);


            view.setOnClickListener(this);
        }

        public void bind(ItemHolder holder, int pos) {
            cursor.moveToPosition(pos);
            id = cursor.getLong(cursor.getColumnIndex(Contract.TABLE_TODO._ID));
            Log.d(TAG, "deleting id: " + id);

            duedate = cursor.getString(cursor.getColumnIndex(Contract.TABLE_TODO.COLUMN_NAME_DUE_DATE));
            description = cursor.getString(cursor.getColumnIndex(Contract.TABLE_TODO.COLUMN_NAME_DESCRIPTION));
            done = cursor.getInt(cursor.getColumnIndex(Contract.TABLE_TODO.COLUMN_NAME_DONE));
            category = cursor.getString(cursor.getColumnIndex(Contract.TABLE_TODO.COLUMN_NAME_CATEGORY));

//implement checkbox listenner when check mark done =1,no check mark done=0

            checkBox.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //set done to 1 or 0 if its checked or not and pass into the item listener
                    if(checkBox.isChecked()){
                        done = 1 ;
                    } else {
                        done = 0;
                    }
                    listener.checkBoxClicked(description,duedate,done,category,id);
                }
            });
            descr.setText(description);
            due.setText(duedate);
            categoryT.setText(category);
            holder.itemView.setTag(id);
            if(done==1){
                checkBox.setChecked(true);
            }
            else{
                checkBox.setChecked(false);
            }
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            listener.onItemClick(pos, description, duedate,done,category, id);
        }

    }

}
