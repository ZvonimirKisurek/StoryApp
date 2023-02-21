package com.zoneproduction.library.DodatniProgrami;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyImagesRepositroy {

    private MyImagesDAO myImagesDAO;
    private LiveData<List<MyImages>> imagesList;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public MyImagesRepositroy(Application application){
        MyImagesDatabase database = MyImagesDatabase.getInstance(application);
        myImagesDAO = database.myImagesDAO();
        imagesList = myImagesDAO.getAllImages();
    }

    public void insert(MyImages myImages){

        //new InsertImageAsyncTask(myImagesDAO).execute(myImages);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImagesDAO.Insert(myImages);
            }
        });
    }

    public void delete(MyImages myImages){

        //new DeleteImageAsyncTask(myImagesDAO).execute(myImages);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImagesDAO.Delete(myImages);
            }
        });
    }

    public void update(MyImages myImages){

        //new UpdateImageAsyncTask(myImagesDAO).execute(myImages);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myImagesDAO.Update(myImages);
            }
        });
    }

    public LiveData<List<MyImages>> getAllImages(){
        return imagesList;
    }

    public static class InsertImageAsyncTask extends AsyncTask<MyImages, Void, Void>{

        MyImagesDAO imagesDAO;

        public InsertImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDAO.Insert(myImages[0]);
            return null;
        }
    }

    public static class UpdateImageAsyncTask extends AsyncTask<MyImages, Void, Void>{

        MyImagesDAO imagesDAO;

        public UpdateImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDAO.Update(myImages[0]);
            return null;
        }
    }

    public static class DeleteImageAsyncTask extends AsyncTask<MyImages, Void, Void>{

        MyImagesDAO imagesDAO;

        public DeleteImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            imagesDAO.Delete(myImages[0]);
            return null;
        }
    }
}
