package lesson2_1;

public class Cat implements Move {
    private  int run;
    private  float jump;
    private  int run_limit;
    private  float jump_limit;

    public Cat (int run, float jump, int run_limit, float jump_limit){
        this.run = run;
        this.jump = jump;
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгнул.");
    }

    @Override
    public void run() {
        System.out.println("Кот побежал.");
    }
}
