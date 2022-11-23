package org.techtown.howhair;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HairViewAdapter extends RecyclerView.Adapter<HairViewAdapter.ViewHolder>{

    ArrayList<HairView> items = new ArrayList<HairView>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HairView item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{//뷰홀더리스트를 이용하기 위해 상속

        EditText decription;
        ImageView image;

        public ViewHolder(View itemView){
            super(itemView);

            image = itemView.findViewById(R.id.image_added);
            decription = itemView.findViewById(R.id.description);
        }

        public void setItem(HairView item){
            image.setImageBitmap(item.getImage());
            decription.setText(item.getText());
        }


    }
    public void addItem(HairView item){
        items.add(item);
    }
    public void setItems(ArrayList<HairView> items){
        this.items = items;
    }

    public HairView getItem(int position){
        return items.get(position);

    }
    public void  setItem(int position, HairView hairView){
        items.set(position, hairView);
    }

}
