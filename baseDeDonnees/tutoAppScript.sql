CREATE TABLE utilisateur
(
  cip CHAR(8) NOT NULL,
  nom VARCHAR(64) NOT NULL,
  prenom VARCHAR(64) NOT NULL,
  email VARCHAR(64) NOT NULL,
  PRIMARY KEY (cip)
);

CREATE TABLE statut
(
  statut_id INT NOT NULL,
  statut_nom VARCHAR(64) NOT NULL,
  PRIMARY KEY (statut_id)
);

CREATE TABLE privilege
(
  privilege_id INT NOT NULL,
  privilège_nom VARCHAR(64) NOT NULL,
  PRIMARY KEY (privilege_id)
);

CREATE TABLE cours
(
  cours_id VARCHAR(10) NOT NULL,
  cours_nom VARCHAR(64) NOT NULL,
  PRIMARY KEY (cours_id)
);

/*
CREATE TABLE sessionuniversitaire
(
  session_numero INT NOT NULL,
  session_programme VARCHAR(64),
  PRIMARY KEY (session_numero, session_numero)
)
*/

CREATE TABLE sessionUniversitaire				
(
  session_id CHAR(3) NOT NULL,
  session_nom VARCHAR(64) NOT NULL,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  PRIMARY KEY (session_id)
);

CREATE TABLE exercice
(
  exercice_id SERIAL,
  exercice_nom VARCHAR(128) NOT NULL,
  exercice_lien VARCHAR NOT NULL,
  exercice_est_approuve CHAR(3),
  exercice_vote INT NOT NULL,
  cours_id VARCHAR(10) NOT NULL,
  ajoute_par CHAR(8) NOT NULL,
  PRIMARY KEY (exercice_id),
  FOREIGN KEY (cours_id) REFERENCES cours(cours_id),
  FOREIGN KEY (ajoute_par) REFERENCES utilisateur(cip)
);

/*
CREATE TABLE Inscription
(
  statut_id INT NOT NULL,
  session_numero INT NOT NULL,
  session_programme VARCHAR(64) NOT NULL,
  cip CHAR(8) NOT NULL,
  cours_id CHAR(3) NOT NULL,
  PRIMARY KEY (session_numero, session_programme, cip, cours_id),
  FOREIGN KEY (statut_id) REFERENCES Statut(statut_id),
  FOREIGN KEY (session_numero, session_programme) REFERENCES sessionuniversitaire(session_numero, session_programme),
  FOREIGN KEY (cip) REFERENCES Utilisateur(cip),
  FOREIGN KEY (cours_id) REFERENCES Cours(cours_id)
);
*/

CREATE TABLE inscription
(
  statut_id INT NOT NULL,
  session_id CHAR(3) NOT NULL,
  cip CHAR(8) NOT NULL,
  cours_id VARCHAR(10) NOT NULL,
  note INT,
  PRIMARY KEY (session_id, cip, cours_id, statut_id),
  FOREIGN KEY (statut_id) REFERENCES Statut(statut_id),
  FOREIGN KEY (session_id) REFERENCES SessionUniversitaire(session_id),
  FOREIGN KEY (cip) REFERENCES Utilisateur(cip),
  FOREIGN KEY (cours_id) REFERENCES Cours(cours_id)
);


CREATE TABLE jumelage
(
  cours_id VARCHAR(10) NOT NULL,
  mentor CHAR(8) NOT NULL,
  mentore_par CHAR(8) NOT NULL,
  PRIMARY KEY (cours_id, mentor, mentore_par),
  FOREIGN KEY (cours_id) REFERENCES Cours(cours_id),
  FOREIGN KEY (mentor) REFERENCES Utilisateur(cip),
  FOREIGN KEY (mentore_par) REFERENCES Utilisateur(cip)
);

CREATE TABLE voteExercice
(
  cip CHAR(8) NOT NULL,
  exercice_id INT NOT NULL,
  PRIMARY KEY (cip, exercice_id),
  FOREIGN KEY (cip) REFERENCES Utilisateur(cip),
  FOREIGN KEY (exercice_id) REFERENCES Exercice(exercice_id)
);

CREATE TABLE impliquePrivilege
(
  statut_id INT NOT NULL,
  privilege_id INT NOT NULL,
  PRIMARY KEY (statut_id, privilege_id),
  FOREIGN KEY (statut_id) REFERENCES statut(statut_id),
  FOREIGN KEY (privilege_id) REFERENCES privilege(privilege_id)
);

CREATE TABLE reunion
(
  reunion_id SERIAL,
  mentore CHAR(8) NOT NULL,
  date_debut TIMESTAMP NOT NULL,
  date_fin  TIMESTAMP NOT NULL,
  numero_local INT NOT NULL,
  mentor CHAR(8) NOT NULL,
  PRIMARY KEY (reunion_id),
  FOREIGN KEY (mentor) REFERENCES Utilisateur(cip),
  FOREIGN KEY (mentore) REFERENCES Utilisateur(cip)
);

CREATE TABLE utilisateurCotes
(
	etudiant_cip CHAR(8) NOT NULL,
	cours_id VARCHAR(10) NOT NULL,
	cotes CHAR(3),
	PRIMARY KEY(etudiant_cip, cours_id),
	FOREIGN KEY(etudiant_cip) REFERENCES utilisateur(cip),
	FOREIGN KEY(cours_id) REFERENCES cours(cours_id)
);
