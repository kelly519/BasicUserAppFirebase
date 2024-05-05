package com.kelly.usersapp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.kelly.usersapp.data.entitiy.Users;
import com.kelly.usersapp.databinding.CardDesignBinding;
import com.kelly.usersapp.ui.fragment.MainPageFragmentDirections;
import com.kelly.usersapp.ui.viewmodel.MainPageViewModel;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CardDesignHolder> {
    private Context mContext;
    private List<Users> usersList;
    private MainPageViewModel viewModel;

    public UsersAdapter(Context mContext, List<Users> usersList, MainPageViewModel viewModel) {
        this.mContext = mContext;
        this.usersList = usersList;
        this.viewModel = viewModel;
    }
    public class CardDesignHolder extends RecyclerView.ViewHolder {
        private CardDesignBinding designBinding;
        public CardDesignHolder(CardDesignBinding designBinding) {
            super(designBinding.getRoot());
            this.designBinding = designBinding;
        }
    }
    @NonNull
    @Override
    public CardDesignHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardDesignBinding binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardDesignHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull CardDesignHolder holder, int position) {
        Users user = usersList.get(position);
        CardDesignBinding t = holder.designBinding;

        t.textViewUserName.setText(user.getUser_name());
        t.textViewUserPhone.setText(user.getUser_phone());

        t.cardViewLine.setOnClickListener(view -> {
            MainPageFragmentDirections.ToUserDetail to = MainPageFragmentDirections.toUserDetail(user);
            Navigation.findNavController(view).navigate(to);

        });

        t.imageViewClear.setOnClickListener(view -> {
            Snackbar.make(view, user.getUser_name() + "Are you sure for delete it?",Snackbar.LENGTH_SHORT)
                    .setAction("Yes",view1 ->{
                viewModel.delete(user.getUser_id());
            }).show();
        });
    }
    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
