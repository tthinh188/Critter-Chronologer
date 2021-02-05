package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee extends User {
    @ElementCollection(
            targetClass = EmployeeSkill.class
    )
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="employee_skills")
    @Column(name="skill")
    private Set<EmployeeSkill> skills;

    @ElementCollection(
            targetClass = DayOfWeek.class
    )
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="employee_days_available")
    @Column(name="day")
    private Set<DayOfWeek> daysAvailable;

    @ManyToMany(
            mappedBy = "employees"
    )
    private List<Schedule> schedules;

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
