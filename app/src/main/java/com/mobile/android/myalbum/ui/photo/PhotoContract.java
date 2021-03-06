package com.mobile.android.myalbum.ui.photo;

import com.mobile.android.myalbum.model.photo.Photo;

import java.util.List;

public interface PhotoContract {
    interface Presenter {
        void getPhotos(int albumId);
        void setView(View view);
        void close();
    }

    interface View {
        void displayPhotos(List<Photo> photos);
        void displayError(String message);
    }
}
