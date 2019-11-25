There are two separate projects within this repository.
1. FlyttaFormer.java is a VERY old Java Swing project I did several years before starting my studies at Nackademin.
It's a simply Java Swing program that lets you move shapes around.

2. Polygons: is another Java Swing project I did during the 2019 summer that I'm quite pleased with.
Imagine that you have a grid of 2000x2000 squares. On this grid you randomly throw out 20 points.
A Convex Polygon is a shape drawn with straight lines between points 
"in which no line segment between two points on the boundary ever goes outside the polygon". 
Or how I would phrase it: Where each new line points more inwards towards the center of the shape, compared to it's neighbour lines.
See https://en.wikipedia.org/wiki/Convex_polygon

Here is the question my program solves:
Which is the larget convex polygon that can be made from the 20 randomly distributed points on the 2000x2000x grid, that does NOT contain any other point?

Instructions:
"Nya prickar" to create 20 random points.
"Streck" to create lines between all the points (click again to remove)
"Skapa polygon" to create a random polygon between random points.
"Reset!" to reset ALL shapes, lines and points.
"Create Polygon matrix" creates ALL possible convex polygons among the points. (This might take several seconds)
"Rita nasta polygon" draws the following polygon in the list of all created.
"Rita storsta polygon" draws the Largest polygon out of all created so far. (press create polygon matrix first in order to see the largest possible).
Can be pressed several times to see the 2nd largest, 3rd largest, up to 5th.
"Rita alla" changes between drawing just the latest created polygon or all at once. 

Accidental feature:
Click "nya prickar", click "skapa polygon" 10-20 times, click "rita alla" to display all at once. Then quickly click "streck" for disco mode.

I originally made this program to solve a question on https://projecteuler.net/, a site offering math-related programming practices/riddles.
As such it wasn't originally intended to be read by others. So it's written with result in mind rather than easily-readability. 
Do excuse the swenglish.

