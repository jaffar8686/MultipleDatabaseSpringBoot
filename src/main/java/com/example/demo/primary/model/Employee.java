package com.example.demo.primary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "employee_id", nullable = false)
    private String employeeId;//1
    @Column(nullable = false)
    private String prefix;//2
    @Column(nullable = false, name = "first_name")
    private String firstName;//3
    @Column(nullable = false, name = "last_name")
    private String lastName;//4
    @Column(nullable = false, name = "mode_of_employment")
    private String modeOfEmployment;//5
    @Column(nullable = false)
    private String role;//6
    @Column(nullable = false,name="email_address")
    private String emailAddress;//7
    @Column(nullable = false,name = "business_unit")
    private String businessUnit;//8
    @Column(nullable = false)
    private String department;//9
    @Column(nullable = false,name = "reporting_manager")
    private String reportingManager;//10
    @Column(nullable = false)
    private String position;//11
    @Column(nullable = false,name = "employee_status")
    private String employeeStatus = "Probation";//12
    @Column(nullable = false, name = "date_of_joining" )
    private Date dateOfJoining;//13
    @Column(nullable = true , name = "date_of_leaving")
    private Date dateOfLeaving;//14
    @Column(nullable = true,name = "year_of_experience")
    private String yearOfExperience;//15
    @Column(nullable = true,name = "work_telephone_number")
    private String workTelephoneNumber;//16
    @Column(nullable = false,name = "date_of_birth")
    private Date dateOfBirth;//17
    @Column(nullable = false)
    private String designation;//18
    @Column(nullable = true,name= "probation_review_date")
    private Date probationReviewDate;//19
    @Column(nullable = false , name = "contact_number")
    private String contactNumber;//20
    @Column(nullable = false,name="working_hours")
    private Double workingHours;//21
    @Column(nullable = false,name = "login_time")
    private Time loginTime;//22
    @Column(nullable = false,name="log_out_time")
    private Time logOutTime;//23
    @Column(nullable = true, name = "available_leaves")
    private double availableLeaves = 0;//24
    private String password;//25
    private String reportee;//26
    @Column( name = "marital_status")
    private String maritalStatus;//27
    @Column( name = "primary_skill_set")
    private String primarySkillSet;//28
    @Column( name = "secondary_skill_set")
    private String secondarySkillSet;//29
    @Column(name = "project")
    private String project;//30
    @Column( name = "ppg_status")
    private String ppgStatus;//31
    @Column( name = "ppg_start_date")
    private  String ppgStartDate;//32
    @Column( name = "last_project")
    private String lastProject;//33
    @Column( name = "project_start_date")
    private String projectStartDate;//34
    @Column( name = "project_end_date")
    private String projectEndDate;//35

    private String comments;//36
    @Column( name = "profile_status")
    private String profileStatus;//37

    private Boolean isdeleted = false ;//38
    @Column( name = "l2manager_name")
    private String l2managerName;//39
    @Column(name = "branch_location")
    private String branchLocation;//41
    @Column( name = "pay_type")
    private String payType;//42

    @Column(name = "last_updated_time")
    private LocalDateTime lastUpdatedTime = LocalDateTime.now();

    @Column(name = "last_updated_by")
    private String lastUpdatedBy = "System";

    @Column(name = "holiday_group",nullable = true)
    private String holidayGroup;

    @Column(name = "gender")
    private String gender;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", modeOfEmployment='" + modeOfEmployment + '\'' +
                ", role='" + role + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", department='" + department + '\'' +
                ", reportingManager='" + reportingManager + '\'' +
                ", position='" + position + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", dateOfLeaving=" + dateOfLeaving +
                ", yearOfExperience='" + yearOfExperience + '\'' +
                ", workTelephoneNumber='" + workTelephoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", designation='" + designation + '\'' +
                ", probationReviewDate=" + probationReviewDate +
                ", contactNumber='" + contactNumber + '\'' +
                ", workingHours=" + workingHours +
                ", loginTime=" + loginTime +
                ", logOutTime=" + logOutTime +
                ", availableLeaves=" + availableLeaves +
                ", password='" + password + '\'' +
                ", reportee='" + reportee + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", primarySkillSet='" + primarySkillSet + '\'' +
                ", secondarySkillSet='" + secondarySkillSet + '\'' +
                ", project='" + project + '\'' +
                ", ppgStatus='" + ppgStatus + '\'' +
                ", ppgStartDate='" + ppgStartDate + '\'' +
                ", lastProject='" + lastProject + '\'' +
                ", projectStartDate='" + projectStartDate + '\'' +
                ", projectEndDate='" + projectEndDate + '\'' +
                ", comments='" + comments + '\'' +
                ", profileStatus='" + profileStatus + '\'' +
                ", isdeleted=" + isdeleted +
                ", l2managerName='" + l2managerName + '\'' +
                ", branchLocation='" + branchLocation + '\'' +
                ", payType='" + payType + '\'' +
                ", lastUpdatedTime=" + lastUpdatedTime +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", holidayGroup='" + holidayGroup + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}