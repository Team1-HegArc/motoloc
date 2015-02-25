/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.motoloc.gestion.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 *
 * @author vincentrobatel
 */
@Entity
@Table(name = "PACK")
@SecondaryTable(name = "PACK_TYPE", pkJoinColumns = @PrimaryKeyJoinColumn(name = "PK_PACK_TYPE", referencedColumnName = "FK_PACK_TYPE"))
public class TarificationPack implements Serializable {
    
    @Id
    @Column(name = "PK_PACK", table = "PACK")
    private Long id;
    
    // TABLE PACK
    @Column(name="BASIC_PRICE", table = "PACK")
    private Double prix_base;
    
    @Column(name="KM_PRICE", table = "PACK")
    private Double prix_km;
    
    // TABLE PACK_TYPE
    @Column(name = "NB_DAYS", table = "PACK_TYPE")
    private int nbJours;
    
    @Column(name="NB_WEEKENDS", table = "PACK_TYPE")
    private int nbWeekends;
    
}
