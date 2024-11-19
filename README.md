# Forest Fire Simulation

This program creates a simulated forest fire through a "lightning strike" and certain density of trees. The fire from the lightning spread the fire outwards until it burns the entire forest or gets stopped from the lack of density of trees.


## Simulator Class
A pixel on the grid has four different states it can be in.
1. _WHITE_
2. _TREE_
3. _FIRE_
4. _ASH_

These different states determine how the fire will affect the pixel in the forest fire grid.\
**_WHITE_** - There is no _TREE_ present in the pixel on the grid and therefore _FIRE_ cannot spread here\
**_TREE_** - A _FIRE_ can spread here if an adjacent pixel is on _FIRE_\
**_FIRE_** - If the adjacent pixel is on _FIRE_, this will convert a _TREE_ to _FIRE_. The _TREE_ that got struck by lightning at the start to initiate the forest fire will start out as _FIRE_\
**_ASH_** - After a _TREE_ is on _FIRE_, it turns to _ASH_

## Monte Carlo Simulation
This program runs a Monte Carlo simulation on how different densities affect the percentage of forest burned. This Monte Carlo simulation will vary the density of the forest in the grid from 1.0 to 100.0. THen it will run the simulation for the density and print out the percentage of forest burned after.
