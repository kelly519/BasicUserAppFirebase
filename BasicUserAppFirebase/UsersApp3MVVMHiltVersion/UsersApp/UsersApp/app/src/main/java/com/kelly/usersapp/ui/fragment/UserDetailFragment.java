package com.kelly.usersapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelly.usersapp.R;
import com.kelly.usersapp.data.entitiy.Users;
import com.kelly.usersapp.databinding.FragmentUserDetailBinding;
import com.kelly.usersapp.ui.viewmodel.MainPageViewModel;
import com.kelly.usersapp.ui.viewmodel.UserDetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserDetailFragment extends Fragment {
    private FragmentUserDetailBinding binding;
    private UserDetailViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false);

        binding.toolbarUserDetail.setTitle("User's Detail");

        UserDetailFragmentArgs bundle = UserDetailFragmentArgs.fromBundle(getArguments());
        Users comingUser = bundle.getUser();

        binding.editTextUserName.setText(comingUser.getUser_name()); 
        binding.editTextUserPhone.setText(comingUser.getUser_phone());

        binding.buttonUpdate.setOnClickListener(view -> {
            String user_name = binding.editTextUserName.getText().toString();
            String user_phone = binding.editTextUserPhone.getText().toString();

            viewModel.update(comingUser.getUser_id(),user_name,user_phone);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(UserDetailViewModel.class);
    }
}