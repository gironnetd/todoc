package com.cleanup.todoc.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.repository.ProjectRepository;
import com.cleanup.todoc.utilities.RxImmediateSchedulerRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;
import static org.junit.Assert.assertSame;

import static org.mockito.Mockito.when;

public class ProjectViewModelUnitTest {
    @Rule
    public RxImmediateSchedulerRule testSchedulerRule = new RxImmediateSchedulerRule();

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private ProjectRepository projectRepository;

    ProjectViewModel projectViewModel;

    private static List<Project> PROJECTS;

    @Before
    public void setupProjectViewModel() {
        MockitoAnnotations.initMocks(this);

        PROJECTS = Arrays.asList(Project.getAllProjects());

        when(projectRepository.getAllProjects()).thenReturn(Single.just(PROJECTS));
        projectViewModel = new ProjectViewModel(projectRepository);
    }

    @Test
    public void get_all_projects() {
        when(projectRepository.getAllProjects()).thenReturn(Single.just(PROJECTS));
        List<Project> actualProjects = projectViewModel.projects().getValue();

        assertSame(PROJECTS, actualProjects);
    }
}
