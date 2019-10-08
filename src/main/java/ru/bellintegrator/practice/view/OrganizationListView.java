package ru.bellintegrator.practice.view;

public class OrganizationListView {

    public Integer id;

    public String name;

    public Integer isActive;

 

    public OrganizationListView(Integer id, String name, Integer isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }
}