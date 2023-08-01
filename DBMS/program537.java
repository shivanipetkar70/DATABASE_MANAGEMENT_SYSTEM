import java.util.*;

class program535
{
    public static void main (String Arg[])
    {
    
 DBMS obj = new DBMS();

 obj.StartDBMS();
/* 
 obj.InsertIntoTable("Rahul",23,89);
 obj.InsertIntoTable("Sagra",26,98);
 obj.InsertIntoTable("Pooja",20,56);
 obj.InsertIntoTable("Sayali",30,78);
 obj.InsertIntoTable("Tejas",29,68);
  
 obj.SelectFrom();
 obj.SelectFrom(4);
 obj.SelectFrom("Tejas");

 System.out.println("Maximum marks are :"+obj.Aggregate_Max());
 System.out.println("Minimum marks are :"+obj.Aggregate_Min());
 System.out.println("Minimum marks are :"+obj.Aggregate_Sum());
 System.out.println("Minimum marks are :"+obj.Aggregate_Avg());

 obj.DeleteFrom(4);
 obj.SelectFrom();*/
   }
}
class Student 
{

    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;

    static
    {
        Generator = 0;
    }

    public Student (String Str,int X,int Y)
    {
        this.Rno = ++Generator;
        this.Name = Str;
        this.Age = X;
        this.Marks = Y;
    }

public void Display()
{
    System.out.println(this.Rno +" " + this.Name +" " + this.Age +" " + this.Marks);
    
}

}
class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList <Student> ();
    }

    public void StartDBMS()
    {
        System.out.println("Marvellous DBMS Started SUccessfully...");
        System.out.println("Table Schema created SUccessfully...");
        String Query;
        String Tokens[];

        Scanner sobj = new Scanner (System.in);
        int TokensCount = 0;

        while(true)
        {

        System.out.println("Marvellous DBMS : ");
        Query = sobj.nextLine();

         Tokens = Query.split(" ");

         TokensCount = Tokens.length;

         if(TokensCount == 1)
         {
           if("exit".equals(Tokens[0]))
           {
            System.out.println("Thank you for using Marvellous DBMS");
            break;
           }
         }
         else if(TokensCount == 2)
         {

         }
         else if(TokensCount == 3)
         {
            
         }
         else if(TokensCount == 4)
         {
            if("select".equals(Tokens[0]))
            {
                SelectFrom();
            }
         }
         else if(TokensCount == 5)
         {
             if("select".equals(Tokens[0]))
             {
                if("MAX".equals(Tokens[1]))
                {
                    System.out.println("Maximum marks are:"+Aggregate_Max());
                }
                else if("MIN".equals(Tokens[1]))
                {
                    System.out.println("Maximum marks are:"+Aggregate_Min());
                }
                else if("SUM".equals(Tokens[1]))
                {
                    System.out.println("Maximum marks are:"+Aggregate_Sum());
                }
                else if("AVG".equals(Tokens[1]))
                {
                    System.out.println("Maximum marks are:"+Aggregate_Avg());
                }
             }
         }
         else if(TokensCount == 6)
         {
            
         }
         else if(TokensCount == 7)
         {
            if("insert".equals(Tokens[0]))
            {
                InsertIntoTable(Tokens[4],Integer.parseInt(Tokens[5]),Integer.parseInt(Tokens[6]));
            }
            else if("delete".equals(Tokens[0]))
            {
                DeleteFrom(Integer.parseInt(Tokens[6]));
            }
         }
        }

    }

    //Insert into table values(   ,     ,    ,);
    public void InsertIntoTable(String Name,int Age,int Marks )
    {

        Student sobj = new Student(Name,Age,Marks);
        lobj.add(sobj);
    }

    // select * from Student

    public void SelectFrom()
    {
        System.out.println("Records from the database are:");

        for(Student sref : lobj)
        {
            sref.Display();
        }
    }

    //  select * from Student where Rno = 11;

    public void SelectFrom(int No)
    {
        System.out.println("Records from the database whose roll no are:");

        for(Student sref : lobj )
        {
            if(sref.Rno == No)
            {
            sref.Display();
            break;
            }
        }
    }

    //select * from Student where Name = Tejas;
    public void SelectFrom(String Str)
    {
        System.out.println("Records from the database whose roll no are:");

        for(Student sref : lobj )
        {
            if(Str.equals(sref.Name))
            {
            sref.Display();
            break;
            }
        }
    }

    
    //delete from Student where Rno = 2;
    public void DeleteFrom(int No)
    {
        System.out.println("Records from the database want to delete whose roll no are:");
      int i = 0;
        for(Student sref : lobj )
        {
            if(sref.Rno == No)
            {
            lobj.remove(i);
            break;
            }
            i++;
        }
    }

   
    // select MAX(marks) from Student
    public int Aggregate_Max()
    {
        Student temp  = lobj.get(0);
        int iMax = temp.Marks;
       
       
        
        for(Student sref : lobj )
        {
            if(sref.Marks > iMax)
            {
           iMax = sref.Marks;
            }
            
        }
        return iMax;
    }

     // select MIN(marks) from Student
    public int Aggregate_Min()
    {
        Student temp  = lobj.get(0);
        int iMin = temp.Marks;
        for(Student sref : lobj )
        {
            if(sref.Marks < iMin)
            {
           iMin = sref.Marks;
            }
            
        }
        return iMin;
    }

     // select SUM(marks) from Student
    public int Aggregate_Sum()
    {
      
        int iSum = 0;
        for(Student sref : lobj )
        {
           iSum = iSum + sref.Marks;
            
        }
        return iSum;
    }

     // select AVG(marks) from Student
    public double Aggregate_Avg()
    {
      
        int iSum = 0;
        for(Student sref : lobj )
        {
           iSum = iSum + sref.Marks;
            
        }
        return (iSum / (lobj.size()));
    }
   
}

// Insert Query
// Insert into Student values rahul 23 67 
// 0        1        2      3   4   5  6
//No of tokens : 7

//select * from Student 
//  0    1  2     3
// no of tokens  4
// delete from student where Rno  =  4
//   0       1     2      3    4  5  6
 //No of tokens : 7
 // select Max Age from student 
 //    0    1   2    3   5
//  //No of tokens : 5