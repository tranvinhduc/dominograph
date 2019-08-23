# Domino Graph

## Introduction

This programe allows us to build a domino graph for a finite language.

## Run the program

java -jar domino-v1.2.jar

## Example 
 * Input: a ab ba 
 * Output: 
>digraph G { 1 [ label="open/" ]; 2 [ label="/close" ]; 3 [ label="/a" ]; 4 [ label="b/" ]; 5 [ label="ba/" ]; 1 -> 3 [ label="0/" ]; 5 -> 2 [ label="2/" ]; 4 -> 5 [ label="/0" ]; 3 -> 4 [ label="/1" ]; 4 -> 3 [ label="2/" ]; }

>File: myFile.dot

## Remarks

* Output of the program is a graph presented by [graph description language](https://en.wikipedia.org/wiki/DOT_(graph_description_language))

* The Graphviz program can be used to visualize this DOT language.
