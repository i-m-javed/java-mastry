import com.capgi.dao.StudentDao;
import com.capgi.dao.StudentDaoImpl;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao=new StudentDaoImpl();
//        studentDao.saveData();
        studentDao.fetchLaptopFromStudent(1);
        studentDao.fetchStudentFromLaptop(101);
        studentDao.updateLaptopBrand(101,"newBrand");
        studentDao.updateStudentCourse(1,"CSAI");
        studentDao.changeLaptopForStudent(1,45);
        studentDao.removeLaptopFromStudent(3);
        studentDao.deleteStudentAndLaptop(2);
    }
}
