package API;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EJBS.calculation;

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("calc")
public class calculationService 
{
	@PersistenceContext(unitName="calc")
	private EntityManager entityManager;
	@POST
	public int CreateCalculation(calculation c)
	{
		entityManager.persist(c);
		int result=0;
		String operation=c.GetOperation();
		if(operation.equals("+"))
		{
			result=c.GetNumber1()+c.GetNumber2();
			c.setResult(result);
			return c.GetResult();
		}
		else if(operation.equals("-"))
		{
			result=c.GetNumber1()-c.GetNumber2();
			c.setResult(result);
			return c.GetResult();
		}
		else if(operation.equals("*"))
		{
			result=c.GetNumber1()*c.GetNumber2();
			c.setResult(result);
			return c.GetResult();
		}
		else if(operation.equals("/"))
		{
			result=c.GetNumber1()/c.GetNumber2();
			c.setResult(result);
			return c.GetResult();
		}
		else
		{
			throw new IllegalArgumentException("Invalid operation: " + c.GetOperation());
		}
	}
	
	
	@GET
	@Path("calculations")
	public List<calculation> getCalculation()
	{
		TypedQuery<calculation> query=entityManager.createQuery("SELECT c FROM calculation c",calculation.class);
		List<calculation>Calculation=query.getResultList();
		return Calculation;
	}
	
	
	
	
	
	
	
}
