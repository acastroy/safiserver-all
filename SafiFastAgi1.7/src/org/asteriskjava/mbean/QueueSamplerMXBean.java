package org.asteriskjava.mbean;


public interface QueueSamplerMXBean { 
    public QueueSample getQueueSample(); 
    public void clearQueue(); 
} 