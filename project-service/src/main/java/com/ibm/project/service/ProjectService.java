package com.ibm.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.project.entity.Project;
import com.ibm.project.repo.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	@Transactional
	public String createProject(Project project) {
		Project savedProject = projectRepository.save(project);
		if(project != null) {
			throw new RuntimeException();
		}
		return savedProject.getId();
	}

	public Optional<Project> getProject(String orderId) {
		return projectRepository.findById(orderId);
	}

	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	public void updateProject(Project project) {
		projectRepository.save(project);
	}

}
