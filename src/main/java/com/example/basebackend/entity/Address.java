package com.example.basebackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_address")
@FieldDefaults(level = AccessLevel.PRIVATE)  // Mặc định tất cả các field là private
@NoArgsConstructor
@Builder
@AllArgsConstructor  // Dùng pattern Builder để tạo object dễ dàng
public class Address extends BaseEntity<Long> {
    String apartmentNumber;
    String floor;
    String building;
    String streetNumber;
    String street;
    String city;
    String country;
    String addressType;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_address_user"))
    User user;
}
