package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Utilisateur;


import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;


import javax.ws.rs.QueryParam;
import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper

public interface UtilisateurMapper {

    List<Utilisateur> select(@Param("cip") String cip);
    void insertUtilisateur(@Param("cip") String cip, @Param("nom") String nom,
                           @Param("prenom") String prenom, @Param("email") String email);



}
