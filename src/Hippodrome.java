
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("black", 3, 0));
        game.getHorses().add(new Horse("white", 3, 0));
        game.getHorses().add(new Horse("blue", 3, 0));

        game.run();

        game.printWinner();
    }

    void run()
    {
        try
        {
            for (int i = 1; i <= 100; ++i)
            {
                move();
                print();
                Thread.sleep(200);
            }
        } catch (InterruptedException e)
        {

        }

    }

    void move()
    {
        horses.forEach(Horse::move);
    }

    void print()
    {
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; ++i)
            System.out.println();
    }

    public Horse getWinner()
    {
        Horse curMax = horses.get(0);
        for (Horse horse : horses)
        {
            if (horse.getDistance() > curMax.getDistance())
                curMax = horse;
        }
        return curMax;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
