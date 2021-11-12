package com.example.library.entity;

import java.util.Date;

public abstract class LoanItem {
    private int code;
    private String name;

    public abstract void getReturnDays();
}
