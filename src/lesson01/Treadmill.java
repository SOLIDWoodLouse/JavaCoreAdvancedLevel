package lesson01;

public class Treadmill implements Passing{

    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public String name() {
        return "Беговая дорожка";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean startMove(int maxDistance) {
        return maxDistance >= length;
    }
}
