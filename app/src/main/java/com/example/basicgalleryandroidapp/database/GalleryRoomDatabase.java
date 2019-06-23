package com.example.basicgalleryandroidapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Image.class}, version = 1)
public abstract class GalleryRoomDatabase extends RoomDatabase {
    public abstract ImageDAO imageDAO();

    public static volatile GalleryRoomDatabase roomDatabaseInstance;

    public static GalleryRoomDatabase getInstance(final Context context) {
        if(roomDatabaseInstance == null) {
            synchronized (GalleryRoomDatabase.class) {
                if(roomDatabaseInstance == null) {
                    roomDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), GalleryRoomDatabase.class, "gallery_database").build();
                }
            }
        }
        return roomDatabaseInstance;
    }
}
