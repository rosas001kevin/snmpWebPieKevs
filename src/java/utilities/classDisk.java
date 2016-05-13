/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Nataniel
 */
public class classDisk {
    public String StorageIndex;
    public String StorageType;
    public String StorageDescr;
    public long StorageAllocationUnits;
    public long StorageSize;
    public long StorageUsed;
    public long StorageAllocationFailures;
    public classDisk(String a){
        StorageIndex = a;
    }
    
    public classDisk(){
        
    }
    
}
