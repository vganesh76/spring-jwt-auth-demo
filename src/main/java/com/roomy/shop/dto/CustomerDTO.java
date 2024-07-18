package com.roomy.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class CustomerDTO implements Serializable {
    private Long id;
    private  String firstName;
    private String lastName;
    private String email;
    private Date createdOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerDTO{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", createdOn=").append(createdOn);
        sb.append('}');
        return sb.toString();
    }
}
