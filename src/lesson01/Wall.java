package lesson01;

public class Wall implements Passing {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String name() {
        return "Стена";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean startMove(int maxDistance) {
        return maxDistance >= height;
    }
}
