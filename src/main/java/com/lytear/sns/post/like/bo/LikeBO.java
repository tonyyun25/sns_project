package com.lytear.sns.post.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.sns.post.like.dao.LikeDAO;

@Service
public class LikeBO {

	@Autowired
	private LikeDAO likeDAO;
	
	//public int like(int userId, int postId) {
	/*좋아요 인지 boolean, 좋아요 취소 count 방법이 다르니 여기서도 다르게 처리 so 리턴 타입을 int가 아니라 boolean으로 줌
	 * 메소드는 연결시키지 말고 어디선가 써 먹을 수 있다는 생각으로 독립적으로 만들어라
	 * */
	public boolean like(int userId, int postId) {
		
		// 좋아요 상태면 좋아요 취소 : 두 번째 방법
		if(this.likeByUserId(userId, postId)) {//postId,userId 받아서 좋아요 인지 아닌지 판단하는 메소드
			int count = likeDAO.deleteLike(userId, postId);
			if(count==0) {
				return false;
			} else {
				return true;
			}
		} else { // 좋아요 취소 상태면 좋아요
			int count = likeDAO.insertLike(userId, postId);
			if(count == 1) {
				return true;
			} else {
				return false;
			}
		}
		
		//return likeDAO.insertLike(userId, postId); // unlike 두 번째방법 적용시 삭제
	}
	
	public int unLike(int userId, int postId) {
		return likeDAO.deleteLike(userId, postId);
	}
	
	
	// postId와 userId로 좋아요 여부 확인 => '여부' : true, false로 알려 줌
	public boolean likeByUserId(int userId, int postId) {
		int count = likeDAO.selectCountLikeByUserId(userId, postId);
		
		if(count == 0) { // 명확한 걸 써 주는 게 좋아. count = 1 이면 원래 한 개 인데 없어졌을 가능성도 있으니 count = 0 이 더 명확함
			return false;
		} else {
			return true;
		}
		
	}
	
	// postId로 생성된 좋아요 개수
	public int likeCount(int postId) {
		return likeDAO.selectCountLikeByPostId(postId);
	}
	
	
	
	
}
