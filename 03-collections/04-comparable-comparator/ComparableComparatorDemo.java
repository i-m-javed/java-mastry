import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CompareByPriority implements Comparator<Job> {

  @Override
  public int compare(Job o1, Job o2) {
    return o1.getPriority().compareTo(o2.getPriority());
  }
}

class Job implements Comparable<Job> {

  private String title;
  private Integer priority;
  private Integer salary;

  public Job(String title, Integer priority, Integer salary) {
    this.title = title;
    this.priority = priority;
    this.salary = salary;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public int compareTo(Job other) {
    int a = this.priority.compareTo(other.priority);
    if (a == 0) {
      return this.title.compareTo(other.title);
    }
    return a;
  }

  @Override
  public String toString() {
    return (title + " | Priority: " + priority + " | salary : " + salary);
  }
}



public class ComparableComparatorDemo {

    static void main() {
        List<Job> jobs = new ArrayList<>();

        jobs.add(new Job("AI engineer", 1, 700000));
        jobs.add(new Job("Data engineer", 3, 500000));
        jobs.add(new Job("Software engineer", 2, 30000));
        jobs.add(new Job("Developer", 2, 600000));

        //        jobs.sort(Comparator.comparing(Job::getPriority).thenComparing(Job::getTitle));

        //        jobs.sort(new CompareByPriority());

        System.out.println("\nBefore:::");
        for (Job j : jobs) {
            System.out.println(j);
        }

        jobs.sort(
                (o1, o2) -> {
                    int a = o1.getPriority().compareTo(o2.getPriority());
                    if (a == 0) {
                        return o1.getTitle().compareTo(o2.getTitle());
                    }
                    return a;
                });

        System.out.println("\nAfter:::");
        for (Job j : jobs) {
            System.out.println(j);
        }
    }
}
