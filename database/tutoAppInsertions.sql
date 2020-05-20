
-- INSERTION DES STATUTS

INSERT INTO statut(statut_id, statut_nom) VALUES(0, 'mentore');
INSERT INTO statut(statut_id, statut_nom) VALUES(1, 'mentor');
INSERT INTO statut(statut_id, statut_nom) VALUES(3, 'enseignant');

-- INSERTION DES PRIVILEGES

INSERT INTO privilege(privilege_id, privilège_nom) 
VALUES(0, 'Peut voter exercice');
INSERT INTO privilege(privilege_id, privilège_nom) 
VALUES(1, 'Peut approuver exercice');
INSERT INTO privilege(privilege_id, privilège_nom) 
VALUES(2, 'Peut planifier Reunion');
INSERT INTO privilege(privilege_id, privilège_nom) 
VALUES(3, 'Peut ajouter exercice');
INSERT INTO privilege(privilege_id, privilège_nom) 
VALUES(4, 'Peut enlever exercice');
INSERT INTO privilege(privilege_id, privilège_nom) 
VALUES(5, 'Peut mentore');
INSERT INTO privilege(privilege_id, privilège_nom) 
VALUES(6, 'Peut supprimer une reunion');

-- RELATION IMPLIQUEPRIVILEGE

INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(0, 1);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(0, 3);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(1, 0);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(1, 2);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(1, 3);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(1, 4);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(1, 6);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(2, 0);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(2, 1);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(2, 6);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(2, 4);
INSERT INTO impliqueprivileges(statut_id, privilege_id) 
VALUES(2, 3);

-- INSERTION DES SESSIONS

INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(1, 'Genie Informatique', 'INTRODUCTION AU GENIE ELECTRIQUE ET AU GÉNIE INFORMATIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(2, 'Genie Informatique', 'SYSTEMES INFORMATIQUES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(3, 'Genie Informatique', 'SYSTEMES DISTRIBUES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(4, 'Genie Informatique', 'SYSTEMES ORDINES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(5, 'Genie Informatique', 'MODELISATION ET SIMULATION');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(6, 'Genie Informatique', 'OBJETS CONNECTES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(7, 'Genie Informatique', 'PROJET MAJEUR EN GENIE INFORMATIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(8, 'Genie Informatique', 'PROJET MAJEUR EN GENIE INFORMATIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(1, 'Genie Electrique', 'INTRODUCTION AU GENIE ELECTRIQUE ET AU GENIE INFORMATIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(2, 'Genie Electrique', 'SYSTEMES INFORMATIQUES ET ELECTRONIQUES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(3, 'Genie Electrique', 'SYSTEMES ELECTRIQUES ET ELECTRONIQUES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(4, 'Genie Electrique', 'SYSTEMES EMBARQUES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(5, 'Genie Electrique', 'SYSTEMES ET CIRCUITS NUMERIQUES');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(6, 'Genie Electrique', 'ELECTRONIQUE ET TELECOMMUNICATIONS');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(7, 'Genie Electrique', 'PROJET MAJEUR EN GENIE ELECTRIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(8, 'Genie Electrique', 'PROJET MAJEUR EN GENIE ELECTRIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(1, 'Genie Robotique', 'INTRODUCTION A LA ROBOTIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(2, 'Genie Robotique', 'ROBOTIQUE INDUSTRIELLE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(3, 'Genie Robotique', 'MOBILITE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(4, 'Genie Robotique', 'INTERACTION AVEC L\’ENVIRONNEMENT');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(5, 'Genie Robotique', 'ASSERVISSEMENT ET CONTROLE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(6, 'Genie Robotique', 'ROBOTISATION');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(7, 'Genie Robotique', 'PROJET EN GENIE ROBOTIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme, nom)
VALUES(8, 'Genie Robotique', 'PROJET EN GENIE ROBOTIQUE');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(1, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(2, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(3, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(4, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(5, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(6, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(7, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(8, 'Genie Civil');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(1, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(2, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(3, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(4, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(5, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(6, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(7, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(8, 'Genie Batiment');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(1, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(2, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(3, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(4, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(5, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(6, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(7, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(8, 'Genie Chimique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(1, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(2, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(3, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(4, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(5, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(6, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(7, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(8, 'Genie Biotechnologique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(1, 'Genie Mecanique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(2, 'Genie Mecanique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(3, 'Genie Mecanique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(4, 'Genie Mecanique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(5, 'Genie Mecanique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(6, 'Genie Mecanique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(7, 'Genie Mecanique');
INSERT INTO sessionuniversitaire(session_numero, session_programme)
VALUES(8, 'Genie Mecanique');

-- Etudiants Tests

INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('leca2312', 'Leclerc', 'Alexandre', 'Alexandre.Leclerc4@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('dioj2117', 'Dionne', 'Joey', 'Joey.Dionne@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('libv2001', 'Libioulle', 'Valentin', 'Valentin.Libioulle@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('cars2019', 'Carrier', 'Simon', 'Simon.G.Carrier@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('jutj2701', 'Juteau', 'Jean-Michel', 'Jean-Michel.Juteau@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('boug2128', 'Boucher', 'Gabriel', 'Gabriel.Boucher@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('colp2502', 'Collin', 'Philippe', 'Philippe.Collin@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('brid2302', 'Briand', 'Danik', 'Danik.Briand@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('alle2004', 'Allard', 'Emeri', 'Emeri.Allard@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('mate2002', 'Matte', 'Eric', 'Eric.Matte@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('lusf1702', 'Lussier', 'Francis', 'Francis.Lussier2@USherbrooke.ca');
INSERT INTO utilisateur(cip, nom, prenom, email)
VALUES('lapf2312', 'Lapalme', 'Felix', 'Felix.Lapalme@USherbrooke.ca');

-- Cours Tests

INSERT INTO cours(cours_id, cours_nom)
VALUES(0, 'GIF310');
INSERT INTO cours(cours_id, cours_nom)
VALUES(1, 'GIF320');
INSERT INTO cours(cours_id, cours_nom)
VALUES(2, 'GIF360');
INSERT INTO cours(cours_id, cours_nom)
VALUES(3, 'GIF362');
INSERT INTO cours(cours_id, cours_nom)
VALUES(4, 'GIF331');
INSERT INTO cours(cours_id, cours_nom)
VALUES(5, 'GIF301');
INSERT INTO cours(cours_id, cours_nom)
VALUES(6, 'GIF340');
INSERT INTO cours(cours_id, cours_nom)
VALUES(7, 'GIF301');
INSERT INTO cours(cours_id, cours_nom)
VALUES(8, 'GEN280');
INSERT INTO cours(cours_id, cours_nom)
VALUES(9, 'GEN400');
INSERT INTO cours(cours_id, cours_nom)
VALUES(10, 'GEN400');
INSERT INTO cours(cours_id, cours_nom)
VALUES(11, 'GEN180');
INSERT INTO cours(cours_id, cours_nom)
VALUES(12, 'GEN171');
INSERT INTO cours(cours_id, cours_nom)
VALUES(13, 'GEN122');
INSERT INTO cours(cours_id, cours_nom)
VALUES(14, 'GEN390');
INSERT INTO cours(cours_id, cours_nom)
VALUES(15, 'GEN350');
INSERT INTO cours(cours_id, cours_nom)
VALUES(16, 'GEN332');
INSERT INTO cours(cours_id, cours_nom)
VALUES(17, 'GEN380');
INSERT INTO cours(cours_id, cours_nom)
VALUES(18, 'GEN371');
INSERT INTO cours(cours_id, cours_nom)
VALUES(19, 'GEN302');






