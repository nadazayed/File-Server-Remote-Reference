import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Student_Interface extends Remote
{
    String serviceName = "StudentService";
    int port = 2000;

    StudentI getStudent() throws RemoteException;

    void AddStudent(StudentI student) throws RemoteException;
    StudentI getStudentInfo(String id) throws RemoteException;
    ArrayList<StudentI> aboveAvgGPA() throws RemoteException;
}
