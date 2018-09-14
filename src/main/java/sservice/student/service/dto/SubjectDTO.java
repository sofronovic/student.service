package sservice.student.service.dto;


import sservice.student.service.model.Subject;

public class SubjectDTO {
	
	private long id;
	private String name;
	private String label;
	private int ects;
	private StudyProgramDTO studyProgram;
	
	
	public SubjectDTO(Subject subject){
		
		id = subject.getId();
		label = subject.getLabel();
		name = subject.getName();
		ects = subject.getEcts();
		studyProgram = new StudyProgramDTO(subject.getStudyProgram());
	}
	
	public SubjectDTO(){}
	
	public SubjectDTO(long id, String name, String label, int ects, StudyProgramDTO studyProgram) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.ects = ects;
		this.studyProgram = studyProgram;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	public StudyProgramDTO getStudyProgram() {
		return studyProgram;
	}
	public void setStudyProgram(StudyProgramDTO studyProgram) {
		this.studyProgram = studyProgram;
	}
	
	
	

}
