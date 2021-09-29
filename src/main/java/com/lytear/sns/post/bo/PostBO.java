package com.lytear.sns.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lytear.sns.common.FileManagerService;
import com.lytear.sns.post.comment.bo.CommentBO;
import com.lytear.sns.post.comment.model.Comment;
import com.lytear.sns.post.dao.PostDAO;
import com.lytear.sns.post.like.bo.LikeBO;
import com.lytear.sns.post.model.Post;
import com.lytear.sns.post.model.PostDetail;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	//public int getTimeline(int userId, String userName, String content, String imagePath) {
	public int addPost(int userId, String userNameTest, String content, MultipartFile file) {
		
		// 방법 1		
		String imagePath = FileManagerService.saveFile(userId, file);
		
		if(imagePath == null) {
			return -1;
		}
		// 방법 2
		/*
		String imagePath = null;
		
		if(file != null) {
			imagePath  = FileManagerService.saveFile(userId, file);
			if(imagePath == null) {
				return 0;
			}
		}
		*/
		return postDAO.insertPost(userId, userNameTest, content, imagePath);
	}
	
	/*
	public List<Post> getPostList() {
		
		return postDAO.selectPostList();
	}*/
	
	//public List<Post> getPostList() {
	//public List<PostDetail> getPostList() {
	public List<PostDetail> getPostList(int userId) {// PostBO에서 like 처리를 위해 userId 파리미터로 받아 옴 
				
		List<Post> postList = postDAO.selectPostList();
		
		List<PostDetail> postDetailList = new ArrayList<>();
		/*다른 테이블에 해당하는 dao(commentDAO)를 바로 호출하는 것은 구조적으로 좋지 않아. bo 부터 호출한다 
		 * */
		
		// 포스트 하나당 댓글 가져오기
		for(Post post : postList) {
			// 해당하는 포스트의 댓글 가져오기
			List<Comment> commentList = commentBO.getCommentListByPostId(post.getId()); // ★★ commentBO에 명령
			
			// post 글 하나당 내가 좋아요 했는지를 체크하기 위해 바로 Like DAO 부르는 건 좋지 않으므로 likeBO, likeDAO 순으로 호출한다
			// 위 commentList도 post 글 하나당 반복문으로 불러온 것과 마찬가지로 좋아요도 post 글 하나당 좋아요 했는지를 결과로 가져온다
			// 해당하는 포스트를 현재 로그인한 사용자가 좋아요 했는지 확인
			boolean isLike = likeBO.likeByUserId(userId, post.getId()); 
			// 해당 포스트에 좋아요 개수
			int likeCount = likeBO.likeCount(post.getId());// 이정보는 postDetail에 저장되어야 함 => postDetail에 변수 추가
			
			
			// post 와 댓글이 매칭  => 두 개 값을 저장할 수 있는 클래스를 post/model 아래에 만든다 (post, 코멘트)
			PostDetail postDetail = new PostDetail();
			postDetail.setPost(post);
			postDetail.setCommentList(commentList);
			postDetail.setLike(isLike);
			postDetail.setLikeCount(likeCount);
			//postDetail.setUserId(userId);// PostBO에서 like 처리를 위해 userId 값 추가 
			
			postDetailList.add(postDetail);
		}
		
		
		//return postDAO.selectPostList();
		return postDetailList;
	}
	
	
	
	
}
