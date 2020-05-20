CREATE TABLE Utilisateur
(
  cip CHAR(8) NOT NULL,
  nom VARCHAR(64) NOT NULL,
  prenom VARCHAR(64) NOT NULL,
  email VARCHAR(64) NOT NULL,
  note INT NOT NULL,
  PRIMARY KEY (cip)
);

CREATE TABLE Statut
(
  statut_id INT NOT NULL,
  statut_nom VARCHAR(64) NOT NULL,
  PRIMARY KEY (statut_id)
);

CREATE TABLE Privilege
(
  privilege_id INT NOT NULL,
  privilège_nom VARCHAR(64) NOT NULL,
  PRIMARY KEY (privilege_id)
);

CREATE TABLE Cours
(
  cours_id INT NOT NULL,
  cours_nom VARCHAR(64) NOT NULL,
  PRIMARY KEY (cours_id)
);

CREATE TABLE Session
(
  session_id INT NOT NULL,
  session_nom VARCHAR(64) NOT NULL,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  PRIMARY KEY (session_id)
);

CREATE TABLE Exercice
(
  exercice_id INT NOT NULL,
  exercice_nom VARCHAR(128) NOT NULL,
  exercice_lien VARCHAR(128) NOT NULL,
  exercice_estApprouve INT NOT NULL,
  exercice_vote INT NOT NULL,
  cours_id INT NOT NULL,
  ajoute_par CHAR(8) NOT NULL,
  PRIMARY KEY (exercice_id),
  FOREIGN KEY (cours_id) REFERENCES Cours(cours_id),
  FOREIGN KEY (ajoute_par) REFERENCES Utilisateur(cip)
);

CREATE TABLE Inscription
(
  statut_id INT NOT NULL,
  session_id INT NOT NULL,
  cip CHAR(8) NOT NULL,
  cours_id INT NOT NULL,
  PRIMARY KEY (statut_id, session_id, cip, cours_id),
  FOREIGN KEY (statut_id) REFERENCES Statut(statut_id),
  FOREIGN KEY (session_id) REFERENCES Session(session_id),
  FOREIGN KEY (cip) REFERENCES Utilisateur(cip),
  FOREIGN KEY (cours_id) REFERENCES Cours(cours_id)
);

CREATE TABLE Jumelage
(
  cours_id INT NOT NULL,
  mentor CHAR(8) NOT NULL,
  mentore_par CHAR(8) NOT NULL,
  PRIMARY KEY (cours_id, mentor, mentore_par),
  FOREIGN KEY (cours_id) REFERENCES Cours(cours_id),
  FOREIGN KEY (mentor) REFERENCES Utilisateur(cip),
  FOREIGN KEY (mentore_par) REFERENCES Utilisateur(cip)
);

CREATE TABLE VoteExercice
(
  cip CHAR(8) NOT NULL,
  exercice_id INT NOT NULL,
  PRIMARY KEY (cip, exercice_id),
  FOREIGN KEY (cip) REFERENCES Utilisateur(cip),
  FOREIGN KEY (exercice_id) REFERENCES Exercice(exercice_id)
);

CREATE TABLE implique_privilges
(
  statut_id INT NOT NULL,
  privilege_id INT NOT NULL,
  PRIMARY KEY (statut_id, privilege_id),
  FOREIGN KEY (statut_id) REFERENCES Statut(statut_id),
  FOREIGN KEY (privilege_id) REFERENCES Privilege(privilege_id)
);