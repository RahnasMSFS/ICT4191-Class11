package lk.ac.vau.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id
	private long CommentId;
	private String Comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date CommentedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commeneted_in",referencedColumnName = "PostId")
	private Post CommentedIn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commeneted_by",referencedColumnName = "UserdId")
	private User CommentedBy;
	
	public Comment()
	{}

	public Comment(long commentId, String comment, Date commentedOn, Post commentedIn, User commentedBy) {
		super();
		CommentId = commentId;
		Comment = comment;
		CommentedOn = commentedOn;
		CommentedIn = commentedIn;
		CommentedBy = commentedBy;
	}

	public long getCommentId() {
		return CommentId;
	}

	public void setCommentId(long commentId) {
		CommentId = commentId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Date getCommentedOn() {
		return CommentedOn;
	}

	public void setCommentedOn(Date commentedOn) {
		CommentedOn = commentedOn;
	}

	@JsonIgnore
	public Post getCommentedIn() {
		return CommentedIn;
	}

	public void setCommentedIn(Post commentedIn) {
		CommentedIn = commentedIn;
	}

	@JsonIgnore
	public User getCommentedBy() {
		return CommentedBy;
	}

	public void setCommentedBy(User commentedBy) {
		CommentedBy = commentedBy;
	}
}
