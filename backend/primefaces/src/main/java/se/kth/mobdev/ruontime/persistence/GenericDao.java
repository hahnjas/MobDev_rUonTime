package se.kth.mobdev.ruontime.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;


public class GenericDao<T extends IEntity>  {

  private EntityManager entityManager;

  private Class<T> clazz;

private String tableName;

  /**
   * Default constructor. Use for extend this class.
   */
  @SuppressWarnings(value = "unchecked")
  public GenericDao() {

    Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();

    if (types[0] instanceof ParameterizedType) {
      // If the class has parameterized types, it takes the raw type.
      ParameterizedType type = (ParameterizedType) types[0];
      clazz = (Class<T>) type.getRawType();
    } else {
      clazz = (Class<T>) types[0];
    }
  }

  /**
   * Constructor with given {@link IEntity} implementation. Use for creting DAO without extending
   * this class.
   * 
   * @param clazz class with will be accessed by DAO methods
   */
  @SuppressWarnings(value = "unchecked")
  public GenericDao(Class<T> clazz) {
    this.clazz = clazz;
  }

  /**
   * Set entity manager.
   * 
   * @param entityManager entity manager
   */
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @SuppressWarnings(value = "unchecked")
  public T load(UUID id) throws EntityNotFoundException {
    T entity = get(id);
    if (entity == null) {
     	return null;
    }
    return entity;
  }

  @SuppressWarnings(value = "unchecked")
  public T get(UUID id) {
    return (T) entityManager.find(clazz, id);
  }



  @SuppressWarnings(value = "unchecked")
  public List<T> getAll() {
	  Query query = entityManager.createQuery("SELECT e FROM "+ this.tableName +" e");
	  return (List<T>) query.getResultList();
  }



  public T save(final T object) {
    if (object.getId() != null) {
      return entityManager.merge(object);
    } else {
      entityManager.persist(object);
      return object;
    }
  }

  public void save(final T... objects) {
    for (T object : objects) {
      save(object);
    }
  }



  public void delete(T object) throws UnsupportedOperationException {
//    deleteAll(Arrays.asList(objects), true);
  }


  public void refresh(final T entity) {
    entityManager.refresh(entity);
  }

  public void flushAndClear() {
    entityManager.flush();
    entityManager.clear();
  }




  /**
   * Get entity manager.
   * 
   * @return entity manager
   */
  protected EntityManager getEntityManager() {
    return entityManager;
  }
}
