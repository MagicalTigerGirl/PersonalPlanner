package com.example.personalplanner.data.model;

public class Food implements Comparable<Food>{
    private String name;
    private String description;
    private Integer imageName;

    public Food() {
    }

    public Food(String name, String description, Integer imageName) {
        this.name = name;
        this.description = description;
        this.imageName = imageName;
    }

    public Food(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImageName() {
        return imageName;
    }

    public void setImageName(Integer imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        if (getName() != null ? !getName().equals(food.getName()) : food.getName() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(food.getDescription()) : food.getDescription() != null)
            return false;
        return getImageName() != null ? getImageName().equals(food.getImageName()) : food.getImageName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getImageName() != null ? getImageName().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Food food) {
        return this.getName().compareTo(food.getName());
    }
}
