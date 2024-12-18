package Trees;

/*
 *
 * @author Dandelion
 * 
 */

import Nodes.BinaryNode;

public class BinaryTree<T>{
	
	private BinaryNode<T> Root;
	
	public BinaryTree(){
		
		this.Root = null;
		
	}
	
	public BinaryTree(T Root){
		
		if (Root!=null){
			
			this.Root = new BinaryNode<T>(Root);
			
		}
		
	}
	
	public BinaryTree(BinaryNode<T> Root){
		
		if (Root!=null){
		
			if (Root.getPreviousReference()!=null){
				
				if (Root.getPosition()){
					
					Root.getPreviousReference().setRightReference(null);
					
				}else{
					
					Root.getPreviousReference().setLeftReference(null);
					
				}
				
				Root.setPreviousReference(null);
				
			}
			
		}
		
		this.Root = Root;
		
	}
	
	public BinaryNode<T> getRoot(){
		
		return this.Root;
		
	}
	
	public BinaryTree<T> getRightBranch(){
		
		if (this.Root==null){return null;}
		
		BinaryNode<T> n = this.Root.getRightReference();
		
		n.setPreviousReference(null);
		
		return new BinaryTree<T>(n);
		
	}
	
	public BinaryTree<T> getLeftBranch(){
		
		if (this.Root==null){return null;}
		
		BinaryNode<T> n = this.Root.getLeftReference();
		
		n.setPreviousReference(null);
		
		return new BinaryTree<T>(n);
		
	}
	
	public int getHeight(){
		
		if (this.Root==null){return 0;}
		
		return this.Root.getHeight();
		
	}
	
	public int getBalancingFactor(){
		
		if (this.Root==null){return 0;}
		
		return this.Root.getBalancingFactor();
		
	}
	
	public void add(T Data){
		
		this.add(new BinaryNode<T>(Data));
		
	}
	
	public void add(BinaryNode<T> Nodo){
		
		if (this.Root!=null && (Nodo!=null ? Nodo.getData()!=null : false)){
			
			Nodo = this.ClearNodo(Nodo);
		
			if (this.Root.getRightReference()==null){
				
				this.Root.setRightReference(Nodo);

			}else if (this.Root.getLeftReference()==null){
				
				this.Root.setLeftReference(Nodo);
				
			}else{
			
				boolean b = true;
				
				BinaryNode<T> Right = this.Root.getRightReference();
				BinaryNode<T> Left = this.Root.getLeftReference();
				
				do{
					
					if (Right.getHeight()==0){
						
						if (Right.getRightReference()==null){
							
							Right.setRightReference(Nodo);
							
						}else{
							
							Right.setLeftReference(Nodo);
							
						}
						
						b = false;
						
					}else if (Left.getHeight()==0){
						
						if (Left.getRightReference()==null){
							
							Left.setRightReference(Nodo);
							
						}else{
							
							Left.setLeftReference(Nodo);
							
						}
						
						b = false;
						
					}else if (Right.getHeight()==1){
						
						if (Right.getRightReference()==null){
							
							Right.setRightReference(Nodo);
							
						}else{
							
							Right.setLeftReference(Nodo);
							
						}
						
						b = false;
						
					}else if (Left.getHeight()==1){
						
						if (Left.getRightReference()==null){
							
							Left.setRightReference(Nodo);
							
						}else{
							
							Left.setLeftReference(Nodo);
							
						}
						
						b = false;
						
					}
					
					Right = this.Root.getRightReference();
					Left = this.Root.getLeftReference();
					
				}while(b);
				
			}
			
		}else if (this.Root==null && (Nodo!=null ? Nodo.getData()!=null : false)){
			
			if (Nodo.getPreviousReference()!=null){
				
				if (Nodo.getPosition()){
					
					Nodo.getPreviousReference().setRightReference(null);
					
				}else{
					
					Nodo.getPreviousReference().setLeftReference(null);
					
				}
				
				Nodo.setPreviousReference(null);
				
			}
			
			this.Root = Nodo;
			
		}
		
	}
	
	public void remove(T Data){
		
		if (this.Root!=null && Data!=null){
			
			remove(this.Root, Data);
			
		}
		
	}
	
	public String toString(){
		
		return this.Root!=null ? this.Root.toString() : "()";
		
	}
	
