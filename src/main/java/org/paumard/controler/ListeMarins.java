package org.paumard.controler;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.paumard.ejb.MarinEJB;
import org.paumard.model.Marin;


@Named("listeMarins")
@RequestScoped
public class ListeMarins implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private transient MarinEJB marinEJB ;
	private List<Marin> liste;
	private Marin marin;
	
	@PostConstruct
	private void init()
	{
		Map<String, String> map=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (map.get("deleteId") != null) {
			Long id = Long.parseLong(map.get("deleteId")) ;
			marinEJB.removeMarin(id);
		}
		System.out.println("Lecture de la liste des marins");
		liste=marinEJB.getAllMarin();
	}
	
	public String remove(Marin marin) {
		
		System.out.println("Effacement d'un marin");
		marinEJB.removeMarin(marin.getId());
		init() ;
		return "listedemarins.xhtml" ;
	}
	
	
	public List<Marin> getListe() {
		return liste;
	}
	public void setListe(List<Marin> liste) {
		this.liste = liste;
	}
	public Marin getMarin() {
		return marin;
	}
	public void setMarin(Marin marin) {
		this.marin = marin;
	}
	
	

}


/*
<!--  
<h:form>
	<h:commandLink value="X" action="#{listeMarins.remove(marin)}"/>
</h:form>
-->
*/