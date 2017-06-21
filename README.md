# Pleo React Challenge

You are given a vector of heights, these heights form a structure like shown in the following figure.
 
![Figure 1](https://github.com/pleo-io/react-challenge/blob/master/figure1.png?raw=true "Figure 1")
 
It is raining over the structure.  The water in one cell always flows to the neighboring cell of least height if it is not already occupied by water or a block. A sink is a cell with the property that water never flows away from it. All the neighboring cells that drains into a sink are said to form a basin. 
 
![Figure 2](https://github.com/pleo-io/react-challenge/blob/master/figure2.png?raw=true "Figure 2")
 
Observe that the structure is thereby partitioned into basins. Determine the number of unit of water contained in all basins.
In the exemple the input for this program is
[2, 5, 1, 3, 1, 2, 1, 7, 7, 6] and it should output 17
 
The goal is to create the most optimal algorithm that given any array will output the correct units of water.
 
Also we would like to see this represented visually using a React application with a UI for entering values and seeing the solution.

Please fork this repo and make your solution there so we can track your solution.
We want to see your progression through commits (so don’t commit the entire solution in 1 commit), edit the README.md explaining your solution and the app.
