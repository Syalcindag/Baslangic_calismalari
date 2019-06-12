/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package button;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sefa
 */
@Entity
@Table(name = "\u00dcYELER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "\u00dcyeler.findAll", query = "SELECT \u00fc FROM \u00dcyeler \u00fc")
    , @NamedQuery(name = "\u00dcyeler.findById", query = "SELECT \u00fc FROM \u00dcyeler \u00fc WHERE \u00fc.id = :id")
    , @NamedQuery(name = "\u00dcyeler.findByAd", query = "SELECT \u00fc FROM \u00dcyeler \u00fc WHERE \u00fc.ad = :ad")
    , @NamedQuery(name = "\u00dcyeler.findBySoyad", query = "SELECT \u00fc FROM \u00dcyeler \u00fc WHERE \u00fc.soyad = :soyad")})
public class Üyeler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "AD")
    private String ad;
    @Basic(optional = false)
    @Column(name = "SOYAD")
    private String soyad;

    public Üyeler() {
    }

    public Üyeler(Integer id) {
        this.id = id;
    }

    public Üyeler(Integer id, String ad, String soyad) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Üyeler)) {
            return false;
        }
        Üyeler other = (Üyeler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "button.\u00dcyeler[ id=" + id + " ]";
    }
    
}
