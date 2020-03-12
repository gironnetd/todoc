package com.cleanup.todoc.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cleanup.todoc.repository.ProjectRepository;

public class ProjectViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private ProjectRepository projectRepository;

    public ProjectViewModelFactory(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProjectViewModel(projectRepository);
    }
}
