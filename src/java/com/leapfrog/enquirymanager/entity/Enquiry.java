/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "enquirytable")
@NamedQueries({
    @NamedQuery(name = "Enquiry.findAll", query = "SELECT e FROM Enquiry e")})
public class Enquiry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enquiry_id")
    private Integer enquiryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enquiry_firstName")
    private String enquiryfirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enquiry_lastName")
    private String enquirylastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enquiry_email")
    private String enquiryEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "enquiry_contactNo")
    private String enquirycontactNo;
    @Basic(optional = false)
    
    @Column(name = "enquiry_addedDate",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date enquiryaddedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enquiry_message")
    private String enquiryMessage;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Courses course;
    @JoinColumn(name = "enquirystatus_id", referencedColumnName = "enquirystatus_id")
    @ManyToOne(optional = false)
    private Enquirystatus enquirystatus;

    public Enquiry() {
    }

    public Enquiry(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Enquiry(Integer enquiryId, String enquiryfirstName, String enquirylastName, String enquiryEmail, String enquirycontactNo, String enquiryMessage) {
        this.enquiryId = enquiryId;
        this.enquiryfirstName = enquiryfirstName;
        this.enquirylastName = enquirylastName;
        this.enquiryEmail = enquiryEmail;
        this.enquirycontactNo = enquirycontactNo;
      
        this.enquiryMessage = enquiryMessage;
    }

    public Integer getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getEnquiryfirstName() {
        return enquiryfirstName;
    }

    public void setEnquiryfirstName(String enquiryfirstName) {
        this.enquiryfirstName = enquiryfirstName;
    }

    public String getEnquirylastName() {
        return enquirylastName;
    }

    public void setEnquirylastName(String enquirylastName) {
        this.enquirylastName = enquirylastName;
    }

    public String getEnquiryEmail() {
        return enquiryEmail;
    }

    public void setEnquiryEmail(String enquiryEmail) {
        this.enquiryEmail = enquiryEmail;
    }

    public String getEnquirycontactNo() {
        return enquirycontactNo;
    }

    public void setEnquirycontactNo(String enquirycontactNo) {
        this.enquirycontactNo = enquirycontactNo;
    }

    public Date getEnquiryaddedDate() {
        return enquiryaddedDate;
    }

    public void setEnquiryaddedDate(Date enquiryaddedDate) {
        this.enquiryaddedDate = enquiryaddedDate;
    }

    public String getEnquiryMessage() {
        return enquiryMessage;
    }

    public void setEnquiryMessage(String enquiryMessage) {
        this.enquiryMessage = enquiryMessage;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public Enquirystatus getEnquirystatus() {
        return enquirystatus;
    }

    public void setEnquirystatus(Enquirystatus enquirystatus) {
        this.enquirystatus = enquirystatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enquiryId != null ? enquiryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquiry)) {
            return false;
        }
        Enquiry other = (Enquiry) object;
        if ((this.enquiryId == null && other.enquiryId != null) || (this.enquiryId != null && !this.enquiryId.equals(other.enquiryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leapfrog.enquirymanager.entity.Enquiry[ enquiryId=" + enquiryId + " ]";
    }
    
}
