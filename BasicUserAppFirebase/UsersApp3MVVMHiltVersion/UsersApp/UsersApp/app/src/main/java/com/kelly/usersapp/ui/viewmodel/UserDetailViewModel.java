package com.kelly.usersapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.kelly.usersapp.data.repo.UsersDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserDetailViewModel extends ViewModel {
    public UsersDaoRepository usersDaoRepository;
    @Inject
    public UserDetailViewModel(UsersDaoRepository usersDaoRepository) {
        this.usersDaoRepository = usersDaoRepository;
    }

    public void update (String user_id, String user_name, String user_phone){
        usersDaoRepository.update(user_id,user_name,user_phone);
    }
}
