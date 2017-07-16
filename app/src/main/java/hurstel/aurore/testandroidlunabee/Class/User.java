package hurstel.aurore.testandroidlunabee.Class;

import java.util.Date;

public class User {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    // private Date dob;
    private String dob;
    private Date registered;
    private String phone;
    private String cell;
    private Id id;
    // private Picture picture;
    private String pictureAdress;
    private String nat;

    public User() {
    }

    public User(String first, String last, String pictureAdress, String email, String gender, String dob, String cell) {
        this.name = new Name(first, last);
        this.pictureAdress = pictureAdress;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.cell = cell;
    }

    public String getFirstName() {
        return name.getFirst();
    }

    public String getLastName() {
        return name.getLast();
    }

    public String getPictureAdress() {
        return pictureAdress;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getCell() {
        return cell;
    }
}
