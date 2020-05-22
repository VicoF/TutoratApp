package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Utilisateur;

import ca.usherbrooke.gegi.server.business.SessionUniversitaire;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;


import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface EtudiantMapper {

    List<Utilisateur> select(@Param("id") Integer id);
    void insertSessionUniversitaire(@Param("sessionuniversitaire") SessionUniversitaire session);
}
