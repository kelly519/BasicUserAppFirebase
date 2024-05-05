package com.kelly.usersapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kelly.usersapp.data.entitiy.Users;
import com.kelly.usersapp.data.repo.UsersDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainPageViewModel extends ViewModel {
    public UsersDaoRepository usersDaoRepository;
    public MutableLiveData<List<Users>> usersList = new MutableLiveData<>();
    @Inject
    public MainPageViewModel(UsersDaoRepository usersDaoRepository){
        this.usersDaoRepository = usersDaoRepository;
        uploadUsers();
        usersList = usersDaoRepository.usersList;
    }
    public void seacrh(String searchingWord){
        usersDaoRepository.seacrh(searchingWord);
    }
    public void delete (String user_id){
        usersDaoRepository.delete(user_id);
    }
    public void uploadUsers(){
        usersDaoRepository.uploadUsers();
    }
}
