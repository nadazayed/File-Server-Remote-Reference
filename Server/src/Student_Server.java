import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Student_Server extends UnicastRemoteObject implements Student_Interface
{
    private static final long serialVersionUID = -7685413364823900207L;

    ArrayList <StudentI> list = new ArrayList<StudentI>();
    int cnt=0;

    protected Student_Server () throws RemoteException
    {
       // super();
    }

    @Override
    public StudentI getStudent() throws RemoteException
    {
        return new Student();
    }

    @Override
    public void AddStudent(StudentI student) throws RemoteException
    {
        System.out.println("Student added\n");
        list.add(student);
        cnt++;
    }

    @Override
    public StudentI getStudentInfo(String id) throws RemoteException
    {
        for (int i=0; i<cnt; i++)
        {
            if (list.get(i).getId().matches(id))
            {
                System.out.println("Student Found");
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<StudentI> aboveAvgGPA() throws RemoteException
    {
        double avg = avg();
        boolean flag = false;
        ArrayList <StudentI> aboveAvg = new ArrayList<StudentI>();

        for (int i=0; i<cnt; i++)
        {
            if (list.get(i).getGpa() >= avg)
            {
                flag = true;
                System.out.println(list.get(i).getGpa()+" >= "+avg);
                aboveAvg.add(list.get(i));
            }
        }
        if (list.isEmpty() || flag == false)
            return null;
        else
            return aboveAvg;
    }

    public double avg() throws RemoteException
    {
        double sum = 0;
        for (int i=0; i<cnt; i++)
        {
            sum+= list.get(i).getGpa();
        }

        System.out.println("sum:"+sum+" cnt:"+cnt+" avg:"+(sum/cnt));
        return (sum/cnt);
    }


    public static void main(String[] args)
    {
        try
        {
            Student_Server server = new Student_Server();

            Registry registry = LocateRegistry.createRegistry(Student_Interface.port);
            registry.rebind(Student_Interface.serviceName, server);

            System.out.println("Server is listening..");
        }

        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

}
