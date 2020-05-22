
-- TRIGGERS --

-- INSERTION DANS INSCRIPTION
CREATE OR REPLACE FUNCTION verifie_insertion_inscription()
RETURNS TRIGGER AS
$$
BEGIN
	IF EXISTS
	(
		SELECT *
		FROM inscription
		WHERE cip = NEW.cip AND statut_id = NEW.statut_id AND cours_id = NEW.cours_id
	) THEN
		RAISE EXCEPTION 'Vous ne pouvez vous inscrire, Vous etes deja inscrit en tant que %'
		, (SELECT statut_nom FROM statut WHERE statut_id = NEW.statut_id);
	END IF;
	
	IF NEW.statut_id = 1 AND EXISTS
	(
		SELECT *
		FROM inscription
		WHERE statut_id = 0 AND cip = NEW.cip AND cours_id = NEW.cours_id
	) THEN
		RAISE EXCEPTION 'Vous ne pouvez vous inscrire en tant que mentor pour un cours
						Dont vous etes mentore';
	ELSIF NEW.statut_id = 0 AND EXISTS
	(
		SELECT *
		FROM inscription
		WHERE statut_id = 1 AND cip = NEW.cip
	) THEN
		RAISE EXCEPTION 'Vous ne pouvez vous inscrire en tant que mentore pour un cours
						Dont vous etes mentor';
	END IF;
	
	IF NOT EXISTS
	(
		SELECT *
		FROM sessionuniversitaire
		WHERE session_id = NEW.session_id
	) THEN
		RAISE EXCEPTION 'ERREUR, Cette session nexiste pas';
	ELSIF NOT EXISTS
	(
		SELECT *
		FROM cours
		WHERE cours_id = NEW.cours_id
	) THEN
		RAISE EXCEPTION 'ERREUR, Cette session nexiste pas';
	
	END IF;
	
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER verifie_insertion_inscription_bit
BEFORE INSERT ON inscription
FOR EACH ROW
EXECUTE PROCEDURE verifie_insertion_inscription()

--MODIFICATION DE VOTE

CREATE OR REPLACE FUNCTION upvote(utilisateur_cip CHAR(8), exercice_a_voter INTEGER)
    RETURNS void AS
$$
BEGIN
    IF EXISTS
        (
            SELECT *
            FROM voteexercice
            WHERE cip = utilisateur_cip AND exercice_id = exercice_a_voter
        ) THEN
        RAISE EXCEPTION 'Vous avez deja voter pour cette exercice. Vous ne pouvez voter une deuxieme fois';
    ELSE
        UPDATE exercice
        SET exercice_vote = exercice_vote + 1
        WHERE exercice_id = exercice_a_voter;
        
        INSERT INTO voteexercice(cip, exercice_id)
        VALUES(utilisateur_cip, exercice_a_voter); 
    END IF;
END;
$$
LANGUAGE 'plpgsql'

--Approbation dun exercice

CREATE OR REPLACE FUNCTION approve_exercice (utilisateur_cip CHAR(8), exercice_a_approuve INTEGER)
RETURNS VOID AS
$$
BEGIN
	IF EXISTS
	(
		SELECT exercice_est_approuve 
		FROM exercice
		WHERE exercice_est_approuve AND exercice_id = exercice_a_approuve
	) THEN
		RAISE NOTICE 'Cet exercice est deja approuve';
	ELSIF 2 IN
	(
		SELECT statut_id
		FROM inscription
		WHERE cip = utilisateur_cip
	) THEN
		UPDATE exercice
		SET exercice_est_approuve = 1
		WHERE exercice_id = exercice_a_approuve;
	ELSE
		RAISE EXCEPTION 'Vous ne posseder pas le droit dapprouve un exercice';
	END IF;
END;
$$
LANGUAGE 'plpgsql'

-- TRIGGER POUR LAPPROBATION

CREATE OR REPLACE FUNCTION verifie_approbation()
RETURNS TRIGGER AS
$$
BEGIN
	IF 2 NOT IN 
	(
		SELECT statut_id
		FROM inscription
		WHERE cip = NEW.cip
	) THEN
		RAISE EXCEPTION 'Vous ne posseder pas le droit dapprouve un exercice';
	END IF;
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER verifie_approbation_but
BEFORE UPDATE OF exercice_est_approuve ON exercice
FOR EACH ROW
EXECUTE PROCEDURE verifie_approbation();