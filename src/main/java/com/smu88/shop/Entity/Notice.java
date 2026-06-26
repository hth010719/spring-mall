package com.smu88.shop.Entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@ToString
public class Notice{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public LocalDate date;
}
