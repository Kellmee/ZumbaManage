package com.zumba.model;

public class Participant {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
	public Participant() {
        
    }

    public Participant(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    

    public int getId() {
        return id;
    }

    public void setId(long id) {
        this.id = (int) id; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    
   

    	public void setBatchId(long batchId) {
    	}


	public String getEmail() {
	
		return null;
	}

	public String getPhone() {
		
		return null;
	}
}
