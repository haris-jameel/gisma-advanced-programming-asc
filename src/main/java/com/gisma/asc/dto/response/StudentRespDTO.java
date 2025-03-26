package com.gisma.asc.dto.response;

import com.gisma.asc.enums.ROLE;
import com.gisma.asc.enums.UserStatus;

public class StudentRespDTO {
        private Long id;
        private String name;
        private String email;
        private ROLE role;
        private UserStatus status;
        private String phone;
        private String address;
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
