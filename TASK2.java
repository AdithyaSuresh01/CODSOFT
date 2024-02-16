import java.util.Scanner;

public class TASK2 {
    
    //VARIABLE DECLARATION AND SCANNER CLASS OBJECT CREATION
    Scanner sc = new Scanner(System.in);
    static String name;
    int maths , physics , biology , chemistry , english , total , averagePercentage;

    //FUNCTION TO GET MARKS FROM USER
    public void getMarks(){
        int flag = 0;
        do{
            System.out.println("\nENTER MARKS :");
            System.out.println("\nMATHS : ");
            maths = sc.nextInt();
            System.out.println("\nPHYSICS : ");
            physics = sc.nextInt();
            System.out.println("\nCHEMISTRY : ");
            chemistry = sc.nextInt();
            System.out.println("\nBIOLOGY : ");
            biology = sc.nextInt();
            System.out.println("\nENGLISH : ");
            english = sc.nextInt();
            
            //BOUNDARY CONDITION OF MARKS INPUT
            if( (maths > 100 || maths < 0) || (physics > 100 || physics < 0) || (chemistry > 100 || chemistry < 0) || (biology > 100 || biology < 0) || (english > 100 || english < 0) ){
                System.out.println("\nMARKS ENTERED ARE WRONG(OUT OF BOUND)!!");
                System.out.println("\nRE-ENTER THE MARKS CORRECTLY!");
                flag = 1;
            }
            else{
                flag = 0;
            }
        }while(flag == 1);
    }

    //FUNCTION TO CALCULATE TOTAL MARKS OBTAINED
    public int calculateTotal(){
        total = (maths+physics+chemistry+biology+english);
        return total;
    }

    //FUNCTION TO CALCULATE AVERAGE PERCENTAGE
    public int calculateAveragePercentage(){
        averagePercentage = (total / 5);
        return averagePercentage;
    }

    //FUNCTION TO CALCULATE GRADE
    public char calculateGrade(int mark){
        if(mark > 90 && mark <= 100){
            return 'O';
        }
        else if(mark > 80 && mark <= 90){
            return 'A';
        }
        else if(mark > 70 && mark <= 80){
            return 'B';
        }
        else if(mark > 60 && mark <= 70){
            return 'C';
        }
        else if(mark > 50 && mark <= 60){
            return 'D';
        }
        else{
            return 'F';
        }
    }

    //FUNCTION TO PRINT MARKSHEET
    public void printMarksheet(){
        System.out.println("\n\t\t*****MARKSHEET*****");
        System.out.format("\nNAME : %s\n", name);
        System.out.format("\n\t\tSUBJECT NAME\tMARKS");
        System.out.format("\n\t\tMATHS\t\t%d", maths);
        System.out.format("\n\t\tPHYSICS\t\t%d", physics);
        System.out.format("\n\t\tCHEMISTRY\t%d", chemistry);
        System.out.format("\n\t\tBIOLOGY\t\t%d", biology);
        System.out.format("\n\t\tENGLISH\t\t%d", english);
        System.out.format("\n\nTOTAL : %d Out Of 500", calculateTotal());
        System.out.format("\n\nAVERAGE PERCENTAGE : %d", calculateAveragePercentage());
        System.out.format("\n\nGRADE : %c\n", calculateGrade(averagePercentage));
    }
    public static void main(String[] args) {

        //CREATING LOCAL SCANNER CLASS OBJECT AND TASK2 CLASS OBJECT
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Name of the Student : ");
        name = sc.nextLine();
        TASK2 task = new TASK2();

        //CALLING getMarks() and printMarksheet() FUNCTIONS
        task.getMarks();
        task.printMarksheet();
    }
}
