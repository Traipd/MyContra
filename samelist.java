package MyContra;

public class samelist<E> {
	private Object[] ob=new Object[0];
	   public void add(E e){
//			System.arraycopy(ob, 0, ob1, 0, ob.length);
			Object []ob1=new Object[ob.length+1];
			ob1[ob.length]=e;
			System.arraycopy(ob, 0, ob1, 0, ob.length);
			ob=ob1;
	   }
	   /**(int i,E e)ob[i]**/
		public void set(int i,E e){
			ob[i]=(Object)e;
		}
		/**·µ»Øob[i]**/
	   public E get(int i){
	   	E st=(E)ob[i];
	   	return st;
	   }
	   /**·µ»Øob.length**/
	   public int size(){
	   	return ob.length;
	   }
}
