package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Jumelage;
import ca.usherbrooke.gegi.server.business.Note;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface NoteMapper {

    void insertNote(@Param("cip") String cip, @Param("statut_id") int statutId,
                        @Param("cours_id") String coursId, @Param("donnee_par") String donneurCip,
                            @Param("note") int note, @Param("commentaire") String commentaire);

    List<Note> select(@Param("cip") String cip, @Param("statut_id") int statutId,
                      @Param("cours_id") String coursId, @Param("donnee_par") String donneurCip,
                      @Param("note") int note, @Param("commentaire") String commentaire);

    void deleteNote(@Param("cip") String cip, @Param("statut_id") int statutId,
                        @Param("cours_id") String coursId, @Param("donnee_par") String donneurCip,
                            @Param("note") int note, @Param("commentaire") String commentaire);
}
