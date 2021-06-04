package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.ExperienceForCV;

public interface ExperienceForCVDao extends JpaRepository<ExperienceForCV, Integer>{
	ExperienceForCV getById(int id);
	List<ExperienceForCV> getAllByJobSeeker_idOrderByEndAtDesc(int id);
	List<ExperienceForCV> getAllByJobSeeker_id(int id);
}
