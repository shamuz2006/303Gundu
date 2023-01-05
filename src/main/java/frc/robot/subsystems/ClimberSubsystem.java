package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import RobotMap.Climber;
import frc.robot.Robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import frc.robot.util.GroundedDigitalInput;


public class ClimberSubsystem extends SubsystemBase {

	private final CANSparkMax climber;
	private final RelativeEncoder climbCode;

	private final GroundedDigitalInput one;
	private final GroundedDigitalInput two;
	private final GroundedDigitalInput three;
	private final GroundedDigitalInput four; 


	public ClimberSubsystem() {
		climber = new CANSparkMax(Climber.CLIMB_PORT_ID, MotorType.kBrushless);
		climbCode = climber.getEncoder();
		one = new GroundedDigitalInput(Climber.BOTTOM_LEFT_LIMIT_SWITCH);
		two = new GroundedDigitalInput(Climber.BOTTOM_RIGHT_LIMIT_SWITCH);
		three = new GroundedDigitalInput(Climber.TOP_LEFT_LIMIT_SWITCH);
		four = new GroundedDigitalInput(Climber.TOP_RIGHT_LIMIT_SWITCH);
	}

	public void climberSpeed(double s) {
		climber.set(s);
	}

	public double getSpeed() {
		return climber.get();
	}

	public boolean topLimit() {
		return (one.get()||two.get());
	}

	public boolean bottomLimit() {
		return (three.get()||four.get());
	}

	public double getEncoderPos() {
		return climbCode.getPosition();
	}

	

}