package com.udea.empleados.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "All details about the Employee.")
public class Employee {

    @ApiModelProperty(notes = "The database generated person ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(notes = "The employee's first name")
    @Column(nullable = false, length = 80)
    @NonNull
    private String firstName;

    @ApiModelProperty(notes = "The employee's last name")
    @Column(nullable = false, length = 80)
    @NonNull
    private String lastName;

    @ApiModelProperty(notes = "The employee's email")
    @Column(nullable = false, length = 80)
    @NonNull
    private String email;

    @ApiModelProperty(notes = "The employee's salary")
    @Column(nullable = false)
    @NonNull
    private Double salary;

    @ApiModelProperty(notes = "The employee's occupation")
    @Column(nullable = false, length = 80)
    @NonNull
    private String occupation;

    @ApiModelProperty(notes = "The employee's dependency")
    @Column(nullable = false, length = 80)
    @NonNull
    private String dependency;

    @ApiModelProperty(notes = "The employee's date of joining the company")
    @Column(nullable = false)
    @NonNull
    private Date joinedDate;

    @ApiModelProperty(notes = "The employee's office number")
    @Column(nullable = false, length = 3)
    @NonNull
    private String office;

    @ApiModelProperty(notes = "The employee's age")
    @Column(nullable = false, length = 2)
    @NonNull
    private Integer age;
}
