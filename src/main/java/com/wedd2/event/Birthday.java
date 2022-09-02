package com.wedd2.event;


import javax.persistence.*;

@Entity
@Table(name = "birthdays")
public class Birthday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "location")
    private String location;

    @Column(name = "activities")
    private String activities;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "kidsAge")
    private Integer kidsAge;

    @Column(name = "theme")
    private String theme;

    @Column(name = "reservationName")
    private String reservationName;

    @Column(name = "contactName")
    private String contactName;

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

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getKidsAge() {
        return kidsAge;
    }

    public void setKidsAge(Integer kidsAge) {
        this.kidsAge = kidsAge;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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


    @Override
    public String toString() {
        return "Birthday{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", activities='" + activities + '\'' +
                ", capacity=" + capacity +
                ", kidsAge=" + kidsAge +
                ", theme='" + theme + '\'' +
                ", reservationName='" + reservationName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", enabled=" + enabled +
                '}';
    }
    public  boolean isEnabled() {return enabled;}
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
}
