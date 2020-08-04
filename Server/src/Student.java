import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Student extends UnicastRemoteObject implements StudentI
{
    private static final long serialVersionUID = 3216164069065738485L;

    private String id, name, department;
    private double gpa;
    private int semester;

    public Student () throws RemoteException
    {
        super();
        System.out.println("Student Obj Receieved");
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public double getGpa()
    {
        return gpa;
    }

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    public int getSemester()
    {
        return semester;
    }

    public void setSemester(int semester)
    {
        this.semester = semester;
    }
}
