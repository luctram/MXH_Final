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
public class Feedback {
    private int FBid;
    private int userId;
    private String date;
    private String Contents;

    public Feedback(int userId, String date, String Contents) {
        this.userId = userId;
        this.date = date;
        this.Contents = Contents;
    }

   
    public Feedback() {
    }

    public int getFBid() {
        return FBid;
    }

    public void setFBid(int FBid) {
        this.FBid = FBid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

 

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String Contents) {
        this.Contents = Contents;
    }
    
    
}
