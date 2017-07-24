package com.example.alvin.w2_d1_ex01;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alvin on 7/24/2017.
 */

public class Picture implements Parcelable {
    private String firstName;
    private String lastName;
    private Bitmap image;

    public Picture() {
    }

    public Picture(String firstName, String lastName, Bitmap image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", image=" + image +
                '}';
    }

    protected Picture(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        image = (Bitmap) in.readValue(Bitmap.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeValue(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Picture> CREATOR = new Parcelable.Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };
}