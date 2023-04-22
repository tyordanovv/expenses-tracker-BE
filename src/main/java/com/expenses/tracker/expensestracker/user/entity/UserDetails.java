package com.expenses.tracker.expensestracker.user.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_details")
@NoArgsConstructor
public class UserDetails {
    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
    @Column(name = "age")
    private int age;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "user_agreement")
    private String userAgreement;
    @Column(name = "user_requisition")
    private String userRequisition;
    @Column(name = "user_language")
    private String userLanguage;
    @Column(name = "preferred_currency")
    private String preferredCurrency;

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public void setAge(int age) {this.age = age;}
    public String getUserLanguage() {return userLanguage;}
    public void setUserLanguage(String userLanguage) {this.userLanguage = userLanguage;}
    public String getPreferredCurrency() {return preferredCurrency;}
    public void setPreferredCurrency(String preferredCurrency) {this.preferredCurrency = preferredCurrency;}
    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}
    public String getUserAgreement() {return userAgreement;}
    public void setUserAgreement(String userAgreement) {this.userAgreement = userAgreement;}
    public String getUserRequisition() {return userRequisition;}
    public void setUserRequisition(String userRequisition) {this.userRequisition = userRequisition;}
}
