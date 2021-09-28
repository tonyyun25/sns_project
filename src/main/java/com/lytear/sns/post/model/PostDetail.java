package com.lytear.sns.post.model;

import java.util.List;

import com.lytear.sns.post.comment.model.Comment;

//DTO(entity가 아닌 다른 데이터), VO (화면)
public class PostDetail {

	private Post post;
	private List<Comment> commentList;
	private int userId;// PostBO에서 like 처리를 위해 userId 변수 추가 
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
