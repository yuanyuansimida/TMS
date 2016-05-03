package com.LI;

public class Teacher {

	
	private long id;
	private String name;
	private String subject;
	
	public Teacher(long id,String name,String subject)
	{
		this.id = id;
		this.name = name;
		this.subject = subject;
	}
	//ID���Ե���
	public void setID(long id)
	{
		this.id = id;
	}
	public long getID()
	{
		return this.id;
	}
	//Name���Ե���
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	//Subject���Ե���
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	public String getSubject()
	{
		return this.subject;
	}
	//����ToString
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + "]";
	}
	
}