	private boolean remove(BinaryNode<T> Nodo, T Data){
		
		if (Nodo!=null && Data!=null){
		
			if (Nodo.getData().toString().equals(Data.toString())){
				
				if (Nodo.getRightReference()==null && Nodo.getLeftReference()==null){
					
					BinaryNode<T> n = Nodo.getPreviousReference();
					
					if (n!=null){
						
						if (Nodo.getPosition()){
						
							n.setRightReference(null);
							
						}else{
							
							n.setLeftReference(null);
							
						}
						
					}else{
						
						this.setRoot(n);
						
					}
					
					Nodo.setPreviousReference(null);
					
					return true;
					
				}else if (Nodo.getRightReference()==null || Nodo.getLeftReference()==null){
					
					BinaryNode<T> n = Nodo.getRightReference()==null ? Nodo.getLeftReference() : Nodo.getRightReference();
					BinaryNode<T> bup = Nodo.getPreviousReference();
					
					if (n.getPosition()){
						
						Nodo.setRightReference(null);
						
					}else{
						
						Nodo.setLeftReference(null);
						
					}
					
					Nodo.setPreviousReference(null);
					
					n.setPreviousReference(bup);
					
					n.setPosition(Nodo.getPosition());
					
					if (bup!=null){
					
						if (n.getPosition()){
							
							bup.setRightReference(n);
							
						}else{
							
							bup.setLeftReference(n);
							
						}
						
					}else{
						
						this.setRoot(n);
						
					}
					
					return true;
					
				}else{
					
					BinaryNode<T> n = Nodo.getRightReference();
					
					BinaryNode<T> a = Nodo.getPreviousReference();
					BinaryNode<T> b = Nodo.getRightReference();
					BinaryNode<T> c = Nodo.getLeftReference();
					
					while(n.getLeftReference()!=null){
						
						n = n.getLeftReference();
						
					}
					
					BinaryNode<T> bup = n.getRightReference();
					BinaryNode<T> past = n.getPreviousReference();
					
					if (bup!=null){
						
						n.setRightReference(null);
						
						bup.setPreviousReference(null);
						bup.setPosition(BinaryNode.LEFT);
						
					}
					
					if (n.getPosition()){
					
						past.setRightReference(bup);
						
					}else{
						
						past.setLeftReference(bup);
						
					}
					
					n.setPreviousReference(null);
					
					Nodo.setPreviousReference(null);
					Nodo.setLeftReference(null);
					Nodo.setRightReference(null);
					
					c.setPreviousReference(null);
					
					if (n!=b){
						
						b.setPreviousReference(null);
						
					}
					
					if (a!=null){
						
						if (Nodo.getPosition()){
						
							a.setRightReference(null);
							a.setRightReference(n);
							
						}else{
							
							a.setLeftReference(null);
							a.setLeftReference(n);
							
						}
						
						n.setPreviousReference(a);
						
					}
					
					n.setLeftReference(c);
					c.setPreviousReference(n);
					
					if (n!=b){
						
						n.setRightReference(b);
						b.setPreviousReference(n);
						
					}
					
					if (a==null){
						
						this.setRoot(n);
						
					}
					
					return true;
					
				}
				
			}else{
				
				boolean b = false;
				
				if (Nodo.getRightReference()!=null){
					
					b = remove(Nodo.getRightReference(), Data);
					
				}
				
				if (Nodo.getLeftReference()!=null && b==false){
					
					b = remove(Nodo.getLeftReference(), Data);
					
				}
				
				return b;
				
			}
			
		}
		
		return false;
		
	}
	
	protected void setRoot(BinaryNode<T> Nodo){
		
		this.Root = Nodo;
		
	}
	
	protected BinaryNode<T> ClearNodo(BinaryNode<T> Nodo){
		
		if (Nodo.getPreviousReference()!=null){
			
			if (Nodo.getPosition()){
				
				Nodo.getPreviousReference().setRightReference(null);
				
			}else{
				
				Nodo.getPreviousReference().setLeftReference(null);
				
			}
			
			Nodo.setPreviousReference(null);
			
		}
		
		if (Nodo.getLeftReference()!=null){
			
			Nodo.getLeftReference().setPreviousReference(null);
			
			Nodo.setLeftReference(null);
			
		}
		
		if (Nodo.getRightReference()!=null){
			
			Nodo.getRightReference().setPreviousReference(null);
			
			Nodo.setRightReference(null);
			
		}
		
		return Nodo;
		
	}
	
}