package sservice.student.service.dto;

import sservice.student.service.model.CourseAttending;

public class CourseAttendingDTO {

	private long id;
	private StudentDTO student;
	private StudyProgramDTO studyProgram;
	
	public CourseAttendingDTO(){}
	
	public CourseAttendingDTO(CourseAttending courseAttending){
		
		id = courseAttending.getId();
		student = new StudentDTO(courseAttending.getStudent());
		studyProgram = new StudyProgramDTO(courseAttending.getStudyProgram());
	}

	public CourseAttendingDTO(long id, StudentDTO student, StudyProgramDTO studyProgram) {
		super();
		this.id = id;
		this.student = student;
		this.studyProgram = studyProgram;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public StudyProgramDTO getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgramDTO studyProgram) {
		this.studyProgram = studyProgram;
	}
	
	
	
}
