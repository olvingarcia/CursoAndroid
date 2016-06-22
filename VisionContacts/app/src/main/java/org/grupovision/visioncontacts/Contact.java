package org.grupovision.visioncontacts;

/**
 * Created by agarcia on 22/06/2016.
 */
public class Contact {

    public Contact(String name, String company, String telephone, String email, String github, String facebook, String twitter, String photo) {
        this.name = name;
        this.company = company;
        this.telephone = telephone;
        this.email = email;
        this.github = github;
        this.facebook = facebook;
        this.twitter = twitter;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private String name;
    private String company;
    private String telephone;
    private String email;
    private String github;
    private String facebook;
    private String twitter;
    private String photo;


}
