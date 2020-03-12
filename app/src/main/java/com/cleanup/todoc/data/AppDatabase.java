package com.cleanup.todoc.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.Arrays;
import java.util.concurrent.Executors;

@Database(entities = {Project.class, Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "todoc.db";
    private static AppDatabase instance;
    // For Singleton instantiation
    private static final Object LOCK = new Object();

    public static AppDatabase database(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                    instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                Executors.newSingleThreadExecutor().execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        instance.projectDao().insertAll(Arrays.asList(Project.getAllProjects()));
                                    }
                                });
                            }
                        }).build();
            }
        }
        return instance;
    }

    public abstract TaskDao taskDao();
    public abstract ProjectDao projectDao();
}
