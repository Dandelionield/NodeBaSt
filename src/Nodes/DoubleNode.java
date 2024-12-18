package Nodes;

/*
 *
 * @author Dandelion
 * 
 */

public class DoubleNode<T> extends Node<T>{

	private DoubleNode<T> previousReference;
	
	public DoubleNode(){
		
		super();
		
		this.previousReference = null;
		
	}
	
	public DoubleNode(T Data){
		
		super(Data);
		
		this.previousReference = null;
		
	}
	
	public DoubleNode(T Data, DoubleNode<T> previousReference, DoubleNode<T> nextReference){
		
		super(Data, nextReference);
		
		this.previousReference = previousReference;
		
	}
	
	public void setNextReference(DoubleNode<T> nextReference){
		
		super.setReference(nextReference);
		
	}
	
	public void setPreviousReference(DoubleNode<T> previousReference){
		
		this.previousReference = previousReference;
		
	}
	
	public DoubleNode<T> getNextReference(){
		
		DoubleNode<T> n = (DoubleNode<T>) super.getReference();
		
		if (n==null){return null;}
		
		n.setPreviousReference(this);
		
		return n;
		
	}
	
	public DoubleNode<T> getPreviousReference(){
		
		DoubleNode<T> n = this.previousReference;
		
		if (n==null){return null;}
		
		n.setNextReference(this);
		
		return n;
		
	}
	
	protected DoubleNode<T> getNextCutReference(){
		
		DoubleNode<T> n = (DoubleNode<T>) super.getReference();
		
		if (n==null){return null;}
		
		return n;
		
	}
	
	protected DoubleNode<T> getPreviousCutReference(){
		
		DoubleNode<T> n = this.previousReference;
		
		if (n==null){return null;}
		
		return n;
		
	}
	
	public DoubleNode<T> switchNodes(){
		
		DoubleNode<T> bup = new DoubleNode<>();
		DoubleNode<T> u = null;
		DoubleNode<T> p = null;
		
		DoubleNode<T> n = (DoubleNode<T>) super.getReference();
		
		if (n!=null){
			
			u = bup;
		
			while(n!=null){
				
				bup.setData(n.getData());
				bup.setPreviousReference(new DoubleNode<T>());
				
				bup = bup.getPreviousReference();
				n = n.getNextReference();
				
			}
			
			bup = bup.getNextReference();
			bup.setPreviousReference(null);
			
		}
		
		n = this.getPreviousReference();
		
		if (n!=null){
		
			bup = new DoubleNode<>();
			p = bup;
			
			while(n!=null){
				
				bup.setData(n.getData());
				bup.setNextReference(new DoubleNode<T>());
				
				bup = bup.getNextReference();
				n = n.getPreviousReference();
				
			}
			
			bup = bup.getPreviousReference();
			bup.setNextReference(null);
			
		}
		
		return new DoubleNode<T>(this.getData(), u, p);
		
	}
	
	public String toString() {
		
		StringBuilder bup = new StringBuilder();
		
		DoubleNode<T> n = this;
		
		while (n.getPreviousReference()!=null){
			
			bup.insert(0, n.getPreviousReference().getData()+" <--> ");
			
			n = n.getPreviousReference();
			
		}

		bup.append(this.getData()!=null ? "{"+this.getData().toString()+"}" : "");

		n = this;
		
		while (n.getNextReference()!=null){
			
			bup.append(" <--> ").append(n.getNextReference().getData());
			
			n = n.getNextReference();
			
		}

		return bup.toString();
		
	}
	
}