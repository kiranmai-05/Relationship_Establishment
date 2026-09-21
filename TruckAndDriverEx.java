import java.util.*;
public class TruckAndDriverEx{
public static void main(String args[]){
Scanner s=new Scanner(System.in);
int size=Integer.parseInt(s.nextLine());
Truck[] t=new Truck[size];
for(int i=0;i<size;i++){
int tid=Integer.parseInt(s.nextLine());
String tname=s.nextLine();
float tmiles=Float.parseFloat(s.nextLine());
int did=Integer.parseInt(s.nextLine());
String dname=s.nextLine();
String dcontact=s.nextLine();
float exp=Float.parseFloat(s.nextLine());
Driver d=new Driver(did,dname,dcontact,exp);
t[i]=new Truck(tid,tname,tmiles,d);
}
int val=Integer.parseInt(s.nextLine());
Truck[] k=getDist(t,val);
if(k==null){
System.out.println("no");
}
else{
for(Truck res:k){
System.out.print(res.getId()+" "+res.getName()+" "+res.getMiles()+" "+res.getdriver().getId()+" "+res.getdriver().getName());
System.out.println();
}
}
}
public static Truck[] getDist(Truck[] t,int val){
ArrayList<Truck>l=new ArrayList<>();
for(Truck k:t){
if(k.getMiles()>=val){
l.add(k);
}
}
Collections.sort(l,(a,b)->Float.compare(b.getdriver().getExp(),a.getdriver().getExp()));
Truck[] res=l.toArray(new Truck[l.size()]);
if(res.length==0){
return null;
}
return res;
}
}
class Truck{
private int id;
private String name;
private float miles;
Driver driver;
public Truck(int id,String name,float miles,Driver driver){
this.id=id;
this.name=name;
this.miles=miles;
this.driver=driver;
}
public int getId(){
return id;
}
public String getName(){
return name;
}
public float getMiles(){
return miles;
}
public Driver getdriver(){
return driver;
}
}
class Driver{
private int id;
private String name;
private String contact;
private float exp;
public Driver(int id,String name, String contact,float exp){
this.id=id;
this.name=name;
this.contact=contact;
this.exp=exp;
}
public int getId(){
return id;
}
public String getName(){
return name;
}
public String getContact(){
return contact;
}
public float getExp(){
return exp;
}
}
