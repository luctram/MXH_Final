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
    private int serialPost;
    private int userCmtId;
    private String contentsCmt;
    private String cmtDate;

    public CommentPost() {
    }

    public int getCmtId() {
        return cmtId;
    }

    public void setCmtId(int cmtId) {
        this.cmtId = cmtId;
    }

    public int getSerialPost() {
        return serialPost;
    }

    public void setSerialPost(int serialPost) {
        this.serialPost = serialPost;
    }

    public int getUserCmtId() {
        return userCmtId;
    }

    public void setUserCmtId(int userCmtId) {
        this.userCmtId = userCmtId;
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
