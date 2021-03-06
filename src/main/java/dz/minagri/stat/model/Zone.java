package dz.minagri.stat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import dz.minagri.stat.util.Identifiable;

@Entity
@Table(name = "zone")
public class Zone extends Identifiable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2413461820531944335L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Version
	private int version;

	private String name;

	private String remarque;
	
	@ManyToOne()
	@JoinColumn(name = "commune_id", nullable = false)
	private Commune commune;
	
	@OneToMany(mappedBy = "zone", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Exploitation> exploitations = new ArrayList<Exploitation>() ;

	@OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
	private List<CarteFellah> carteFellahs= new ArrayList<CarteFellah>() ;

	public Zone() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the remarque
	 */
	public String getRemarque() {
		return remarque;
	}

	/**
	 * @param remarque the remarque to set
	 */
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	/**
	 * @return the commune
	 */
	public Commune getCommune() {
		return commune;
	}

	/**
	 * @param commune the commune to set
	 */
	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public Long getId() {
		return id;
	}


	public List<Exploitation> getExploitations() {
		return exploitations;
	}

	public void setExploitations(List<Exploitation> exploitations) {
		this.exploitations = exploitations;
	}

	public void addExploitation(Exploitation exploitation) {
		exploitation.setZone(this);
		exploitations.add(exploitation);
	}
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
	 * @return the carteFellahs
	 */
	public List<CarteFellah> getCarteFellahs() {
		return carteFellahs;
	}

	/**
	 * @param carteFellahs the carteFellahs to set
	 */
	public void setCarteFellahs(List<CarteFellah> carteFellahs) {
		this.carteFellahs = carteFellahs;
	}

	public void addCaretfellah(CarteFellah careteFellah) {
		careteFellah.setZone(this);
		carteFellahs.add(careteFellah);
	}

	@Override
	public Class<?> getConcreteClass() {
		return Zone.class;
	}

	
}
