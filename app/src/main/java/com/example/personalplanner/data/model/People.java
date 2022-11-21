package com.example.personalplanner.data.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class People implements Comparable<People>, Parcelable {
    private String name;
    private String surname;
    private String rol;
    private Date birthdayDate;              // la fecha o la edad?
    private int color;
    private int image;

    public People(String name, String surname, String rol, Date birthdayDate, int color, int image) {
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.birthdayDate = birthdayDate;
        this.color = color;
        this.image = image;
    }

    public People(String name, String surname, Date birthdayDate, int color, int image) {
        this.name = name;
        this.surname = surname;
        this.birthdayDate = birthdayDate;
        this.color = color;
        this.image = image;
    }

    public People(String name, String surname, String rol, int image) {
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.image = image;
    }

    public People() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (!getName().equals(people.getName())) return false;
        if (!getSurname().equals(people.getSurname())) return false;
        if (getRol() != null ? !getRol().equals(people.getRol()) : people.getRol() != null)
            return false;
        return getBirthdayDate().equals(people.getBirthdayDate());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + (getRol() != null ? getRol().hashCode() : 0);
        result = 31 * result + getBirthdayDate().hashCode();
        return result;
    }

    @Override
    public int compareTo(People people) {
        return this.getName().compareTo(people.getName());
    }


    protected People(Parcel in) {
        name = in.readString();
        surname = in.readString();
        rol = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(rol);
    }
}
