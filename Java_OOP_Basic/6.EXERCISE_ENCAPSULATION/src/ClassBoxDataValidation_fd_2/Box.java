package ClassBoxDataValidation_fd_2;

public class Box {
    private final int NULL = 0;

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return this.length;
    }

    private void setLength(double length) {

        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
            this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        if(width == 0 || width < 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
            this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        if(height == 0 || height < 0){
            System.out.println("Height cannot be zero or negative.");
        }
            this.height = height;
    }


    private double calculateSurfaceArea(){
       return (2*this.getLength()*this.getWidth()) + (2*this.getLength()*this.getHeight()) + (2*this.getWidth()*this.getHeight());
    }

    private double calculateLiteralSurfaceArea(){
        return (2*this.getLength()*this.getHeight()) + (2*this.getWidth()*this.getHeight());
    }

    private double calculateVolume(){
        return this.getLength()*this.getWidth()*this.getHeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Surface Area - %.2f",this.calculateSurfaceArea()))
                .append(System.lineSeparator())
                .append(String.format("Lateral Surface Area - %.2f",this.calculateLiteralSurfaceArea()))
                .append(System.lineSeparator())
                .append(String.format("Volume - %.2f",this.calculateVolume()));

        return sb.toString();
    }
}