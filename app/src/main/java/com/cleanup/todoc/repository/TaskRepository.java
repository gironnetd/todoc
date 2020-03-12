package com.cleanup.todoc.repository;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.data.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private static TaskRepository instance;

    public TaskRepository(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public LiveData<List<Task>> getAllTasks() {
        return taskDao.getAll();
    }

    public void insertTask(Task task) {
        taskDao.insert(task);
    }

    public void deleteTask(Task task) {
        taskDao.delete(task);
    }

    public static TaskRepository getInstance(TaskDao taskDao) {
        if(instance == null) {
            synchronized (TaskRepository.class) {
                instance = new TaskRepository(taskDao);
            }
        }
        return instance;
    }
}
