public class RotateCommand implements Command {
    private String direction;

    public RotateCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Satellite satellite) {
        satellite.rotate(direction);
    }
}
