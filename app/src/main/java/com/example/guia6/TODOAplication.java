package com.example.guia6;
import android.app.Application;
import com.google.firebase.firestore.FirebaseFirestore;

public class TODOAplication extends Application{
    public static FirebaseFirestore firebaseFirestore;

    @Override
    public void onCreate() {
        super.onCreate();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }
}
