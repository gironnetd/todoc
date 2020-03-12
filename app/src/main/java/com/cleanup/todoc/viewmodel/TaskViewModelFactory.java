package com.cleanup.todoc.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cleanup.todoc.repository.TaskRepository;

public class TaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private TaskRepository taskRepository;

    public TaskViewModelFactory(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TaskViewModel(taskRepository);
    }
}
