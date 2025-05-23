package com.codewithaman.todoapispring;

public class Todo{
	private String todo;
	private int id;
	private Boolean completed;
	private Integer userId;

	public void setTodo(String todo){
		this.todo = todo;
	}

	public String getTodo(){
		return todo;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCompleted(boolean completed){
		this.completed = completed;
	}

	public Boolean isCompleted(){
		return completed;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return userId;
	}

	public Todo(String todo, int id, boolean completed, int userId) {
		this.todo = todo;
		this.id = id;
		this.completed = completed;
		this.userId = userId;
	}

	@Override
 	public String toString(){
		return 
			"Todo{" + 
			"todo = '" + todo + '\'' + 
			",id = '" + id + '\'' + 
			",completed = '" + completed + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
