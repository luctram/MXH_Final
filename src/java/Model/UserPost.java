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
public class UserPost {
    private int userId;
    private String date;
    private int postId;
    private String content;
    private String imgVideoLink;
    private int countLike;

    public UserPost() {
    }

    public UserPost(int userId, String date, int postId, String content, String imgVideoLink, int countLike) {
        this.userId = userId;
        this.date = date;
        this.postId = postId;
        this.content = content;
        this.imgVideoLink = imgVideoLink;
        this.countLike = countLike;
    }

    public UserPost(int userId, int countLike) {
        this.userId = userId;
        this.countLike = countLike;
    }


    public UserPost(int postId, String content, String imgVideoLink) {
        this.postId = postId;
        this.content = content;
        this.imgVideoLink = imgVideoLink;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImgVideoLink() {
        return imgVideoLink;
    }

    public void setImgVideoLink(String imgVideoLink) {
        this.imgVideoLink = imgVideoLink;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    
}
