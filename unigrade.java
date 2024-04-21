
public class unigrade {
    public static void main(String[] args) {

        Course c = new Course("CSE",
                102, "Progamming 2",
                "Introduction to OOP", 6);
        System.out.println(c.courseCode() + " - " + c.getTitle());
        System.out.println(c);

        Teacher t = new Teacher("Joseph LEDET",
                "josephledet@akdeniz.edu.tr", 123L,
                "CSE", 1);
        System.out.println(t);

        Student s = new Student("Test STUDENT ",
                "me@somewhere.com", 456L, "CSE");
        System.out.println(s);

        s.passCourse(c);
        System.out.println(s.getAKTS());

        System.out.println("-------------------");

        Course course = new Course("CSE",
                101, "Computer Programming 1",
                "Introduction to Prgramming", 6);
        Student student = new Student("Can DO",
                "cando@akdeniz.edu.tr", 123L, "CSE");

        student.passCourse(course);
        course.setCourseNumber(course.getCourseNumber() + 10);
        System.out.println(student);
        System.out.println(course);
        course = new Course("CSE",
                102, "Computer Programming 2",
                "Introduction to OOP", 4);
        student.passCourse(course);
        // course.setCourseNumber(course.getCourseNumber() - 10);
        System.out.println(course);
        System.out.println(student);
    }
}

class Course {

    private String departmentCode;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;

    public Course(String departmentCode, int courseNumber,
            String title, String description, int AKTS) {

        this.setDepartmentCode(departmentCode);
        this.setCourseNumber(courseNumber);
        this.title = title;
        this.description = description;
        this.setAKTS(AKTS);
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        if (departmentCode.length() == 4 || departmentCode.length() == 3) {
            this.departmentCode = departmentCode;
        } else {
            throw new IllegalArgumentException(
                    "Department code must be 3 or 4 characters long.");
        }
    }

    public int getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        if (courseNumber >= 100 && courseNumber <= 999) {
            this.courseNumber = courseNumber;
        } else if (courseNumber >= 5000 && courseNumber <= 5999) {
            this.courseNumber = courseNumber;
        } else if (courseNumber >= 7000 && courseNumber <= 7999) {
            this.courseNumber = courseNumber;
        } else {
            throw new IllegalArgumentException(
                    "Course number must be within valid ranges.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void setAKTS(int AKTS) {
        if (AKTS > 0) {
            this.AKTS = AKTS;
        } else {
            throw new IllegalArgumentException(
                    "AKTS must be greater than zero.");
        }
    }

    public String courseCode() {
        return this.departmentCode + this.courseNumber;
    }

    @Override
    public String toString() {
        return departmentCode + courseNumber + " - " + title
                + " (" + AKTS + ")";
    }

}

class Person {

    private String name;
    private String email;
    private long ID;
    private String departmentCode;

    public Person(String name, String email, long ID,
            String departmentCode) {
        this.setDepartmentCode(departmentCode);
        this.setID(ID);
        this.setEmail(email);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmailAddress(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException(" invalid email!");
        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]"
                + "+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}"
                + "\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
        // Pattern pattern = Pattern.compile("^(.+)@([^@]+[^.])$");
        // Matcher matcher = pattern.matcher(email);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        if (departmentCode.length() == 3 ||
                departmentCode.length() == 4) {
            this.departmentCode = departmentCode;
        } else {
            throw new IllegalArgumentException(
                    "Department code must be 3 or 4 characters long.");
        }
    }

    @Override
    public String toString() {

        return name + " (" + ID + ")" + " - " + email;
    }
}

class Teacher extends Person {

    private int rank;

    public Teacher(String name, String email, long ID,
            String departmentCode, int rank) {
        super(name, email, ID, departmentCode);
        this.setRank(rank);
    }

    public void setRank(int rank) {
        if (1 <= rank && rank <= 4) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException(
                    "Rank must be between 1 and 4.");
        }
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        switch (rank) {
            case 1:
                return "Lecturer";
            case 2:
                return "Assistant Professor";
            case 3:
                return "Associate Professor";
            case 4:
                return "Professor";
            default:
                throw new IllegalArgumentException(
                        "Invalid rank value.");
        }
    }

    public void promote() {
        if (this.rank < 4) {
            rank++;
        } else {
            throw new IllegalArgumentException(
                    "Invalid rank value. It cannot "
                            + "be promoted further, already highest rank.");
        }
    }

    public void demote() {
        if (1 < this.rank) {
            rank--;
        } else {
            throw new IllegalArgumentException(
                    "Invalid rank value. It cannot "
                            + "be demoted further, already lowest rank.");
        }
    }

    @Override
    public String toString() {

        return getTitle() + " " + super.toString();
    }
}

class Student extends Person {
    private int AKTS;

    Student(String name, String email, long ID,
            String departmentCode) {
        super(name, email, ID, departmentCode);
        this.AKTS = 0;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void passCourse(Course course) {
        this.AKTS += course.getAKTS();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class GradStudent extends Student {

    private int rank;
    private String thesisTopic;

    public GradStudent(String name, String email,
            long ID, String departmentCode, int rank, String thesisTopic) {
        super(name, email, ID, departmentCode);
        this.setRank(rank);
        this.setThesisTopic(thesisTopic);
    }

    public void setRank(int rank) {
        if (rank == 1 || rank == 2 || rank == 3) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException(
                    "invalid rank value!");
        }
    }

    public int getRank() {
        return rank;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public String getLevel() {

        switch (rank) {
            case 1:
                return "Master's Student";
            case 2:
                return "Doctoral Student";
            case 3:
                return "Doctoral Candidate";
            default:
                throw new IllegalArgumentException(
                        "invalid rank value");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}