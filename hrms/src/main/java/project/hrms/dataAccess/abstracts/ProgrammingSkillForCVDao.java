package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.ProgrammingSkillForCV;


public interface ProgrammingSkillForCVDao extends JpaRepository<ProgrammingSkillForCV, Integer>{
	ProgrammingSkillForCV getById(int id);
	List<ProgrammingSkillForCV> getAllByJobSeeker_id(int id);
}