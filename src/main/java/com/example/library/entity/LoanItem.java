package com.example.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

public abstract class LoanItem {
    private Integer id;
    private int code;
    private String name;

    public abstract void getReturnDays();
}
