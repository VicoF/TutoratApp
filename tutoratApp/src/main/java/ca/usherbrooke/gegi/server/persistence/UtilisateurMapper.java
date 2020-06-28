package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Inscription;
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

    List<Inscription> getInscriptions(@Param("statut_id") int statutId,@Param("session_id") String session_id,@Param("cip") String cip, @Param("cours_id")String coursId );

    void insertInscription(@Param("statut_id") int statutId, @Param("session_id") String sessionId,
                           @Param("cip") String cip, @Param("cours_id") String coursId);



}
