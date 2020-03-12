package com.cleanup.todoc.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends ViewModel {

    private TaskRepository taskRepository;
    private LiveData<List<Task>> tasks;

    public TaskViewModel(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        tasks = this.taskRepository.getAllTasks();
    }

    public LiveData<List<Task>> getTasks() {
        return tasks;
    }

    public void insertTask(Task task) {
        taskRepository.insertTask(task);
    }

    public void deleteTask(Task task) {
        taskRepository.deleteTask(task);
    }
}
