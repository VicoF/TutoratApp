package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Utilisateur;


import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;


import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
<<<<<<< HEAD:tutoratApp/src/main/java/ca/usherbrooke/gegi/server/persistence/UtilisateurMapper.java
public interface UtilisateurMapper {

    List<Utilisateur> select(@Param("cip") String cip);


=======
public interface EtudiantMapper {
    List<Utilisateur> select(@Param("id") Integer id);
    void insertSessionUniversitaire(@Param("sessionuniversitaire") SessionUniversitaire session);
>>>>>>> master:tutoratApp/src/main/java/ca/usherbrooke/gegi/server/persistence/EtudiantMapper.java
}
