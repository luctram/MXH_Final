/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TramLuc
 */
public class CommentPost {
    private int cmtId;
    private int postId;
    private int userId;
    private String contentsCmt;
    private String cmtDate;

    public CommentPost(int postId, int userId, String contentsCmt, String cmtDate) {
        this.postId = postId;
        this.userId = userId;
        this.contentsCmt = contentsCmt;
        this.cmtDate = cmtDate;
    }

    

    public CommentPost() {
    }

    public int getCmtId() {
        return cmtId;
    }

    public void setCmtId(int cmtId) {
        this.cmtId = cmtId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public CommentPost(int cmtId, String contentsCmt) {
        this.cmtId = cmtId;
        this.contentsCmt = contentsCmt;
    }

    public String getContentsCmt() {
        return contentsCmt;
    }

    public void setContentsCmt(String contentsCmt) {
        this.contentsCmt = contentsCmt;
    }

    public String getCmtDate() {
        return cmtDate;
    }

    public void setCmtDate(String cmtDate) {
        this.cmtDate = cmtDate;
    }
    
}
