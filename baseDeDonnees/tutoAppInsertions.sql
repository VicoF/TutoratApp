
-- INSERTION DES STATUTS

INSERT INTO statut(statut_id, statut_nom) VALUES(0, 'mentore');
INSERT INTO statut(statut_id, statut_nom) VALUES(1, 'mentor');
INSERT INTO statut(statut_id, statut_nom) VALUES(2, 'enseignant');

-- INSERTION DES PRIVILEGES

INSERT INTO privilege(privilege_id, privilege_nom) 
VALUES(0, 'Peut voter exercice');
INSERT INTO privilege(privilege_id, privilege_nom) 
VALUES(1, 'Peut approuver exercice');
INSERT INTO privilege(privilege_id, privilege_nom) 
VALUES(2, 'Peut planifier Reunion');
INSERT INTO privilege(privilege_id, privilege_nom) 
VALUES(3, 'Peut ajouter exercice');
INSERT INTO privilege(privilege_id, privilege_nom) 
VALUES(4, 'Peut enlever exercice');
INSERT INTO privilege(privilege_id, privilege_nom) 
VALUES(5, 'Peut mentore');
INSERT INTO privilege(privilege_id, privilege_nom) 
VALUES(6, 'Peut supprimer une reunion');

-- RELATION IMPLIQUEPRIVILEGE

INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(0, 1);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(0, 3);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(1, 0);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(1, 2);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(1, 3);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(1, 4);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(1, 6);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(2, 0);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(2, 1);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(2, 6);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(2, 4);
INSERT INTO impliqueprivilege(statut_id, privilege_id) 
VALUES(2, 3);

-- INSERTION DES SESSIONS
/*
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
*/

-- INSERTION DE NOUVELLE SESSIONS --

INSERT INTO sessionuniversitaire(session_id, session_nom, date_debut, date_fin)
VALUES('A19', 'automne 2019', '2019-08-26', '2019-12-22');
INSERT INTO sessionuniversitaire(session_id, session_nom, date_debut, date_fin)
VALUES('H20', 'Hivers 2020', '2020-01-07', '2020-04-23');
INSERT INTO sessionuniversitaire(session_id, session_nom, date_debut, date_fin)
VALUES('E20', 'automne 2019', '2020-04-27', '2020-08-10');

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
VALUES('GEN101', 'Resolution de probleme et conception en genie');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GEN111', 'La communication et le travail en equipe');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GEN122', 'Équations différentielles linéaires');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GEN135', 'Circuits electriques I');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GEN136', 'Circuits électriques II');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GEN143', 'Introduction à la programmation');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GEN144', 'Programmation et algorithmes');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GEN145', 'Atelier de programmation');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GIF302', 'Conception dun système informatique distribue');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GIF332', 'Reseaux et protocoles de communication');
INSERT INTO cours(cours_id, cours_nom)
VALUES('GIF350', 'Modeles de conception');


--INSERTION DEXERCICES DE TEST --

INSERT INTO exercice(exercice_nom, exercice_lien, exercice_vote, ajoute_par, cours_id)
VALUES('pythagore', 'hola.com', 0, 'boug2128', 'GEN101');
INSERT INTO exercice(exercice_nom, exercice_lien, exercice_vote, ajoute_par, cours_id)
VALUES('derivee partielle', 'hola.com', 0, 'boug2128', 'GEN143');
INSERT INTO exercice(exercice_nom, exercice_lien, exercice_vote, ajoute_par, cours_id)
VALUES('derivee double', 'hola.com', 0, 'boug2128', 'GEN144');
INSERT INTO exercice(exercice_nom, exercice_lien, exercice_vote, ajoute_par, cours_id)
VALUES('integral triple', 'hola.com', 0, 'boug2128', 'GEN122');
INSERT INTO exercice(exercice_nom, exercice_lien, exercice_vote, ajoute_par, cours_id)
VALUES('gradient', 'hola.com', 0, 'boug2128', 'GIF302');
INSERT INTO exercice(exercice_nom, exercice_lien, exercice_vote, ajoute_par, cours_id)
VALUES('circuit electrique de base', 'hola.com', 0, 'boug2128', 'GIF332');
INSERT INTO exercice(exercice_nom, exercice_lien, exercice_vote, ajoute_par, cours_id)
VALUES('equivalent thevenin', 'hola.com', 0, 'boug2128', 'GIF350');





