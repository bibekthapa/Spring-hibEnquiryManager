/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.enquirymanager.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "enquirystatus")
@NamedQueries({
    @NamedQuery(name = "Enquirystatus.findAll", query = "SELECT e FROM Enquirystatus e")})
public class Enquirystatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enquirystatus_id")
    private Integer enquirystatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enquirystatus_type")
    private String enquirystatusType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "enquirystatus_color")
    private String enquirystatusColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enquirystatus")
    private List<Enquiry> enquiryList;

    public Enquirystatus() {
    }

    public Enquirystatus(Integer enquirystatusId) {
        this.enquirystatusId = enquirystatusId;
    }

    public Enquirystatus(Integer enquirystatusId, String enquirystatusType, String enquirystatusColor) {
        this.enquirystatusId = enquirystatusId;
        this.enquirystatusType = enquirystatusType;
        this.enquirystatusColor = enquirystatusColor;
    }

    public Integer getEnquirystatusId() {
        return enquirystatusId;
    }

    public void setEnquirystatusId(Integer enquirystatusId) {
        this.enquirystatusId = enquirystatusId;
    }

    public String getEnquirystatusType() {
        return enquirystatusType;
    }

    public void setEnquirystatusType(String enquirystatusType) {
        this.enquirystatusType = enquirystatusType;
    }

    public String getEnquirystatusColor() {
        return enquirystatusColor;
    }

    public void setEnquirystatusColor(String enquirystatusColor) {
        this.enquirystatusColor = enquirystatusColor;
    }

    public List<Enquiry> getEnquiryList() {
        return enquiryList;
    }

    public void setEnquiryList(List<Enquiry> enquiryList) {
        this.enquiryList = enquiryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enquirystatusId != null ? enquirystatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquirystatus)) {
            return false;
        }
        Enquirystatus other = (Enquirystatus) object;
        if ((this.enquirystatusId == null && other.enquirystatusId != null) || (this.enquirystatusId != null && !this.enquirystatusId.equals(other.enquirystatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leapfrog.enquirymanager.entity.Enquirystatus[ enquirystatusId=" + enquirystatusId + " ]";
    }
    
}
