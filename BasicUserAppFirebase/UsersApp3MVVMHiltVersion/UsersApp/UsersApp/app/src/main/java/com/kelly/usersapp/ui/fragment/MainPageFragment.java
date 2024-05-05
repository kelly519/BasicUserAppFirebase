package com.kelly.usersapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.kelly.usersapp.R;
import com.kelly.usersapp.data.entitiy.Users;
import com.kelly.usersapp.databinding.FragmentMainPageBinding;
import com.kelly.usersapp.ui.adapter.UsersAdapter;
import com.kelly.usersapp.ui.viewmodel.MainPageViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainPageFragment extends Fragment {
    private FragmentMainPageBinding binding;
    private MainPageViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);

        binding.toolbarMainPage.setTitle("Users");

        binding.rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.usersList.observe(getViewLifecycleOwner(),usersList -> {
            UsersAdapter usersAdapter = new UsersAdapter(requireContext(),usersList,viewModel);
            binding.rv.setAdapter(usersAdapter);
        });

        binding.fab.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.toUserRegister);
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                viewModel.seacrh(s);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                viewModel.seacrh(s);
                return true;
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainPageViewModel.class);
    }
}