import com.highcom.mapper.StudentMapper;
import com.highcom.po.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class testStudent {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void before() throws IOException {
        //读取全局配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //拿到SqlSession工厂对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //拿到SqlSession
        sqlSession = factory.openSession();
        //获取接口实现类对象
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }


    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void findStudent(){
        List<Student> studentList = studentMapper.findStudents();
        for(Student student: studentList){
            List<Score> scoreList = student.getScoreList();
            Classes classes = student.getClasses();
            Teacher teacher = classes.getTeacher();
            System.out.println(student.getStudent_id()+":"+student.getStudent_name()+"\t\t"+classes.getClass_name()+"\t\t"+teacher.getTeacher_name());
            for(Score score : scoreList){
                Course course = score.getCourse();
                System.out.println(course.getCourse_name()+"\t\t"+score.getGrade());
            }
        }
    }
}

