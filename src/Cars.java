/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class Cars {
    Intersection src;
    Intersection dst;
    Intersection[] path;
    
    Cars(CityMap map){
        src=map.getrandom(); 
        dst=map.getrandom();
        while(src==dst){
            dst=map.getrandom()
        }
        path=map.dijkstra(src,dst);
    }
}
