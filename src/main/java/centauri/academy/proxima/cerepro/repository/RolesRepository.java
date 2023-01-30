package centauri.academy.proxima.cerepro.repository;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Roles;

/**
 * 
 * @author maurizio - m.franco@proximanetwork.it
 *
 */
@SessionScoped
public class RolesRepository implements RepositoryInterface {
	
	private Logger logger = LoggerFactory.getLogger("RolesRepository");
	
	public Roles getEntityForTest() {
		logger.info("getEntityForTest - START");
		Roles role = new Roles();
		role.setLabel("label test");
		role.setLevel(2);// TODO ---> generate a random int
		role.setDescription("description test");
		logger.info("getEntityForTest - DEBUG - role: " + role.toString());
		return role;
	}
	
	public List<EntityInterface> findAll() {
		logger.info("findAll - START");
	    return findAll(Roles.class);
	}
	
	public EntityInterface findById(long id) {
		logger.info("findById - START - id: " + id);
		return findById(id, Roles.class); 
	}


	public boolean delete(long id) {
		logger.info("delete - START - id: " + id);
		return delete(Roles.class, id); 
	}
	
	/**
	 *
	 * @return an integer representative of the deleted rows
	 */
	public int deleteAll() {
		logger.info("deleteAll - START");
		return deleteAll(Roles.class);
	}

	

}
