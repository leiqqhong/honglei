package cn.bdqn.entity;

import java.util.Date;

public class EasybuyComment {

	private int ecId;
	private String reply;
	private String content;
	private Date createTime;
	private Date replyTime;
	private String nickName;
	public int getEcId() {
		return ecId;
	}
	public void setEcId(int ecId) {
		this.ecId = ecId;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public EasybuyComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EasybuyComment(int ecId, String reply, String content,
			Date createTime, Date replyTime, String nickName) {
		super();
		this.ecId = ecId;
		this.reply = reply;
		this.content = content;
		this.createTime = createTime;
		this.replyTime = replyTime;
		this.nickName = nickName;
	}
	
	
}
