
package individualproject;

public class TrainersInCourse {
    private Trainer trainer;
    private Course course;

    public TrainersInCourse(Trainer trainer, Course course) {
        this.trainer = trainer;
        this.course = course;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    

}
