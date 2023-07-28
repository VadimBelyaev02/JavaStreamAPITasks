package com.vadim.model;

import java.util.List;

public class House {
    private int id;
    private String buildingType;
    private List<Recruit> recruitList;

    public House() {
    }

    public House(int id, String buildingType, List<Recruit> recruitList) {
        this.id = id;
        this.buildingType = buildingType;
        this.recruitList = recruitList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public List<Recruit> getPersonList() {
        return recruitList;
    }

    public void setPersonList(List<Recruit> recruitList) {
        this.recruitList = recruitList;
    }

    @Override
    public String toString() {
        return "House{id=" + id + ", buildingType='" + buildingType + "', personList=" + recruitList + '}';
    }
}
