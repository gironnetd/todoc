package com.cleanup.todoc.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.repository.ProjectRepository;

import java.util.List;

public class ProjectViewModel extends ViewModel {

    private ProjectRepository  projectRepository;
    private LiveData<List<Project>> projects;

    public ProjectViewModel(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        projects = this.projectRepository.getAllProjects();
    }

    public LiveData<List<Project>> getProjects() {
        return projects;
    }
}
