import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface StudentI extends Remote
{
    String getId() throws RemoteException;
    void setId(String id) throws RemoteException;

    String getName() throws RemoteException;
    void setName(String name) throws RemoteException;

    String getDepartment() throws RemoteException;
    void setDepartment(String department) throws RemoteException;

    double getGpa() throws RemoteException;
    void setGpa(double gpa) throws RemoteException;

    int getSemester() throws RemoteException;
    void setSemester(int semester) throws RemoteException;
}

