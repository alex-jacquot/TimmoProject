/** BienManager.java
 * 
 * 
 * Note : Mandat is a immaterial link between a Client and a Bien, only both ids are shared taht are then used by associated Manager classes
 * 
 * @author Alex Jacquot
 * */

package agence;

import java.util.Date;

import clients.Client;

public class Mandat {

	int idClient;
	int idBien;
	int prix;
	Date dateLimite;

	public Mandat(int idClient, int idBien, int prix, Date dateLimite) {
		this.idClient = idClient;
		this.idBien = idBien;
		this.prix = prix;
		this.dateLimite = dateLimite;
	}
}
