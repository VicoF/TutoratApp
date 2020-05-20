
-- TRIGGERS --

CREATE OR REPLACE FUNCTION verifie_insertion_reservation()
RETURNS TRIGGER AS
$$
BEGIN
	if NEW.statut_id = 1 AND EXISTS
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
	
	RETURN NEW;
END;
LANGUAGE 'plpgsql';

CREATE TRIGGER verifie_insertion_reservation_bit
BEFORE INSERT ON inscription
FOR EACH ROW
EXECUTE PROCEDURE verifie_insertion_reservation();