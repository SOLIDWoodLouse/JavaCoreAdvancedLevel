package lesson01;

public class Human implements Movement{

    private int maxLength;
    private int maxHeight;
    private String name;

    public Human(int maxLength, int maxHeight, String name) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public void run() {
        System.out.println(name + " бежит.");
    }

    @Override
    public void jump() {
        System.out.println(name + " прыгает.");
    }
}
