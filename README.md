# dominograph


##Introduction

Ce programe nous permet de construire un graphe de dominos pour un langage fini.

##Lancer le programme

java -jar domino-v1.2.jar

##Exemple 
 * Input: a ab ba 
 * Output: 
>digraph G { 1 [ label="open/" ]; 2 [ label="/close" ]; 3 [ label="/a" ]; 4 [ label="b/" ]; 5 [ label="ba/" ]; 1 -> 3 [ label="0/" ]; 5 -> 2 [ label="2/" ]; 4 -> 5 [ label="/0" ]; 3 -> 4 [ label="/1" ]; 4 -> 3 [ label="2/" ]; }

>File: myFile.dot

##Remarques

* Output du programme est un graphe présenté par [le langage DOT](http://fr.wikipedia.org/wiki/DOT_(langage))

* On peut utiliser le programme Graphviz pour visualiser ce langage DOT.

