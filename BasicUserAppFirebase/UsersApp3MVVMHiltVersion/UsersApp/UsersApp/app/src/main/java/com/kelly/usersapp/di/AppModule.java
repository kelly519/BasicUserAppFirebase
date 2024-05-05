package com.kelly.usersapp.di;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kelly.usersapp.data.repo.UsersDaoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public UsersDaoRepository provideUsersDaoRepository(CollectionReference collectionUsers){
        return new UsersDaoRepository(collectionUsers);
    }
    @Provides
    @Singleton
    public CollectionReference provideCollectionReference(){
        return FirebaseFirestore.getInstance().collection("Users");
    }
}
