COMP = javac
exec = java

creationClasse :
	mkdir build
compilation:
	@echo "----------------------------------------------------------"
	@echo "debut de la compilation des fichier .java du fil rouge.."
	@echo "----------------------------------------------------------"
	cd filrouge && $(COMP) -d ../build  -cp ../jar/scheduleio.jar ../filrouge/*.java


debut:
	@echo "----------------------------------------------------------"
	@echo "executions des .classes et affichages du filrouge"
	@echo "----------------------------------------------------------"
	@echo "----------------------premier Main----------------------- "
	cd filrouge && $(exec) -cp ../build:../jar/scheduleio.jar filrouge.Main
	@echo "-------------------fin du premier main-------------------- "
	@echo "----------------------------------------------------------"
	@echo "-----------deuxième main pour les autres testes------------ "
	cd filrouge && $(exec) -cp ../build/:../../jar/scheduleio.jar filrouge.Main2
	@echo "-----------------------------------------------------------"
	@echo "-------------------fin de l'application--------------------- "

all: suppression  creationClasse compilation debut 

suppression:
	rm -rf build
