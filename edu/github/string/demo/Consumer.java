package edu.github.string.demo;

public class Consumer implements Runnable{
  private Counter cou;
  Consumer(Counter cou){
    this.cou=cou;  
  }
  public void run(){
      while(true)
      cou.dec( );
  }    
}
