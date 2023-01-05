package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveMoreDistance extends CommandBase {

    private final double distance;
    private final int speed;

    public DriveMoreDistance(double d, int s) {
        this.distance = d;
        this.speed = s;
        addRequirements(Robot.drivebase);
    }

    @Override
    public void initialize() {
        Robot.drivebase.resetEncoders();
    }

    @Override
    public void execute() {
        Robot.drivebase.drive(speed, speed);
    }

    @Override
    public void end(boolean i) {
        Robot.drivebase.drive(0,0);   
    }

    @Override
    public boolean isFinished() {
        return Robot.drivebase.getRightEncoderDistance() >= distance;
    }


}