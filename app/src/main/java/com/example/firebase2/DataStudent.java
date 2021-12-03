package com.example.firebase2;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DataStudent {
    //this class is used to get access to the object Student
    private DatabaseReference databaseReference;
    public DataStudent(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(Student.class.getSimpleName());
    }
    //insert the values within the db
    //using a return type value inorder to separate UI and logic
    public Task<Void> add(Student student) {
     return databaseReference.push().setValue(student);
    }

    //update the values within the db
    public Task<Void> update(String key, HashMap<String, Object> hashMap) {
        return databaseReference.child(key).updateChildren(hashMap);
    }

    //deleting the values from the db
    public Task<Void> delete(String key) {
        return  databaseReference.child(key).removeValue();
    }
}
