package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Utilisateur;


import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;


import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface UtilisateurMapper {

    List<Utilisateur> select(@Param("cip") String cip);


}
