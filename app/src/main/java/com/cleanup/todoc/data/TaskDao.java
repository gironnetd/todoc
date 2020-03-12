package com.cleanup.todoc.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    Single<List<Task>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Task> tasks);

    @Delete
    void delete(Task task);

    @Delete
    void deleteAll(List<Task> tasks);
}
