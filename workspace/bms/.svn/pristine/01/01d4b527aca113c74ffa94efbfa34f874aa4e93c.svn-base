package com.bms.service.reply;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.reply.ReplyDao;
import com.bms.dto.reply.ReplyVO;
import com.bms.request.reply.CommunityReplyRequest;

public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDao replyDao;
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	@Override
	public void mobileReplyWrite(ReplyVO reply) throws SQLException {
		replyDao.mobileReplyWrite(reply);
	}
	@Override
	public ReplyVO mobileReply(String board_code) throws SQLException {
		ReplyVO reply = replyDao.mobileReply(board_code);
		return reply;
	}
	@Override
	public void mobileReplyDelete(String reply_code) throws SQLException {
		replyDao.mobileReplyDelete(reply_code);
	}
	@Override
	public void mobileReplyModify(ReplyVO reply) throws SQLException {
		replyDao.mobileReplyModify(reply);
		
	}
	@Override
	public List<ReplyVO> mobileReplyList(String board_code) throws SQLException {
		List<ReplyVO> reply = replyDao.mobileReplyList(board_code);
		return reply;
	}
	@Override
	public int mobileReplyCnt(String board_code) throws SQLException {
		int cnt = replyDao.mobileReplyCnt(board_code);
		return cnt;
	}
	@Override
	public List<CommunityReplyRequest> mobileReplyUpCode() throws SQLException {
		List<CommunityReplyRequest> replyUp = replyDao.mobileReplyUpCode();
		return replyUp;
	}
	@Override
	public void mobilReplyRegist(ReplyVO reply) throws SQLException {
		replyDao.mobileReplyRegist(reply);
	}
	@Override
	public void mobilReplyResRegist(ReplyVO reply) throws SQLException {
		replyDao.mobileReplyResRegist(reply);
	}
	
}
