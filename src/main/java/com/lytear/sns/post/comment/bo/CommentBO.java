package com.lytear.sns.post.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.sns.post.comment.dao.CommentDAO;
import com.lytear.sns.post.comment.model.Comment;


@Service
public class CommentBO {
	
	
	@Autowired
	private CommentDAO commentDAO;
	
	public int addComment(int userId, String userNameTest, int postId, String content){
		return commentDAO.insertComment(userId, userNameTest, postId, content) ;
	}
	
	
	// postId 에 해당하는 댓글 리스트 가져오기
	public List<Comment> getCommentListByPostId(
			int postId
			){
		return commentDAO.selectCommentListByPostId(postId);
	}
	
	public int deleteCommentByPostId(int postId) {
		return commentDAO.deleteCommentByPostId(postId);
	}
	
	
}
