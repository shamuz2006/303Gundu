pacakge frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot.climb;

public class ClimbUp extends CommandBase {

    public ClimbUp() {
        addRequirements(Robot.climb);
    }

    @Override
    public void execute(double s) {
        double speed = s;
        climb.climberSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return climb.topLimit();
    }

    @Override
    public void end(boolean i) {
        climb.climberSpeed(0);
    }

}