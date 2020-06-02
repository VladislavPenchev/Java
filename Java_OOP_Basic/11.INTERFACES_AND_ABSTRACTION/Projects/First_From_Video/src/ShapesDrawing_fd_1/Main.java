package ShapesDrawing_fd_1;

public class Main {
    public static void main(String[] args) {

        Drawable circle = new Circle(5);

        Drawable rect = new Rectangle(10,20);

        drawFigure(circle);
        drawFigure(rect);

    }

    public static void drawFigure(Drawable figure){
        figure.draw();
    }
}
