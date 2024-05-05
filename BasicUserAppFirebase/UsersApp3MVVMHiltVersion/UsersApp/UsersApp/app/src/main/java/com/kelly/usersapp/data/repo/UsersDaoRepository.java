package com.kelly.usersapp.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.kelly.usersapp.data.entitiy.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsersDaoRepository {
    public MutableLiveData<List<Users>> usersList = new MutableLiveData<>();
    private CollectionReference collectionUsers;

    public UsersDaoRepository(CollectionReference collectionUsers){
        this.collectionUsers = collectionUsers;
    }
    public void register(String user_name,String user_phone){
        Users newUser = new Users("",user_name,user_phone);
        collectionUsers.document().set(newUser);
    }

    public void update (String user_id, String user_name, String user_phone){
        HashMap<String,Object> updatedPerson = new HashMap<>();
        updatedPerson.put("user_name",user_name);
        updatedPerson.put("user_phone",user_phone);
        collectionUsers.document(user_id).update(updatedPerson);

    }
    public void seacrh(String searchingWord){
        collectionUsers.addSnapshotListener(((value, error) -> {
            ArrayList<Users> list = new ArrayList<>();

            for (DocumentSnapshot documentSnapshot : value.getDocuments()){
                Users user = documentSnapshot.toObject(Users.class);

                if (user != null){
                    user.setUser_id(documentSnapshot.getId());
                    if (user.getUser_name().toLowerCase().contains(searchingWord.toLowerCase())) {
                        list.add(user);
                    }
                }
            }
            usersList.setValue(list);

        }));
    }
    public void delete (String user_id){
        collectionUsers.document(user_id).delete();
    }
    public void uploadUsers(){
        collectionUsers.addSnapshotListener(((value, error) -> {
            ArrayList<Users> list = new ArrayList<>();

            for (DocumentSnapshot documentSnapshot : value.getDocuments()){
                Users user = documentSnapshot.toObject(Users.class);

                if (user != null){
                    user.setUser_id(documentSnapshot.getId());
                    list.add(user);
                }
            }
            usersList.setValue(list);

        }));
    }

}
