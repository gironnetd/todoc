package com.cleanup.todoc.utilities;

import android.content.Context;

import com.cleanup.todoc.data.AppDatabase;
import com.cleanup.todoc.repository.ProjectRepository;
import com.cleanup.todoc.repository.TaskRepository;
import com.cleanup.todoc.viewmodel.ProjectViewModelFactory;
import com.cleanup.todoc.viewmodel.TaskViewModelFactory;

public class InjectorUtils {

    static public TaskViewModelFactory provideTaskViewModelFactory(Context context) {
        TaskRepository taskRepository = getTaskRepository(context);
        return new TaskViewModelFactory(taskRepository);
    }

    static private TaskRepository getTaskRepository(Context context) {
        return TaskRepository.getInstance(AppDatabase.database(context).taskDao());
    }

    static public ProjectViewModelFactory provideProjectViewModelFactory(Context context) {
        ProjectRepository projectRepository = getProjectRepository(context);
        return new ProjectViewModelFactory(projectRepository);
    }

    static private ProjectRepository getProjectRepository(Context context) {
        return ProjectRepository.getInstance(AppDatabase.database(context).projectDao());
    }
}
