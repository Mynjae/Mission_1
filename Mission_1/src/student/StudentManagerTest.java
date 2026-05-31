package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentManagerTest {

    StudentManager studentManager;

    @BeforeAll
    void setUp() throws Exception {
        studentManager = new StudentManager();
    }

    @Test
    @Order(1)
    void testAddStudent() {
        studentManager.addStudent("민재");
        assertTrue(studentManager.hasStudent("민재"));
    }

    @Test
    @Order(2)
    void testDuplicateAddStudent() {
        assertThrows(IllegalArgumentException.class, () -> {
            studentManager.addStudent("민재");
        });
    }

    @Test
    @Order(3)
    void testRemoveStudent() {
        studentManager.removeStudent("민재");
        assertFalse(studentManager.hasStudent("민재"));
    }

    @Test
    @Order(4)
    void testHasStudent() {
        assertThrows(IllegalArgumentException.class, () -> {
            studentManager.removeStudent("민재");
        });
    }
}