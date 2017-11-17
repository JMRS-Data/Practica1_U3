package model;

import java.io.Serializable;

public class Student implements Serializable{
	
	private Long id;
	private String name;
	private String studentGroup;
	private String turn;
	/**
	 * @param id
	 * @param name
	 * @param studentGroup
	 * @param turn
	 */
	public Student(Long id, String name, String studentGroup, String turn) {
		super();
		this.id = id;
		this.name = name;
		this.studentGroup = studentGroup;
		this.turn = turn;
	}
	/**
	 * 
	 */
	public Student() {
		this(0L,"","","");		
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the studentGroup
	 */
	public String getStudentGroup() {
		return studentGroup;
	}
	/**
	 * @param studentGroup the studentGroup to set
	 */
	public void setStudentGroup(String studentGroup) {
		this.studentGroup = studentGroup;
	}
	/**
	 * @return the turn
	 */
	public String getTurn() {
		return turn;
	}
	/**
	 * @param turn the turn to set
	 */
	public void setTurn(String turn) {
		this.turn = turn;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", studentGroup=" + studentGroup + ", turn=" + turn + "]";
	}
	
	

}
