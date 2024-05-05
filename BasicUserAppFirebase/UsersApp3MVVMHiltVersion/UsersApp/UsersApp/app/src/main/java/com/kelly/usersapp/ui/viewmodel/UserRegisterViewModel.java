package com.kelly.usersapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.kelly.usersapp.data.repo.UsersDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserRegisterViewModel extends ViewModel {
    public UsersDaoRepository usersDaoRepository;
    @Inject
    public UserRegisterViewModel(UsersDaoRepository usersDaoRepository) {
        this.usersDaoRepository = usersDaoRepository;
    }
    public void register(String user_name, String user_phone){
        usersDaoRepository.register(user_name,user_phone);
    }
}

