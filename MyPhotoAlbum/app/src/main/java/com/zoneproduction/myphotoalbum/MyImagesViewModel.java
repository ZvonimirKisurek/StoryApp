package com.zoneproduction.myphotoalbum;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyImagesViewModel extends AndroidViewModel {

    private MyImagesRepositroy repositroy;
    private LiveData<List<MyImages>> imagesList;

    public MyImagesViewModel(@NonNull Application application) {
        super(application);

        repositroy = new MyImagesRepositroy(application);
        imagesList = repositroy.getAllImages();
    }

    public void insert(MyImages myImages){
        repositroy.insert(myImages);
    }

    public void delete(MyImages myImages){
        repositroy.delete(myImages);
    }

    public void update(MyImages myImages){
        repositroy.update(myImages);
    }

    public LiveData<List<MyImages>> getAllImages(){
        return imagesList;
    }
}
