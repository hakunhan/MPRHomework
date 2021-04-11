package com.example.myfriend.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfriend.R;
import com.example.myfriend.model.Friend;

import java.util.List;

public class FriendAdapter  extends RecyclerView.Adapter<FriendAdapter.FriendHolder> {
    private List<Friend> friends;

    public FriendAdapter(List<Friend> friends){
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_friend, parent, false);

        return new FriendHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder holder, int position) {
        Friend friend = friends.get(position);

        holder.bind(friend);
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public class FriendHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private ImageButton btnMail, btnSms, btnCall;

        public FriendHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            btnMail = itemView.findViewById(R.id.btnMail);
            btnSms = itemView.findViewById(R.id.btnSms);
            btnCall = itemView.findViewById(R.id.btnCall);
        }

        public void bind(Friend friend){
            tvName.setText(friend.getName());


        }
    }
}
