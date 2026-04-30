#!/bin/bash

# 1. Nettoyage des anciens fichiers compilés
echo "Nettoyage..."
rm -rf bin
mkdir bin

# 2. Compilation de tous les fichiers .java
# On utilise find pour lister tous les fichiers dans controller, model, view, etc.
echo "Compilation en cours..."
javac -d bin $(find main -name "*.java")

# 3. Vérification du succès de la compilation
if [ $? -eq 0 ]; then
    echo "Compilation réussie !"
    echo "Lancement de Lacuna..."
    # 4. Exécution (on suppose que Lacuna est votre classe principale)
    java -cp bin Lacuna
else
    echo "Erreur lors de la compilation."
fi