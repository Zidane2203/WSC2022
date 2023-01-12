/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ktp_20190140083.project;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yusuf
 */
@Entity
@Table(name = "kartutandapenduduk")
@NamedQueries({
    @NamedQuery(name = "Kartutandapenduduk.findAll", query = "SELECT k FROM Kartutandapenduduk k"),
    @NamedQuery(name = "Kartutandapenduduk.findById", query = "SELECT k FROM Kartutandapenduduk k WHERE k.id = :id"),
    @NamedQuery(name = "Kartutandapenduduk.findByNama", query = "SELECT k FROM Kartutandapenduduk k WHERE k.nama = :nama"),
    @NamedQuery(name = "Kartutandapenduduk.findByNik", query = "SELECT k FROM Kartutandapenduduk k WHERE k.nik = :nik"),
    @NamedQuery(name = "Kartutandapenduduk.findByAlamat", query = "SELECT k FROM Kartutandapenduduk k WHERE k.alamat = :alamat")})
public class Kartutandapenduduk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Nama")
    private String nama;
    @Column(name = "NIK")
    private String nik;
    @Column(name = "Alamat")
    private String alamat;

    public Kartutandapenduduk() {
    }

    public Kartutandapenduduk(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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
        if (!(object instanceof Kartutandapenduduk)) {
            return false;
        }
        Kartutandapenduduk other = (Kartutandapenduduk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ktp_20190140083.project.Kartutandapenduduk[ id=" + id + " ]";
    }
    
}
