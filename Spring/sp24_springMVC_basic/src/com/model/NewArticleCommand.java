package com.model;

public class NewArticleCommand {
	
	//게시판 글쓰기 (DTO, VO 클래스에 해당)
	private String title, content;
	private int parentId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "NewArticleCommand [title=" + title + 
				", content=" + content + 
				", parentId=" + parentId + "]";
	}

}
