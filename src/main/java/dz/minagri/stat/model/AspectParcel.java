/**
 * 
 */
package dz.minagri.stat.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import dz.minagri.stat.enumeration.EtatMauvHerb;
import dz.minagri.stat.enumeration.EtatSanitaire;
import dz.minagri.stat.enumeration.EtatVegetParcelle;
import dz.minagri.stat.util.Identifiable;

/**
 * @author bellal djamel
 *
 */
@Entity
@Table(name = "aspectparcel")
public class AspectParcel extends Identifiable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6644422942655033827L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Version
	private int version;
	
	@Column(name = "etatsanitaire", nullable = true)
	@Enumerated(EnumType.STRING)
	private EtatSanitaire etatSanitaire;
	
	@Column(name = "etatvegetparcelle", nullable = true)
	@Enumerated(EnumType.STRING)
	private EtatVegetParcelle etatVegetParcelle;
	
	@Column(name = "etatmauvherb", nullable = true)
	@Enumerated(EnumType.STRING)
	private EtatMauvHerb etatmauvherb;

	@Column(name = "record_date",columnDefinition = "DATE")
	private LocalDate recorddate;
	
	@OneToOne()
	@JoinColumn(name = "productionparcel_id", nullable = false)
	private ProductionParcel productionparcel;
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the etatSanitaire
	 */
	public EtatSanitaire getEtatSanitaire() {
		return etatSanitaire;
	}

	/**
	 * @param etatSanitaire the etatSanitaire to set
	 */
	public void setEtatSanitaire(EtatSanitaire etatSanitaire) {
		this.etatSanitaire = etatSanitaire;
	}

	/**
	 * @return the etatVegetParcelle
	 */
	public EtatVegetParcelle getEtatVegetParcelle() {
		return etatVegetParcelle;
	}

	/**
	 * @param etatVegetParcelle the etatVegetParcelle to set
	 */
	public void setEtatVegetParcelle(EtatVegetParcelle etatVegetParcelle) {
		this.etatVegetParcelle = etatVegetParcelle;
	}

	/**
	 * @return the etatmauvherb
	 */
	public EtatMauvHerb getEtatmauvherb() {
		return etatmauvherb;
	}

	/**
	 * @param etatmauvherb the etatmauvherb to set
	 */
	public void setEtatmauvherb(EtatMauvHerb etatmauvherb) {
		this.etatmauvherb = etatmauvherb;
	}

	@Override
	public Long getId() {
		return id;
	}
	

	/**
	 * @return the recorddate
	 */
	public LocalDate getRecorddate() {
		return recorddate;
	}

	/**
	 * @param recorddate the recorddate to set
	 */
	public void setRecorddate(LocalDate recorddate) {
		this.recorddate = recorddate;
	}

	/**
	 * @return the productionparcel
	 */
	public ProductionParcel getProductionparcel() {
		return productionparcel;
	}

	/**
	 * @param productionparcel the productionparcel to set
	 */
	public void setProductionparcel(ProductionParcel productionparcel) {
		this.productionparcel = productionparcel;
	}

	/* (non-Javadoc)
	 * @see dz.minagri.stat.util.Identifiable#getConcreteClass()
	 */
	@Override
	public Class<?> getConcreteClass() {
		return AspectParcel.class;
	}

}
