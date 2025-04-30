package br.com.jonathan.course_rest_with_spring.data.dto.v2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonDTOv2 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String address;
    private String gender;

    public PersonDTOv2(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTOv2 that = (PersonDTOv2) o;
        return getId() == that.getId() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getBirthDay(), that.getBirthDay()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getBirthDay(), getAddress(), getGender());
    }
}
