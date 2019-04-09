/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crips;

/**
 *
 * @author EJ Ortega
 */
public class Data {
    
    private String algo, fileSize;
    private double speed;
    private long memoryBefore, memoryAfter, security;
    
    public Data(String algo, String fileSize, double speed, long memoryBefore, long memoryAfter, long security){
        this.algo = algo;
        this.fileSize = fileSize;
        this.speed = speed;
        this.memoryBefore = memoryBefore;
        this.memoryAfter = memoryAfter;
        this.security=security;
    }
    public String getAlgo(){
        return this.algo;
    }
    
    public String getFileSize(){
        return this.fileSize;
    }
    
    public double getSpeed(){
        return this.speed;
    }
    
    
    public long getMemoryBefore(){
        return this.memoryBefore;
    }
   
    public long getMemoryAfter(){
        return this.memoryAfter;
    }
    
    public long getSecurity() {
        return this.security;
    }
}
