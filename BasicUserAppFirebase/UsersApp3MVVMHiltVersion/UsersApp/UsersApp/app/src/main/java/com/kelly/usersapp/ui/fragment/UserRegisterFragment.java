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
import com.kelly.usersapp.databinding.FragmentUserRegisterBinding;
import com.kelly.usersapp.ui.viewmodel.MainPageViewModel;
import com.kelly.usersapp.ui.viewmodel.UserRegisterViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserRegisterFragment extends Fragment {
    private FragmentUserRegisterBinding binding;
    private UserRegisterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentUserRegisterBinding.inflate(inflater, container, false);

        binding.toolbarUserRegister.setTitle("User Register");

        binding.buttonRegister.setOnClickListener(view -> {
            String user_name = binding.editTextUserName.getText().toString();
            String user_phone = binding.editTextUserPhone.getText().toString();

            viewModel.register(user_name, user_phone);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(UserRegisterViewModel.class);
    }
}