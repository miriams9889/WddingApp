package com.wedd2.event;


import javax.persistence.*;

@Entity
@Table(name = "baptisms")
public class Baptism {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "location")
    private String location;

    // @Column(name = "date")
    // private String date;


    @Column(name = "design")
    private String design;

    @Column(name = "reservationName")
    private String reservationName;

    @Column(name = "contactName")
    private String contactName;

    @Column(name = "phoneNr")
    private String phoneNr;

    private boolean enabled;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }


    // public String getDate() {
    //     return date;
    // }

    // public void setDate(String date) {
    //     this.date = date;
    // }

    @Override
    public String toString() {
        return "Wedding{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", design='" + design + '\'' +
                ", reservationName='" + reservationName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
