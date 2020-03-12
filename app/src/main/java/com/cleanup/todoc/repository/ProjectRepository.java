package com.cleanup.todoc.repository;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.data.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectRepository {

    private ProjectDao projectDao;
    private static ProjectRepository instance;

    public ProjectRepository(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public LiveData<List<Project>> getAllProjects() {
        return projectDao.getAll();
    }

    public static ProjectRepository getInstance(ProjectDao projectDao) {
        if(instance == null) {
            synchronized (ProjectRepository.class) {
                instance = new ProjectRepository(projectDao);
            }
        }
        return instance;
    }
}
