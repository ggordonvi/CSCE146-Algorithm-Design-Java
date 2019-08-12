import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinalGrade
{
     //returns grade corresponding to percentage
     static String grade (double m)
     {
          if(m>=90 && m<=100)
          {
              return "A";            
          }
          else if(m>=85 && m<=89)
          {
              return "B+";
          }
          else if(m>=80 && m<=84)
          {
              return "B";
          }
          else if(m>=75 && m<=79)
          {
              return "C+";
          }
          else if(m>=70 && m<=74)
          {
              return "C";
          }
          else if(m>=65 && m<=69)
          {
              return "D+";
          }
          else if(m>=60 && m<=64)
          {
              return "D";
          }
          else if(m<60)
          {
              return "F";
          }
          else
          {
              return "";
          }
     }

     public static void main(String args[]) throws IOException
     {
          String line;
          double marks[]=new double[7];
          double total=0,rawtotal=0;
          String header[]={"Your lab average is ","Your homework average is ","Your first exam is ","Your first lab exam is ","Your second exam is ","Your second lab exam is ","Your final is "};
          FileReader fileReader =   new FileReader("perfectGrades.txt");
          BufferedReader bufferedReader =new BufferedReader(fileReader);
          int i=0,j=0;

          //read all the marks from the file
          while((line = bufferedReader.readLine()) != null)
          {
              if(i%2!=0)//skip header
              {
                   marks[j]=Double.parseDouble(line);
                   j++;
              }
              i++;
          }
          
          //Calculate respective percentages      
          total=total+(marks[0]*20/100);//Calculating 20% of lab average
          total=total+(marks[1]*30/100);//Calculating 30% of home work average
          total=total+(marks[2]*10/100);//Calculating 10% of Exam 1
          total=total+(marks[3]*10/100);//Calculating 10% of Lab 1
          total=total+(marks[4]*10/100);//Calculating 10% of Exam 2
          total=total+(marks[5]*10/100);//Calculating 10% of Lab 2
          total=total+(marks[6]*10/100);//Calculating 10% of Final exam

          //print all marks
          for(int j1=0;j1<marks.length;j1++)
          {
              System.out.println(header[j1]+marks[j1]);
          }

          //Calculate extra work credits
          int extra_credits=0;
          for(int j2=0;j2<marks.length;j2++)
          {
              if(marks[j2]==100)
            	  extra_credits=extra_credits+2;

          }
          System.out.println("Your extra work total is "+extra_credits+" points");
          
          //add extra work points
          total=total+(((marks[2]+marks[3]+marks[4]+marks[5])*extra_credits)/100);

          //calculate the grade for 100
          rawtotal=(total*100)/110;

          //Round up to the nearest whole number
          rawtotal=Math.ceil(rawtotal);

          System.out.printf("Your raw total is %.1f\n", rawtotal);
          System.out.println("Your final grade is "+grade(total));
     }
}