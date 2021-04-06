package edu.github.bean;


public class Worker /* extends Persion */ implements Comparable<Worker>/* 鎸囧畾姣旇緝瀵硅薄 */{
    private String name;
    private int age;
    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Worker() {
        super();
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){//实现功能,写自己的内容
        return "worker"+"----"+this.getName()+":"+this.getAge();
    }   
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
        //return name.hashCode()+age*31;相当于这样
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/* @Override */
    /* public int compareTo(Worker o) {         */
    /*     Worker wo=/* (Worker) *///compareable<>指定了泛型,就省略强转动作 */
    /*     int temp=this.age-wo.age;//数据 */
    /*     return temp==0?this.name.compareTo(wo.name):temp; */
    /* } */
    @Override
    public int compareTo(Worker o) {
        // TODO Auto-generated method stub
        
        return 0;
    }
    
}
