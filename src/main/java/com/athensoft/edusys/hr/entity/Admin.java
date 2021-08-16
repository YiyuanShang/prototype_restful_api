package com.athensoft.edusys.hr.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends Employee{

}
