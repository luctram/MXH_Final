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
    private String userName;
    private String date;
    private String Contents;

    public Feedback(String userName, String date, String Contents) {
        this.userName = userName;
        this.date = date;
        this.Contents = Contents;
    }

    public Feedback() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
