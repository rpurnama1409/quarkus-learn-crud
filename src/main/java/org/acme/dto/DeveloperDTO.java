/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.acme.dto;

/**
 *
 * @author rpurnama
 */
public class DeveloperDTO {
    private String name;
    private String skill;
    private String hobby;

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public DeveloperDTO() {
    }

    public DeveloperDTO(String name, String skill, String hobby) {
        this.name = name;
        this.skill = skill;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    public String getHobby() {
        return hobby;
    }
}
