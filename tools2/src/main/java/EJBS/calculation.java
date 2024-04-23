package EJBS;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity

public class calculation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int Number1,Number2,Result;
	private String operation;
	public calculation()
	{}
	public void setOperation(String operation)
	{
		this.operation=operation;
	}
	
	public void setNumber1(int num)
	{
		this.Number1=num;
	}
	
	public void setNumber2(int num)
	{
		this.Number2=num;
	}
	
	public void setResult(int result)
	{
		this.Result=result;
	}
	
	public String GetOperation()
	{
		return this.operation;
	}
	
	public int GetNumber1()
	{
		return this.Number1;
	}
	
	public int GetNumber2()
	{
		return this.Number2;
	}
	
	public int GetResult()
	{
		return this.Result;
	}
	
}