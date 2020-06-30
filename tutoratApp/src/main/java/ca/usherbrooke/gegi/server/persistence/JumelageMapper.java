package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Jumelage;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface JumelageMapper {

    void insertJumelage(@Param("cours_id") String coursId, @Param("session_id") String sessionId,
                           @Param("etudiant") String etudiantCip, @Param("mentore_par") String mentorCip);

    List<Jumelage> select(@Param("cours_id") String coursId, @Param("session_id") String sessionId,
                                @Param("etudiant") String etudiantCip, @Param("mentore_par") String mentorCip);

    void deleteJumelages(@Param("cours_id") String coursId, @Param("session_id") String sessionId,
                         @Param("etudiant") String etudiantCip, @Param("mentore_par") String mentorCip);
}
