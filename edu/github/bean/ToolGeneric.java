package edu.github.bean;

public class ToolGeneric<Craze> {
    private Craze c;

	public Craze getC() {
		return c;
	}

	public void setC(Craze c) {
		this.c = c;
	}
    /**
     * 将泛型定义在方法上,来接收任意对象
     * @param <w>
     * @param c
     */
    public <w>/* 定义泛型 */ void  show(w/* 使用泛型 */ c){
        System.out.println("show"+c.toString());
    }
    public void print(Craze c){
        
        
        System.out.println("print"+c.toString());
    }
    /**
     * 当方法静态时,不能访问类中定义的泛型craze.如果要在被静态修饰的方法中使用泛型,只能将泛型定义在方法上
     * @param c
     */
    public static <w> void method(w c){
        System.out.println("method"+c);
    }
    

    
}
